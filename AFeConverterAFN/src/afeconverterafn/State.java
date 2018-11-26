
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
    
    public State(String ID){
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
    public boolean getFinal(){
        return this.isFinal;
    }
    */
    public State convertState(){
        State a = new State(ID);
        for(Transition t : transicao){
            if(t.getLetra().equals("ε"))
                for(Transition t1 : t.getEstado().transicao){
                    if(t1.getEstado().getID().contains("f") && !a.getID().contains("f"))
                        a.setID(a.getID().concat("f"));
                    
                    a.addTransicao(t1);
                }
            else
                a.addTransicao(t);
        }
              
        return a;
    }
    
    public void addTransicao(Transition t){
        if(!this.transicao.contains(t))
            this.transicao.add(t);
    }
    
    public String getTransitions(String letra){
        String a = "";
        for(Transition t : transicao){
            if(t.getLetra().equals(letra)){
                String id = t.getEstado().getID();
                if(!a.contains(id))
                    a += (id+",");
            }
        }
        return a;
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
