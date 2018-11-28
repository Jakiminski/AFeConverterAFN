
package afeconverterafn;

import java.util.*;

/**
 *
 * @author Jonas
 */
public class Automata {

    protected ArrayList<String> sigma;  // Alfabeto
    protected ArrayList <State> delta;  // Função Programa, leitura (ConjEstados Q x Alfabeto Sigma)
    protected State q0;                 // Estado Inicial
    protected ArrayList<State> finais;  // Conjunto de estados finais

    public Automata(){
        this.sigma = new ArrayList<>(); // Alfabeto
        this.delta = new ArrayList<>(); // Funcao Programa (Tem o Conjunto de Estados)
        this.finais = new ArrayList<>();// Conj. Estados Finais
    }
    
    public State deltaFindState(String key){
        //Iteracao, todos os estados presentes na funcao programa
        for(State estado : delta){ 
            if(estado.getID().equals(key))//Comparacao ID==key ?
                return estado; //Estado encontrado
        }
        return null;
    }
    
    public State getState(int index){
        if(index < delta.size())
            return delta.get(index);
        return null;
    }
    
    public boolean isStateInsideDelta(String key){
        State temp = this.deltaFindState(key);
        return (temp == null) ? false : true; 
    }
    
    public void addState(State estado){
        //Verificação se estado já faz parte do conjunto Q
        State newstate = this.deltaFindState(estado.getID());
        if (newstate == null) // Se estado não pertence a delta
            delta.add(estado);//Inclusao na FuncaoPrograma
    }
    
    public void addStateInicial(State estado){
        this.q0 = estado;
        this.addState(estado);// qo pertence a delta
    }
    
    public void addStateFinal(State estado){
        this.finais.add(estado);
        this.addState(estado);
    }
    
    public void addAlphabeto(String letra){
        if(sigma.contains(letra) == false)
            sigma.add(letra);
    }
    
    public void addTransitionState(String key, afeconverterafn.Transition t){
        for(State estado : delta){ 
            if(estado.getID().equals(key))//Comparacao ID==key ?
                estado.addTransicao(t); //Estado encontrado
                
        }
    }
    
    public Automata converter(){
        Automata afn = new Automata();
        afn.sigma = this.sigma;
        afn.sigma.remove("ε");
        
        for(State s : delta){
            if(s.getID().contains("f")){
                afn.addStateFinal(s.updateState(s.fechoVazio(), this));
            }
            else{
                if(s.getID().contains("0"))
                    afn.addStateInicial(s.updateState(s.fechoVazio(), this));
                else
                    afn.addState(s.updateState(s.fechoVazio(), this));
            }
            
        }
        
        return afn;        
    }
    
    
}
