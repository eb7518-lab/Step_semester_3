package week6.class_problems;

public class IdCard {
    String name;
    int booksIssued;

    public static void main(String[] args) {
        IdCard ravi = new IdCard();
        ravi.name = "Ravi";
        ravi.booksIssued = 2;

        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;

        System.out.println(ravi.name + " " + ravi.booksIssued);
        System.out.println(duplicate == ravi);

        IdCard separate = new IdCard();
        separate.name = "Ravi";
        separate.booksIssued = 3;

        System.out.println(separate == ravi);
    }
}