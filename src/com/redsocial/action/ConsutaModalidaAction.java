package com.redsocial.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.FiltroBean;
import com.redsocial.bean.ModalidadBean;
import com.redsocial.service.ModalidadService;
import com.redsocial.service.ModalidadServiceImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@SuppressWarnings("serial")
@ParentPackage("dawi")
@CommonsLog
public class ConsutaModalidaAction extends ActionSupport {

	private @Getter @Setter List<ModalidadBean> lstModalidad = new ArrayList<ModalidadBean>();

	private @Getter @Setter FiltroBean filtro;

	@Action(value = "/consultaModalidadPorFiltro", results = { @Result(name = "success", type = "json") })
	public String listar() {
		log.info("En listar Modalidad");
		try {
			ModalidadService service = new ModalidadServiceImpl();
			lstModalidad = service.listaModalidad(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/consultaModalidadMultiple", results = { @Result(name = "success", type = "json") })
	public String listarMultiple() {
		log.info("En listar listarMultiple");
		try {
			ModalidadService service = new ModalidadServiceImpl();
			lstModalidad = service.listaModalidadMultiple(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
