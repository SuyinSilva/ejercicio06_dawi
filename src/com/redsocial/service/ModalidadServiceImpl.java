package com.redsocial.service;

import java.util.List;

import com.redsocial.bean.DeporteBean;
import com.redsocial.bean.FiltroBean;
import com.redsocial.bean.ModalidadBean;
import com.redsocial.dao.MySqlModalidadDAO;

public class ModalidadServiceImpl implements ModalidadService{

	MySqlModalidadDAO dao = new MySqlModalidadDAO();
	
	@Override
	public List<ModalidadBean> listaModalidad(String filtro) throws Exception {
		return dao.listaModalidad(filtro);
	}

	@Override
	public int actualizaModalidad(ModalidadBean bean) throws Exception {
		return dao.actualizaModalidad(bean);
	}

	@Override
	public int insertaModalidad(ModalidadBean bean) throws Exception {
		return dao.insertaModalidad(bean);
	}

	@Override
	public List<DeporteBean> listaDeporte() throws Exception {
		return dao.listaDeporte();
	}

	@Override
	public int eliminaModalidad(int idModalidad) throws Exception {
		return dao.eliminaModalidad(idModalidad);
	}

	@Override
	public List<ModalidadBean> listaModalidad(FiltroBean filtro) throws Exception {
		return dao.listaModalidad(filtro);
	}

	@Override
	public List<ModalidadBean> listaModalidadMultiple(FiltroBean filtro) throws Exception {
		return dao.listaModalidadMultiple(filtro);
	}

}
