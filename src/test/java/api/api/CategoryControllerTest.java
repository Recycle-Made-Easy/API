package api.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import api.api.entities.Category;
import api.api.services.CategoryService;
import controllers.CategoryController;

public class CategoryControllerTest {
	
	@InjectMocks
	CategoryController underTest;
	
	@Mock
	CategoryService categoryService;
	@Mock
	private Category mockCategory;
	
	private MockMvc mockMvc;
	private Category testCategory;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		testCategory = new Category("Automobile");
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
	}
	
	@Test
	public void findAllReturnsListOfCategories() {
		when(categoryService.findAllCategories()).thenReturn(Collections.singletonList(testCategory));
		List<Category> retrievedCategories = underTest.findAll();
		assertThat(retrievedCategories, contains(testCategory));
	}
	@Test
	public void findByNameReturnsSingleCategory() {
		when(categoryService.findCategoryByName("test item")).thenReturn(testCategory);
		Category retrievedCategory = underTest.findCategoryByName("test item");
		assertThat(retrievedCategory, is(testCategory));
	}
	@Test
	public void addCategory() {
		when(categoryService.addCategory(mockCategory)).thenReturn(testCategory);
		Category retrievedCategory = underTest.addCategory(mockCategory);
		assertThat(retrievedCategory, is(testCategory));
	}
}