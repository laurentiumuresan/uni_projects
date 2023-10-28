package isp.lab11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Exercises {
    public int findLongestStringLength(List<String> list) {
        return list.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public int sumOfEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(integer -> integer.equals(integer / 2 * 2))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<String> toUppercase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public Map<Character, List<String>> groupByFirstLetter(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));

    }

    public long numberOfOccurrences(File file, String word) throws IOException {
        List<String> linees = Files.readAllLines(file.toPath());
        return linees.stream()
                .filter(s -> s.equals(word))
                .count();

    }

    public List<Product> sortProducts(List<Product> list) {
        return list.stream()
                .filter(p -> p.getCategory().equals("Electronics"))
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }

    public double calculateTotalRevenue(List<Order> completedOrders){
        return completedOrders.stream()
                .filter(order->order.getStatus().equals("complete"))
                .mapToDouble(Order::getTotal)
                .reduce(Double::sum)
                .orElse(0);
                //.sum();
    }

    public static void main(String[] args) throws IOException {
        Exercises exercises = new Exercises();
        List<Product> products = Arrays.asList(
                new Product("A", "Electronics", 54),
                new Product("B", "Electronics", 25),
                new Product("C", "Electronics", 223),
                new Product("D", "Home", 421),
                new Product("E", "Home", 232)
        );
        List<Order> orders = Arrays.asList(
                new Order("21",13.23,"incomplete"),
                new Order("32",324.34,"complete"),
                new Order("43",143,"incomplete"),
                new Order("76",65,"complete"),
                new Order("56",23.43,"complete")
        );
        System.out.println(exercises.findLongestStringLength(List.of(new String[]{"2e3", "23dqw", "weecew"})));
        System.out.println(exercises.toUppercase(List.of(new String[]{"2e3", "23dqw", "weecew"})));
        System.out.println(exercises.groupByFirstLetter(List.of(new String[]{"ae3", "a23dqw", "bweecew"})));
        System.out.println(exercises.sumOfEvenNumbers(List.of(new Integer[]{1, 4, 5, 3, 2,})));
        Files.write(Paths.get("Exercise7.txt"), List.of((new String[]{"2e3", "2e3", "2e3", "23dqw", "weecew"})));
        System.out.println(exercises.numberOfOccurrences(new File("Exercise7.txt"), "2e3"));
        System.out.println(exercises.sortProducts(products));
        System.out.println(exercises.calculateTotalRevenue(orders));

    }
}
