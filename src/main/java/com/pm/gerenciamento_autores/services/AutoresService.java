package com.pm.gerenciamento_autores.services;

import com.pm.gerenciamento_autores.models.AutoresModel;
import com.pm.gerenciamento_autores.repositories.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresService {

    @Autowired
    private AutoresRepository autoresRepository;

    public List<AutoresModel> findAll() {return autoresRepository.findAll();}

    public AutoresModel criarAutor(AutoresModel autoresModel) {
        return autoresRepository.save(autoresModel);
    }

    public Optional<AutoresModel> buscarId(Long id){return autoresRepository.findById(id);}

    public AutoresModel atualizarAutor(Long id, AutoresModel autoresModel){
        AutoresModel autor =  buscarId(id).get();
        autor.setNome(autoresModel.getNome());

        return autoresRepository.save(autor);
    }

    public void deletarAutor(Long id) {
        autoresRepository.deleteById(id);
    }
}
