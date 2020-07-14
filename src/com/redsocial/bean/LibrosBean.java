package com.redsocial.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibrosBean {
	
	 private int idLibros;
	 private String titulo;
	 private Double precio;
	 private TemaBean Tema ;
}
