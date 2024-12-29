package models;
public class Teacher extends Person {
    public String subject;
    public int yearsOfExperience;
    public int salary;
    public Teacher(String name, String surname, int age, boolean gender, String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }
    public void giveRaise(int percentage) {
        salary += salary * percentage / 100;
    }
    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + ".";
    }
}


