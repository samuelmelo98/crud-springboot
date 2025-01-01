package br.com.string.string_back_end.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marca_seq")
    @SequenceGenerator(name = "marca_seq", sequenceName = "seq_tb_marca", allocationSize = 1)
    private Long idMarca;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;



    public Marca(){}

    public Marca(Long idMarca, String nome) {
        this.idMarca = idMarca;
        this.nome = nome;
    }

    public Marca(String nome, User user) {
        this.nome = nome;
        this.user = user;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
