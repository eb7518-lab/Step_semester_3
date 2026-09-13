package week6.class_problems;

public class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {
        Course theory = new Course("CSE101", "Programming", 4);
        Course lab = new Course("CSE102", "Programming Lab", 3, 1);

        System.out.println(theory.title + " Total Credits: " + theory.totalCredits());
        System.out.println(lab.title + " Total Credits: " + lab.totalCredits());
    }
}