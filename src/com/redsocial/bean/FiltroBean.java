package com.redsocial.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiltroBean {

	private String nombre;
	private int edad;
	private int numHombres;
	private int numMujeres;
	private int idDeporte;
	
	private String[] deportes;
	
}
