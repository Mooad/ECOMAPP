package org.sid.lightecomv1.data;

import java.util.List;

import org.sid.lightecomv1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Product, Long>{
 
	@RestResource(path="/selectedProducts")
	public List<Product> findBySelectedIsTrue();
	
	@RestResource(path="/selectedByKeyword")
	public List<Product>  findByNameContains(@Param("mc")String mc);
	
	
}
