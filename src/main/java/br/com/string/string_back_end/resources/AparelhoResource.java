package br.com.string.string_back_end.resources;

import br.com.string.string_back_end.entities.Aparelho;
import br.com.string.string_back_end.entities.User;
import br.com.string.string_back_end.repositories.AparelhoRepository;
import br.com.string.string_back_end.services.AparelhoService;
import br.com.string.string_back_end.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/aparelhos")
public class AparelhoResource {

    @Autowired
    private AparelhoService aparelhoService;
    
    @GetMapping
    public ResponseEntity<List<Aparelho>>carregaTodos(){
       // User user = new User(1L,"Samuel","Melo","samuel@","61999999999","9999999999");
        List<Aparelho> aparelhos = aparelhoService.listaAparelhos();
        return ResponseEntity.ok().body(aparelhos);

    }

    @PostMapping(value = "/add")
    public Aparelho adicionarAparelho(@RequestBody Aparelho aparelho){
        return aparelhoService.adicionaAparelho(aparelho);

    }

    @GetMapping("/{id}")
    public Aparelho obterAparelhoPorId(@PathVariable Long id) {
        return aparelhoService.obterUsuarioPorId(id);
    }
//    @PostMapping
//    public User addUser(@RequestBody User user) {
//        return userService.addUser(user);
//    }[

}
