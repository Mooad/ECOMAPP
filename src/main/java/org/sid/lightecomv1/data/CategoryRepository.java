package org.sid.lightecomv1.data;

import org.sid.lightecomv1.entities.Category;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")

@RepositoryRestResource 
@Qualifier("CategoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long>{
	 
	}
