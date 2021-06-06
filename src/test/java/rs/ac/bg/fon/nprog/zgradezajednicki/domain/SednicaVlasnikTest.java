package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SednicaVlasnikTest extends GenericEntityTest {

	private SednicaVlasnik sv;
	
	@BeforeEach
	void setUp() throws Exception {
		genericEntity = new SednicaVlasnik();
		sv = new SednicaVlasnik();
	}

	@AfterEach
	void tearDown() throws Exception {
		genericEntity = null;
		sv = null;
	}

	@Test
	void testSednicaVlasnik() {
		sv= new SednicaVlasnik();
		
		assertNotNull(sv);
	}

	@Test
	void testSednicaVlasnikSednicaSkupstineVlasnikPosebnogDela() {
		sv = new SednicaVlasnik(new SednicaSkupstine(), new VlasnikPosebnogDela());
		
		assertNotNull(sv);
		assertNotNull(sv.getSednicaSkupstine());
		assertNotNull(sv.getVlasnikPosebnogDela());
	}

	@Test
	void testSetSednicaSkupstine() {
		sv.setSednicaSkupstine(new SednicaSkupstine());
		
		assertNotNull(sv.getSednicaSkupstine());
	}

	@Test
	void testSetVlasnikPosebnogDela() {
		sv.setVlasnikPosebnogDela(new VlasnikPosebnogDela());
		
		assertNotNull(sv.getVlasnikPosebnogDela());
	}

}
