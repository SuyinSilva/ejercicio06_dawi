package com.redsocial.service;

import com.redsocial.bean.MedicamentoBean;
import com.redsocial.dao.MySqlMedicamentoDAO;

public class MedicamentoServiceImpl implements MedicamentoService {

	MySqlMedicamentoDAO dao = new MySqlMedicamentoDAO();
	
	@Override
	public int insertaMedicamento(MedicamentoBean obj) throws Exception {
		return dao.insertaMedicamento(obj);
	}

}
