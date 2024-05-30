package staticKeyword;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("DS", 21);
        Student s2 = new Student("AR", 24);
        Student s3 = new Student("JM", 23);
        Student s4 = new Student("KK", 19);

        System.out.println(Student.getTotalStudent());
    }
}
