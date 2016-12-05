package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
    }
    @Bean
	public CommandLineRunner demo(ProductRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Product("pamolive", "soap",1));
			repository.save(new Product("lifeboy", "soap",1));
			repository.save(new Product("rin", "soap",4));
			repository.save(new Product("arial", "ditergent",3));
			repository.save(new Product("medimix", "ditergent",2));

			// fetch all customers
			log.info("Product found with findAll():");
			log.info("-------------------------------");
			for (Product product : repository.findAll()) {
				log.info(product.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Product product = repository.findOne(1);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(product.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Product bauer : repository.findByDescription("soap")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}

}