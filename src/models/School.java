package models;

import java.util.ArrayList;

public class School {
    public ArrayList<Person> members;

    public School() {
        members = new ArrayList<>();
    }

    public void addMember(Person member) {
        members.add(member);
    }

    @Override
    public String toString() {
        String result = "";
        for (Person member : members) {
            result += member.toString() + "\n";
        }
        return result;
    }
}




