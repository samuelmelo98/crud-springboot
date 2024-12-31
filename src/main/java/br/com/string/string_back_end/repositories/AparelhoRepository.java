package br.com.string.string_back_end.repositories;

import br.com.string.string_back_end.entities.Aparelho;
import br.com.string.string_back_end.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AparelhoRepository extends JpaRepository<Aparelho, Long>{
    
}
