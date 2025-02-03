import java.util.Scanner;

public class kbc{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalWinnings = 0;
        int totalCorrect = 0;
        int totalQuestions = 15;
        int questionsPerRound = 5;
        
        System.out.println("Welcome to KBC Game!");
        System.out.println("Rules:");
        System.out.println("1. There are 3 rounds with 5 questions each.");
        System.out.println("2. You must answer at least 3 questions correctly in a round to move to the next round.");
        System.out.println("3. The winnings increase with each round.");
        System.out.println("4. If you fail to answer at least 3 questions correctly, the game is over.");
        System.out.print("Do you want to start the game? (yes/no): ");
        String startGame = sc.next().toLowerCase();
        
        if (!startGame.equals("yes")) {
            System.out.println("Thank you! See you next time.");
            return;
        }
        
        String[][] questions = {
            {"What is the national animal of India?", "Tiger", "Cheetah", "Lion", "Fox", "A"},
            {"What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", "C"},
            {"Which planet is known as the Red Planet?", "Venus", "Mars", "Jupiter", "Saturn", "B"},
            {"Who wrote 'Hamlet'?", "Shakespeare", "Milton", "Chaucer", "Wordsworth", "A"},
            {"What is the square root of 64?", "6", "7", "8", "9", "C"},
            {"What is the largest ocean on Earth?", "Atlantic", "Indian", "Pacific", "Arctic", "C"},
            {"How many continents are there?", "5", "6", "7", "8", "C"},
            {"What is the capital of Japan?", "Seoul", "Beijing", "Tokyo", "Bangkok", "C"},
            {"Who discovered gravity?", "Newton", "Einstein", "Galileo", "Curie", "A"},
            {"What is the chemical symbol for gold?", "Ag", "Au", "Pb", "Hg", "B"},
            {"Which is the smallest planet in the solar system?", "Mercury", "Mars", "Venus", "Pluto", "A"},
            {"Who painted the Mona Lisa?", "Picasso", "Van Gogh", "Da Vinci", "Rembrandt", "C"},
            {"Which gas do plants use for photosynthesis?", "Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen", "B"},
            {"What is the hardest natural substance on Earth?", "Gold", "Iron", "Diamond", "Quartz", "C"},
            {"Who developed the theory of relativity?", "Newton", "Einstein", "Galileo", "Tesla", "B"}
        };

        int[][] winningsPerRound = {
            {1000, 2000, 3000, 4000, 5000},
            {6000, 7000, 8000, 9000, 10000},
            {15000, 20000, 25000, 30000, 50000}
        };
        
        for (int round = 0; round < 3; round++) {
            System.out.println("\nStarting ROUND " + (round + 1) + "...");
            int correctAnswers = 0;
            
            for (int i = round * questionsPerRound; i < (round + 1) * questionsPerRound; i++) {
                System.out.println("\n" + questions[i][0]);
                System.out.println("A. " + questions[i][1]);
                System.out.println("B. " + questions[i][2]);
                System.out.println("C. " + questions[i][3]);
                System.out.println("D. " + questions[i][4]);
                System.out.print("Enter your choice (A/B/C/D): ");
                String choice = sc.next().toUpperCase();
                
                if (choice.equals(questions[i][5])) {
                    correctAnswers++;
                    totalCorrect++;
                    totalWinnings += winningsPerRound[round][i % 5];
                    System.out.println("Correct! You won " + winningsPerRound[round][i % 5] + " INR");
                } else {
                    System.out.println("Wrong answer. The correct answer was " + questions[i][5]);
                }
            }
            
            if (correctAnswers < 3) {
                System.out.println("\nYou answered only " + correctAnswers + " questions correctly. Game Over!");
                break;
            } else {
                System.out.println("\nCongratulations! You answered " + correctAnswers + " questions correctly.");
            }
        }
        
        System.out.println("\nYou answered " + totalCorrect + " out of " + totalQuestions + " questions correctly.");
        System.out.println("You won " + totalWinnings + " INR!\nSo proud of you! Have a great day!");
        sc.close();
    }
}
