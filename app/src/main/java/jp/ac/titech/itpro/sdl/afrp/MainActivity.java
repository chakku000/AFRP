package jp.ac.titech.itpro.sdl.afrp;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

import jp.ac.titech.itpro.sdl.afrp.ast.AST;
import jp.ac.titech.itpro.sdl.afrp.ast.TopLevelAST;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private EditText inputCode;
    private String sourceCode;
    private TextView resultview;    /* 結果を出力するView */

    /* センサー関連の変数 */
    private SensorManager sensorManager;
    private Sensor accel;       // 加速度センサー
    private Sensor light;       // 照度センサー

    /* FRPの実装に必要な変数 */
    private TopLevelAST ast;
    private TreeMap<String, String> nodes;
    private TreeMap<String, String> lastnodes;
    private List<String> innodes;   /* 入力ノード */
    private List<String> outnodes;  /* 出力ノード */
    private TreeMap<String, TreeSet<String>> depend;
    private ArrayList<String> executionOrder;   /* 実行順序 */

    /* Activityが生成された最初の1回だけ呼び出される */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("chakku:MainActivity", "onCreate");

        /* Viewの設定 */
        inputCode = findViewById(R.id.SourceCode);  // ソースコード入力用View
        resultview = findViewById(R.id.ResultText); // 計算結果表示用View

        /* センサーマネージャの設定 */
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager == null) {
            // センサーマネージャが取得できない場合にAndroidの画面にエラーメッセージを表示
            Toast.makeText(this, R.string.toast_no_sensor_manager, Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        /* 各種センサーの設定 */
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER); // 加速度センサー
        if (accel == null) {
            // 加速度センサーが取得できない場合にAndroidでエラーメッセージを表示
            Toast.makeText(this, R.string.toast_no_accel_sensor, Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        // 照度センサー
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (light == null) {
            // 照度センサーが取得できない場合にAndroidでエラーメッセージを表示
            Toast.makeText(this, R.string.toast_no_light_sensor, Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        /* FRPで使用する変数(ノード)の初期化 */
        nodes = new TreeMap<>();
        lastnodes = new TreeMap<>();
    }

    /* Activityが全面に出るときに呼び出される */
    @Override
    protected void onResume() {
        super.onResume();

        //checkSensors();
    }

    /* Activityがバックグラウンドに移動したときに呼び出される */
    @Override
    protected void onPause() {
        super.onPause();

        /* Listenerを解除 */
        sensorManager.unregisterListener(this);
        Log.d("chakku:onPause", "センサーリスナーを解除します");
    }

    /* Runボタンをクリックした時に呼び出される */
    // EditText(inputCode)からソースコード(String)を取得してsourceCodeに代入
    public void onClickRun(View v) {
        Log.d("chakku:MainActivity", "onClickRun");
        // ソースコードをViewから取得
        sourceCode = inputCode.getText().toString();
        Log.d("chakku:MainActivity", sourceCode);

        /* 字句解析 + 構文解析 */
        AFRPLexer lexer = new AFRPLexer(CharStreams.fromString(sourceCode));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AFRPParser parser = new AFRPParser(tokens);
        AFRPParser.TopLevelContext toplevelctx = parser.topLevel();
        Log.d("chakku:MainActivity", "Parse OK");

        /* AST作成 */
        ast = TopLevelAST.parse(toplevelctx);
        innodes = ast.innodes;
        outnodes = ast.outnodes;
        Log.d("chakku:入力ノード", "" + innodes);
        depend = ast.getDependence();
        Log.d("chakku:MainActivity", "Generate AST : Success");
        for (Map.Entry<String, TreeSet<String>> entry : depend.entrySet()) {
            String str = entry.getKey();
            str += " : ";
            for (String s : entry.getValue()) {
                str += s + " ";
            }
            Log.d("chakku:依存関係", str);
        }
        executionOrder = TopologicalSort(depend, (ArrayList<String>) innodes);
        Log.d("chakku:実行順序", executionOrder.toString());

        /* リスナーの登録 */
        // SensorManager.SENSOR_DELAY_NORMAL : 200ms (DELAY_FASTESTなら0ms,DELAY_GAMEなら20ms,DELAY_UIなら60ms,DELAY_NORMALなら200ms)
        if (innodes.indexOf("accx") != -1 || innodes.indexOf("accy") != -1 || innodes.indexOf("accz") != -1) {
            Log.d("chakku:Sensor", "加速度センサーをリスナーに登録します");
            sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_UI);
        }
        if (innodes.indexOf("light") != -1) {
            Log.d("chakku:Sensor", "照度センサーをリスナーに登録します");
            sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    /* Stopボタンをクリックした時の呼び出し */
    public void onClickStop(View v) {
        Log.d("chakku:onClickStop", "Stopボタンがクリックされました");
        sensorManager.unregisterListener(this);
    }

    /* センサーの値が変更された時に呼び出し */
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            //Log.d("chakku:onSensorChanged","加速度センサーの値が変わりました");
            nodes.put("accx", Float.toString(event.values[0]));
            nodes.put("accy", Float.toString(event.values[1]));
            nodes.put("accz", Float.toString(event.values[2]));
        } else if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            nodes.put("light", Float.toString(event.values[0]));
        } else {
            Log.d("chakku:onSensorChanged", "不明なセンサーの値が変わりました");
        }

        /* TODO ASTから計算 */
        ast.setOrder(executionOrder);                   // 実行順序を設定
        String evalres = ast.eval(nodes,lastnodes);               // 実行
        //Log.d("chakku:onSensorChanged",evalres);

        /* TODO 結果を出力 */
        String outstr = "";
        for (String out : outnodes) {
            outstr += out + " : " + nodes.get(out) + "\n";
        }
        resultview.setText(outstr);

        /* 大文字で前回の値を取れるように */
        for(Map.Entry<String,String> entry : nodes.entrySet()){
            String key = entry.getKey().toUpperCase();
            lastnodes.put(key,entry.getValue());
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    /* トポロジカルソート */
    public static ArrayList<String> TopologicalSort(TreeMap<String, TreeSet<String>> map, ArrayList<String> innodes) {
        TreeMap<String, TreeSet<String>> G = new TreeMap<>();
        for (String entry : map.keySet()) G.put(entry, new TreeSet<String>());
        for (String entry : innodes) G.put(entry, new TreeSet<String>());
        for (Map.Entry<String, TreeSet<String>> entry : map.entrySet()) {
            for (String s : entry.getValue()) G.get(s).add(entry.getKey());
        }
        TreeMap<String, Integer> indeg = new TreeMap<>();
        for (String entry : G.keySet()) indeg.put(entry, 0);
        for (Map.Entry<String, TreeSet<String>> entry : G.entrySet()) {
            for (String s : entry.getValue()) {
                int deg = indeg.get(s);
                indeg.put(s, deg + 1);
            }
        }
        TreeMap<String, Boolean> used = new TreeMap<>();
        for (String node : G.keySet()) used.put(node, false);
        ArrayList<String> ret = new ArrayList<>();
        for (String node : G.keySet()) {
            if (indeg.get(node) == 0 && used.get(node) == false) {
                Queue<String> que = new ArrayDeque<>();
                que.offer(node);
                used.put(node, true);
                while (!que.isEmpty()) {
                    String u = que.poll();
                    ret.add(u);
                    for (String v : G.get(u)) {
                        int deg = indeg.get(v);
                        deg--;
                        indeg.put(v, deg);
                        if (indeg.get(v) == 0 && !used.get(v)) {
                            used.put(v, true);
                            que.offer(v);
                        }
                    }
                }
            }
        }
        return ret;
    }

    private void checkSensors() {
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuffer strListbuf = new StringBuffer("Sensor List:\n\n");
        int count = 0;

        for (Sensor sensor : sensors) {
            count++;
            String str = String.format(
                    "%s: %s\n", String.valueOf(count + 1), sensor.getName());
            strListbuf.append(str);
        }
        resultview.setText(strListbuf);
    }
}