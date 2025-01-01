package br.com.string.string_back_end.resources;

import br.com.string.string_back_end.entities.Marca;
import br.com.string.string_back_end.entities.User;
import br.com.string.string_back_end.services.MarcaService;
import br.com.string.string_back_end.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/marcas")
public class MarcaResource {

    @Autowired
    private MarcaService marcaService;
    
    @GetMapping
    public ResponseEntity<List<Marca>>carregaTodos(){
       // User user = new User(1L,"Samuel","Melo","samuel@","61999999999","9999999999");
        List<Marca> marcas = marcaService.listaUsuarios();
        return ResponseEntity.ok().body(marcas);

    }

    @PostMapping
    public Marca adicionarMarca(@RequestBody Marca marca){
        return marcaService.adicionarMarca(marca);

    }

    @GetMapping("/{id}")
    public Marca obterUsuario(@PathVariable Long id) {
        return marcaService.obterMarcaPorId(id);
    }
//    @PostMapping
//    public User addUser(@RequestBody User user) {
//        return userService.addUser(user);
//    }[

}
