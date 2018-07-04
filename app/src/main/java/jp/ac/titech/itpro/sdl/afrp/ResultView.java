package jp.ac.titech.itpro.sdl.afrp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

class ResultView extends View{
    public ResultView(Context context){
        this(context,null);
    }
    public ResultView(Context context, AttributeSet attrs){
        this(context,attrs,0);
    }
    public ResultView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}