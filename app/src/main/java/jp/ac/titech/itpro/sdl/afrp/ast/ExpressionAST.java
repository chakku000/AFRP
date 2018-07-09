package jp.ac.titech.itpro.sdl.afrp.ast;

import android.util.Log;

import org.antlr.runtime.tree.Tree;
import org.stringtemplate.v4.NumberRenderer;

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
            ast.str = ctx.binOpBitXor().getText();
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
    public String eval(Map<String, String> map) {
        if(exptype == ExpType.CONSTANT) return getConstant();
        else if(exptype == ExpType.ID){
            return map.get(getID());
        }
        else if(exptype == ExpType.BINOP){
            String op = getOp();
            String ex1 = expressions.get(0).eval(map);
            String ex2 = expressions.get(1).eval(map);

            String ret = "";
            switch (op){
                case "*": {
                    double e1 = Double.parseDouble(ex1);
                    double e2 = Double.parseDouble(ex2);
                    ret = Double.toString(e1 * e2);
                }
                    break;
                case "/": {
                    double e1 = Double.parseDouble(ex1);
                    double e2 = Double.parseDouble(ex2);
                    ret = Double.toString(e1/e2);
                }
                    break;
                case "%": {  // ex1,ex2を両方intで扱って剰余をとる
                    double e1 = Double.parseDouble(ex1);
                    double e2 = Double.parseDouble(ex2);
                    ret = Integer.toString((int) e1 % (int) e2);
                }
                    break;
                case "+": {
                    //Log.d("chakku:check--- +",ex1);
                    //Log.d("chakku:check--- +",ex2);
                    double e1 = Double.parseDouble(ex1);
                    double e2 = Double.parseDouble(ex2);
                    ret = Double.toString(e1 + e2);
                }
                    break;
                case "-": {
                    double e1 = Double.parseDouble(ex1);
                    double e2 = Double.parseDouble(ex2);
                    ret = Double.toString(e1 - e2);
                }
                    break;
                case "<<": {
                    int e1,e2;
                    if(isDigit(ex1)) e1 = Integer.parseInt(ex1);
                    else e1 = (int)Double.parseDouble(ex1);
                    if(isDigit(ex2)) e2 = Integer.parseInt(ex2);
                    else e2 = (int)Double.parseDouble(ex2);
                    if(isDigit(ex1)) e1 = Integer.parseInt(ex1);
                    else e1 = (int)Double.parseDouble(ex1);
                    ret = Double.toString(e1 << e2);
                }
                    break;
                case ">>": {
                    int e1,e2;
                    if(isDigit(ex1)) e1 = Integer.parseInt(ex1);
                    else e1 = (int)Double.parseDouble(ex1);
                    if(isDigit(ex2)) e2 = Integer.parseInt(ex2);
                    else e2 = (int)Double.parseDouble(ex2);
                    if(isDigit(ex1)) e1 = Integer.parseInt(ex1);
                    else e1 = (int)Double.parseDouble(ex1);
                    ret = Double.toString(e1 >> e2);
                }
                    break;
                case "<":{
                    double e1 = Double.parseDouble(ex1);
                    double e2 = Double.parseDouble(ex2);
                    if(e1 < e2) ret = "True";
                    else ret = "False";
                }
                    break;
                case ">":{
                    double e1 = Double.parseDouble(ex1);
                    double e2 = Double.parseDouble(ex2);
                    if(e1 > e2) ret = "True";
                    else ret = "False";
                }
                    break;
                case "<=":{
                    double e1 = Double.parseDouble(ex1);
                    double e2 = Double.parseDouble(ex2);
                    if(e1 <= e2) ret = "True";
                    else ret = "False";
                }
                    break;
                case ">=":{
                    double e1 = Double.parseDouble(ex1);
                    double e2 = Double.parseDouble(ex2);
                    if(e1 >= e2) ret = "True";
                    else ret = "False";
                }
                    break;
                case "==":{
                    if(ex1.equals("True") || ex1.equals("False") || ex2.equals("True") || ex2.equals("False")){
                        if(ex1.equals(ex2)) ret = "True";
                        else ret = "False";
                    }else{
                        double e1 = Double.parseDouble(ex1);
                        double e2 = Double.parseDouble(ex2);
                        if(e1 == e2) ret = "True";
                        else ret = "False";
                    }
                }
                    break;
                case "!=":{
                    if(ex1.equals("True") || ex1.equals("False") || ex2.equals("True") || ex2.equals("False")){
                        if(ex1.equals(ex2)) ret = "False";
                        else ret = "True";
                    }else{
                        double e1 = Double.parseDouble(ex1);
                        double e2 = Double.parseDouble(ex2);
                        if(e1 == e2) ret = "False";
                        else ret = "True";
                    }
                }
                    break;
                case "&": {
                    int e1, e2;
                    if (isDigit(ex1)) e1 = Integer.parseInt(ex1);
                    else e1 = (int) Double.parseDouble(ex1);
                    if (isDigit(ex2)) e2 = Integer.parseInt(ex2);
                    else e2 = (int) Double.parseDouble(ex2);
                    ret = Integer.toString(e1 & e2);
                }
                    break;
                case "^": {
                    int e1, e2;
                    if (isDigit(ex1)) e1 = Integer.parseInt(ex1);
                    else e1 = (int) Double.parseDouble(ex1);
                    if (isDigit(ex2)) e2 = Integer.parseInt(ex2);
                    else e2 = (int) Double.parseDouble(ex2);
                    ret = Integer.toString(e1 ^ e2);
                }
                    break;
                case "|": {
                    int e1, e2;
                    if (isDigit(ex1)) e1 = Integer.parseInt(ex1);
                    else e1 = (int) Double.parseDouble(ex1);
                    if (isDigit(ex2)) e2 = Integer.parseInt(ex2);
                    else e2 = (int) Double.parseDouble(ex2);
                    ret = Integer.toString(e1 | e2);
                }
                    break;
                case "&&":{
                    boolean b1=false,b2=false;
                    if(isBoolean(ex1)){
                        if(ex1.equals("True")) b1 = true;
                        else b1 = false;
                    }else if(isNumber(ex1)){
                        double e1 = Double.parseDouble(ex1);
                        if(e1 != 0) b1 = true;
                        else b1 = false;
                    }else{
                        Log.d("chakku:ErrorEvalExp","ExpressionASTのevalの&&において想定外のエラー");
                    }

                    if(b1){
                        if(isBoolean(ex2)){
                            if(ex2.equals("True")) b2 = true;
                            else b2 = false;
                        }else if(isNumber(ex2)){
                            double e2 = Double.parseDouble(ex2);
                            if(e2 != 0) b2 = true;
                            else b2 = false;
                        }else{
                            Log.d("chakku:ErrorEvalExp","ExpressionASTのevalの&&において想定外のエラー");
                        }
                    }
                    if(b1 && b2) ret = "True";
                    else ret = "False";
                }
                    break;
                case "||":{
                    boolean b1=false,b2=false;
                    if(isBoolean(ex1)){
                        if(ex1.equals("True")) b1 = true;
                        else b1 = false;
                    }else if(isNumber(ex1)){
                        double e1 = Double.parseDouble(ex1);
                        if(e1 != 0) b1 = true;
                        else b1 = false;
                    }else{
                        Log.d("chakku:ErrorEvalExp","ExpressionASTのevalの&&において想定外のエラー");
                    }
                    if(b1){
                        ret = "True";
                        break;
                    }
                    else{
                        if(isBoolean(ex2)){
                            if(ex2.equals("True")) b2 = true;
                            else b2 = false;
                        }else if(isNumber(ex2)){
                            double e2 = Double.parseDouble(ex2);
                            if(e2 != 0) b2 = true;
                            else b2 = false;
                        }else{
                            Log.d("chakku:ErrorEvalExp","ExpressionASTのevalの&&において想定外のエラー");
                        }
                    }
                    if(b1 || b2){
                        ret = "True";
                    }else{
                        ret = "False";
                    }
                }
                    break;
            }
            return ret;
        }else{  // if expression
            String ret = "";
            String cond = expressions.get(0).eval(map);
            if(isCondTrue(cond)){
                ret = expressions.get(1).eval(map);
            }else{
                ret = expressions.get(2).eval(map);
            }
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

    public static boolean isDigit(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public static boolean isNumber(String s){
        try{
            Double.parseDouble(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public static boolean isBoolean(String s){
        return s.equals("True") || s.equals("False");
    }
    public static boolean isCondTrue(String s){
        if(isBoolean(s)){
            if(s.equals("True")) return true;
            else return false;
        }else{
            if(!isNumber(s)){
                Log.d("chakku:Error","想定しないエラー(ExpressionAST.isCondTrue)");
                return false;
            }
            double d = Double.parseDouble(s);
            if(d==0) return false;
            return true;
        }
    }
}
