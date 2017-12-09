/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unidavi.webdev.poo.continuous.integration;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jessicapeixe
 */
public class WordCount {
    
    private final Map<String, Integer> lista = new TreeMap<>();
    
    public Map<String, Integer> phrase(String sFrase) {
        
        setaDadosLista(sFrase);
        
        return inverteListaPalavras();
    }
    
    /**
     * Seta a frase informada no contador
     * @param sFrase 
     */
    private void setaDadosLista(String sFrase) {
        String[] aPalavras = sFrase.split(" ");
        
        for (String sPalavra : aPalavras) {
            
            Integer iTotal = 1;
            for (Map.Entry<String, Integer> pair : lista.entrySet()) {
                if (sPalavra.equals(pair.getKey())){
                    iTotal = pair.getValue() + 1;
                }
            }

            if (iTotal == 1) {
                lista.put(sPalavra, iTotal);
            }
            else {
                for (Map.Entry<String, Integer> pair : lista.entrySet()) {
                    if (sPalavra.equals(pair.getKey())){
                        pair.setValue(iTotal);
                    }
                }
            }
        }
    }
    
    /**
     * Inverte os dados do contador
     * @return Map
     */
    private Map<String, Integer> inverteListaPalavras() {
        
        Map<String, Integer> aDadosInvertidos = new TreeMap<>();
        
        for (Map.Entry<String, Integer> oLista : lista.entrySet()) {
            aDadosInvertidos.put(oLista.getKey(), oLista.getValue());
        }
        
        return aDadosInvertidos;
    }
}