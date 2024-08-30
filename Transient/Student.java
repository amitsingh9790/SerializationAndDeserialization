package SerializationAndDeserialization.Transient;
import java.io.*;

public class Student implements Serializable {
    String name;
    int rollno;
    transient String college; //ye line serialize nahi hoga kyoki transient keyword lagaya hai

    public Student(String name, int rollno, String college) {
        this.name = name;
        this.rollno = rollno;
        this.college = college;
    }

    void display(){
        System.out.println("Student Name: "+name);
        System.out.println("Student RollNo: "+rollno);
        System.out.println("Student college: "+college);
    }
}

class Main{
    public static void main(String[] args) throws Exception {

        // Serialization
        FileOutputStream fos = new FileOutputStream("E:/Coding/FJWP/ClassCodes/src/SerializationAndDeserialization/Serialization.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Student std = new Student("Amit",101,"MMMUT");
        oos.writeObject(std);

        // DeSerialization
        FileInputStream fis = new FileInputStream("E:/Coding/FJWP/ClassCodes/src/SerializationAndDeserialization/Serialization.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student std1 = (Student)ois.readObject();
        std1.display();
    }
}
