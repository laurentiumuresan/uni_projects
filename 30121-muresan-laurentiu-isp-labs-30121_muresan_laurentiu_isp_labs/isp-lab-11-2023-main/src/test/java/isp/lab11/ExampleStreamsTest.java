package isp.lab11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Radu Miron
 */
public class ExampleStreamsTest {
    private static final List<ExampleStreams.Person> PERSONS = Arrays.asList(

            new ExampleStreams.Person("John", "Thomson", 25, true, 1200),
            new ExampleStreams.Person("Olivia", "Harris", 18, false, 0),
            new ExampleStreams.Person("Lucas", "Scott", 35, true, 1100),
            new ExampleStreams.Person("Benjamin", "Lee", 15, false, 0),
            new ExampleStreams.Person("Olivia", "Patel", 28, false, 0),
            new ExampleStreams.Person("Ava", "Lee", 14, false, 0)

    );
    ExampleStreams exampleStreams = new ExampleStreams();

    @Test
    public void testFindEmployedPersons() {
        List<ExampleStreams.Person> EMPLOYED = Arrays.asList(
                new ExampleStreams.Person("John", "Thomson", 25, true, 1200),
                new ExampleStreams.Person("Lucas", "Scott", 35, true, 1100));
        Assertions.assertTrue(EMPLOYED.toString().equals(exampleStreams.findEmployedPersons(PERSONS).toString()));
    }

    @Test
    public void testFindAllPersonsByLastName() {
        List<ExampleStreams.Person> LastName = Arrays.asList(
                new ExampleStreams.Person("Benjamin", "Lee", 15, false, 0),
                new ExampleStreams.Person("Ava", "Lee", 14, false, 0));
        Assertions.assertTrue(LastName.toString().equals(exampleStreams.findAllPersonsByLastName(PERSONS, "Lee").toString()));
    }

    @Test
    public void testFindTheFirstPersonByFirstName() {
        Assertions.assertTrue(exampleStreams.findFirstPersonByFirstName(PERSONS, "Olivia").toString().equals(new ExampleStreams.Person("Olivia", "Harris", 18, false, 0).toString()));
    }

    @Test
    public void testGetUniqueFirstNames() {
        Set<String> uniqueFirstName = Set.of("John", "Olivia", "Lucas", "Benjamin", "Ava");
        Assertions.assertTrue(uniqueFirstName.equals(exampleStreams.getUniqueFirstNames(PERSONS)));
    }

    @Test
    public void testCalculateAverageSalary() {
        Assertions.assertEquals(1150.0, exampleStreams.calculateAverageSalary(PERSONS));
    }

    @Test
    public void testGroupByEmploymentStatus() {
        List<ExampleStreams.Person> EMPLOYED = Arrays.asList(
                new ExampleStreams.Person("John", "Thomson", 25, true, 1200),
                new ExampleStreams.Person("Lucas", "Scott", 35, true, 1100));
        Assertions.assertTrue(EMPLOYED.toString().equals(exampleStreams.groupByEmploymentStatus(PERSONS).get(true).toString()));

        List<ExampleStreams.Person> UNEMPLOYED = Arrays.asList(
                new ExampleStreams.Person("Olivia", "Harris", 18, false, 0),
                new ExampleStreams.Person("Benjamin", "Lee", 15, false, 0),
                new ExampleStreams.Person("Olivia", "Patel", 28, false, 0),
                new ExampleStreams.Person("Ava", "Lee", 14, false, 0));
        Assertions.assertTrue(UNEMPLOYED.toString().equals(exampleStreams.groupByEmploymentStatus(PERSONS).get(false).toString()));
    }

    @Test
    public void testGroupByFirstName() {
        List<ExampleStreams.Person> OLIVIA = Arrays.asList(
                new ExampleStreams.Person("Olivia", "Harris", 18, false, 0),
                new ExampleStreams.Person("Olivia", "Patel", 28, false, 0));
        Assertions.assertTrue(OLIVIA.toString().equals(exampleStreams.groupByFirstName(PERSONS).get("Olivia").toString()));
        Assertions.assertEquals("["+PERSONS.get(0).toString()+"]",(exampleStreams.groupByFirstName(PERSONS).get("John").toString()));
        Assertions.assertEquals("["+PERSONS.get(2).toString()+"]",(exampleStreams.groupByFirstName(PERSONS).get("Lucas").toString()));
        Assertions.assertEquals("["+PERSONS.get(3).toString()+"]",(exampleStreams.groupByFirstName(PERSONS).get("Benjamin").toString()));
        Assertions.assertEquals("["+PERSONS.get(5).toString()+"]",(exampleStreams.groupByFirstName(PERSONS).get("Ava").toString()));

    }

    @Test
    public void testLists() {
        List<String> l1 = List.of("1", "2", "3");
        List<String> l2 = List.of("1", "2", "3");
        List<String> l3 = List.of("2", "3", "1");

        Assertions.assertEquals(l1, l2, "the lists are not equal");
        Assertions.assertNotSame(l1, l2, "the lists are the same");
        Assertions.assertNotEquals(l1, l3, "the lists are equal");
    }
}
