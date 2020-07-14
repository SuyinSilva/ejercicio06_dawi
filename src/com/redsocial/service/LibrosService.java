package com.redsocial.service;

import java.util.List;


import com.redsocial.bean.FiltroLibrosBean;
import com.redsocial.bean.LibrosBean;
import com.redsocial.bean.TemaBean;

public interface LibrosService {


	public List<LibrosBean> listaLibros(String filtro) throws Exception;
	public int actualizaLibros(LibrosBean bean) throws Exception;
	public int insertaLibros(LibrosBean bean) throws Exception;
	public int eliminaLibros(int idLibros) throws Exception;
	public List<TemaBean> listaTema() throws Exception;
	
	public List<LibrosBean> listaLibros(FiltroLibrosBean filtro)  throws Exception;
	public List<LibrosBean> listaLibrosMultiple(FiltroLibrosBean filtro)  throws Exception;
}
