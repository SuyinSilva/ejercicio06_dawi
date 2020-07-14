package com.redsocial.service;

import java.util.List;

import com.redsocial.bean.FiltroLibrosBean;
import com.redsocial.bean.LibrosBean;
import com.redsocial.bean.TemaBean;
import com.redsocial.dao.MySqlLibrosDAO;


public class LibrosServiceImpl implements LibrosService{

	MySqlLibrosDAO dao = new MySqlLibrosDAO();
	
	@Override
	public List<LibrosBean> listaLibros(String filtro) throws Exception {
		return dao.listaLibros(filtro);
	}

	@Override
	public int actualizaLibros(LibrosBean bean) throws Exception {
		return dao.actualizaLibros(bean);
	}

	@Override
	public int insertaLibros(LibrosBean bean) throws Exception {
		return dao.insertaLibros(bean);
	}

	@Override
	public List<TemaBean> listaTema() throws Exception {
		return dao.listaTema();
	}

	@Override
	public int eliminaLibros(int idLibros) throws Exception {
		return dao.eliminaLibros(idLibros);
	}

	@Override
	public List<LibrosBean> listaLibros(FiltroLibrosBean filtro) throws Exception {
		return dao.listaLibros(filtro);
	}

	@Override
	public List<LibrosBean> listaLibrosMultiple(FiltroLibrosBean filtro) throws Exception {
		return dao.listaLibrosMultiple(filtro);
	}

}
