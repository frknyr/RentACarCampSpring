package kodlama.io.rentACar2.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.rentACar2.entities.concretes.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer>{
	
	boolean existsByName(String name); // Spring JPA Keywords
	
}
