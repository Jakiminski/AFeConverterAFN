
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
    
    public String fechoVazio(String fecho){
        if(!fecho.contains(ID)){
            fecho += (ID + ",");
            for(Transition t : transicao){
                if(t.isEmpty()){
                    fecho = (t.getEstado().fechoVazio(fecho) + ",");
                }
            }
        }
        return fecho;
    }
    
    public State updateState(String fecho, Automata afx){
        StringTokenizer token = new StringTokenizer(fecho, ",");
        State stt = new State(ID);
        
        for(Transition t : transicao){
            if(!t.isEmpty())
                stt.addTransicao(t);
        }
        
        while(token.hasMoreTokens()){
            String str = (String)token.nextToken();
            if(!str.isEmpty()){
                State stado = afx.deltaFindState(str);
                cloneTransition(stado);
                ArrayList<Transition> newTrans = stado.getTransitionSet();
                for(Transition t : newTrans){
                    if(t.getEstado().getID().contains("f") && !ID.contains("f"))
                        stt.setID(ID.concat("f"));
                    
                    stt.addTransicao(t);
                }
            }
        }
        
        return stt;
    }
    
    public void addTransicao(Transition t){
        if(t != null && !this.transicao.contains(t))
            this.transicao.add(t);
    }
    
    public void cloneTransition(State next){
        ArrayList <Transition> t1 = new ArrayList();
        for(Transition t : transicao){
            if(t.getEstado().getID().equals(ID)){
                t1.add(new Transition(t.getLetra(), next));
            }
        }
        for(Transition t : t1){
                addTransicao(t);
        }
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
    
    public ArrayList<Transition> getTransitionSet(){
        return transicao;
    }
    
}
