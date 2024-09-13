public class Tabuleiro {

    public static void iniciarJogo(Campo[][] velha) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                velha[i][j] = new Campo();
            }
        }
    }

    public static void imprimeJogo(Campo[][] velha) {
        limparTela();
        System.out.println("  0    1    2");
        System.out.printf("0  %c | %c | %c %n", velha[0][0].getSimbolo(), velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
        System.out.println("  ---|---|---");
        System.out.printf("1  %c | %c | %c %n", velha[1][0].getSimbolo(), velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
        System.out.println("  ---|---|---");
        System.out.printf("2  %c | %c | %c %n", velha[2][0].getSimbolo(), velha[2][1].getSimbolo(), velha[2][2].getSimbolo());
    }

    public static void limparTela() {
        for (int i = 0; i < 200; i++) {
            System.out.println(" ");
        }
    }

    public static boolean verificarJogada(Campo[][] velha, int p[], char simboloAtual) {
        if (velha[p[0]][p[1]].getSimbolo() == ' ') {
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        } else {
            System.out.println("Posição já ocupada.");
            return false;
        }
    }

    public static String verificaVitoria(Campo[][] velha) {
        for (int i = 0; i < 3; i++) {

            if (velha[i][0].getSimbolo() != ' ' && velha[i][0].getSimbolo() == velha[i][1].getSimbolo() && velha[i][1].getSimbolo() == velha[i][2].getSimbolo()) {
                return String.valueOf(velha[i][0].getSimbolo());
            }

            if (velha[0][i].getSimbolo() != ' ' && velha[0][i].getSimbolo() == velha[1][i].getSimbolo() && velha[1][i].getSimbolo() == velha[2][i].getSimbolo()) {
                return String.valueOf(velha[0][i].getSimbolo());
            }
        }

        if (velha[0][0].getSimbolo() != ' ' && velha[0][0].getSimbolo() == velha[1][1].getSimbolo() && velha[1][1].getSimbolo() == velha[2][2].getSimbolo()) {
            return String.valueOf(velha[0][0].getSimbolo());
        }
        if (velha[0][2].getSimbolo() != ' ' && velha[0][2].getSimbolo() == velha[1][1].getSimbolo() && velha[1][1].getSimbolo() == velha[2][0].getSimbolo()) {
            return String.valueOf(velha[0][2].getSimbolo());
        }

        return "";
    }
}
