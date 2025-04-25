import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    String candidateName;
    JobRole(String candidateName) { this.candidateName = candidateName; }
    abstract boolean isQualified();
    abstract void printDetails();
}

class SoftwareEngineer extends JobRole {
    int codingScore;
    SoftwareEngineer(String name, int codingScore) { super(name); this.codingScore = codingScore; }
    boolean isQualified() { return codingScore >= 75; }
    void printDetails() { System.out.println("Software Engineer - " + candidateName + " | Coding Score: " + codingScore); }
}

class DataScientist extends JobRole {
    int dataScore;
    DataScientist(String name, int dataScore) { super(name); this.dataScore = dataScore; }
    boolean isQualified() { return dataScore >= 70; }
    void printDetails() { System.out.println("Data Scientist - " + candidateName + " | Data Score: " + dataScore); }
}

class ProductManager extends JobRole {
    int leadershipScore;
    ProductManager(String name, int leadershipScore) { super(name); this.leadershipScore = leadershipScore; }
    boolean isQualified() { return leadershipScore >= 80; }
    void printDetails() { System.out.println("Product Manager - " + candidateName + " | Leadership Score: " + leadershipScore); }
}

class Resume<T extends JobRole> {
    private final List<T> applications = new ArrayList<>();
    void addResume(T resume) { applications.add(resume); }
    List<T> getAllResumes() { return applications; }
}

class ResumeScreeningSystem {
    static void screenResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            resume.printDetails();
            if (resume.isQualified()) System.out.println("Qualified");
            else System.out.println("Not Qualified");
            System.out.println();
        }
    }
}

public class AIDrivenResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResumes = new Resume<>();
        seResumes.addResume(new SoftwareEngineer("Alice", 85));
        seResumes.addResume(new SoftwareEngineer("Bob", 60));

        Resume<DataScientist> dsResumes = new Resume<>();
        dsResumes.addResume(new DataScientist("Carol", 72));
        dsResumes.addResume(new DataScientist("Dave", 65));

        Resume<ProductManager> pmResumes = new Resume<>();
        pmResumes.addResume(new ProductManager("Eve", 90));
        pmResumes.addResume(new ProductManager("Frank", 75));

        System.out.println("=== Screening Software Engineers ===");
        ResumeScreeningSystem.screenResumes(seResumes.getAllResumes());

        System.out.println("=== Screening Data Scientists ===");
        ResumeScreeningSystem.screenResumes(dsResumes.getAllResumes());

        System.out.println("=== Screening Product Managers ===");
        ResumeScreeningSystem.screenResumes(pmResumes.getAllResumes());
    }
}
