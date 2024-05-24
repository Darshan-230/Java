package employee;

public class Main {

    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Darshan", 21, 35000);
        Employee emp2 = new Employee(102, "Ashwin", 22, 45000);
        Employee emp3 = new Employee(103, "Talati", 20, 19500);

        emp1.setTax(CalculateEmpTax.calucateTax(emp1));
        emp2.setTax(CalculateEmpTax.calucateTax(emp2));
        emp3.setTax(CalculateEmpTax.calucateTax(emp3));

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
    }
}
