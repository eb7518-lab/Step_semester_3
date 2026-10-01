package week7.class_problems;

public class Scorecard {
    private boolean[] answers;
    private int current;

    public Scorecard(int questionCount) {
        answers = new boolean[questionCount];
        current = 0;
    }

    public void recordAnswer(boolean correct) {
        if (current < answers.length) {
            answers[current] = correct;
            current++;
        }
    }

    public int getScore() {
        int score = 0;

        for (boolean answer : answers) {
            if (answer) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scorecard s = new Scorecard(4);

        s.recordAnswer(true);
        s.recordAnswer(true);
        s.recordAnswer(false);
        s.recordAnswer(true);

        System.out.println(s.getScore());
    }
}