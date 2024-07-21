package lastpencil;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("How many pencils would you like to use:");
            boolean validInput = false;
            int totalPencils = 0;
            do {
                try {
                    totalPencils = Integer.parseInt(scanner.nextLine());
                    if (totalPencils < 0) {
                        throw new NumberFormatException();
                    } else if (totalPencils == 0) {
                        System.out.println("number of pencils should be positive");
                        continue;
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException ne) {
                    System.out.println("The number of pencils should be numeric");
                }
            } while (!(validInput));

            System.out.println("Who will be the first (John, Jack)");
            String firstPlayer;
            while (true){
                firstPlayer = scanner.nextLine();
                if (("John".equals(firstPlayer)) || ("Jack".equals(firstPlayer))) {
                    break;
                }
                System.out.println("Choose between John and Jack");
            }
            boolean isJohn = false;
            printPencils(totalPencils);

            isJohn = firstPlayer.equals("John");

            while ((totalPencils > 0)) {
                if (isJohn) {
                    System.out.println("John's turn!");
                    totalPencils = getTotalPencils(scanner, totalPencils);
                    isJohn = false;
                    printPencils(totalPencils);
                    if(totalPencils == 0) {
                        System.out.println("Jack won!");
                    }
                } else {
                    System.out.println("Jack's turn!");
                    isJohn = true;
                    //Jack is a bot. So call botPlay method.
                    totalPencils = botPlay(totalPencils);
                    printPencils(totalPencils);
                    if(totalPencils == 0) {
                        System.out.println("John won!");
                    }
                }
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static int botPlay(int totalPencils) {
        int botPick = 0;
        Random random = new Random();

        if (totalPencils % 4 == 1) {
            //pick random number between 1 and 3.
            if (totalPencils == 1) {
                botPick = 1;
            } else {
                botPick = random.nextInt(3) + 1;
            }
        } else if (totalPencils % 4 == 0) {
            //pick 3 pencils
            botPick = 3;
        } else if (totalPencils % 4 == 3) {
            //pick 2 pencils
            botPick = 2;
        } else if (totalPencils % 4 == 2) {
            //pick 1 pencil.
            botPick = 1;
        }
        System.out.println(botPick);
        totalPencils -= botPick;
        return totalPencils;
    }
    private static int getTotalPencils(Scanner scanner, int totalPencils) {
        int pickedPencils = 0;
        while (true) {
            try {
                pickedPencils = Integer.parseInt(scanner.nextLine());
                if (pickedPencils == 1 || pickedPencils == 2 || pickedPencils == 3) {
                    if (pickedPencils > totalPencils) {
                        System.out.println("Too many pencils were taken");
                        continue;
                    }
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException ne) {
                System.out.println("Possible values: '1', '2' or '3'");
            }
        }
        totalPencils -= pickedPencils;
        return totalPencils;
    }

    private static void printPencils(int p) {
        for (int i = 0; i < p; i++) {
            System.out.print("|");
        }
        System.out.println();
    }
}