
package afeconverterafn;

import java.util.*;

/**
 *
 * @author Jonas
 */
class Automata {

    protected ArrayList<String> sigma; // Alfabeto
    protected ArrayList <State> delta; // Função Programa, leitura (ConjEstados Q x Alfabeto Sigma)
    protected State q0; // Estado Inicial
    protected ArrayList<State> finais; // Conjunto de estados finais

    Automata(){
        this.sigma = new ArrayList<>(); // Alfabeto
        this.delta = new ArrayList<>();// Funcao Programa (Tem o Conjunto de Estados)
        this.finais = new ArrayList<>(); // Conj. Estados Finais
    }
    
    public State deltaFindState(String key){
        //Iteracao, todos os estados presentes na funcao programa
        for(State estado : delta){ 
            if(estado.getID().equals(key))//Comparacao ID==key ?
                return estado; //Estado encontrado
        }
        return null;
    }
    
    public boolean isStateInsideDelta(String key){
        State temp = this.deltaFindState(key);
        return (temp == null)? false : true; 
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
        this.sigma.add(letra);
    }
}
