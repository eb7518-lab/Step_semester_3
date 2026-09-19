package week6.class_problems;

public class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        PlacementRecord s1 = new PlacementRecord("Ravi", "TCS", 4.5);
        PlacementRecord s2 = new PlacementRecord("Anitha", "Zoho", 6.2);
        PlacementRecord s3 = new PlacementRecord("Karthik", "Infosys", 4.0);

        PlacementRecord[] students = {s1, s2, s3};

        for (PlacementRecord student : students) {
            student.printRecord();
        }
    }
}