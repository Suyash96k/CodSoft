import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Grade Calculator!");

        System.out.print("Enter the number of subjects: ");
        int numSubjects;
        try {
            numSubjects = Integer.parseInt(scanner.nextLine());
            if (numSubjects <= 0) {
                System.out.println("Number of subjects must be greater than 0.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            try {
                marks[i] = Integer.parseInt(scanner.nextLine());
                if (marks[i] < 0 || marks[i] > 100) {
                    System.out.println("Marks should be between 0 and 100.");
                    i--;
                    continue;
                }
                totalMarks += marks[i];
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                i--;
            }
        }

        double averagePercentage = (double) totalMarks / numSubjects;
        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
