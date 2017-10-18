package Modelo;

public class ManterNotas {

    private Integer id;
    private String nome;
    private Integer nota1;
    private Integer nota2;
    private Integer nota3;
    private Integer nota4;
    private Integer media;
    private String situacao;
    private Integer turma;

    public ManterNotas(String nome) {
        this.setId(0);
        this.setNome(nome);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNota1() {
        return nota1;
    }

    public void setNota1(Integer nota1) {
        this.nota1 = nota1;
    }

    public Integer getNota2() {
        return nota2;
    }

    public void setNota2(Integer nota2) {
        this.nota2 = nota2;
    }

    public Integer getNota3() {
        return nota3;
    }

    public void setNota3(Integer nota3) {
        this.nota3 = nota3;
    }

    public Integer getNota4() {
        return nota4;
    }

    public void setNota4(Integer nota4) {
        this.nota4 = nota4;
    }

    public Integer getMedia() {
        return media;
    }

    public void setMedia(Integer media) {
        this.media = (nota1 + nota2 + nota3 + nota4) / 4;
        //media = (nota1 + nota2 + nota3 + nota4)/4;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getTurma() {
        return turma;
    }

    public void setTurma(Integer turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "nome=" + nome + ", media=" + media + ", situacao=" + situacao;
    }

}
