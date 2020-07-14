package com.redsocial.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.redsocial.bean.ConcursoBean;

public class MySqlConcursoDAO implements ConcursoDAO {
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
	public int eliminaConcurso(int idConcurso) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.delete("SQL_elimina_Concurso", idConcurso);
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
	public int insertaConcurso(ConcursoBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.insert("SQL_inserta_Concurso", obj);
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
	public int actualizaConcurso(ConcursoBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.update("SQL_actualiza_Concurso", obj);
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
	public List<ConcursoBean> consultaConcurso(String filtro) throws Exception {
		List<ConcursoBean> salida = null;
		SqlSession session = null;
		try {
			//Se crea la conexión(Session) a la BD
			session = sqlMapper.openSession();
			//Se aplica al sentecia en la BD
			salida = session.selectList("SQL_lista_Concurso", filtro+"%");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	
	
	
	
}
