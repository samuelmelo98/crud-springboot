package br.com.string.string_back_end.resources;

import br.com.string.string_back_end.entities.Modelo;
import br.com.string.string_back_end.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/modelos")
public class ModeloResource {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public ResponseEntity<List<Modelo>> carregaTodos() {
        List<Modelo> modelos = modeloService.listaModelo();
        return ResponseEntity.ok().body(modelos);
    }

    @PostMapping
    public Modelo adicionarMarca(@RequestBody Modelo modelo) {
        return modeloService.adicionaModelo(modelo);
    }

    @GetMapping("/{id}")
    public Modelo obterUsuario(@PathVariable Long id) {
        return modeloService.obterModeloPorId(id);
    }

    @RequestMapping(value = "/modelos", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> options() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Allow", "GET, POST, OPTIONS");
        return ResponseEntity.ok().headers(headers).build();
    }
}
