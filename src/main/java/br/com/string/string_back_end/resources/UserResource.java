package br.com.string.string_back_end.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.string.string_back_end.entities.User;
import br.com.string.string_back_end.services.UserService;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService userService;
    
    @GetMapping
    public ResponseEntity<List<User>>carregaTodos(){
       // User user = new User(1L,"Samuel","Melo","samuel@","61999999999","9999999999");
        List<User> usuarios = userService.listaUsuarios();
        return ResponseEntity.ok().body(usuarios);

    }

    @PostMapping(value = "/add")
    public User adicionarUsuario(@RequestBody User user){
        return userService.adicionarUsuario(user);

    }

    @GetMapping("/{id}")
    public User obterUsuario(@PathVariable Long id) {
        return userService.obterUsuarioPorId(id);
    }
//    @PostMapping
//    public User addUser(@RequestBody User user) {
//        return userService.addUser(user);
//    }

}
