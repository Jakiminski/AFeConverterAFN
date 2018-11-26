
package afeconverterafn;

/**
 *
 * @author Jonas
 */
public class Transition {
   private String letra; // símbolo lido
   private State proximo; // estado seguinte
   
   Transition(String letra, State proximo){
       this.letra = letra;
       this.proximo = proximo;
   }
   
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
      
}
