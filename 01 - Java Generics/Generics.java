/*
Problem 1
import java.util.ArrayList;

abstract class WarehouseItem{
    abstract String getName();
}
class Electronics extends WarehouseItem{
    String name;
    Electronics(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
}
class Groceries extends WarehouseItem{
    String name;
    Groceries(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
}
class Furniture extends WarehouseItem{
    String name;
    Furniture(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
}
class Storage<T extends WarehouseItem>{
    private final ArrayList<T> items = new ArrayList<>();
    void addItem(T item){
        items.add(item);
    }

    ArrayList<T> getItems(){
        return items;
    }

    static void displayItems(ArrayList<? extends WarehouseItem> items){
        for(WarehouseItem item : items){
            System.out.println(item.getName());
        }
    }
}

public class Generics {
    public static void main(String[] args){
        Storage<Electronics> electronicStorage = new Storage<>();
        electronicStorage.addItem(new Electronics("Laptop"));
        electronicStorage.addItem(new Electronics("SmartPhone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apples"));
        groceriesStorage.addItem(new Groceries("Bananas"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Table"));
        furnitureStorage.addItem(new Furniture("Chairs"));

        System.out.println("Display Electronics:");
        Storage.displayItems(electronicStorage.getItems());
        System.out.println("Display Groceries:");
        Storage.displayItems(groceriesStorage.getItems());
        System.out.println("Display Furniture:");
        Storage.displayItems(furnitureStorage.getItems());
    }
}
*/

/*
Problem 2
import java.util.ArrayList;

abstract class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void applyDiscount(double percentage) {
        price -= price * percentage / 100;
    }

    abstract void displayDetails();
}

class BookCategory extends Product {
    BookCategory(String name, double price) {
        super(name, price);
    }

    @Override
    void displayDetails() {
        System.out.println("Book: " + name + " Rs." + price);
    }
}

class ClothingCategory extends Product {
    ClothingCategory(String name, double price) {
        super(name, price);
    }

    @Override
    void displayDetails() {
        System.out.println("Clothing: " + name + " Rs." + price);
    }
}

class GadgetsCategory extends Product {
    GadgetsCategory(String name, double price) {
        super(name, price);
    }

    @Override
    void displayDetails() {
        System.out.println("Gadget: " + name + " Rs." + price);
    }
}

class ProductCatalog<T extends Product> {
    final ArrayList<T> catalog = new ArrayList<>();

    void addProduct(T product) {
        catalog.add(product);
    }

    void displayInfo() {
        for (T item : catalog) {
            item.displayDetails();
        }
    }

    <t extends Product> void applyDiscount(t product, double percentage) {
        product.applyDiscount(percentage);
    }
}

public class Generics {
    public static void main(String[] args) {
        ProductCatalog<BookCategory> bookCatalog = new ProductCatalog<>();
        bookCatalog.addProduct(new BookCategory("Java Programming", 500));
        bookCatalog.addProduct(new BookCategory("Data Structures", 400));

        ProductCatalog<ClothingCategory> clothingCatalog = new ProductCatalog<>();
        clothingCatalog.addProduct(new ClothingCategory("T-shirt", 800));
        clothingCatalog.addProduct(new ClothingCategory("Jeans", 1200));

        ProductCatalog<GadgetsCategory> gadgetCatalog = new ProductCatalog<>();
        gadgetCatalog.addProduct(new GadgetsCategory("Smartphone", 15000));
        gadgetCatalog.addProduct(new GadgetsCategory("Laptop", 50000));

        System.out.println("Before Discount:");
        bookCatalog.displayInfo();
        clothingCatalog.displayInfo();
        gadgetCatalog.displayInfo();

        bookCatalog.applyDiscount(bookCatalog.catalog.get(0), 10);
        clothingCatalog.applyDiscount(clothingCatalog.catalog.get(0), 5);
        gadgetCatalog.applyDiscount(gadgetCatalog.catalog.get(0), 20);

        System.out.println("\nAfter Discount:");
        bookCatalog.displayInfo();
        clothingCatalog.displayInfo();
        gadgetCatalog.displayInfo();
    }
}
 */

/*
Problem 3
import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    String courseName;
    String instructor;

    CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    abstract void evaluate();

    void display() {
        System.out.println(courseName + " by " + instructor);
        evaluate();
    }
}

class ExamCourse extends CourseType {
    ExamCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    void evaluate() {
        System.out.println("Evaluation: Final Exam");
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    void evaluate() {
        System.out.println("Evaluation: Weekly Assignments");
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    void evaluate() {
        System.out.println("Evaluation: Research Project");
    }
}

class Course<T extends CourseType> {
    List<T> courseList = new ArrayList<>();

    void addCourse(T course) {
        courseList.add(course);
    }

    void showAllCourses() {
        for (T course : courseList) {
            course.display();
        }
    }

    static void displayAnyCourseList(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.display();
        }
    }
}

public class Generics {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Mathematics", "Dr. Sharma"));
        examCourses.addCourse(new ExamCourse("Physics", "Dr. Reddy"));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("English", "Ms. Meera"));
        assignmentCourses.addCourse(new AssignmentCourse("History", "Mr. Jacob"));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Thesis", "Dr. Bose"));
        researchCourses.addCourse(new ResearchCourse("Quantum Research", "Dr. Patel"));

        System.out.println("Exam-Based Courses:");
        examCourses.showAllCourses();

        System.out.println("\nAssignment-Based Courses:");
        assignmentCourses.showAllCourses();

        System.out.println("\nResearch-Based Courses:");
        researchCourses.showAllCourses();

        System.out.println("\nDisplaying All Courses using Wildcards:");
        Course.displayAnyCourseList(examCourses.courseList);
        Course.displayAnyCourseList(assignmentCourses.courseList);
        Course.displayAnyCourseList(researchCourses.courseList);
    }
}
 */

