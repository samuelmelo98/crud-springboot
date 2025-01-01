package br.com.string.string_back_end.services;

import br.com.string.string_back_end.entities.Marca;
import br.com.string.string_back_end.entities.User;
import br.com.string.string_back_end.repositories.MarcaRepository;
import br.com.string.string_back_end.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listaUsuarios(){
        return marcaRepository.findAll();
    }

    public Marca adicionarMarca(Marca marca){
        return marcaRepository.saveAndFlush(marca);
    }

    public Marca obterMarcaPorId(Long id){
        return marcaRepository.findById(id).orElseThrow(() -> new RuntimeException("Marca não encontrado."));
    }


    
}
