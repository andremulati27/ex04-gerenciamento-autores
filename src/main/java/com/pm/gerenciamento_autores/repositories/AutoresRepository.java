package com.pm.gerenciamento_autores.repositories;

import com.pm.gerenciamento_autores.models.AutoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoresRepository extends JpaRepository<AutoresModel, Long> {
}