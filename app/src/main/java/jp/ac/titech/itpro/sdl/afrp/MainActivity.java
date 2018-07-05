package jp.ac.titech.itpro.sdl.afrp;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;

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

import jp.ac.titech.itpro.sdl.afrp.ast.AST;
import jp.ac.titech.itpro.sdl.afrp.ast.TopLevelAST;

public class MainActivity extends AppCompatActivity {
    private EditText inputCode;
    private String sourceCode;
    private TextView resultview;

    private SensorManager sensorManager;
    private Sensor accel;       // 加速度センサー

    private TopLevelAST ast;

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
    }

    /* Runボタンをクリックした時に呼び出される */
    // EditText(inputCode)からソースコード(String)を取得してsourceCodeに代入
    public void onClickRun(View v){
        Log.d("chakku:MainActivity","onClickRun");
        sourceCode = inputCode.getText().toString();
        Log.d("chakku:MainActivity",sourceCode);
        AFRPLexer lexer = new AFRPLexer(CharStreams.fromString(sourceCode));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AFRPParser parser = new AFRPParser(tokens);
        AFRPParser.TopLevelContext toplevelctx = parser.topLevel();
        Log.d("chakku:MainActivity","Parse OK");
        ast = TopLevelAST.parse(toplevelctx);
        ast.print();
    }
}
