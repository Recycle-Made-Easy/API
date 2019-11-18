package api.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import api.api.entities.Recyclable;

public class RecycleItemTest {

	Recyclable underTest;
	
	@Before
	public void setup() {
		underTest = new Recyclable("Plastic Grocery Bag");
	}
	
	@Test
	public void canCreateRecyclable() {
		assertEquals(underTest.getName(), "Plastic Grocery Bag");
	}
	
	@Test
	public void canUpdateRecycleable() {
		underTest.updateName("Glass Jar");
		assertEquals(underTest.getName(), "Glass Jar");
	}
}
