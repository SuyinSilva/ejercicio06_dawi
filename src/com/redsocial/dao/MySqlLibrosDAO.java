package com.redsocial.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.redsocial.bean.FiltroLibrosBean;
import com.redsocial.bean.LibrosBean;
import com.redsocial.bean.TemaBean;

public class MySqlLibrosDAO implements LibrosDAO{
	
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
	public List<LibrosBean> listaLibros(String filtro) throws Exception {
		SqlSession session = null;
		List<LibrosBean> salida = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_lista_libros", filtro+"%")  ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	@Override
	public int actualizaLibros(LibrosBean bean) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.update("SQL_actualiza_libros", bean);
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
	public int insertaLibros(LibrosBean bean) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.insert("SQL_inserta_libros", bean);
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
	public int eliminaLibros(int idLibros) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.delete("SQL_elimina_libros", idLibros);
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
	public List<TemaBean> listaTema() throws Exception {
		SqlSession session = null;
		List<TemaBean> salida = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_lista_tema");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	@Override
	public List<LibrosBean> listaLibros(FiltroLibrosBean filtro) throws Exception {
		SqlSession session = null;
		List<LibrosBean> salida = null;
		try {
			session = sqlMapper.openSession();
			filtro.setTitulo(filtro.getTitulo()+"%");
			salida = session.selectList("SQL_listaLibrosPorFiltro",filtro );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	@Override
	public List<LibrosBean> listaLibrosMultiple(FiltroLibrosBean filtro) throws Exception {
		SqlSession session = null;
		List<LibrosBean> salida = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_listaLibrosMultiple",filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	

	
}
	