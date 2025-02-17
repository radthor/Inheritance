import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
public class InheritanceDemo {

        public static void main(String[] args) {
            ArrayList<Worker> workers = new ArrayList<>();

            workers.add(new Worker("John", "Smith", "000001", "Mr", 1990, 25.00));
            workers.add(new Worker("Mary", "Johnson", "000002", "Mrs", 1985, 22.50));
            workers.add(new Worker("James", "Wilson", "000003", "Mr", 1988, 30.00));

            workers.add(new SalaryWorker("Sarah", "Davis", "000004", "Ms", 1982, 75000.00));
            workers.add(new SalaryWorker("Michael", "Brown", "000005", "Mr", 1987, 65000.00));
            workers.add(new SalaryWorker("Emma", "Taylor", "000006", "Ms", 1980, 85000.00));


            double[] weeklyHours = {40.0, 50.0, 40.0};

            System.out.println("\nWeekly Payroll Report");
            System.out.println("===========================================");


            for (int week = 0; week < weeklyHours.length; week++) {
                System.out.printf("\nWeek %d (%.1f hours):\n", week + 1, weeklyHours[week]);
                System.out.println("-------------------------------------------");
                System.out.printf("%-20s %-10s %12s\n", "Name", "ID", "Pay");
                System.out.println("-------------------------------------------");

                // Process each worker
                for (Worker w : workers) {
                    // Get worker's full name
                    String fullName = w.getFirstName() + " " + w.getLastName();

                    // Capture the original System.out
                    PrintStream originalOut = System.out;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(baos));

                    // Get pay information
                    w.displayWeeklyPay(weeklyHours[week]);

                    // Restore original System.out
                    System.setOut(originalOut);

                    // Parse the output to get the total pay
                    String output = baos.toString();
                    String totalPay = "";
                    if (w instanceof SalaryWorker) {
                        totalPay = output.substring(output.lastIndexOf("$") + 1).trim();
                    } else {
                        totalPay = output.substring(output.lastIndexOf("$") + 1).trim();
                    }

                    // Print formatted worker information
                    System.out.printf("%-20s %-10s $%11.2f\n",
                            fullName.substring(0, Math.min(20, fullName.length())),
                            w.getID(),
                            Double.parseDouble(totalPay));
                }
            }
        }
    }

