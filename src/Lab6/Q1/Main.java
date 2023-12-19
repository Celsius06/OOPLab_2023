package Lab6.Q1;

// import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        // b.
            MyPair<String, Integer> pair1 = new MyPair<>("Anders", 13);
            System.out.println(pair1);

        // c.
            MyPair<String, Double> pair2 = new MyPair<>("Phoenix", 39.7);
            System.out.println(pair2);

        // d. No, since the two given types has the different variable types: double and integer
            // => This should not be allowed

        // e.
            MyPair<String,Integer>[] grades = new MyPair[5]; 
            // Warning message of "new MyPair[5]": Type safety: The expression of type MyPair[] needs unchecked conversion to conform to MyPair<String,Integer>[]

            grades[0] = new MyPair<>("Discrete Mathematics", 100);
            grades[1] = new MyPair<>("Linear Algebra", 70);
            grades[2] = new MyPair<>("Theoretical Models in Computing", 55);
            grades[3] = new MyPair<>("Digital Logic Design", 65);
            // grades[4] = new MyPair<>("Object-Oriented Programming", 60);

            // Dynamic array method
            // ArrayList<MyPair<String, Integer>> grades = new ArrayList<>();
            // grades.add(new MyPair<>("Discrete Mathematics", 100));
            // grades.add(new MyPair<>("Linear Algebra", 70));
            // grades.add(new MyPair<>("Theoretical Models in Computing", 55));
            // grades.add(new MyPair<>("Digital Logic Design", 65);
            // grades.add(new MyPair<>("Object-Oriented Programming", 60);

            for (int i = 0; i < grades.length; i++) {
                System.out.println(grades[i]);
            }              
            
            // System.out.println(grades[0]);
            // System.out.println(grades[1]);
            // System.out.println(grades[2]);
            // System.out.println(grades[3]);
            // System.out.println(grades[4]);

        // f.
            for (MyPair<String, Integer> grade : grades) {  // Foreach loop
                System.out.println(grade);
            }
            // => The values of those array elements that we didn't assign anything to will be NULL

        // g.
            MyPair<MyPair<Integer, Integer>, String> appointment = new MyPair<>(new MyPair<>(10, 30), "Dentist");
            System.out.println(appointment);
            // appointment is of type MyPair<MyPair<Integer, Integer>, String>. 
            // So, appointment.Fst would be of type MyPair<Integer, Integer>, 
            // and therefore, appointment.Fst.Snd would be of type Integer
            Integer value = appointment.Fst.Snd;
            System.out.println(value);

        // h.
            MyPair<String, Integer> pair3 = pair1;
            MyPair<String, Double> pair4 = pair2;
            MyPair <Integer, String> swapped1 = pair3.Swap();
            MyPair <Double, String> swapped2 = pair4.Swap();
            System.out.println(swapped1);   
            System.out.println(swapped2);         
    }
}


