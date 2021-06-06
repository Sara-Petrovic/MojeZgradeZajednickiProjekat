package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public abstract class GenericEntityTest {

	
	protected GenericEntity genericEntity;

	@Test
	void testGetTableName() {
		String s = genericEntity.getTableName();
		
		assertNotNull(s);
	}

	@Test
	void testGetColumnNamesForInsert() {
		String s = genericEntity.getColumnNamesForInsert();
		
		assertNotNull(s);
	}

	@Test
	void testGetInsertValues() {
		String s = genericEntity.getInsertValues();
		
		assertNotNull(s);
	}

	@Test
	void testGetAlijas() {
		String s = genericEntity.getAlijas();
		
		assertNotNull(s);
	}


	@Test
	void testGetUpdateValues() {
		String s = genericEntity.getUpdateValues();
		
		assertNotNull(s);
	}

	@Test
	void testGetPrimaryKeyValue() {
		String s = genericEntity.getPrimaryKeyValue();
		
		assertNotNull(s);
	}

	@Test
	void testGetJoin() {
		String s = genericEntity.getJoin();
		
		assertNotNull(s);
	}

	@Test
	void testSelectWhere() {
		String s = genericEntity.selectWhere();
		
		assertNotNull(s);
	}

	@Test
	void testMakeList() throws Exception {
		ResultSet resultSet = mock(ResultSet.class);

		//pravi ResultSet (1 element u ResultSetu)
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);

        // Launch the method against your mock
        List<GenericEntity> lista = genericEntity.makeList (resultSet);

        // Check the result
        assertNotNull(lista);
        GenericEntity entity = lista.get(0);
        
        assertNotNull(entity, "Generic entities were not parsed.");
	}

}
