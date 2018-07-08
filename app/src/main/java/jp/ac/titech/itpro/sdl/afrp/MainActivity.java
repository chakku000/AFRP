package jp.ac.titech.itpro.sdl.afrp;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

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
import java.util.TreeMap;

import jp.ac.titech.itpro.sdl.afrp.ast.AST;
import jp.ac.titech.itpro.sdl.afrp.ast.TopLevelAST;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    private EditText inputCode;
    private String sourceCode;
    private TextView resultview;    /* 結果を出力するView */

    /* センサー関連の変数 */
    private SensorManager sensorManager;
    private Sensor accel;       // 加速度センサー

    /* FRPの実装に必要な変数 */
    private TopLevelAST ast;
    private Map<String,Number> nodes;
    private List<String> outnodes;

    /* Activityが生成された最初の1回だけ呼び出される */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("chakku:MainActivity","onCreate");

        /* Viewの設定 */
        inputCode = findViewById(R.id.SourceCode);  // ソースコード入力用View
        resultview = findViewById(R.id.ResultText); // 計算結果表示用View

        /* センサーマネージャの設定 */
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        if(sensorManager == null){
            // センサーマネージャが取得できない場合にAndroidの画面にエラーメッセージを表示
            Toast.makeText(this,R.string.toast_no_sensor_manager,Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        /* 各種センサーの設定 */
        /* TODO : センサーの取得を必要になってからしてもいいかもしれない */
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER); // 加速度センサー
        if(accel == null){
            // 加速度センサーが取得できない場合にAndroidでエラーメッセージを表示
            Toast.makeText(this,R.string.toast_no_accel_sensor,Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        /* FRPで使用する変数(ノード)の初期化 */
        nodes = new TreeMap<>();
    }

    /* Activityが全面に出るときに呼び出される */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /* Activityがバックグラウンドに移動したときに呼び出される */
    @Override
    protected void onPause(){
        super.onPause();

        /* Listenerを解除 */
        sensorManager.unregisterListener(this);
        Log.d("chakku:onPause","センサーリスナーを解除します");
    }

    /* Runボタンをクリックした時に呼び出される */
    // EditText(inputCode)からソースコード(String)を取得してsourceCodeに代入
    public void onClickRun(View v){
        Log.d("chakku:MainActivity","onClickRun");
        // ソースコードをViewから取得
        sourceCode = inputCode.getText().toString();
        Log.d("chakku:MainActivity",sourceCode);

        /* 字句解析 + 構文解析 */
        AFRPLexer lexer = new AFRPLexer(CharStreams.fromString(sourceCode));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AFRPParser parser = new AFRPParser(tokens);
        AFRPParser.TopLevelContext toplevelctx = parser.topLevel();
        Log.d("chakku:MainActivity","Parse OK");

        /* AST作成 */
        ast = TopLevelAST.parse(toplevelctx);
        outnodes = ast.outnodes;
        Log.d("chakku:MainActivity","Generate AST : Success");

        /* リスナーの登録 */
        // TODO : 現在は暫定的に加速度センサーを取得しているが、inputnodesの値をみて決定するべき
        // SensorManager.SENSOR_DELAY_NORMAL : 200ms (DELAY_FASTESTなら0ms,DELAY_GAMEなら20ms,DELAY_UIなら60ms)
        sensorManager.registerListener(this,accel,SensorManager.SENSOR_DELAY_NORMAL);
    }

    /* Stopボタンをクリックした時の呼び出し */
    public void onClickStop(View v){
        Log.d("chakku:onClickStop","Stopボタンがクリックされました");
        sensorManager.unregisterListener(this);
    }

    /* センサーの値が変更された時に呼び出し */
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            Log.d("chakku:onSensorChanged","加速度センサーの値が変わりました");
            nodes.put("accx",event.values[0]);
            nodes.put("accy",event.values[1]);
            nodes.put("accz",event.values[2]);
        }else{
            Log.d("chakku:onSensorChanged","不明なセンサーの値が変わりました");
        }

        /* TODO ASTから計算 */

        /* TODO 結果を出力 */
        String outstr = "";
        for(String out : outnodes){
            outstr += out + " : " + nodes.get(out) + "\n";
        }
        resultview.setText(outstr);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}