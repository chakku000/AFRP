package jp.ac.titech.itpro.sdl.afrp.ast;

import org.antlr.v4.runtime.tree.TerminalNode;

import jp.ac.titech.itpro.sdl.afrp.AFRPParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import android.util.Log;

public class TopLevelAST implements AST{
    public List<String> innodes,outnodes;
    public List<DefinitionAST> definitions;

    public static TopLevelAST parse(AFRPParser.TopLevelContext ctx){
        TopLevelAST ast = new TopLevelAST();
        ast.innodes = parseInput(ctx.inputdef());
        ast.outnodes = parseOutput(ctx.outputdef());
        ast.definitions = new ArrayList<DefinitionAST>();
        for(AFRPParser.DefinitionContext def_ctx : ctx.definition()){
            ast.definitions.add(DefinitionAST.parse(def_ctx));
        }
        return ast;
    }

    public static List<String> parseInput(AFRPParser.InputdefContext ctx){
        List<String> ret = new ArrayList<String>();
        for(TerminalNode node : ctx.ID()){
            ret.add(node.getSymbol().getText());
        }
        return ret;
    }

    public static List<String> parseOutput(AFRPParser.OutputdefContext ctx){
        List<String> ret = new ArrayList<String>();
        for(TerminalNode node : ctx.ID()){
            ret.add(node.getSymbol().getText());
        }
        return ret;
    }

    @Override
    public void print(){
        print(0);
    }

    @Override
    public void print(int tab){
        String str = "TopLevelAST: ";
        str += "input{";
        for(String s : innodes) str += s + ",";
        str += "} output{";
        for(String s : outnodes) str += s + ",";
        str += "}";
        Log.d("chakku:AST",str);
        for(DefinitionAST ast : definitions){
            ast.print(tab+2);
        }
    }

    @Override
    public void exec(Map<String, Number> map) {

    }

    /*
       依存関係を返す
       Key : ノード名
       Value : Keyノードが依存しているノード名
     */
    public Map<String,Collection<String>> getDependence(){
        TreeMap<String,Collection<String>> ret = new TreeMap<>();
        for(DefinitionAST ast : definitions){
            String nodename = ast.getNodeName();
            Collection<String> dep = ast.getDependence();
        }
        return ret;
    }
}