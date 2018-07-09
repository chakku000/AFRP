package jp.ac.titech.itpro.sdl.afrp.ast;

import jp.ac.titech.itpro.sdl.afrp.AFRPParser;

import android.util.Log;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DefinitionAST implements AST {
    public String node_id;
    public ExpressionAST expast;
    public TreeSet<String> dependence;

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
    public String eval(Map<String, String> map) {
        String val = expast.eval(map);
        //Log.d("chakku:Definition" , node_id + " : " + val);
        map.put(node_id,val);
        return val;
    }

    /* 依存している変数のリストを作成する */
    public TreeSet<String> getDependence(){
        dependence = expast.getDependance();
        return dependence;
    }

    /* node <node_id> = <exp> の node_id を返す */
    public String getNodeName(){
        return node_id;
    }
}
