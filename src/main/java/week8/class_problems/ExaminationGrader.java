package week8.class_problems;

import java.util.Scanner;

interface Question {
    double grade(String answer);
    String getType();
}

class MCQQuestion implements Question {
    private String correctAnswer;
    private double marks;

    public MCQQuestion(String correctAnswer, double marks) {
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }

    public double grade(String answer) {
        return answer.equals(correctAnswer) ? marks : 0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TrueFalseQuestion implements Question {
    private String correctAnswer;
    private double marks;

    public TrueFalseQuestion(String correctAnswer, double marks) {
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }

    public double grade(String answer) {
        return answer.equals(correctAnswer) ? marks : 0;
    }

    public String getType() {
        return "TF";
    }
}

class EssayQuestion implements Question {
    private String correctAnswer;
    private double marks;

    public EssayQuestion(String correctAnswer, double marks) {
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }

    public double grade(String answer) {
        String[] keywords = correctAnswer.toLowerCase().split(",");
        String studentAnswer = answer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {
            if (studentAnswer.contains(keyword.trim())) {
                count++;
            }
        }

        if (count >= 2) {
            return marks * 0.75;
        } else if (count == 1) {
            return marks * 0.50;
        }

        return 0;
    }

    public String getType() {
        return "ESSAY";
    }
}

public class ExaminationGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.nextLine();
            String correctAnswer = sc.nextLine();
            String studentAnswer = sc.nextLine();
            double marks = sc.nextDouble();
            sc.nextLine();

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQQuestion(correctAnswer, marks);
            } else if (type.equals("TF")) {
                question = new TrueFalseQuestion(correctAnswer, marks);
            } else {
                question = new EssayQuestion(correctAnswer, marks);
            }

            double score = question.grade(studentAnswer);
            total += score;

            System.out.printf("%s: %.2f%n", question.getType(), score);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}