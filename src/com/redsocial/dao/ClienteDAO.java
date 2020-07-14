package com.redsocial.dao;

import java.util.List;

import com.redsocial.bean.CategoriaBean;
import com.redsocial.bean.ClienteBean;

public interface ClienteDAO {

	public abstract List<CategoriaBean> listaCategoria() throws Exception;

	public abstract int insertaCliente(ClienteBean obj) throws Exception;

}
