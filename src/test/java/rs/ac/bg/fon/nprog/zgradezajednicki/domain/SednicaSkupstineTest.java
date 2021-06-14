package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SednicaSkupstineTest extends GenericEntityTest {
	
	private SednicaSkupstine ss;

	@BeforeEach
	void setUp() throws Exception {
		genericEntity = new SednicaSkupstine();
		ss= new SednicaSkupstine();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		genericEntity = null;
		ss=null;
	}

	@Test
	void testSednicaSkupstine() {
		ss= new SednicaSkupstine();
		
		assertNotNull(ss);
		assertNotNull(ss.getVlasnici());
	}

	@Test
	void testSednicaSkupstineLongDateIntStringStambenaZajednicaListOfVlasnikPosebnogDela() {
		ss = new SednicaSkupstine(2l, new Date(), 0, "Popravka krova", new StambenaZajednica(), new ArrayList<VlasnikPosebnogDela>());
	
		assertNotNull(ss);
		assertEquals(2l, ss.getSednicaSkupstineId());
		assertNotNull(ss.getDatumOdrzavanja());
		assertEquals("Popravka krova", ss.getDnevniRed());
		assertNotNull(ss.getStambenaZajednica());
		assertNotNull(ss.getVlasnici());
	}

	@Test
	void testSetVlasnici() {

		ss.setVlasnici(new ArrayList<VlasnikPosebnogDela>());
		assertNotNull(ss.getVlasnici());
		
	}

	@Test
	void testSetSednicaSkupstineId() {
		ss.setSednicaSkupstineId(2l);
		
		assertEquals(2l, ss.getSednicaSkupstineId());
	}

	@Test
	void testSetDatumOdrzavanja() {
		ss.setDatumOdrzavanja(new Date());
		
		assertNotNull(ss.getDatumOdrzavanja());
	}

	@Test
	void testSetBrojPrisutnih() {
		ss.setBrojPrisutnih(14);
		
		assertEquals(14, ss.getBrojPrisutnih());
	}

	@Test
	void testSetBrojPrisutnihNula() {
		
		assertThrows(java.lang.RuntimeException.class, ()->ss.setBrojPrisutnih(0));
		
	}
	@Test
	void testSetDnevniRed() {
		ss.setDnevniRed("Krecenje");
		
		assertEquals("Krecenje", ss.getDnevniRed());
	}

	@Test
	void testSetStambenaZajednica() {
		ss.setStambenaZajednica(new StambenaZajednica());
		
		assertNotNull(ss.getStambenaZajednica());
	}

}
