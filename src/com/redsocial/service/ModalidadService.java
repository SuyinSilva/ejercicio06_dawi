package com.redsocial.service;

import java.util.List;

import com.redsocial.bean.DeporteBean;
import com.redsocial.bean.FiltroBean;
import com.redsocial.bean.ModalidadBean;

public interface ModalidadService {


	public List<ModalidadBean> listaModalidad(String filtro) throws Exception;
	public int actualizaModalidad(ModalidadBean bean) throws Exception;
	public int insertaModalidad(ModalidadBean bean) throws Exception;
	public int eliminaModalidad(int idModalidad) throws Exception;
	public List<DeporteBean> listaDeporte() throws Exception;
	
	public List<ModalidadBean> listaModalidad(FiltroBean filtro)  throws Exception;
	public List<ModalidadBean> listaModalidadMultiple(FiltroBean filtro)  throws Exception;
}
