package jp.ac.titech.itpro.sdl.afrp.ast;

import java.util.Map;
public interface AST {
    public void print();
    public void print(int tab);
    public String exec(Map<String,Number> map);
}
