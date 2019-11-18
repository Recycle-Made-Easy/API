package api.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.api.Recyclable;

@Repository
public interface RecyclableRepository extends CrudRepository<Recyclable, Long> {

}
