import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {
    SalaryWorker p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp() {
        p1 = new SalaryWorker("Andrew", "Joslin", "100034", "Mr", 1985, 49000);
        p2 = new SalaryWorker("Jacob", "Schmidt", "100035", "Mr", 1924, 53000);
        p3 = new SalaryWorker("Frank", "Dodd", "100036", "Mr", 1956, 45000);
        p4 = new SalaryWorker("Tina", "Elbow", "100037", "Mrs", 1986, 44000);
        p5 = new SalaryWorker("Angela", "Mark", "100038", "Mrs", 2014, 43000);
        p6 = new SalaryWorker("Helga", "Duffell", "100039", "Ms", 1996, 42000);

    }
    @Test
     void getAnnualSalary() {
        p1.getAnnualSalary();
        assertEquals(49000.0, p1.getAnnualSalary());
    }

    @Test
    void setAnnualSalary() {
        p1.setAnnualSalary(42000.0);
        assertEquals(42000.0, p1.getAnnualSalary());
    }
    @Test
    void testdisplayWeeklyPay() {
        p1.displayWeeklyPay(40);
        String expected = "One week at annual salary is 942.3076923076923\n" +
                "Weekly pay is 1/52 of  $49000\n" +
                "Total Pay: $942.3076923076923\n";
    }

    @Test
    void toCSV() {
        String expected =
                "100034, Andrew, Joslin, Mr, 1985, 49000.0";
        assertEquals(expected, p1.toCSV());
    }

    @Test
    void testToJSONRecord() {
        String expected = "{\"IDNum\":\"100034\"," +
                "\"firstName\":\"Andrew\"," +
                " \"lastName\":\"Joslin\"," +
                " \"title\":\"Mr\"," +
                " \"YOB\":1985," +
                " \"Annual Salary\":49000.0}";
        assertEquals(expected, p1.toJSONRecord());
    }

    @Test
    void toXMLRecord() {
        String expected = "<Salary Worker>" +
                "<IDNum>100034</IDNum>" +
                "<firstName>Andrew</firstName>" +
                "<lastName>Joslin</lastName>" +
                "<title>Mr</title>" +
                "<YOB>1985</YOB>" +
                "<Annual Salary>49000.0</Annual Salary>" +
                "</Salary Worker>";
        assertEquals(expected, p1.toXMLRecord());
    }
}