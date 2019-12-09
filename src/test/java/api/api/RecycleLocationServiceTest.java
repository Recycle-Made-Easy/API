package api.api;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import api.api.entities.RecycleCenter;
import api.api.repository.RecycleCenterRepository;
import api.api.services.RecycleCenterService;

public class RecycleLocationServiceTest {
	@InjectMocks
	RecycleCenterService underTest;
	@Mock
	private RecycleCenterRepository recycleLocationRepo;
	@Mock
	private RecycleCenter mockLocation;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
}
	@Test
	public void shouldBeAbleToSaveLocation() {
		underTest.addRecycleCenter(mockLocation);
		verify(recycleLocationRepo).save(mockLocation);
	}
	
	@Test
	public void shouldBeAbleToFindLocationByName() {
		underTest.findRecycleCenterByName("Dublin");
		verify(recycleLocationRepo).findByName("Dublin");
	}
	

}
