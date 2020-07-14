package com.redsocial.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.MedicamentoBean;
import com.redsocial.service.MedicamentoServiceImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@SuppressWarnings("serial")
@ParentPackage("dawi")
@CommonsLog
public class MedicamentoAction extends ActionSupport{

	@Getter@Setter
	private MedicamentoBean medicamento;
	
	private Map<String, Object> session = ActionContext.getContext().getSession();

	
	@Action(value = "/registraMedicamento", results = { @Result(name = "success", location = "/registraMedicamento.jsp", type = "redirect") })
	public String registra() {
		log.info("En registrar Medicamento");
		try {
			MedicamentoServiceImpl service = new MedicamentoServiceImpl();
			int s = service.insertaMedicamento(medicamento);
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
}
