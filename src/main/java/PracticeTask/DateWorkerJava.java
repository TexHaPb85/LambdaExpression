package PracticeTask;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class DateWorkerJava {
    public static int month(String month){
        List<String> monthsArr = new ArrayList<>(Arrays.asList("січеня", "лютого", "березня", "квітня", "травня", "червня", "липня",
                "серпня", "вересня", "жовтня","листопада","грудня"));
        return monthsArr.indexOf(month);
    }

    public static String stringDay(int day){
        switch (day){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "Error";
        }
    }

    public static String dayOfWeek(String date){
        List<String> list=Arrays.stream(date
                .split(" "))
                .collect(Collectors.toList());
        Integer day = list.stream()
                .map(Integer::parseInt)
                .findFirst()
                .orElse(-1);
        Integer month = list.stream()
                .map(x->month(x))
                .findFirst()
                .orElse(-1);
        Integer year = list.stream()
                .filter(x->x.length()==4)
                .map(Integer::parseInt)
                .findFirst()
                .orElse(-1);

        Date dateObj = new GregorianCalendar(year,month,day).getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateObj);
        return stringDay(calendar.get(Calendar.DAY_OF_WEEK));
    }
}
