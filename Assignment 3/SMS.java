import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;

class Person {
    protected String name;
    protected String dob;
    protected String bloodGroup;
    protected int age;

    public Person(String name, String dob, String bloodGroup) {
        this.name = name;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
        this.age = calculateAge(dob);
    }

    private int calculateAge(String dob) {
        if (!dob.matches("\\d{2}-\\d{2}-\\d{4}")) {
            System.out.println("Invalid DOB format for " + name + ". Use dd-MM-yyyy.");
            return -1;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu")
        .withResolverStyle(ResolverStyle.STRICT);
        LocalDate birthDate = LocalDate.parse(dob, formatter);
        return (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }
}

class Student extends Person {
    private String branch;
    private String mode;
    private String studentID;
    private String email;
    private static int[] count = new int[20];

    public Student(String name, String branch, String mode, String dob, String bloodGroup) {
        super(name, dob, bloodGroup);
        this.branch = branch;
        this.mode = mode;
        int id = getBranchCode(branch, mode);
        if (id != -1) {
            this.studentID = generateID(id, mode);
            this.email = generateEmail(branch);
        } else {
            System.out.println("Invalid branch for student: " + name);
        }
    }

    private int getBranchCode(String branch, String mode) {
        int base = switch (branch.toLowerCase()) {
            case "mechanical" -> 0;
            case "civil" -> 1;
            case "cse" -> 2;
            case "extc" -> 3;
            case "it" -> 4;
            case "instrumentation" -> 5;
            case "production" -> 6;
            case "chemical" -> 7;
            case "textile" -> 8;
            case "electrical" -> 9;
            default -> -1;
        };
        if (base == -1) return -1;
        return mode.equalsIgnoreCase("DSY") ? base + 10 : base;
    }

    private String generateID(int code, String mode) {
        int year = Year.now().getValue();
        if (mode.equalsIgnoreCase("DSY")) {
            year += 1;
        }
        int d = (code >= 10) ? 5 : 0;
        String[] codes = {"ME", "CE", "CS", "EC", "IT", "IN", "PR", "CH", "TT", "EL"};
        String shortCode = codes[code % 10];

        if (++count[code] < 10)
            return year + "B" + shortCode + d + "0" + count[code];
        else
            return year + "B" + shortCode + d + count[code];
    }

    private String generateEmail(String branch) {
        String emailPrefix = name.toLowerCase().replaceAll(" ", "");
        return emailPrefix + "@" + branch.toLowerCase() + ".sggs.ac.in";
    }

    public void displayInfo() {
        System.out.println("Name        : " + name);
        System.out.println("Branch      : " + branch);
        System.out.println("Email       : " + email);
        System.out.println("Student ID  : " + studentID);
        System.out.println("Age         : " + age);
        System.out.println("Blood Group : " + bloodGroup);
        System.out.println();
    }
}

public class SMS {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide student data as a command-line argument.");
            return;
        }

        String[] studentDataArray = args[0].split("\\|");

        for (String studentData : studentDataArray) {
            String[] data = studentData.split(",");
            if (data.length != 5) {
                System.out.println("Invalid student record: " + studentData);
                continue;
            }

            Student student = new Student(
                    data[0].trim(),
                    data[1].trim(),
                    data[2].trim(),
                    data[3].trim(),
                    data[4].trim()
            );

            student.displayInfo();
        }
    }
}
