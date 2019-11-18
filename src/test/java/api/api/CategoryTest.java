package api.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import api.api.entities.Category;
import api.api.repository.CategoryRepository;
import api.api.services.CategoryService;


public class CategoryTest {

	@InjectMocks
	CategoryService underTest;
	@Mock
	private CategoryRepository categoryRepo;
	@Mock
	private Category mockCategory;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddCategoryToRepo() {
		underTest.addCategory(mockCategory);
		verify(categoryRepo).save(mockCategory);
	}
	
}
