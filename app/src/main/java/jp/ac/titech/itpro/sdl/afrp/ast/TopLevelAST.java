package jp.ac.titech.itpro.sdl.afrp.ast;

import org.antlr.v4.runtime.tree.TerminalNode;

import jp.ac.titech.itpro.sdl.afrp.AFRPParser;

import java.util.ArrayList;
import java.util.List;

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
}