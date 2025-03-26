import java.util.*;

// Abstract class representing a Job Role
abstract class JobRole {
    public abstract String getRoleName();
}

// Specific job roles extending JobRole
class SoftwareEngineer extends JobRole {
    @Override
    public String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    @Override
    public String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    @Override
    public String getRoleName() {
        return "Product Manager";
    }
}

// Generic class to handle resumes
class Resume<T extends JobRole> {
    private T jobRole;
    private String candidateName;
    private String experience;

    public Resume(T jobRole, String candidateName, String experience) {
        this.jobRole = jobRole;
        this.candidateName = candidateName;
        this.experience = experience;
    }

    public T getJobRole() {
        return jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Candidate: " + candidateName + " - Applying for: " + jobRole.getRoleName() + " - Experience: " + experience;
    }
}

// Resume Screening System
public class SmartAIResumeScreener {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Resume<? extends JobRole>> resumeList = new ArrayList<>();

        while (true) {
            System.out.println("\nChoose a job role to apply for:");
            System.out.println("1. Software Engineer");
            System.out.println("2. Data Scientist");
            System.out.println("3. Product Manager");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 4) {
                System.out.println("Exiting Resume Screening System. Here are the received applications:");
                for (Resume<?> resume : resumeList) {
                    System.out.println(resume);
                }
                break;
            }

            System.out.print("Enter Candidate Name: ");
            String candidateName = scanner.nextLine();

            System.out.print("Enter Years of Experience: ");
            String experience = scanner.nextLine();

            Resume<?> resume = null;
            switch (choice) {
                case 1:
                    resume = new Resume<>(new SoftwareEngineer(), candidateName, experience);
                    break;
                case 2:
                    resume = new Resume<>(new DataScientist(), candidateName, experience);
                    break;
                case 3:
                    resume = new Resume<>(new ProductManager(), candidateName, experience);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    continue;
            }

            resumeList.add(resume);
            System.out.println("Application received: " + resume);
        }
        scanner.close();
    }
}

