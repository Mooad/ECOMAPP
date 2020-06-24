package org.sid.lightecomv1.web;

import org.sid.lightecomv1.data.ProduitRepository;
import org.sid.lightecomv1.entities.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
@CrossOrigin("*")
@RestController
public class CatalogueRestController {
    private ProduitRepository produitRepository;

    public CatalogueRestController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    
    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Product p=produitRepository.findById(id).get();
        return Files.readAllBytes(Paths.get("C:/Users/mfajri/3D Objects/ecom/products/"+p.getPhotoName()));
    }
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
       Product p=produitRepository.findById(id).get();
       p.setPhotoName(file.getOriginalFilename());
       Files.write(Paths.get("C:/Users/mfajri/3D Objects/ecom/products/"+p.getPhotoName()),file.getBytes());
       produitRepository.save(p);
    }
}