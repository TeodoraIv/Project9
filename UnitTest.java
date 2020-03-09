package fmi.informatics.hw9;

import fmi.informatics.extending.Student;
import fmi.informatics.functional.Rock;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class UnitTest {
    @Test
    public void unitTestTask1() {
        ArrayList<Student> students = new ArrayList<Student>();
        Stream.of(Student.StudentGenerator.make(),
                Student.StudentGenerator.make(),
                Student.StudentGenerator.make()
        )
                .filter(s -> s.getName().length() > 4)
                .sorted((s1, s2) -> s2.getName().compareTo(s1.getName()))
                .forEach(s -> students.add(s));

        Assert.assertEquals(students.get(0).getName().toString(),"Petyr");
    }

    @Test
    public void unitTestTask2() {
        ArrayList<String> animals = new ArrayList<String>();
        Stream.of("cat", "dog", "cow", "bird")
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList())
                .forEach(s -> animals.add(s));


        Assert.assertEquals(animals.get(0),"cat");
    }

    @Test
    public void unitTestTask3() {
        List<Student> studs = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            ((ArrayList) studs).add(Student.StudentGenerator.make());
        }
        String studNames = studs.stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .map(s -> s.getName())
                .reduce((s1, s2) -> {
                    if (s2 != null) return s1 + ", " + s2;
                    return s1;
                })
                .get();
        System.out.println(studNames);


        Assert.assertEquals(studNames,"Mariya, Ivan, Stoyan, Petya, Ivan");
    }
    @Test
    public void unitTestTask4() {

        IntStream.iterate(0, i -> i + 1)
                .skip(5)
                .limit(10)
                .forEach(i -> {
                    if (i % 2 == 0)
                        System.out.println(i);
                });
    }
    @Test
    public void unitTestTask5() {
        Rock onEarth = new Rock();
        onEarth.drop(onEarth.height());
        Rock onMars = new Rock();

        assertEquals(onEarth,onMars);

    }
}
