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

import api.api.controllers.RecycleCenterController;
import api.api.entities.RecycleCenter;
import api.api.services.RecycleCenterService;

public class RecyclableLocationControllerTest {
	
	@InjectMocks
	RecycleCenterController underTest;
	
	@Mock
	RecycleCenterService recycleLocationService;
	@Mock
	private RecycleCenter mockRecycleLocation;
	
	private MockMvc mockMvc;
	private RecycleCenter testRecycleLocation;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		testRecycleLocation = new RecycleCenter("Dublin");
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
	}
	
	@Test
	public void findAllReturnsListOfRecyclableLocations() {
		when(recycleLocationService.findAllRecycleLocations()).thenReturn(Collections.singletonList(testRecycleLocation));
		List<RecycleCenter> retrievedRecyclableLocation = underTest.findAll();
		assertThat(retrievedRecyclableLocation, contains(testRecycleLocation));
	}
	
	@Test
	public void findByNameReturnsSingleRecyclableLocation() {
		when(recycleLocationService.findRecycleCenterByName("Dublin")).thenReturn(testRecycleLocation);
		RecycleCenter retrievedRecyclableLocation = underTest.findRecyclableLocationByName("Dublin");
		assertThat(retrievedRecyclableLocation, is(testRecycleLocation));
	}
	
	@Test
	public void addRecyclableLocation() {
		when(recycleLocationService.addRecycleCenter(mockRecycleLocation)).thenReturn(testRecycleLocation);
		RecycleCenter retrievedRecycleLocation = underTest.addRecycleLocation(mockRecycleLocation);
		assertThat(retrievedRecycleLocation, is(testRecycleLocation));
	}

}
