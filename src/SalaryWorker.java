public class SalaryWorker extends Worker{

   private double AnnualSalary = 0.0;

    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double AnnualSalary) {
        super(firstName, lastName, ID, title, YOB, 0.0);
        this.AnnualSalary = AnnualSalary;
    }

    public double getAnnualSalary() {
        return AnnualSalary;
    }

    public void setAnnualSalary(double AnnualSalary) {
        this.AnnualSalary = AnnualSalary;
    }

    @Override
    double calculateWeeklyPay(double WeeklyPay) {
        return AnnualSalary / 52;
    }
    @Override
    void displayWeeklyPay(double hoursWorked) {
        double regularPay = AnnualSalary / 12;
        System.out.println("One week at annual salary is " + AnnualSalary / 52);
        System.out.println("Weekly pay is 1/52 of  $" + AnnualSalary);
        System.out.println("Total Pay: $" + AnnualSalary / 52);
    }

@Override
public String toString() {
    return "Worker{" +
            "ID='" + getID() + '\'' +
            ", firstName='" + getFirstName() + '\'' +
            ", lastName='" + getLastName() + '\'' +
            ", YOB=" + getYOB() +
            ", title='" + getTitle() + '\'' +
            ", annual salary=" + AnnualSalary +
            '}';
}

@Override
public String toCSV() {
    return getID() + ", " + getFirstName() + ", " + getLastName() + ", " + getTitle() + ", " + getYOB() + ", " + AnnualSalary;
}

@Override
public String toJSONRecord() {
    String retString = "";
    char DQ = '\u0022';  // Assign the double quote char to a variable
    retString =  "{" + DQ + "IDNum" + DQ + ":" + DQ + this.getID() + DQ + ",";
    retString += DQ + "firstName" + DQ + ":" + DQ + this.getFirstName() + DQ + ",";
    retString += " " + DQ + "lastName"  + DQ + ":" + DQ + this.getLastName() + DQ + ",";
    retString += " " + DQ + "title" + DQ + ":" + DQ + this.getTitle() + DQ + ",";
    retString += " " + DQ + "YOB"  + DQ + ":" + this.getYOB() + ",";
    retString += " " + DQ + "Annual Salary" + DQ + ":" + this.AnnualSalary + "}";
    return retString;
}
@Override
public String toXMLRecord() {
    String retString = "";
    retString = "<Salary Worker>" + "<IDNum>" + this.getID() + "</IDNum>";
    retString += "<firstName>" + this.getFirstName() + "</firstName>";
    retString += "<lastName>" + this.getLastName() + "</lastName>";
    retString += "<title>" + this.getTitle() + "</title>";
    retString += "<YOB>" + this.getYOB() + "</YOB>";
    retString += "<Annual Salary>" + this.AnnualSalary + "</Annual Salary></Salary Worker>";
    return retString;
}
    }

