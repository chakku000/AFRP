package jp.ac.titech.itpro.sdl.afrp.ast;

import jp.ac.titech.itpro.sdl.afrp.AFRPParser;

import android.util.Log;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DefinitionAST implements AST {
    public String node_id;
    public ExpressionAST expast;
    public Collection<String> dependence;

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

    @Override
    public void exec(Map<String, Number> map) {

    }

    /* 依存している変数のリストを作成する */
    public Collection<String> getDependence(){
        dependence = expast.getDependance();
        return dependence;
    }

    /* node <node_id> = <exp> の node_id を返す */
    public String getNodeName(){
        return node_id;
    }
}
