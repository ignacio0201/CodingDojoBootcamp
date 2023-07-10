package com.codingdojo.mapadehashmatique;

import java.util.HashMap;
import java.util.Set;

public class ProyectoTrackList {
	
	//ATRIBUTOS ENCAPSULADOS
	private HashMap<String, String> trackList;
	
	//CONSTRUCTOR - INICIALIZACION ATRIBUTOS
	public ProyectoTrackList() {
		this.trackList = new HashMap<String, String>();
	}
	
	//GETTERS Y SETTERS
	public HashMap<String, String> getTrackList() {
		return trackList;
	}

	public void setTrackList(HashMap<String, String> trackList) {
		this.trackList = trackList;
	}
	
	//METODOS
	
	//AGREGAR CANCION
	void agregarTrack(String titulo, String letra) {
		trackList.put(titulo, letra);
	}
	
	//OBTENER CANCION
	void obtenerTrack(String titulo) {
		boolean encontrado = false;
		//SI SE ENCUENTRA
		Set<String> tracks = trackList.keySet();
		for (String track : tracks) {
			if(track.equalsIgnoreCase(titulo.trim())) {
				System.out.println(track + ": " + trackList.get(track));
				encontrado = true;
				break;
			}
	    }
		//SI NO SE ENCUENTRA
		if(encontrado != true) {
			System.out.println("No se han encontrado resultados para: " + titulo);
		}
	}
	
	//MOSTRAR LISTA DE CANCIONES
	void mostarTrackList() {
		Set<String> tracks = trackList.keySet();
		for (String track : tracks) {
	    System.out.println(track + ": " + trackList.get(track));
	    }
	}
}


