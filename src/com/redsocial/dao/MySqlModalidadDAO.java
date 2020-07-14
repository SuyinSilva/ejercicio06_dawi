package com.redsocial.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.redsocial.bean.DeporteBean;
import com.redsocial.bean.FiltroBean;
import com.redsocial.bean.ModalidadBean;

public class MySqlModalidadDAO implements ModalidadDAO{
	
	/*
	 * Session en myIbatis-->Coneccion de BD
	 * SqlSessionFactory -->Permite crear conexiones
	 */
	
	SqlSessionFactory sqlMapper = null;
	{
		String archivo = "ConfiguracionIbatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(archivo);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ModalidadBean> listaModalidad(String filtro) throws Exception {
		SqlSession session = null;
		List<ModalidadBean> salida = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_lista_modalidad", filtro+"%")  ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	@Override
	public int actualizaModalidad(ModalidadBean bean) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.update("SQL_actualiza_Modalidad", bean);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}
	@Override
	public int insertaModalidad(ModalidadBean bean) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.insert("SQL_inserta_modalidad", bean);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}
	@Override
	public int eliminaModalidad(int idModalidad) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.delete("SQL_elimina_Modalidad", idModalidad);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}
	@Override
	public List<DeporteBean> listaDeporte() throws Exception {
		SqlSession session = null;
		List<DeporteBean> salida = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_lista_deporte");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	@Override
	public List<ModalidadBean> listaModalidad(FiltroBean filtro) throws Exception {
		SqlSession session = null;
		List<ModalidadBean> salida = null;
		try {
			session = sqlMapper.openSession();
			filtro.setNombre(filtro.getNombre()+"%");
			salida = session.selectList("SQL_listaModalidadPorFiltro",filtro );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	@Override
	public List<ModalidadBean> listaModalidadMultiple(FiltroBean filtro) throws Exception {
		SqlSession session = null;
		List<ModalidadBean> salida = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_listaModalidadMultiple",filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	

	
}
	