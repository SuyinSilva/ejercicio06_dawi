package com.redsocial.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteBean {

	private int idCliente;
	private String nombre;
	private String dni;
	private String fechaNacimiento;
	private CategoriaBean categoria;
}
