
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameUtilities {

    public static void playWithFriend() {

        Scanner key = new Scanner(System.in);
        System.out.println("What is Player's One name?");
        String player1 = key.next();
        System.out.println("What is Player's Two name?");
        String player2 = key.next();

        Messages.start();

        System.out.println(player1 + " write down a word, but don't allow " + player2 + " to see it!");

        String word = key.next();

        Messages.someTextArt1();

        char[] ch = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            ch[i] = word.charAt(i);
        }

        List<String> word1 = new ArrayList<>();

        for (int i = 0; i < ch.length; i++) {
            word1.add("_");
        }

        List<String> images = Messages.hangManImages();
        boolean finish = true;
        int nr = 1;
        int nr2 = 0;
        while (finish) {

            for (String s : word1) {
                System.out.print(s + " ");
            }

            System.out.println();

            System.out.println("Enter a letter!");1
            String letter = key.next();
            boolean exists = true;

            for (int i = 0; i < ch.length; i++) {

                if (letter.equalsIgnoreCase(String.valueOf(ch[i]))) {
                    word1.remove(i);
                    word1.add(i, letter);
                    exists = false;
                    ++nr2;
                }
            }


            if(nr2==ch.length){
                System.out.println(word);
                Messages.youWon();
                finish = false;
            }

            if (exists) {
                System.out.println(images.get(nr));
                ++nr;
                System.out.println("The word doesn't contain " + letter);
                if (nr == 7){
                    Messages.youLost();
                    finish = false;
                    System.out.println(word);
                }
            }

        }
    }
}
