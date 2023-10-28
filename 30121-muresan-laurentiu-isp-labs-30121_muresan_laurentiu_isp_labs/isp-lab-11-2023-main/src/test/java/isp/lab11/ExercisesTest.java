package isp.lab11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExercisesTest {
    Exercises exercises = new Exercises();

    @Test
    public void findLongestStringLengthTest(){
        Assertions.assertEquals(7,exercises.findLongestStringLength(List.of(new String[]{"2e3", "23dqw", "weecew","hsdrlfk"})));
    }

    @Test
    public void sumOfEvenNumbersTest(){
        Assertions.assertEquals(14,exercises.sumOfEvenNumbers(List.of(new Integer[]{1, 4, 5, 3, 2,8,0})));
    }

    @Test
    public void toUppercaseTest(){
        Assertions.assertEquals(List.of(new String[] {"DCA", "DEWE", "CS"}), exercises.toUppercase(List.of(new String[] {"dca", "Dewe", "cs"})));
    }

    @Test
    public void groupByFirstLetterTest(){
        Assertions.assertTrue(Map.of("a", List.of(new String[] {"ana", "andrei"}),
                                "b", List.of(new String[]{"bogdan"}),
                        "d", List.of(new String[]{"diana"})).toString().equals(
                ( exercises.groupByFirstLetter(List.of( new String[] {"ana", "bogdan", "diana", "andrei"})).toString())));
    }

    @Test
    public void numberOfOccurrencesTest() throws IOException {
        Files.write(Paths.get("Ex7Test.txt"), List.of((new String[]{"abc", "erd", "rdv", "abc", "acb", "abc"})));
        Assertions.assertEquals(3,exercises.numberOfOccurrences(new File("Ex7Test.txt"), "abc"));
    }

    @Test
    public void sortProductsTest(){
        List<Product> products = Arrays.asList(
                new Product("A", "Electronics", 54),
                new Product("B", "Electronics", 25),
                new Product("C", "Electronics", 223),
                new Product("D", "Home", 421),
                new Product("E", "Home", 232)
        );
        List<Product> sortedProducts = Arrays.asList(
                new Product("B", "Electronics", 25),
                new Product("A", "Electronics", 54),
                new Product("C", "Electronics", 223)
        );
        Assertions.assertEquals(sortedProducts,exercises.sortProducts(products));

    }

    @Test
    public void calculateTotalRevenue(){
        List<Order> orders = Arrays.asList(
                new Order("21",13.23,"incomplete"),
                new Order("32",324.34,"complete"),
                new Order("43",143,"incomplete"),
                new Order("76",65,"complete"),
                new Order("56",23.43,"complete")
        );
        Assertions.assertEquals(324.34+65+23.43,exercises.calculateTotalRevenue(orders));
    }
}
