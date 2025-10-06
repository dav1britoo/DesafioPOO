package model;

import java.util.ArrayList;
import java.util.List;


public class Teatro {

    private List<Poltrona> poltronas;

    public Teatro() {
        poltronas = new ArrayList<>();
        inicializarPoltronas();
    }

    // Inicializa 100 poltronas (10 filas de 10)
    public void inicializarPoltronas() {
        for (int fila = 1; fila <= 10; fila++) {
            for (int numero = 1; numero <= 10; numero++) {
                poltronas.add(new Poltrona(fila, numero, Status.LIVRE));
            }
        }
    }

    public List<Poltrona> getPoltronas() {
        return poltronas;
    }

    // Exibe o mapa com siglas
    public void exibirMapa() {
        for (int fila = 1; fila <= 10; fila++) {
            for (int numero = 1; numero <= 10; numero++) {
                Poltrona p = buscarPoltrona(fila, numero);
                System.out.print(p.getSigla() + " ");
            }
            System.out.println();
        }
    }

    // Busca poltrona por fila e número
    public Poltrona buscarPoltrona(int fila, int numero) {
        return poltronas.stream()
                .filter(p -> p.getNumeroDaFila() == fila && p.getNumeroDaPoltrona() == numero)
                .findFirst()
                .orElse(null);
    }

    // Cálculo de arrecadação
    public int calcularArrecadacao() {
        return (int) poltronas.stream()
                .filter(p -> p.getStatus() == Status.CONFIRMADA)
                .count() * 20;
    }

    // Totais por status
    public long totalLivres() {
        return poltronas.stream().filter(p -> p.getStatus() == Status.LIVRE).count();
    }

    public long totalReservadas() {
        return poltronas.stream().filter(p -> p.getStatus() == Status.RESERVADA).count();
    }

    public long totalConfirmadas() {
        return poltronas.stream().filter(p -> p.getStatus() == Status.CONFIRMADA).count();
    }
}
