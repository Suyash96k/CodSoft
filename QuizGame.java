import java.util.*;

public class QuizGame {

    static class Question {
        String questionText;
        String[] options;
        int correctAnswerIndex;

        public Question(String questionText, String[] options, int correctAnswerIndex) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Adding questions
        questions.add(new Question("What is the capital of India?", new String[]{"1.New Delhi", "2. Mumbai", "3. Pune", "4. Punjab"}, 0));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"}, 1));
        questions.add(new Question("What is the largest ocean on Earth?", new String[]{"1. Atlantic Ocean", "2. Indian Ocean", "3. Arctic Ocean", "4. Pacific Ocean"},3 ));
        questions.add(new Question("What is the currency of India?", new String[]{"1. Dollar","2. Rupee","3. Yen","4. Pound"}, 1));
        questions.add(new Question("Which is the longest river in India?", new String[]{"1. Yamuna", "2. Ganga", "3. Godavari", "4. Kaveri"}, 1));
       
        int score = 0;
        int questionNumber = 0;
        Map<Integer, Boolean> results = new HashMap<>();

        System.out.println("Welcome to the Quiz Game!");

        for (Question question : questions) {
            questionNumber++;
            System.out.println("\nQuestion " + questionNumber + ": " + question.questionText);
            for (String option : question.options) {
                System.out.println(option);
            }

            long startTime = System.currentTimeMillis();
            long endTime = startTime + 30000; // 30 seconds timer
            int userAnswer = -1;

            while (System.currentTimeMillis() < endTime) {
                System.out.print("Your answer (1-4): ");
                try {
                    userAnswer = Integer.parseInt(scanner.nextLine());
                    if (userAnswer < 1 || userAnswer > 4) {
                        System.out.println("Invalid choice. Please select a valid option (1-4).");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            }

            if (System.currentTimeMillis() >= endTime) {
                System.out.println("Time's up! Moving to the next question.");
            } else if (userAnswer - 1 == question.correctAnswerIndex) {
                System.out.println("Correct!");
                score++;
                results.put(questionNumber, true);
            } else {
                System.out.println("Wrong! The correct answer was: " + (question.correctAnswerIndex + 1));
                results.put(questionNumber, false);
            }
        }

        System.out.println("\nQuiz Over!");
        System.out.println("Your Score: " + score + "/" + questions.size());
        System.out.println("Summary:");

        for (int i = 1; i <= questions.size(); i++) {
            System.out.println("Question " + i + ": " + (results.getOrDefault(i, false) ? "Correct" : "Incorrect"));
        }

        scanner.close();
    }
}
