package jp.ac.titech.itpro.sdl.afrp.ast;

import android.util.Log;

import jp.ac.titech.itpro.sdl.afrp.AFRPParser;

public class ExpressionAST implements AST {
    public enum ExpType{
        CONSTANT,ID,BINOP,IF
    };

    public ExpType exptype;
    public String str;
    public static ExpressionAST parse(AFRPParser.ExpressionContext ctx){
        ExpressionAST ast = new ExpressionAST();

        if(ctx.constant() != null){
            ast.exptype = ExpType.CONSTANT;
            ast.str = ctx.constant().getText();
        }else if(ctx.ID() != null){
            ast.exptype = ExpType.ID;
            ast.str = ctx.ID().getText();
        }
        return ast;
    }

    public String getConstant(){
        return str;
    }
    public String getID(){
        return str;
    }
    public String getOp(){
        return str;
    }


    @Override
    public void print() {
        print(0);
    }

    @Override
    public void print(int tab) {
        String tabs = "";
        for(int i=0;i<tab;i++) tabs += " ";
        String str = "ExpressionAST: " + this.str;
        Log.d("chakku:AST",tabs + str);
    }
}
