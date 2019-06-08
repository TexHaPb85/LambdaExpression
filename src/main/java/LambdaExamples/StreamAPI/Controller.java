package LambdaExamples.StreamAPI;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Controller {
    static void sipleStreams(){
        Stream<String> srts = Arrays.stream(new String[]{"a","b","c"});
        srts.forEach(System.out::println);

        IntStream intStream = Arrays.stream(new int[]{1,2,3});

        LongStream longStream = LongStream.of(new long[]{24,54,3,});
    }

    static void sreamFilter(){
        Stream<String> stringStream = Stream.of("asdgs","12345", "123456879");
        stringStream.filter(n->n.length()>5).forEach(System.out::println);

        stringStream.limit(2).forEach(System.out::println);
        stringStream.skip(2).forEach(System.out::println);
    }

    static void sreamFilm(){
        Stream<Film> filmStream = Stream.of(new Film("2",100),new Film("2", 24));
        filmStream.mapToDouble(Film::getPrice).forEach(System.out::println);
    }

    public static void main(String[] args) {
        sreamFilm();
    }
}
