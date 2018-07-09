package jp.ac.titech.itpro.sdl.afrp.ast;

import java.util.Map;
public interface AST {
    public void print();
    public void print(int tab);
    public String eval(Map<String,String> map,Map<String,String> lastmap);
}
