package org.sid.lightecomv1;

import java.util.Random;

import org.sid.lightecomv1.data.CategoryRepository;
import org.sid.lightecomv1.data.ProduitRepository;
import org.sid.lightecomv1.entities.Category;
import org.sid.lightecomv1.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import net.bytebuddy.utility.RandomString;

//@EnableJpaRepositories({ "org.sid.dao" })
@SpringBootApplication
public class LightEcomV1Application implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(LightEcomV1Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		repositoryRestConfiguration.exposeIdsFor(Product.class, Category.class);
		categoryRepository.save(new Category(null, "Computers", null, null, null));
		categoryRepository.save(new Category(null, "Smarthphones", null, null, null));
		categoryRepository.save(new Category(null, "Printers", null, null, null));

		Random rnd = new Random();

		categoryRepository.findAll().forEach(c -> {
			for(int i =0; i<10;i++)
				{Product p = new Product();
			p.setName(RandomString.make(13));
			p.setCurrentprice(100 + rnd.nextInt(10000));
			p.setAvailable(rnd.nextBoolean());
			p.setPromotion(rnd.nextBoolean());
			p.setSelected(rnd.nextBoolean());
			p.setCategory(c);
			p.setPhotoName("unkown.jpg");
			produitRepository.save(p);
				}
		});
	}

}
