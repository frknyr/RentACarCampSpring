package kodlama.io.rentACar2.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.rentACar2.entities.concretes.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

}
