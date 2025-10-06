package model;


public class GerenciadorReserva {

    private Teatro teatro;

    public GerenciadorReserva(Teatro teatro) {
        this.teatro = teatro;
    }

    public boolean reservar(int fila, int numero) {
        Poltrona p = teatro.buscarPoltrona(fila, numero);
        if (p != null && p.getStatus() == Status.LIVRE) {
            p.setStatus(Status.RESERVADA);
            return true;
        }
        return false;
    }

    public boolean confirmar(int fila, int numero) {
        Poltrona p = teatro.buscarPoltrona(fila, numero);
        if (p != null && p.getStatus() == Status.RESERVADA) {
            p.setStatus(Status.CONFIRMADA);
            return true;
        }
        return false;
    }

    public boolean cancelar(int fila, int numero) {
        Poltrona p = teatro.buscarPoltrona(fila, numero);
        if (p != null && p.getStatus() != Status.LIVRE) {
            p.setStatus(Status.LIVRE);
            return true;
        }
        return false;
    }
}
