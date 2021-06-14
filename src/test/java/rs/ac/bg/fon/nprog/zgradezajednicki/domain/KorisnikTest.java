package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KorisnikTest extends GenericEntityTest{

	Korisnik k;
	
	@BeforeEach
	void setUp() throws Exception {
		genericEntity = new Korisnik();
		k = new Korisnik();
	}

	@AfterEach
	void tearDown() throws Exception {
		genericEntity = null;
		k = null;
	}

	@Test
	void testKorisnik() {
		k = new Korisnik();
		
		assertNotNull(genericEntity);
	}

	@Test
	void testKorisnikLongStringStringStringString() {
		k = new Korisnik(1l, "Pera", "Peric", "pera","pera");
		
		assertNotNull(k);
		assertEquals(1l, k.getId());
		assertEquals("Peric", k.getPrezime());
		assertEquals("Pera", k.getIme());
		assertEquals("pera", k.getKorisnickoIme());
		assertEquals("pera", k.getLozinka());


	}

	@Test
	void testSetId() {
		k.setId(23l);
		
		assertEquals(23l, k.getId()); 
	}

	@Test
	void testSetIme() {
		k.setIme("Pera");
		
		assertEquals("Pera", k.getIme());
	}
	
	@Test
	@DisplayName("Testira ako je uneto null umesto imena")
	void testSetImeNull() {
		
		assertThrows(java.lang.NullPointerException.class, ()->k.setIme(null));
		
	}
	
	@Test
	void testSetImeKratakString() {
		
		assertThrows(java.lang.RuntimeException.class, ()->k.setIme("P"));
		
	}

	@Test
	void testSetPrezime() {
		k.setPrezime("Peric");
		
		assertEquals("Peric", k.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		
		assertThrows(java.lang.NullPointerException.class, ()->k.setPrezime(null));
		
	}
	
	@Test
	void testSetPrezimeKratakString() {
		
		assertThrows(java.lang.RuntimeException.class, ()->k.setPrezime("T"));
		
	}

	@Test
	void testSetKorisnickoIme() {
		k.setKorisnickoIme("pera");
		
		assertEquals("pera", k.getKorisnickoIme());
	}
	
	
	@Test
	void testSetKorisnickoImeNull() {

		assertThrows(java.lang.NullPointerException.class, ()->k.setKorisnickoIme(null));

	}
	
	@Test
	void testSetKorisnickoImeKratakString() {
		
		assertThrows(java.lang.RuntimeException.class, ()->k.setKorisnickoIme("p"));
		
	}

	@Test
	void testSetLozinka() {
		k.setLozinka("pera");
		
		assertEquals("pera", k.getLozinka());
	}
	
	@Test
	void testSetLozinkaNull() {

		assertThrows(java.lang.NullPointerException.class, ()->k.setLozinka(null));

	}
	
	@Test
	void testSetLozinkaKratakString() {
		
		assertThrows(java.lang.RuntimeException.class, ()->k.setLozinka("p"));
		
	}

	
}
