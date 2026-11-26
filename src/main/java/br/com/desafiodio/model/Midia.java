package br.com.desafiodio.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;

@Entity
public class Midia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String genero;
    @Enumerated(EnumType.STRING)
    private TipoMidia tipo;
    private Integer temporadas;
    private LocalDate lancamento;
    private String prioridade;
    @Enumerated(EnumType.STRING)
    private StatusMidia status = StatusMidia.NA_LISTA;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public TipoMidia getTipo() { return tipo; }
    public void setTipo(TipoMidia tipo) { this.tipo = tipo; }
    public Integer getTemporadas() { return temporadas; }
    public void setTemporadas(Integer temporadas) { this.temporadas = temporadas; }
    public LocalDate getLancamento() { return lancamento; }
    public void setLancamento(LocalDate lancamento) { this.lancamento = lancamento; }
    public String getPrioridade() { return prioridade; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }
    public StatusMidia getStatus() { return status; }
    public void setStatus(StatusMidia status) { this.status = status; }
}
