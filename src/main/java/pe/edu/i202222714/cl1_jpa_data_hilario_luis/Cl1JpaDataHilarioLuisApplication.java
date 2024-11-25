package pe.edu.i202222714.cl1_jpa_data_hilario_luis;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202222714.cl1_jpa_data_hilario_luis.repository.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Cl1JpaDataHilarioLuisApplication implements CommandLineRunner {
	@Autowired
	CountryRepository countryRepository;
	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataHilarioLuisApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		//ifPresentOrElse()
		countryRepository.findById("ARG").ifPresentOrElse(country -> {
					System.out.println("Idiomas de Argentina:");
					country.getIdiomas().forEach(lang -> System.out.println(lang.getLanguagePk().getLanguage()));
				},
				() -> countryRepository.findById("PER").ifPresent(country -> {
					System.out.println("Idiomas de Peru:");
					country.getIdiomas().forEach(lang -> System.out.println(lang.getLanguagePk().getLanguage()));
				})
		);

		//deleteAllById()
//        List<String> countryCodes = List.of("COL", "ARG");
//        countryCodes.stream().filter((item)->{
//            return countryRepository.existsById(item);
//        }).collect(Collectors.toList());
//
//        if (!countryCodes.isEmpty()) {
//            countryRepository.deleteAllById(countryCodes);
//            System.out.println("Países eliminados: COL y ARG.");
//        }else {
//            System.out.println("No country code found");
//        }


	}
}
