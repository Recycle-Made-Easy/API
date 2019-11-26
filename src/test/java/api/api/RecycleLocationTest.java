package api.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import api.api.entities.RecycleCenter;

public class RecycleLocationTest {

	RecycleCenter underTest;
	
	@Before
	public void setup() {
		underTest = new RecycleCenter("Recycle Center");
	}
	
	@Test
	public void canCreateRecycleLocation() {
		assertEquals(underTest.getName(), "Recycle Center");
	}
	
	@Test
	public void canUpdateRecycleLocationAttributes() {
		underTest.updateName("Updated Name");
		underTest.updateStreetAddress("123 Main St.");
		underTest.updateCity("Columbus");
		underTest.updateState("OH");
		underTest.updateZipCode("43215");		
		assertEquals(underTest.getName(), "Updated Name");
		assertEquals(underTest.getStreetAddress(), "123 Main St.");
		assertEquals(underTest.getCity(), "Columbus");
		assertEquals(underTest.getState(), "OH");
		assertEquals(underTest.getZipCode(), "43215");
		
	}
	
	
	
}
