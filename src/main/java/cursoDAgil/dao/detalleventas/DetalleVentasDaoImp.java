package cursoDAgil.dao.detalleventas;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.mappers.DetalleVentasMapper;

@Named
public class DetalleVentasDaoImp implements DetalleVentasDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4113698898281390702L;
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<DetalleVentas> listarTodasDetalleVentas() {
		List<DetalleVentas> list = null;
		try{
			DetalleVentasMapper detalleVentasMapper = sqlSession.getMapper(DetalleVentasMapper.class);
			list = detalleVentasMapper.listarTodasDetalleVentas();
			return list;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

}
