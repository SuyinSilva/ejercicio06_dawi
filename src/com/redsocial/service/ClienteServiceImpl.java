package com.redsocial.service;

import java.util.List;

import com.redsocial.bean.CategoriaBean;
import com.redsocial.bean.ClienteBean;
import com.redsocial.dao.MySqlClienteDAO;

public class ClienteServiceImpl implements ClienteService {

	MySqlClienteDAO dao = new MySqlClienteDAO();

	@Override
	public List<CategoriaBean> listaCategoria() throws Exception {
		return dao.listaCategoria();
	}

	@Override
	public int insertaCliente(ClienteBean obj) throws Exception {
		return dao.insertaCliente(obj);
	}

}
