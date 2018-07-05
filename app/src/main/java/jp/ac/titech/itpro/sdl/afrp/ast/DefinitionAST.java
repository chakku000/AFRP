package jp.ac.titech.itpro.sdl.afrp.ast;

import jp.ac.titech.itpro.sdl.afrp.AFRPParser;

import android.util.Log;

public class DefinitionAST implements AST {
    public String node_id;
    public ExpressionAST expast;

    public static DefinitionAST parse(AFRPParser.DefinitionContext ctx){
        DefinitionAST ast = new DefinitionAST();
        ast.node_id = ctx.ID().getText();
        ast.expast = ExpressionAST.parse(ctx.expression());
        return ast;
    }

    @Override
    public void print() {
        print(0);
    }

    @Override
    public void print(int tab){
        String tabs = "";
        for(int i=0;i<tab;i++) tabs += " ";
        String str = "DefinitionAST";
        str += " ID = " + node_id;
        str += "\n";
        Log.d("chakku:AST",tabs + str);
        expast.print(tab+2);
    }
}
