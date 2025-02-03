package br.com.string.string_back_end.entities;
import java.time.Instant;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "tb_user")

public class User implements java.io.Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "seq_tb_user", allocationSize = 1)
    private Long idUser;
    private String nome;
    private String sobreNome;
    private String email;
    private String senha;
    private String telefone;
    private Instant dtCadastro;
    private List<String> roles;
    /**
     * Neste mapeamento, um usuario pode ter varios aparelhos associados ao seu id.
     * E um aparelho pertence a um usuario.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Aparelho> aparelhos ;// = new ArrayList<Aparelho>();

    public User(){}

    

    public User(Long idUser, String nome, String sobreNome, String email, String senha, String telefone) {
        this.idUser = idUser;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dtCadastro = Instant.now();
    }



    public Long getIdUser() {
        return idUser;
    }

    public void setId(Long id) {
        this.idUser = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Aparelho> getAparelhos() {
        return aparelhos;
    }

    public void setAparelhos(List<Aparelho> aparelhos) {
        this.aparelhos = aparelhos;
    }

    public Instant getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Instant dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Type(ListArrayType.class)
    @Column(name = "roles", columnDefinition = "varchar[]")
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idUser);
        hash = 41 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.idUser, other.idUser);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("id=").append(idUser);
        sb.append(", nome=").append(nome);
        sb.append(", sobreNome=").append(sobreNome);
        sb.append(", email=").append(email);
        sb.append(", senha=").append(senha);
        sb.append(", telefone=").append(telefone);
        sb.append('}');
        return sb.toString();
    }

    
    
}
