package com.redsocial.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.CategoriaBean;
import com.redsocial.bean.ClienteBean;
import com.redsocial.service.ClienteServiceImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@SuppressWarnings("serial")
@ParentPackage("dawi")
@CommonsLog
public class ClienteAction extends ActionSupport {

	private @Getter @Setter ClienteBean cliente = new ClienteBean();
	private @Getter @Setter  List<CategoriaBean> lstCategoria = new ArrayList<CategoriaBean>();

	private Map<String, Object> session = ActionContext.getContext().getSession();

	@Action(value = "/registraCliente", results = {
			@Result(name = "success", location = "/registraCliente.jsp", type = "redirect") })
	public String registra() {
		log.info("En registrar Cliente");
		try {
			ClienteServiceImpl service = new ClienteServiceImpl();
			int s = service.insertaCliente(cliente);
			if (s > 0) {
				session.put("MENSAJE", "Registro exitoso");
			} else {
				session.put("MENSAJE", "Registro erróneo");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/cargaCategoria", results = { @Result(name = "success", type = "json") })
	public String cargaDeporte() {
		log.info("En carga deporte");
		try {
			ClienteServiceImpl service = new ClienteServiceImpl();
			lstCategoria = service.listaCategoria();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
