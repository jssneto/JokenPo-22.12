

import java.util.Random;
import java.util.Scanner;

public record JokenPo(

        Player user,
        Player IA,
        int rouds
) {

    public void toPlay(){
        System.out.println("\n******** SEJA BEM-VINDO(A), " + user.getNome() + " ********\n");

        for (int i = 1; i <= rouds; i++) {

            int choiceUser = choiceUser();
            if (choiceUser < 1 || choiceUser > 3) {
                System.out.println("\nJOGADA INVALIDA (1, 2, 3): ");
                System.out.println("\tPONTO PARA " + IA.getNome() + "\n");
                IA.incrementScore();
                continue;
            }

            int choiceIA = choiceIA();

            System.out.print("\n" + choiceUser + " X " + choiceIA + "\n");

            int result = choiceUser - choiceIA;

            winnerRound(result);

        }


    }

    public void showFinalResult(){
        System.out.println("\n***************************************\n");

        Integer finalScoreUser = user.getScore();
        Integer finalScoreIA = IA.getScore();

        System.out.println("\n\tPLACAR FINAL: " + user.getNome() + " " + user.getScore() + " X " + IA.getScore() + " " + IA.getNome());

        if(finalScoreUser == finalScoreIA) {
            System.out.println("\t\t\tEMPATE");
        } else {
            String finalWinner = (finalScoreUser > finalScoreIA) ? user.getNome() : IA.getNome();

            System.out.println("\t\tVENCEDOR = " + finalWinner.toUpperCase());

        }

        System.out.println("\n***************************************\n");

    }

    private void winnerRound(int result) {
        String winnerRound;
        if(result == 0 ) {
            winnerRound = "EMPATE!";
        }else {
           if(result == -1  || result == 2) {
               IA.incrementScore();
               winnerRound = IA.getNome();
           } else {
               user.incrementScore();
               winnerRound = user.getNome();
           }
        }
        System.out.println("\nVencedor do Round: " + winnerRound + "\n");
    }



    private int choiceIA() {
        Random random = new Random();
        return random.nextInt(3) + 1;

    }


    private int choiceUser() {
        Scanner scan = new Scanner(System.in);

        System.out.println("1 = PEDRA ");
        System.out.println("2 = PAPEL ");
        System.out.println("3 = TESOURA ");

        System.out.println("Informe a sua jogada: ");
        
        return scan.nextInt();
    }



}
