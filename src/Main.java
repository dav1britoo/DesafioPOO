import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Teatro teatro = new Teatro();
        GerenciadorReserva gerenciador = new GerenciadorReserva(teatro);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Exibir mapa de poltronas");
            System.out.println("2. Reservar poltrona");
            System.out.println("3. Confirmar reserva");
            System.out.println("4. Cancelar reserva");
            System.out.println("5. Mostrar totais");
            System.out.println("6. Mostrar arrecadação");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    teatro.exibirMapa();
                    break;

                case 2:
                    System.out.print("Fila (1-10): ");
                    int filaR = scanner.nextInt();
                    System.out.print("Poltrona (1-10): ");
                    int numR = scanner.nextInt();
                    if (gerenciador.reservar(filaR, numR)) {
                        System.out.println("Reserva realizada com sucesso.");
                    } else {
                        System.out.println("Não foi possível reservar. Verifique se está livre.");
                    }
                    break;

                case 3:
                    System.out.print("Fila (1-10): ");
                    int filaC = scanner.nextInt();
                    System.out.print("Poltrona (1-10): ");
                    int numC = scanner.nextInt();
                    if (gerenciador.confirmar(filaC, numC)) {
                        System.out.println("Reserva confirmada.");
                    } else {
                        System.out.println("Não foi possível confirmar. Verifique se está reservada.");
                    }
                    break;

                case 4:
                    System.out.print("Fila (1-10): ");
                    int filaX = scanner.nextInt();
                    System.out.print("Poltrona (1-10): ");
                    int numX = scanner.nextInt();
                    if (gerenciador.cancelar(filaX, numX)) {
                        System.out.println("Reserva cancelada.");
                    } else {
                        System.out.println("Não foi possível cancelar.");
                    }
                    break;

                case 5:
                    System.out.println("Total livres: " + teatro.totalLivres());
                    System.out.println("Total reservadas: " + teatro.totalReservadas());
                    System.out.println("Total confirmadas: " + teatro.totalConfirmadas());
                    break;

                case 6:
                    System.out.println("Valor arrecadado: R$ " + teatro.calcularArrecadacao());
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        System.out.println("Encerrando aplicação...");
        scanner.close();
    }
}
