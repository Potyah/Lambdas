package lambdas_endless_stream;

import java.util.Scanner;
import java.util.stream.IntStream;

public class EndlessStream {
    public static void main(String[] args) {
        // Создать бесконечный поток корней чисел. С консоли прочитать число – сколько элементов нужно вычислить, затем – распечатать эти элементы
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите колличество элементов, необходимое для вывода в консоль: ");
        int limit = scanner.nextInt();

        IntStream.iterate(0, x -> x + 1)
                .mapToDouble(Math::sqrt)
                .limit(limit)
                .forEach(System.out::println);
    }
}