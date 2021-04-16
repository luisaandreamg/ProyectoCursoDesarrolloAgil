package cursoDAgil.dao.ganancias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Ganancias;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class GananciasDaoImplTest {
	@Inject
	GananciasDao gananciasDao;


	@Ignore
	public void consultarGananciasPorId() {
		Ganancias ganancias = new Ganancias();
		Map<String, Integer> mapGanancias = new HashMap<>();
		mapGanancias.put("idGanancia", 1);
		try{
			ganancias = gananciasDao.obtenerGananciasPorId(mapGanancias);
			assertNotNull(ganancias);
			System.out.println("id:" + ganancias.getIdGanancia());
			System.out.println("calle:" + ganancias.getTotalGanancia());
		}catch(Exception e){
			System.out.println("Error4: " + e);
		}
	}
	
	@Test
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("Test consultar todas las ganancias");
		try{
			List<Ganancias> lista = gananciasDao.obtenerGanancias();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		}catch (Exception e) {
			System.out.println("error5" + e);
		}
	}
	
	@Ignore
	public void nuevoRegistro() {
		Ganancias ganancia = new Ganancias();
		System.out.println("Test nuevo registro");
		try {
			ganancia.setIdGanancia(4);
			ganancia.setIdVenta(3);
			ganancia.setTotalGanancia(11.2);
			SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
			try{
				Date date = DateFor.parse("08/07/2019");
				ganancia.setDate(date);
			}catch(ParseException e){
				e.printStackTrace();
			}
			
			gananciasDao.nuevaGanancia(ganancia);
		} catch (Exception e) {
			System.out.println("Error6: " + e);
		}
	}
}
