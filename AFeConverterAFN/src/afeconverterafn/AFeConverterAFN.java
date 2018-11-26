/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afeconverterafn;

import afeafngui.*;

import java.util.*; // Classes Scanner, ArrayList;
import java.io.*;

/**
 *
 * @author Jonas
 */
public class AFeConverterAFN {
    
    
    
    public static Automata getAutomataFile(String filename) {
        
        Automata afe = null;
        
        try {
            afe = new Automata();
            BufferedReader file = new BufferedReader(new FileReader(filename));
            
            //primeiro leitura:´pega os símbolos do alfabeto
            String line = file.readLine();
            getSigmaLine(line, afe);           
            
            //segunda leitura: pega a quantidade de estados
            line = file.readLine();
            int j = Integer.parseInt(line.trim());
            
            //próximas n<= 7 leituras: pega os estados (Não consegui pegar as transições
            for(int i = 0; i < j; i++){
                line = file.readLine();
                afe.addState(getStateLine(line));
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("O arquivo não pôde ser localizado");
        } catch (IOException io) {
            System.out.println("Há informações faltando no arquivo");
        } finally {
            
        }
        return afe;
    }
    
    public static void getSigmaLine(String line, Automata af){
        StringTokenizer token = new StringTokenizer(line, " ");
        for(int i = 0; i < 3; i++){
            if(token.hasMoreTokens() == false){
                break;
            }else{
                af.addAlphabeto((String)token.nextToken());
            }
        }
    }
    
    public static State getStateLine(String line) {
        if(line != null){
            State state;
            StringTokenizer token = new StringTokenizer(line, " ");
            
            if(token != null){
                state = new State((String)token.nextToken());
                return state;
            }
        }
        return null;
    }
   
   public static void main(String[] args) {
        gui ui = new gui();    
        ui.setVisible(true);
       
        /*System.out.println("Nome do arquivo: ");
        String filename = (new Scanner(System.in)).nextLine();
        
        Automata afe = getAutomataFile(filename);
        
        afe.showAutomata();
        */
    }

}
