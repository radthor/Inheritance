import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    Worker p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        p1 = new Worker("Andrew", "Joslin", "100034", "Mr", 1985, 13.15);
        p2 = new Worker("Jacob", "Schmidt", "100035", "Mr", 1924, 14.50);
        p3 = new Worker("Frank", "Dodd", "100036", "Mr", 1956, 19.20);
        p4 = new Worker("Tina", "Elbow", "100037", "Mrs", 1986, 19.85);
        p5 = new Worker("Angela", "Mark", "100038", "Mrs", 2014, 45.45);
        p6 = new Worker("Helga", "Duffell", "100039", "Ms", 1996, 99.99);

    }

    @Test
    void getHourlyPayRate() {
        p1.getHourlyPayRate();
        assertEquals(13.15, p1.getHourlyPayRate());
    }

    @Test
    void setHourlyPayRate() {
        p1.setHourlyPayRate(45.45);
        assertEquals(45.45, p1.getHourlyPayRate());
    }

    @Test
    void testdisplayWeeklyPay() {
        p1.displayWeeklyPay(40);
        String expected = "Regular Hours: 40.0 at $13.15 per hour\n" +
                "Regular Pay: $526.0\n" +
                "Overtime Hours: 0\n" +
                "Overtime Pay: $0.00\n" +
                "Total Pay: $526.0\n";
    }

    @Test
    void toCSV() {
        String expected =
                "100034, Andrew, Joslin, Mr, 1985, 13.15";
        assertEquals(expected, p1.toCSV());
    }

    @Test
    void testToJSONRecord() {
        String expected = "{\"IDNum\":\"100034\"," +
                "\"firstName\":\"Andrew\"," +
                " \"lastName\":\"Joslin\"," +
                " \"title\":\"Mr\"," +
                " \"YOB\":1985," +
                " \"hourlyPayRate\":13.15}";
        assertEquals(expected, p1.toJSONRecord());
    }

    @Test
    void toXMLRecord() {
        String expected = "<Worker>" +
                "<IDNum>100034</IDNum>" +
                "<firstName>Andrew</firstName>" +
                "<lastName>Joslin</lastName>" +
                "<title>Mr</title>" +
                "<YOB>1985</YOB>" +
                "<hourlyPayRate>13.15</hourlyPayRate>" +
                "</Worker>";
        assertEquals(expected, p1.toXMLRecord());
    }
}