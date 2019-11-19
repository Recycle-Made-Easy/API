package api.api;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import api.api.entities.RecycleLocation;
import api.api.repository.RecycleLocationRepository;
import api.api.services.RecycleLocationService;

public class RecycleLocationServiceTest {
	@InjectMocks
	RecycleLocationService underTest;
	@Mock
	private RecycleLocationRepository recycleLocationRepo;
	@Mock
	private RecycleLocation mockLocation;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
}
	@Test
	public void shouldBeAbleToSaveLocation() {
		underTest.addRecycleLocation(mockLocation);
		verify(recycleLocationRepo).save(mockLocation);
	}
	
	@Test
	public void shouldBeAbleToFindLocationByName() {
		underTest.findRecycleLocationByName("Dublin");
		verify(recycleLocationRepo).findRecycleLocationByName("Dublin");
	}
	

}
