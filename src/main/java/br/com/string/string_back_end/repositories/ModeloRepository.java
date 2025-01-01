package br.com.string.string_back_end.repositories;

import br.com.string.string_back_end.entities.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long>{
    
}
