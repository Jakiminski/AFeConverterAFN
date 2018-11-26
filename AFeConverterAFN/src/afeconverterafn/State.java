
package afeconverterafn;

import java.util.*;

/**
 *
 * @author Jonas
 */
public class State {
    private String ID;//nome do estado
    //private boolean isFinal; // Define se é estado final ou não
    public ArrayList<Transition> transicao; // Transicoes possíveis a partir desse estado
    
    State(String ID){
        this.ID = ID;
        //this.isFinal = false;
        transicao = new ArrayList<Transition>();
    }
    /*
    State(String ID, boolean isFinal){
        this.ID = ID;
        this.isFinal = isFinal;
        transicao = new ArrayList<Transition>();
    }
    */
    public void setID(String ID){
        this.ID = ID;
    }
    
    public String getID(){
        return this.ID;
    }
    /*
    public void setFinal(boolean isFinal){
        this.isFinal = isFinal;
    }
    
    public boolean getFinal(){
        return this.isFinal;
    }
    */
    public void addTransicao(Transition t){
        this.transicao.add(t);
    }
    
    public void showTransitions(String sym){
        Iterator itTrans = this.transicao.iterator();
        while(itTrans.hasNext()){
            Transition a = (Transition)itTrans.next();
            if(a.getLetra() == sym)
                System.out.print(a.getEstado().getID());           
        }
        System.out.print("\t");           
    }
    
}
