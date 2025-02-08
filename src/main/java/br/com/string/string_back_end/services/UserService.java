package br.com.string.string_back_end.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.string.string_back_end.repositories.UserRepository;

import br.com.string.string_back_end.entities.User;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    public List<User> listaUsuarios(){
        return userRepository.findAll();
    }

    public User adicionarUsuario(User user){
        if (Objects.isNull(user.getDtCadastro())) {
            user.setDtCadastro(Instant.now());
            user.setSenha(passwordEncoder.encode(user.getSenha()));
        }

        return userRepository.saveAndFlush(user);
    }

    public User obterUsuarioPorId(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
    }

    public User obterUsuarioPorName(String login){
        return  userRepository.findByNome(login);
    }

    public User obterUsuarioPorEmail(String email){
        return userRepository.findByEmail(email);
    }



    
}
