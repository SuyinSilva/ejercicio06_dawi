package com.redsocial.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.ConcursoBean;
import com.redsocial.service.ConcursoService;
import com.redsocial.service.ConcursoServiceImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@SuppressWarnings("serial")
@ParentPackage("dawi")
@CommonsLog
public class ConcursoAction extends ActionSupport{
	
	//Para la consulta
	private @Getter @Setter List<ConcursoBean> concursos= new ArrayList<ConcursoBean>();
	private @Getter @Setter String filtro ="";
	
	//para el registrar y actualizar
	private @Getter @Setter ConcursoBean concurso;
	
	//para eliminar
	private @Getter @Setter String id;
	
	@Action(value="/eliminaConcurso",results={@Result(name="success", location="/crudConcurso.jsp")	})
	public String elimina(){
		log.info("En eliminar concurso");
		try {
			ConcursoService service = new ConcursoServiceImpl();
			service.eliminaConcurso(Integer.parseInt(id));
			concursos =  service.consultaConcurso(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value="/actualizaConcurso",results={@Result(name="success", location="/crudConcurso.jsp")})
	public String actualiza(){
		log.info("En actualizar concurso");	
		try {
			ConcursoService service = new ConcursoServiceImpl();
			service.actualizaConcurso(concurso);
			concursos =  service.consultaConcurso(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value="/registraConcurso",results={@Result(name="success", location="/crudConcurso.jsp")})
	public String registra(){
		log.info("En registrar concurso");		
		try {
			ConcursoService service = new ConcursoServiceImpl();
			service.insertaConcurso(concurso);
			concursos =  service.consultaConcurso(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value="/consultaConcurso",results={@Result(name="success", location="/crudConcurso.jsp")})
	public String listar(){
		log.info("En listar concurso");	
		ConcursoService service = new ConcursoServiceImpl();
		try {
			concursos =  service.consultaConcurso(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
}



