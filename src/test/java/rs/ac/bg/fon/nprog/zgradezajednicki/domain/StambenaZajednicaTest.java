package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



class StambenaZajednicaTest extends GenericEntityTest {

	private StambenaZajednica sz;
	
	@BeforeEach
	void setUp() throws Exception {
		genericEntity = new StambenaZajednica();
		sz = new StambenaZajednica();
	}

	@AfterEach
	void tearDown() throws Exception {
		genericEntity = null;
		sz = null;
	}

	@Test
	void testStambenaZajednica() {
		sz = new StambenaZajednica();
		
		assertNotNull(sz);
	}

	@Test
	void testStambenaZajednicaLongStringStringMestoStringStringStringString() {
		sz = new StambenaZajednica(3l, "Hilandarska", "1", new Mesto(), "170-123", "Intesa", "123", "321");
		
		assertNotNull(sz);
		assertEquals(3l, sz.getStambenaZajednicaId());
		assertEquals("1", sz.getBroj());
		assertEquals("Hilandarska", sz.getUlica());
		assertNotNull(sz.getMesto());
		assertEquals("170-123", sz.getTekuciRacun());
		assertEquals("Intesa", sz.getBanka());
		assertEquals("123", sz.getPib());
		assertEquals("321", sz.getMaticniBroj());
	}

	@Test
	void testSetBanka() {
		sz.setBanka("Unicredit");
		
		assertEquals("Unicredit", sz.getBanka());
	}

	@Test
	void testSetPib() {
		sz.setPib("123");
		
		assertEquals("123", sz.getPib());
	}

	@Test
	void testSetMaticniBroj() {
		sz.setMaticniBroj("321");
		
		assertEquals("321", sz.getMaticniBroj());
	}

	@Test
	void testSetTekuciRacun() {
		sz.setTekuciRacun("170-111");
		
		assertEquals("170-111", sz.getTekuciRacun());
	}

	@Test
	void testSetStambenaZajednicaId() {
		sz.setStambenaZajednicaId(12l);
		
		assertEquals(12l, sz.getStambenaZajednicaId());
	}

	@Test
	void testSetUlica() {
		sz.setUlica("Rajacka");
		
		assertEquals("Rajacka", sz.getUlica());
	}

	@Test
	void testSetUlicaKratakString() {
		
		assertThrows(java.lang.RuntimeException.class, ()->sz.setUlica("Vojv"));
		
	}
	@Test
	void testSetBroj() {
		sz.setBroj("15");
		
		assertEquals("15", sz.getBroj());
	}

	@Test
	void testSetMesto() {
		sz.setMesto(new Mesto());
		
		assertNotNull(sz.getMesto());
	}

	@Test
	void testToString() {
		sz.setUlica("Vojvode Stepe");
		sz.setBroj("15");
		sz.setMesto(new Mesto(1l, "123", "Beograd"));
		
		String s = sz.toString();
		
		assertTrue(s.contains("Vojvode Stepe"));
		assertTrue(s.contains("15"));
		assertTrue(s.contains("Beograd"));
		
	}
	@ParameterizedTest
	@CsvSource({
		"167, 185, false",
		"173, 173, true"

	})
	void testEqualsObject(Long id1,Long id2, boolean eq) {
		sz.setStambenaZajednicaId(id1);
		
		StambenaZajednica sz2 = new StambenaZajednica();
		sz2.setStambenaZajednicaId(id2);
		
		assertEquals(eq, sz.equals(sz2));
	}

}
