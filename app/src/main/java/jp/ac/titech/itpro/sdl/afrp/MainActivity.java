package jp.ac.titech.itpro.sdl.afrp;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.EditText;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ResultView resultview;
    private EditText inputCode;
    private String sourceCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("chakku:MainActivity","onCreate");

        // ソースコードを取得するView
        inputCode = findViewById(R.id.SourceCode);
    }

    // Runボタンをクリックした時に呼び出される
    // EditText(inputCode)からソースコード(String)を取得してsourceCodeに代入
    public void onClickRun(View v){
        Log.d("MainActivity","onClickRun");
        sourceCode = inputCode.getText().toString();
        Log.d("chakku:MainActivity",sourceCode);
        AFRPLexer lexer = new AFRPLexer(CharStreams.fromString(sourceCode));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
    }
}
