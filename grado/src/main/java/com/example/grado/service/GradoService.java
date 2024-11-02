package com.example.grado.service;

import java.util.List;

import com.example.grado.model.Grado;

public interface GradoService {
	
	Grado getGradoById(Long id);
	void saveGrado(Grado grado);
	void updateGrado(Grado grado);
	void deleteGrado(Long id);
	List<Grado> getAllGrados();

}
