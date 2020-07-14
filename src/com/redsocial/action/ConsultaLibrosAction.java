package com.redsocial.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import com.redsocial.bean.FiltroLibrosBean;
import com.redsocial.bean.LibrosBean;
import com.redsocial.bean.TemaBean;
import com.redsocial.service.LibrosService;
import com.redsocial.service.LibrosServiceImpl;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@SuppressWarnings("serial")
@ParentPackage("dawi")
@CommonsLog
public class ConsultaLibrosAction extends ActionSupport {

	private @Getter @Setter List<LibrosBean> lstLibros = new ArrayList<LibrosBean>();
	private @Getter @Setter List<TemaBean> lstTema = new ArrayList<TemaBean>();

	private @Getter @Setter FiltroLibrosBean filtro;

	@Action(value = "/consultaLibrosMultiple", results = { @Result(name = "success", type = "json") })
	public String listarMultiple() {
		log.info("En listar listarMultiple");
		try {
			LibrosService service = new LibrosServiceImpl();
			lstLibros = service.listaLibrosMultiple(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value = "/cargaTema", results = { @Result(name = "success", type = "json") })
	public String cargaTema() {
		log.info("En carga tema");
		try {
			LibrosService service = new LibrosServiceImpl();
			lstTema = service.listaTema();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
