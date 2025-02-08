package br.com.string.string_back_end.security;

import br.com.string.string_back_end.entities.User;
import br.com.string.string_back_end.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    public CustomUserDetailsService(UserService userService) {
    }
    /*
No Spring Security, o nome de usuário do formulário de login é enviado pelo cliente (navegador, Postman, etc.) como um campo chamado username por padrão.
Esse valor é capturado automaticamente pelo Spring Security e passado para o método loadUserByUsername(String username).
   Fluxo de funcionamento:Formulário de Login ou Requisição O usuário envia os dados via um formulário HTML (POST /login) ou via API (POST /authenticate), contendo os campos username e password (ou nomes personalizados, caso configurado).
<form method="post" action="/login">
    <input type="text" name="username" placeholder="Email">
    <input type="password" name="password">
    <button type="submit">Entrar</button>
</form>

Interceptação pelo Spring Security
  O UsernamePasswordAuthenticationFilter intercepta a requisição e extrai os valores de username e password.

Chamando loadUserByUsername
    O Spring Security chama loadUserByUsername(username), passando o valor do campo username.
@Override
public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    User user = userService.obterUsuarioPorEmail(name); // Aqui "name" vem do formulário
    if(user == null) {
        throw new UsernameNotFoundException("Usuário não encontrado.");
    }
    return org.springframework.security.core.userdetails.User.builder()
            .username(user.getNome())
            .password(user.getSenha())
            .roles(user.getRoles().toArray(new String[0]))
            .build();
}
Autenticação e Autorização
    O Spring Security verifica a senha e, se válida, autentica o usuário.
    * */

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.obterUsuarioPorEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario não encontrado.");
        }
        return org.springframework.security.core.userdetails.User.builder().username(user.getNome()).password(user.getSenha()).roles(user.getRoles().toArray(new String[user.getRoles().size()])).build();
    }
}
//teste
