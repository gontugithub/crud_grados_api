package com.example.grado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grado.model.Grado;

public interface GradoRepository extends JpaRepository<Grado, Long> {

}
