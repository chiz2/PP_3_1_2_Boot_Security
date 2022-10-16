package ru.kata.spring.boot_security.demo;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class ApplicationTests {
    public static void main(String... args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.iterator().forEachRemaining(System.out::println);
    }

    public void test() {

}
}
