package com.example.grado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grado.model.Grado;
import com.example.grado.service.GradoService;


@RestController
@RequestMapping("/api/grado")
@CrossOrigin(origins = "*")
public class GradoController {
	
	private final GradoService gradoService;

	@Autowired
	public GradoController(GradoService gradoService) {
		this.gradoService = gradoService;
	}
	
	@GetMapping("/{id}")
	public Grado getGradoById(@PathVariable Long id) {
		 return gradoService.getGradoById(id);
	}
	
	
	@GetMapping
	public List<Grado> getAllGrados(){
		return gradoService.getAllGrados();
	}
	
	@PostMapping
	public void saveGrado(@RequestBody Grado grado) {
		gradoService.saveGrado(grado);
	}
	
	@PutMapping("/{id}")
	public void updateGrado(@RequestBody Grado grado, @PathVariable Long id) {
		if(gradoService.getGradoById(id) != null) {
			grado.setId(id);
			gradoService.updateGrado(grado);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteGrado(@PathVariable Long id) {
		gradoService.deleteGrado(id);
		
	}
	
	
	

}
