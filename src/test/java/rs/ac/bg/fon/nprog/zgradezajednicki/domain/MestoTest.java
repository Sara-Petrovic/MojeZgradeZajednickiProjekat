package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class MestoTest extends GenericEntityTest {

	private Mesto m;
	
	@BeforeEach
	void setUp() throws Exception {
		genericEntity = new Mesto();
		
		m = new Mesto();
	}

	@AfterEach
	void tearDown() throws Exception {
		genericEntity = null;
		m=null;
	}

	@Test
	void testMesto() {
		m = new Mesto();
		
		assertNotNull(m);
	}

	@Test
	void testMestoLongStringString() {
		m = new Mesto(3l, "31000", "Uzice");
		
		assertNotNull(m);
		assertEquals(3l, m.getMestoId());
		assertEquals("31000", m.getPtt());
		assertEquals("Uzice", m.getNaziv());

	}

	@Test
	void testSetNaziv() {
		m.setNaziv("Beograd");
		
		assertEquals("Beograd", m.getNaziv()); 
	}
	
	@Test
	void testSetNazivNull() {

		assertThrows(java.lang.NullPointerException.class, ()->m.setNaziv(null));

	}
	
	@Test
	void testSetNazivKratakString() {
		
		assertThrows(java.lang.RuntimeException.class, ()->m.setNaziv("U"));
		
	}

	@Test
	void testSetMestoId() {
		m.setMestoId(4l);
		
		assertEquals(4l, m.getMestoId());
	}

	@Test
	void testSetMestoIdNull() {

		assertThrows(java.lang.NullPointerException.class, ()->m.setMestoId(null));

	}
	@Test
	void testSetPtt() {
		m.setPtt("31000");
		
		assertEquals("31000", m.getPtt());
	}
	@Test
	void testSetPttNull() {

		assertThrows(java.lang.NullPointerException.class, ()->m.setPtt(null));

		
	}
	
	@Test
	void testToString() {
		m.setNaziv("Novi Sad");
		
		String s = m.toString();
		
		assertTrue(s.contains("Novi Sad"));
		
	}

	@ParameterizedTest
	@CsvSource({
		"3, 3, true",
		"2, 5, false"

	})
	void testEqualsObject(Long  id1,Long id2, boolean eq) {
		m.setMestoId(id1);
		
		Mesto m2= new Mesto();
		m2.setMestoId(id2);
		
		assertEquals(eq, m.equals(m2));
	}

}
