package br.com.string.string_back_end.services;

import br.com.string.string_back_end.entities.Aparelho;
import br.com.string.string_back_end.entities.User;
import br.com.string.string_back_end.repositories.AparelhoRepository;
import br.com.string.string_back_end.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AparelhoService {

    @Autowired
    private AparelhoRepository aparelhoRepository;

    public List<Aparelho> listaAparelhos(){
        return aparelhoRepository.findAll();
    }

    public Aparelho adicionaAparelho(Aparelho aparelho){
        return aparelhoRepository.saveAndFlush(aparelho);
    }

    public Aparelho obterUsuarioPorId(Long id){
        return aparelhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aparelho não encontrado."));
    }


    
}
