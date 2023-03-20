package it.polito.tdp.alien.model;

import java.util.*;

public class Dizionario {
	
	HashMap<String, List<String>> mappaParole=new HashMap<String, List<String>>();
	
	public void aggiungiParole(String parola, String traduzione) {
		//mappaParole.put(parola, traduzione); 
		if(mappaParole.containsKey(parola)) {
			mappaParole.get(parola).add(traduzione);
		}
		else {
		List<String> lista=new LinkedList<String>();
		lista.add(traduzione);
		mappaParole.put(parola, lista);
		}
	}
	
	public List<String> daiSignificato(String parola) {
		List<String> lista=new LinkedList<String>();
		lista=mappaParole.get(parola);
		if(lista==null)
			return null;
		return lista;
			
	}

}
