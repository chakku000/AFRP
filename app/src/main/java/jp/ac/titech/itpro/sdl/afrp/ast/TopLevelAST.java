package jp.ac.titech.itpro.sdl.afrp.ast;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.Tree;

import jp.ac.titech.itpro.sdl.afrp.AFRPParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import android.util.Log;

public class TopLevelAST implements AST{
    public List<String> innodes,outnodes;
    public List<DefinitionAST> definitions;
    public ArrayList<DefinitionAST> executionOrder;

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
    public String eval(Map<String, String> map) {
        //Log.d("chakku:Toplevel","Eval called size = " + executionOrder.size());

        for(DefinitionAST ast : executionOrder){
            //Log.d("chakku:Toplevel2","\tnodeid = " + ast.node_id);
            ast.eval(map);
        }
        return "Eval Success";
    }

    /*
       依存関係を返す
       Key : ノード名
       Value : Keyノードが依存しているノード名
     */
    public TreeMap<String,TreeSet<String>> getDependence(){
        TreeMap<String,TreeSet<String>> ret = new TreeMap<>();
        for(DefinitionAST ast : definitions){
            String nodename = ast.getNodeName();
            //Log.d("chakku:TopLevel",nodename);
            TreeSet<String> dep = ast.getDependence();
            ret.put(nodename,dep);
        }
        return ret;
    }

    public void setOrder(ArrayList<String> order){
        executionOrder = new ArrayList<>();
        //Log.d("chakku:setOrder","order is " + order);
        for(String nodename : order){
            for(DefinitionAST ast : definitions){
                if(nodename.equals(ast.node_id)){
                    executionOrder.add(ast);
                }
            }
        }
    }
}