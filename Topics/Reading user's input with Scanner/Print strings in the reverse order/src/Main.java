import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String[] inputString = new String[3];

        //input for loop.
        for (int i = 0; i < inputString.length; i++) {
            inputString[i] = scanner.next();
        }

        //loop to print outpoot.
        for (int i = inputString.length - 1; i >= 0; i--) {
            System.out.println(inputString[i]);
        }
    }
}
