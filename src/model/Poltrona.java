package model;


public class Poltrona {

    private int numeroDaFila;
    private int numeroDaPoltrona;
    private Status status; // Corrigido: usar enum em vez de String

    // Construtor padrão
    public Poltrona() {
        this.status = Status.LIVRE; // Toda poltrona começa como livre
    }

    // Construtor completo
    public Poltrona(int numeroDaFila, int numeroDaPoltrona, Status status) {
        this.numeroDaFila = numeroDaFila;
        this.numeroDaPoltrona = numeroDaPoltrona;
        this.status = status;
    }

    // Getters e Setters
    public int getNumeroDaFila() {
        return numeroDaFila;
    }

    public void setNumeroDaFila(int numeroDaFila) {
        this.numeroDaFila = numeroDaFila;
    }

    public int getNumeroDaPoltrona() {
        return numeroDaPoltrona;
    }

    public void setNumeroDaPoltrona(int numeroDaPoltrona) {
        this.numeroDaPoltrona = numeroDaPoltrona;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Método auxiliar para exibir sigla
    public String getSigla() {
        switch (status) {
            case LIVRE: return "L";
            case RESERVADA: return "R";
            case CONFIRMADA: return "C";
            default: return "?";
        }
    }
}
