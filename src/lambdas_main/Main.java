package lambdas_main;

import lambdas_persons.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Александр", 27),
                new Person("Олег", 5),
                new Person("Екатерина", 46),
                new Person("Светлана", 3),
                new Person("Георгий", 34),
                new Person("Вероника", 20),
                new Person("Ростислав", 17),
                new Person("Сергей", 42),
                new Person("Анна", 33),
                new Person("Светлана", 37),
                new Person("Олег", 43),
                new Person("Вероника", 1),
                new Person("Александр", 57),
                new Person("Вероника", 34)
        ));

        // Получить список уникальных имен, вывести список уникальных имен в формате: Имена: Иван, Сергей, Петр
        String uniqueNames = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(uniqueNames);

        // Получить список людей младше 18, посчитать для них средний возраст
        List<Person> personsYoungerEighteen = persons.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.toList());

        if (personsYoungerEighteen.isEmpty()) {
            System.out.println("В списке нет людей, младше 18 лет");
        } else {
            System.out.println("Список людей младше 18 лет: " + personsYoungerEighteen);
        }

        OptionalDouble personsYoungerEighteenAgeAverage = personsYoungerEighteen.stream()
                .mapToInt(Person::getAge)
                .average();

        if (personsYoungerEighteenAgeAverage.isEmpty()) {
            System.out.println("В коллекции нет людей, младше 18 лет, посчитать средний возраст невозможно");
        } else {
            System.out.println("Средний возраст людей, младше 18 лет: " + personsYoungerEighteenAgeAverage.getAsDouble());
        }

        // При помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст
        Map<String, Double> averageAgeByName = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        System.out.println("Средний возраст по имени: " + averageAgeByName);

        // Получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста
        List<Person> personsInInterval = persons.stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());

        if (personsInInterval.isEmpty()) {
            System.out.println("В списке нет людей, возрастом от 20 до 45 лет");
        } else {
            System.out.println("Список людей, возраст которых от 20 до 45 лет:" + personsInInterval);
        }
    }
}