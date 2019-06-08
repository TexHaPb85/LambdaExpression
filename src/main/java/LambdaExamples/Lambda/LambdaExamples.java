package LambdaExamples.Lambda;

import java.util.function.*;

public class LambdaExamples {

    static void simpleLambda(){
        Operation<Integer> operation = (v1, v2)-> v1+v2;
        Operation<String> operationStr = (v1,v2)->v1+v2;
        Printer printer = string-> System.out.println(string);
        printer.consolePrint(String.valueOf(operation.getResult(1,2)));
        printer.consolePrint(operationStr.getResult("x","a"));
        //System.out.println(operation.getResult(1,2));
        //System.out.println(operationStr.getResult("x","a"));
    }

    static void blockLamda(){
        /**val - input parameter of function
         * if method(function) does not apply any parameters, writes empty brackets
         * Factorial factorial = () ->{algorithm};
         */
        Factorial factorial = val ->{
            int result =1;
            for (int i = 0; i <=val ; i++) {
                result*=i;
            }
            return result;
        };
    }

    static void functionalInterfaces(){
        Predicate<Integer> predicate = n-> n==0;
        System.out.println(predicate.test(0)); //method test of FI Predicate can check some conditions

        Consumer<String> consumer = str -> System.out.println(str); //
        consumer.accept("test");//method accept makes some actions with input object, and returns nothing

        Function<String,Integer> function = str -> Integer.valueOf(str); //Function<R,T>
        System.out.println((function.apply("22")+2)+"=24res"); // method accept of FI Function convert Type R to Type T

        Supplier<String> supplier = () ->{
            return "string";
        };
        System.out.println(supplier.get());//method get of FI supplier don`t accepts any objects, but returns objects of Type T

        UnaryOperator<Integer> operator = n-> Integer.valueOf((int) Math.sqrt(Double.valueOf(n)));
        System.out.println(operator.apply(16));//Unary operation executes for one number. For example square root.

        BinaryOperator<Double> pow = (v1,v2)->Math.pow(v1,v2);
        System.out.println(pow.apply(2.0,5.0));
    }

    static void links(){
//        Consumer<String> consumer = str -> System.out.println(str); //
//        consumer.accept("test");
        Consumer<String> consumer = System.out::println;
        consumer.accept("test");

    }
}
