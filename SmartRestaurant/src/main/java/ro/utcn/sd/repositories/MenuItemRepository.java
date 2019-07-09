package ro.utcn.sd.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ro.utcn.sd.entities.MenuItem;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long>{

	List<MenuItem> findAllByType(String type);
	
}