/*
Problem 4
import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    void displayMeal();
    boolean isValid();
}

class VegetarianMeal implements MealPlan {
    String name;

    VegetarianMeal(String name) {
        this.name = name;
    }

    @Override
    public void displayMeal() {
        System.out.println("Vegetarian Meal: " + name);
    }

    @Override
    public boolean isValid() {
        return !name.toLowerCase().contains("meat");
    }
}

class VeganMeal implements MealPlan {
    String name;

    VeganMeal(String name) {
        this.name = name;
    }

    @Override
    public void displayMeal() {
        System.out.println("Vegan Meal: " + name);
    }

    @Override
    public boolean isValid() {
        return !name.toLowerCase().contains("meat") && !name.toLowerCase().contains("milk");
    }
}

class KetoMeal implements MealPlan {
    String name;

    KetoMeal(String name) {
        this.name = name;
    }

    @Override
    public void displayMeal() {
        System.out.println("Keto Meal: " + name);
    }

    @Override
    public boolean isValid() {
        return !name.toLowerCase().contains("sugar");
    }
}

class HighProteinMeal implements MealPlan {
    String name;

    HighProteinMeal(String name) {
        this.name = name;
    }

    @Override
    public void displayMeal() {
        System.out.println("High-Protein Meal: " + name);
    }

    @Override
    public boolean isValid() {
        return name.toLowerCase().contains("egg") || name.toLowerCase().contains("chicken") || name.toLowerCase().contains("protein");
    }
}

class Meal<T extends MealPlan> {
    List<T> mealList = new ArrayList<>();

    void addMeal(T meal) {
        if (meal.isValid()) {
            mealList.add(meal);
        } else {
            System.out.println("Invalid meal: " + meal.getClass().getSimpleName());
        }
    }

    void showMeals() {
        for (T meal : mealList) {
            meal.displayMeal();
        }
    }

    static <T extends MealPlan> void generatePersonalizedMeal(T meal) {
        if (meal.isValid()) {
            System.out.println("Generated Meal Plan:");
            meal.displayMeal();
        } else {
            System.out.println("Cannot generate meal plan. Invalid meal: " + meal.getClass().getSimpleName());
        }
    }
}

public class Generics {
    public static void main(String[] args) {
        Meal<VeganMeal> veganPlan = new Meal<>();
        veganPlan.addMeal(new VeganMeal("Tofu Salad"));
        veganPlan.addMeal(new VeganMeal("Vegan Burger"));
        veganPlan.addMeal(new VeganMeal("Milk Smoothie"));

        Meal<HighProteinMeal> proteinPlan = new Meal<>();
        proteinPlan.addMeal(new HighProteinMeal("Boiled Eggs"));
        proteinPlan.addMeal(new HighProteinMeal("Protein Shake"));

        System.out.println("Vegan Meals:");
        veganPlan.showMeals();

        System.out.println("\nHigh Protein Meals:");
        proteinPlan.showMeals();

        System.out.println("\nGenerating Personalized Meal:");
        Meal.generatePersonalizedMeal(new KetoMeal("Chicken Stir Fry"));
        Meal.generatePersonalizedMeal(new VegetarianMeal("Paneer Tikka"));
        Meal.generatePersonalizedMeal(new VeganMeal("Milk Soup"));
    }
}
 */

/*
Problem 5
import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    String candidateName;

    JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    abstract boolean isQualified();

    abstract void printDetails();
}

class SoftwareEngineer extends JobRole {
    int codingScore;

    SoftwareEngineer(String name, int codingScore) {
        super(name);
        this.codingScore = codingScore;
    }

    boolean isQualified() {
        return codingScore >= 75;
    }

    void printDetails() {
        System.out.println("Software Engineer - " + candidateName + " | Coding Score: " + codingScore);
    }
}

class DataScientist extends JobRole {
    int dataScore;

    DataScientist(String name, int dataScore) {
        super(name);
        this.dataScore = dataScore;
    }

    boolean isQualified() {
        return dataScore >= 70;
    }

    void printDetails() {
        System.out.println("Data Scientist - " + candidateName + " | Data Score: " + dataScore);
    }
}

class ProductManager extends JobRole {
    int leadershipScore;

    ProductManager(String name, int leadershipScore) {
        super(name);
        this.leadershipScore = leadershipScore;
    }

    boolean isQualified() {
        return leadershipScore >= 80;
    }

    void printDetails() {
        System.out.println("Product Manager - " + candidateName + " | Leadership Score: " + leadershipScore);
    }
}

class Resume<T extends JobRole> {
    private final List<T> applications = new ArrayList<>();

    void addResume(T resume) {
        applications.add(resume);
    }

    List<T> getAllResumes() {
        return applications;
    }
}

class ResumeScreeningSystem {
    static void screenResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            resume.printDetails();
            if (resume.isQualified()) {
                System.out.println("Qualified");
            } else {
                System.out.println("Not Qualified");
            }
            System.out.println();
        }
    }
}

public class Generics {
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
