package api.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.api.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
