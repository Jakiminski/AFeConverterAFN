package afeconverterafn;

import java.util.StringTokenizer;

/**
 *
 * @author Jonas
 */
public class Transition {
   private String letra; // símbolo lido
   private State proximo; // estado seguinte
   
   public Transition(String letra, State proximo){
       this.letra = letra;
       this.proximo = proximo;
   }
   
  /* public Transition(String letra, State proximo){
       this.letra = letra;
       this.proximo = proximo;
   }
   */
   
   public void setLetra(String letra){
       this.letra = letra;
   }
   
   public String getLetra(){
       return this.letra;
   }
   
   public void setEstado(State estado){
       this.proximo = estado;
   }
   
   public State getEstado(){
       return this.proximo;
   }
   
   public boolean isEmpty (){
       return letra.equals("ε");
   }
      
}
