import java.util.Scanner;

public class JogoDaVelha {

    public static void EstruturaJogo() {
        Campo[][] velha = new Campo[3][3];
        Boolean jogo = true;
        char simboloAtual = 'X';
        String vitoria = "";
        Scanner scanner = new Scanner(System.in);

        Tabuleiro.iniciarJogo(velha);

        while (jogo) {
            Tabuleiro.imprimeJogo(velha);
            vitoria = Tabuleiro.verificaVitoria(velha);
            if (!vitoria.equals("")) {
                System.out.println("Jogador " + vitoria + " venceu!");
                break;
            }
            try {
                if(Tabuleiro.verificarJogada(velha, jogar(scanner, simboloAtual), simboloAtual)) {
                    simboloAtual = (simboloAtual == 'X') ? 'O' : 'X';
                }
            } catch (Exception e) {
                System.out.println("Erro");
            }
        }
        System.out.println("Fim do jogo");
    }

    public static int[] jogar(Scanner scanner, char simboloAtual) {
        int p[] = new int[2];
        System.out.printf("Quem joga: %c%n", simboloAtual);
        System.out.print("Informe a linha: ");
        p[0] = scanner.nextInt();
        System.out.print("Informe a coluna: ");
        p[1] = scanner.nextInt();
        return p;
    }
}
