import java.util.Scanner;

public class NimGameViewModel {

    public void startGame(NimGameView view, int[] sticks) {
        view.displaySticks(sticks);
    }


    public void remove(int[] sticks, Scanner scanner) {
        System.out.println("Enter the Row number(1->4): ");
        int row=0;
        boolean isNotFirstCall=false;
        do{
            if(sticks[row-1]==0){
                System.out.println("There is no sticks in that row,please select another row");
            }
            if(isNotFirstCall){
                System.out.println("Please enter a valid Row Number (1->4)");
            }
            row=scanner.nextInt();
            isNotFirstCall=true;
        }while(row<1 || row>4 || sticks[row-1]==0);


        isNotFirstCall=false;
        System.out.println("Enter the number of the sticks to be removed: ");
        int noOfSticks=0;

        do{
            if(isNotFirstCall){
                System.out.println("Please enter a valid number of sticks to be removed");
            }
            noOfSticks=scanner.nextInt();
            isNotFirstCall=true;
        }while(sticks[row-1]-noOfSticks<0 || noOfSticks<=0);

        sticks[row-1]=sticks[row-1]-noOfSticks;
    }

    public boolean isWinner(int[] sticks) {
        for(int i:sticks){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
