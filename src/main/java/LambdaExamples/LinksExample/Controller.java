package LambdaExamples.LinksExample;

public class Controller {
    public static void main(String[] args) {
        Database database = User::new;
        User user =database.createUser("name","1234");
        LinkPow linkPow = User::pow;
        System.out.println(linkPow.pow(2,5));
    }
}
