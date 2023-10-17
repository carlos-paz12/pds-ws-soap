package br.edu.ifrn.pds.ifilmes_ws.model;

public class Filme {

    private int id;
    private String titulo;
    private String sinopse;
    private int duracao; // representada em minutos
    private int anoLancamento;
    private double avaliacao;

    public Filme() {
    }

    public Filme(int id, String titulo, String sinopse, int duracao, int anoLancamento, double avaliacao) {
        this.id = id;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.titulo = titulo;
        this.avaliacao = avaliacao;
    }

    public Filme(String titulo, String sinopse, int duracao, int anoLancamento, double avaliacao) {
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.titulo = titulo;
        this.avaliacao = avaliacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

}
