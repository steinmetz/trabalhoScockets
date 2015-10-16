/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;
 
import java.util.ArrayList;

public class Relatorio {
    public int bytes;
    public int repeticoes;
    public int erros;
    public ArrayList<Long> tempos = new ArrayList<>();

    @Override
    public String toString() {
        String tempo = "";
        for(long i : tempos){
           tempo += i+"\r\n";
        }
        return "Relatorio\n\n"+
               "bytes=" + bytes + "\n"+ 
               "repeticoes=" + repeticoes + "\n"+
               "erros=" + erros + "\n"+
               "tempos=\n" + tempo;
    }
    
    
}
