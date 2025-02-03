package br.com.string.string_back_end.dto;

import java.util.List;

public record UsuarioDTO(String login, String senha, List<String> roles) {
}
