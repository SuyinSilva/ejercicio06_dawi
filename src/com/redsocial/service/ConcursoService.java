package com.redsocial.service;

import java.util.List;

import com.redsocial.bean.ConcursoBean;

public interface ConcursoService {

	public abstract int eliminaConcurso(int idConcurso) throws Exception;
	public abstract int insertaConcurso(ConcursoBean obj) throws Exception;
	public abstract int actualizaConcurso(ConcursoBean obj) throws Exception;
	public abstract List<ConcursoBean> consultaConcurso(String filtro) throws Exception;
	
	
	
	
}
