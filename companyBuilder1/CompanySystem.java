



abstract class Employee{

    private String name;
    private int id;
    protected double baseSalary;

    public abstract double calculatePay();
    //abstract inseamna ca implementeaza copiii
    

    public Employee(String name,int id){
        this.name = name;
        this.id = id;
    }




    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }
}

class FullTimeEmployee extends Employee{

    private double bonus;
    //protected baseSalary
    public FullTimeEmployee(String name,int id,double baseSalary,double bonus){
        super(name,id);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }


    @Override
    public double calculatePay(){
        return this.baseSalary+this.bonus;
    }

}

class Contractor extends Employee{
    private double hourlyRate;
    private int hoursWorked;


    public Contractor(String name,int id,double hourlyRate,int hoursWorked){
        super(name,id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }



    @Override
    public double calculatePay(){
        return this.hourlyRate*hoursWorked;
    }
}





public class CompanySystem {

    public static void main(String[] args){

        Employee[] listEmployees= {new FullTimeEmployee("Ayan", 0, 1300, 20), new Contractor("Caca", 1, 12, 20)};

        for (int i =0;i<listEmployees.length;i++){
            System.out.println(listEmployees[i].getName()+" "+listEmployees[i].getId()+" "+listEmployees[i].calculatePay());
        }

    }


}