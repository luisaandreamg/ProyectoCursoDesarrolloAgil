package cursoDAgil.dao.ganancias;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.bd.mappers.GananciasMapper;

@Named
public class GananciasDaoImpl implements GananciasDao {

	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Ganancias> obtenerGanancias() {
		try{
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			return gananciasMapper.obtenerGanancias();
		}catch(Exception e){
			System.out.println("Error1: " + e);
		}
		return null;
	}

	@Override
	public Integer nuevaGanancia(Ganancias ganancias) {
		try{
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			System.out.println("ganancia creada con éxito");
			return gananciasMapper.nuevaGanancia(ganancias);
		}catch(Exception e){
			System.out.println("Error2: " + e);
		}
		return null;
	}

	@Override
	public Ganancias obtenerGananciasPorId(Map<String, Integer> mapGanancias) {
		try{
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			return gananciasMapper.obtenerGananciasPorId(mapGanancias);
		}catch(Exception e){
			System.out.println("Error3: " + e);
		}
		return null;
	}

}
