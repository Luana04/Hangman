import java.util.Scanner;

public class Game {

    public static void hangMan(){
        Scanner key = new Scanner(System.in);
        Messages.welcome();
        boolean isValid = true;

        while(isValid) {
            isValid = false;
            System.out.println("Press 1 if you want to play with a friend.");
            System.out.println("Press 2 if you want to play with the CPU.");

            int answer = key.nextInt();

            switch (answer) {
                case 1:
                    GameUtilities.playWithFriend();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Please type a valid answer.");
                    isValid = true;
            }

            System.out.println("Do you want to play again?");
            String answer2 = key.next();
            if (answer2.equalsIgnoreCase("yes")){
                isValid = true;
            } else Messages.goodBye();
        }
    }
}
