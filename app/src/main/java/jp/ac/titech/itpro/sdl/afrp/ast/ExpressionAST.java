package jp.ac.titech.itpro.sdl.afrp.ast;

import android.util.Log;

import org.antlr.runtime.tree.Tree;

import jp.ac.titech.itpro.sdl.afrp.AFRPParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class ExpressionAST implements AST {
    public enum ExpType{
        CONSTANT,ID,BINOP,IF
    };

    public ExpType exptype;
    public String str;
    public List<ExpressionAST> expressions;
    public static ExpressionAST parse(AFRPParser.ExpressionContext ctx){
        ExpressionAST ast = new ExpressionAST();

        if(ctx.constant() != null){
            ast.exptype = ExpType.CONSTANT;
            ast.str = ctx.constant().getText();
        }else if(ctx.ID() != null){
            ast.exptype = ExpType.ID;
            ast.str = ctx.ID().getText();
        }else if(ctx.binOpMulDiv() != null){
            ast.exptype = ExpType.BINOP;
            ast.str = ctx.binOpMulDiv().getText();
        }else if(ctx.binOpAddSub() != null){
            ast.exptype = ExpType.BINOP;
            ast.str = ctx.binOpAddSub().getText();
        }else if(ctx.binOpShift() != null){
            ast.exptype = ExpType.BINOP;
            ast.str = ctx.binOpShift().getText();
        }else if(ctx.binOpCompare() != null){
            ast.exptype = ExpType.BINOP;
            ast.str = ctx.binOpCompare().getText();
        }else if(ctx.binOpEqual() != null){
            ast.exptype = ExpType.BINOP;
            ast.str = ctx.binOpEqual().getText();
        }else if(ctx.binOpBitAnd() != null){
            ast.exptype = ExpType.BINOP;
            ast.str = ctx.binOpBitAnd().getText();
        }else if(ctx.binOpBitXor() != null){
            ast.exptype = ExpType.BINOP;
            ast.str = ctx.binOpBitOr().getText();
        }else if(ctx.binOpBitOr() != null){
            ast.exptype = ExpType.BINOP;
            ast.str = ctx.binOpBitOr().getText();
        }else if(ctx.binOpLogicOr() != null){
            ast.exptype = ExpType.BINOP;
            ast.str = ctx.binOpLogicOr().getText();
        }else if(ctx.binOpLogicAnd() != null){
            ast.exptype = ExpType.BINOP;
            ast.str = ctx.binOpLogicAnd().getText();
        }else{
            ast.exptype = ExpType.IF;
        }


        if(ast.exptype == ExpType.BINOP || ast.exptype == ExpType.IF){
            ast.expressions = new ArrayList<>();
            for(AFRPParser.ExpressionContext expctx : ctx.expression()){
                ast.expressions.add(ExpressionAST.parse(expctx));
            }
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
        if(expressions != null){
            for(ExpressionAST ast : expressions){
                ast.print(tab+2);
            }
        }
    }

    @Override
    public String exec(Map<String, Number> map) {
        if(exptype == ExpType.CONSTANT) return getConstant();
        else if(exptype == ExpType.ID) return getID();
        else if(exptype == ExpType.BINOP){
            String op = getOp();
            String ex1 = expressions.get(0).exec(map);
            String ex2 = expressions.get(1).exec(map);

            String ret = "";
            float e1,e2;
            switch (op){
                case "*":
                    e1 = Float.parseFloat(ex1);
                    e2 = Float.parseFloat(ex2);
                    ret = Float.toString(e1*e2);
                    break;
                case "/":
                    e1 = Float.parseFloat(ex1);
                    e2 = Float.parseFloat(ex2);
                    ret = Float.toString(e1/e2);
                    break;
                case "%":   // ex1,ex2を両方intで扱って剰余をとる
                    e1 = Float.parseFloat(ex1);
                    e2 = Float.parseFloat(ex2);
                    ret = Integer.toString((int)e1 % (int)e2);
                    break;
                case "+":
                    e1 = Float.parseFloat(ex1);
                    e2 = Float.parseFloat(ex2);
                    ret = Float.toString(e1+e2);
                    break;
                case "-":
                    e1 = Float.parseFloat(ex1);
                    e2 = Float.parseFloat(ex2);
                    ret = Float.toString(e1-e2);
                    break;
            }
            return ret;
        }else{  // if expression
            String ret = "";
            return ret;
        }
    }


    /* 依存してる変数のリストを返す */
    public TreeSet<String> getDependance(){
        TreeSet<String> ret = new TreeSet<>();
        if(exptype == ExpType.CONSTANT){
        }else if(exptype == ExpType.ID){
            ret.add(getID());
        }else if(exptype == ExpType.BINOP){
            for(ExpressionAST ast : expressions){
                ret.addAll(ast.getDependance());
            }
        }else if(exptype == ExpType.IF){
            for(ExpressionAST ast : expressions){
                ret.addAll(ast.getDependance());
            }
        }
        return ret;
    }
}
