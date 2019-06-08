package PracticeTask;

import java.util.Arrays;

public class DateWorker {
    public int day;
    public String month;
    public int year;


    public final String MONTHS[];
    public final int DAYS_IN_MONTH[];

    public DateWorker(String date) {
        this.month="";
        this.MONTHS = new String[]{"січеня", "лютого", "березня", "квітня", "травня", "червня", "липня",
                "серпня", "вересня", "жовтня","листопада","грудня"};
        this.DAYS_IN_MONTH= new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        setDate(date);
    }

    public void setDate(String date){

        Character[] characters= new Character[date.length()];
        char arr[]=date.toCharArray();
        for (int i = 0; i < date.length(); i++) {
            characters[i]=arr[i];
        }

        Arrays.stream(characters).filter(n->n<(char)47 || n>(char)58).filter(n->!n.equals(' ')).forEach(n->month+=n);
        final String[] temp = {""};
        Arrays.stream(characters).skip(date.length()-4-month.length()).filter(n->n>(char)47 && n<(char)58).forEach(n-> temp[0] +=n);//skip - пропускає перші н елементів
        year=Integer.valueOf(temp[0]);
        temp[0]="";
        Arrays.stream(characters).limit(date.length()-4-month.length()).filter(n->n>(char)47 && n<(char)58).forEach(n-> temp[0] +=n);//limit - залишає перші н елементів
        day=Integer.valueOf(temp[0]);
        System.out.println(year + "  - " +month+" - "+day);
    }

    public int getDayNumber(){
        int dayNumber=0;
        DayInYear dayInYear = (arr,monthCount)-> {
            int sum=0;
            for (int i = 0; i < monthCount; i++) {
                sum+=DAYS_IN_MONTH[i];
            }
            sum+=day;
            return sum;
        };

        for (int i=0;i<12;i++) {
            if(month.equals(MONTHS[i])){
                dayNumber += dayInYear.getSum(DAYS_IN_MONTH,i);
                if(year%4==0){
                    day++;
                }
                return dayNumber-1;
            }
        }
        return dayNumber-1;
    }

    public int getFirstDayOfYear(){
        int KV = (year-1906)/4;
        int diff=0;
        diff+=(year-1906)-KV;
        if(year%4==1) diff+=KV*2+1;
        else diff+=KV*2;
        return diff%7;
    }

    public int getMonthNumber(){
        for (int i = 0; i <MONTHS.length; i++) {
            if(month.equals(MONTHS[i])){
                return i+1;
            }
        }
        return 0;
    }

    public String getDayOfWeek(){
        System.out.println("fist day: "+getFirstDayOfYear()+"\nDay number: "+getDayNumber());
        int res= (getDayNumber()+getFirstDayOfYear())%7;
        switch (res){
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5:
                return "Saturday";
            case 6:
                return "Sunday";
            default:
                return "Error";
        }
    }

    public static void getDaysWithoutStreamAPI(String date) {
        //Stream<Character> day = Stream.of(date.toCharArray()).filter(val->val>(char)47 && val<(char)58)
        String day = new String();
        String month = new String();
        String year = new String();
        //Stream<Character> dayS =Stream.of(date.toCharArray());
        for (int i = 0; i <date.length() ; i++) {
            char[] dateC = date.toCharArray();
            if(i<2 && dateC[i]>(char)47 && dateC[i]<(char)58){
                day+=dateC[i];
            }else if(dateC[i]>(char)47 && dateC[i]<(char)58){
                year+=dateC[i];
            }else {
                if(dateC[i]!=' ') {
                    month += dateC[i];
                }
            }
        }

        int dayI =Integer.parseInt(day);
        int yearI=Integer.parseInt(year);
        System.out.println(dayI+"/"+month+"/"+yearI);
    }
}
