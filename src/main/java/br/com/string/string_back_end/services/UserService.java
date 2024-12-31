package br.com.string.string_back_end.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.string.string_back_end.repositories.UserRepository;

import br.com.string.string_back_end.entities.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listaUsuarios(){
        return userRepository.findAll();
    }

    public User adicionarUsuario(User user){
        return userRepository.saveAndFlush(user);
    }

    public User obterUsuarioPorId(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
    }


    
}
