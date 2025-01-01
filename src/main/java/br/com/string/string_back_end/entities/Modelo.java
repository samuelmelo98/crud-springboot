package br.com.string.string_back_end.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modelo_seq")
    @SequenceGenerator(name = "modelo_seq", sequenceName = "seq_tb_modelo", allocationSize = 1)
    private Long idModelo;
    private String nome;
    private String descricao;
    private String inforAdicionais;
    private Instant dtAdicionado;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    public Modelo(){

    }

    public Modelo(String nome, String descricao, String inforAdicionais, Instant dtAdicionado, User user) {
        this.nome = nome;
        this.descricao = descricao;
        this.inforAdicionais = inforAdicionais;
        this.dtAdicionado = dtAdicionado;
        this.user = user;
    }

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInforAdicionais() {
        return inforAdicionais;
    }

    public void setInforAdicionais(String inforAdicionais) {
        this.inforAdicionais = inforAdicionais;
    }

    public Instant getDtAdicionado() {
        return dtAdicionado;
    }

    public void setDtAdicionado(Instant dtAdicionado) {
        this.dtAdicionado = dtAdicionado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
