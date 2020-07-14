package com.redsocial.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.DeporteBean;
import com.redsocial.bean.ModalidadBean;
import com.redsocial.service.ModalidadService;
import com.redsocial.service.ModalidadServiceImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@SuppressWarnings("serial")
@ParentPackage("dawi")
@CommonsLog
public class ModalidadAction extends ActionSupport {

	// Para la consulta
	private @Getter @Setter List<ModalidadBean> lstModalidad = new ArrayList<ModalidadBean>();
	private @Getter @Setter String filtro = "";

	// Para el combo
	private @Getter @Setter List<DeporteBean> lstDeporte = new ArrayList<DeporteBean>();

	// Para insertar y actualizar
	private @Getter @Setter ModalidadBean modalidad;
	
	// Para eliminar
	private @Getter @Setter String id;

	@Action(value = "/cargaDeporte", results = { @Result(name = "success", type = "json") })
	public String cargaDeporte() {
		log.info("En carga deporte");
		try {
			ModalidadServiceImpl service = new ModalidadServiceImpl();
			lstDeporte = service.listaDeporte();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/eliminaModalidad", results = { @Result(name = "success", location = "/crudModalidad.jsp") })
	public String elimina() {
		log.info("En eliminar Modalidad");
		ModalidadService service = new ModalidadServiceImpl();
		try {
			service.eliminaModalidad(Integer.parseInt(id));
			lstModalidad = service.listaModalidad(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/actualizaModalidad", results = { @Result(name = "success", location = "/crudModalidad.jsp") })
	public String actualiza() {
		log.info("En actualizar Modalidad");
		ModalidadService service = new ModalidadServiceImpl();
		try {
			service.actualizaModalidad(modalidad);
			lstModalidad = service.listaModalidad(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/registraModalidad", results = { @Result(name = "success", location = "/crudModalidad.jsp") })
	public String registra() {
		log.info("En registrar Modalidad");
		try {
			ModalidadService service = new ModalidadServiceImpl();
			service.insertaModalidad(modalidad);
			lstModalidad = service.listaModalidad(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/consultaModalidad", results = { @Result(name = "success", location = "/crudModalidad.jsp") })
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


}
