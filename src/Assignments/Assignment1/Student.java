package Assignment1;
public class Student extends Human {
    private int roll_no;
    private String classes;
    private int Semester;
    private int cpi;

    Student(int age, String gender, String name, int roll_no, String classes, int Semester, int cpi) {
        super(age, gender, name);
        this.roll_no = roll_no;
        this.classes = classes;
        this.Semester = Semester;
        this.cpi = cpi;
    }
    public int getRoll_no() {
        return roll_no;
    }

    public String getClasses() {
        return classes;
    }

    public int getSemester() {
        return Semester;
    }

    public int getCpi() {
        return cpi;
    }
}
