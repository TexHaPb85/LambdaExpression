package PracticeTask;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        /*DateWorker dateWorker = new DateWorker("10 березня 2020");
        System.out.println("Result: "+dateWorker.getDayOfWeek());*/
        String a[] = new String[22];
        String b[] = new String[22];
        //Arrays.stream(arr)+Arrays.stream(arr);
        Stream.concat(Arrays.stream(a), Arrays.stream(b)).toArray(String[]::new);

    }
}
