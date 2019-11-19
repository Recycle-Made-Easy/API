package api.api;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import api.api.entities.Category;
import api.api.entities.Recyclable;
import api.api.repository.RecyclableRepository;
import api.api.services.RecyclableService;

public class RecyclableServiceTest {

	@InjectMocks
	RecyclableService underTest;
	@Mock
	private RecyclableRepository recyclableRepo;
	@Mock
	private Recyclable mockRecyclable;
	@Mock
	private Category mockCategory;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void canAddRecyclableToRepo() {
		underTest.addRecyclable(mockRecyclable);
		verify(recyclableRepo).save(mockRecyclable);
	}
	
	@Test
	public void canFindRecyclableById() {
		underTest.findRecyclableById(1L);
		verify(recyclableRepo).findById(1L);
	}
	
//	@Test
//	public void canFindRecyclableByName() {
//		underTest.addRecyclable(mockRecyclable);
//		mockRecyclable
//		verify(recyclableRepo).findRecyclableByName("cans");
//	}
	@Test
	public void canFindAllRecyclables() {
		underTest.findAllRecyclables();
		verify(recyclableRepo).findAll();
	}
	
	@Test
	public void deleteRecyclable() {
		underTest.addRecyclable(mockRecyclable);
		underTest.deleteRecyclable(mockRecyclable);
		verify(recyclableRepo).delete(mockRecyclable);
	}
	
}
