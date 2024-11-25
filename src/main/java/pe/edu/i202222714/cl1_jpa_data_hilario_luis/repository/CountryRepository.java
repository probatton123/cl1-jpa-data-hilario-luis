package pe.edu.i202222714.cl1_jpa_data_hilario_luis.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202222714.cl1_jpa_data_hilario_luis.entity.Country;

public interface CountryRepository extends CrudRepository<Country, String> {
}
