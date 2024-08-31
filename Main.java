import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] sticks={1,3,5,7};

        System.out.println("Welcome To Nim Game");
        System.out.println("==============================================");

        System.out.println("Game Instructions: ");
        NimGameView view=new NimGameView();
        view.displaySticks(sticks);

        System.out.println("Objective: \n"+
                        "\n"+
                        "The aim of the Nim game is to avoid being the player who has to pick the last stick. \n"+
                        "The player who is forced to pick the last stick loses the game.\n"+
                        "\n");

        System.out.println("Game Rules:\n" +
                "\n" +
                "1. On your turn, you must remove one or more sticks from a single row.\n" +
                "2. You can remove any number of sticks (as long as you remove at least one), but only from one row.\n" +
                "3. After removing the sticks, the next player takes their turn.\n" +
                "4. The game continues until one player is forced to take the last stick. The player who takes the last stick loses the game.\n" +
                "\n");

        System.out.println("==============================================");


        while(true){
            view.displayChoice();
            int choice=scanner.nextInt();

            if(choice==1){
                NimGameViewModel nimGame=new NimGameViewModel();

                while(true){
                    if(nimGame.isWinner(sticks)){
                        System.out.println("Player1 is the Winner");
                        break;
                    }

                    view.displaySticks(sticks);
                    System.out.println("Player1's turn:");
                    nimGame.remove(sticks,scanner);

                    if(nimGame.isWinner(sticks)){
                        System.out.println("Player2 is the Winner");
                        break;
                    }

                    view.displaySticks(sticks);
                    System.out.println("Player2's turn:");
                    nimGame.remove(sticks,scanner);

                    if(nimGame.isWinner(sticks)){
                        System.out.println("Player1 is the Winner");
                        break;
                    }
                }
            }else{
                break;
            }
        }
        System.out.println("----------Thank You------------");
    }
}
