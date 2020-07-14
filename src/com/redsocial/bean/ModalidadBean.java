package com.redsocial.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModalidadBean {
	private int idModalidad;
	private String nombre;
	private int edadMaxima;
	private int edadMinima;
	private int numHombres;
	private int numMujeres;
	private String sede;
	private DeporteBean deporte;
	
}
