package br.com.string.string_back_end.services;

import br.com.string.string_back_end.entities.Aparelho;
import br.com.string.string_back_end.entities.Modelo;
import br.com.string.string_back_end.repositories.AparelhoRepository;
import br.com.string.string_back_end.repositories.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> listaModelo(){
        return modeloRepository.findAll();
    }

    public Modelo adicionaModelo(Modelo modelo){
        return modeloRepository.saveAndFlush(modelo);
    }

    public Modelo obterModeloPorId(Long id){
        return modeloRepository.findById(id).orElseThrow(() -> new RuntimeException("Modelo não encontrado."));
    }


    
}
