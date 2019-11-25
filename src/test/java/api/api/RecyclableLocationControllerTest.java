package api.api;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import api.api.controllers.RecyclableLocationController;
import api.api.entities.RecycleLocation;
import api.api.services.RecycleLocationService;

public class RecyclableLocationControllerTest {
	
	@InjectMocks
	RecyclableLocationController underTest;
	
	@Mock
	RecycleLocationService recycleLocationService;
	@Mock
	private RecycleLocation mockRecycleLocation;
	
	private MockMvc mockMvc;
	private RecycleLocation testRecycleLocation;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		testRecycleLocation = new RecycleLocation("Dublin");
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
	}
	
	@Test
	public void findAllReturnsListOfRecyclableLocations() {
		when(recycleLocationService.findAllRecycleLocations()).thenReturn(Collections.singletonList(testRecycleLocation));
		List<RecycleLocation> retrievedRecyclableLocation = underTest.findAll();
		assertThat(retrievedRecyclableLocation, contains(testRecycleLocation));
	}
	
	@Test
	public void findByNameReturnsSingleRecyclableLocation() {
		when(recycleLocationService.findRecycleLocationByName("Dublin")).thenReturn(testRecycleLocation);
		RecycleLocation retrievedRecyclableLocation = underTest.findRecyclableLocationByName("Dublin");
		assertThat(retrievedRecyclableLocation, is(testRecycleLocation));
	}
	
	@Test
	public void addRecyclableLocation() {
		when(recycleLocationService.addRecycleLocation(mockRecycleLocation)).thenReturn(testRecycleLocation);
		RecycleLocation retrievedRecycleLocation = underTest.addRecycleLocation(mockRecycleLocation);
		assertThat(retrievedRecycleLocation, is(testRecycleLocation));
	}

}
