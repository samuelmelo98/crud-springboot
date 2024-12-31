package br.com.string.string_back_end.entities;

import br.com.string.string_back_end.entities.enums.AparelhoStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_aparelho")
public class Aparelho {
    @Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aparelho_seq")
    @SequenceGenerator(name = "aparelho_seq", sequenceName = "seq_tb_aparelho", allocationSize = 1)
    private Long idAparelho;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private Instant dataEntrada;
    private String observacoes;
    private AparelhoStatus aparelhoStatus = AparelhoStatus.AGUARDANDO_ORCAMENTO;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
    public Aparelho() {
    }

    public Aparelho(Long idAparelho, String marca, String modelo, String numeroSerie, Instant dataEntrada, String observacoes, AparelhoStatus aparelhoStatus) {
        this.idAparelho = idAparelho;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.dataEntrada = dataEntrada;
        this.observacoes = observacoes;
        this.aparelhoStatus = aparelhoStatus;
    }

    public Long getIdAparelho() {
        return idAparelho;
    }

    public void setIdAparelho(Long idAparelho) {
        this.idAparelho = idAparelho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Instant getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Instant dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public AparelhoStatus getAparelhoStatus() {
        return aparelhoStatus;
    }

    public void setAparelhoStatus(AparelhoStatus aparelhoStatus) {
        this.aparelhoStatus = aparelhoStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aparelho)) return false;
        Aparelho aparelho = (Aparelho) o;
        return getIdAparelho().equals(aparelho.getIdAparelho());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAparelho());
    }

    @Override
    public String toString() {
        return "Aparelho{" +
                "idAparelho=" + idAparelho +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", dataEntrada=" + dataEntrada +
                ", observacoes='" + observacoes + '\'' +
                ", aparelhoStatus=" + aparelhoStatus +
                '}';
    }
}
