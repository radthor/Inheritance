 class Worker extends Person {

   private double hourlyPayRate = 0.0;

    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate) {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

   double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyPayRate;
        } else {
            double regularPay = 40 * hourlyPayRate;
            double overtimeHours = hoursWorked - 40;
            double overtimePay = overtimeHours * (hourlyPayRate * 1.5);
            return regularPay + overtimePay;
        }
    }

    void displayWeeklyPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            double regularPay = hoursWorked * hourlyPayRate;
            System.out.println("Regular Hours: " + hoursWorked + " at $" + hourlyPayRate + " per hour");
            System.out.println("Regular Pay: $" + regularPay);
            System.out.println("Overtime Hours: 0");
            System.out.println("Overtime Pay: $0.00");
            System.out.println("Total Pay: $" + regularPay);
        } else {
            double regularPay = 40 * hourlyPayRate;
            double overtimeHours = hoursWorked - 40;
            double overtimePay = overtimeHours * (hourlyPayRate * 1.5);
            double totalPay = regularPay + overtimePay;

            System.out.println("Regular Hours: 40 at $" + hourlyPayRate + " per hour");
            System.out.println("Regular Pay: $" + regularPay);
            System.out.println("Overtime Hours: " + overtimeHours + " at $" + (hourlyPayRate * 1.5) + " per hour");
            System.out.println("Overtime Pay: $" + overtimePay);
            System.out.println("Total Pay: $" + totalPay);
        }

    }
    @Override
    public String toString() {
        return "Worker{" +
                "ID='" + getID() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", YOB=" + getYOB() +
                ", title='" + getTitle() + '\'' +
                ", hourlyPayRate=" + hourlyPayRate +
                '}';
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + hourlyPayRate;
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
        retString += " " + DQ + "hourlyPayRate" + DQ + ":" + this.hourlyPayRate + "}";
        return retString;
    }
    @Override
    public String toXMLRecord() {
        String retString = "";
        retString = "<Worker>" + "<IDNum>" + this.getID() + "</IDNum>";
        retString += "<firstName>" + this.getFirstName() + "</firstName>";
        retString += "<lastName>" + this.getLastName() + "</lastName>";
        retString += "<title>" + this.getTitle() + "</title>";
        retString += "<YOB>" + this.getYOB() + "</YOB>";
        retString += "<hourlyPayRate>" + this.hourlyPayRate + "</hourlyPayRate></Worker>";
        return retString;
    }
}
