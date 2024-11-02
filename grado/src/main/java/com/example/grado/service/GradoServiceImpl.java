package com.example.grado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grado.model.Grado;
import com.example.grado.repository.GradoRepository;

@Service
public class GradoServiceImpl implements GradoService {
	
	private final GradoRepository gradoRepository;
	
	@Autowired
	public GradoServiceImpl(GradoRepository gradorepository) {
		this.gradoRepository = gradorepository;
	}
	

	@Override
	public Grado getGradoById(Long id) {
		Optional<Grado> optionalGrado = gradoRepository.findById(id);
        return optionalGrado.orElse(null);
	}

	@Override
	public void saveGrado(Grado grado) {
		gradoRepository.saveAndFlush(grado);
		
	}

	@Override
	public void updateGrado(Grado grado) {
		gradoRepository.save(grado);
	}

	@Override
	public void deleteGrado(Long id) {
		gradoRepository.deleteById(id);
		
	}

	@Override
	public List<Grado> getAllGrados() {
		return gradoRepository.findAll();
		
	}
	
	

}
