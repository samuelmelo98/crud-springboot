package br.com.string.string_back_end.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.string.string_back_end.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
    User findByNome(String nome);
}
