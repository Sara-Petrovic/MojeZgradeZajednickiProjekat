package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VlasnikPosebnogDelaTest extends GenericEntityTest {

	private VlasnikPosebnogDela v;
	
	@BeforeEach
	void setUp() throws Exception {
		genericEntity = new VlasnikPosebnogDela();
		v = new VlasnikPosebnogDela();
	}

	@AfterEach
	void tearDown() throws Exception {
		genericEntity = null;
		v=null;
	}

	@Test
	void testVlasnikPosebnogDela() {
		v = new VlasnikPosebnogDela();
		
		assertNotNull(v);
	}

	@Test
	void testVlasnikPosebnogDelaLongStringStringStringDoubleStringStambenaZajednica() {
		v = new VlasnikPosebnogDela(1l, "Pera", "Peric", "12", 43, "pera@gmail.com", new StambenaZajednica());
		
		assertNotNull(v);
		assertEquals(1l, v.getVlasnikId());
		assertEquals("Pera", v.getIme());
		assertEquals("Peric", v.getPrezime());
		assertEquals("12", v.getBrojPosebnogDela());
		assertEquals(43, v.getVelicinaPosebnogDela());
		assertEquals("pera@gmail.com", v.getKontaktVlasnika());
		assertNotNull(v.getStambenaZajednica());
	}

	@Test
	void testSetStambenaZajednica() {
		v.setStambenaZajednica(new StambenaZajednica());
		
		assertNotNull(v.getStambenaZajednica());
	}

	@Test
	void testSetVlasnikId() {
		v.setVlasnikId(3l);
		
		assertEquals(3l,v.getVlasnikId());
	}

	@Test
	void testSetIme() {
		v.setIme("Mika");
		
		assertEquals("Mika",v.getIme());
	}

	@Test
	void testSetPrezime() {
		v.setPrezime("Mikic");
		
		assertEquals("Mikic",v.getPrezime());
	}

	@Test
	void testSetBrojPosebnogDela() {
		v.setBrojPosebnogDela("14");
		
		assertEquals("14",v.getBrojPosebnogDela());
	}

	@Test
	void testSetVelicinaPosebnogDela() {
		v.setVelicinaPosebnogDela(55);
		
		assertEquals(55,v.getVelicinaPosebnogDela());
	}

	@Test
	void testSetKontaktVlasnika() {
		v.setKontaktVlasnika("mika@gmail.com");
		
		assertEquals("mika@gmail.com",v.getKontaktVlasnika());
	}

	@Test
	void testSetMernaJedinica() {
		v.setMernaJedinica(MernaJedinica.m2);
		
		assertEquals(MernaJedinica.m2,v.getMernaJedinica());
	}

	@Test
	void testToString() {
		v.setIme("Zika");
		v.setPrezime("Zikic");
		
		String s = v.toString();
		
		assertTrue(s.contains("Zika"));
		assertTrue(s.contains("Zikic"));
		
	}
}
