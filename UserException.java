package exceptions;

import java.util.Scanner;
import static java.lang.Character.isLowerCase;


public class UserException {
    public static void main(String[] args) throws NotEvenException, FromOneToTen, Person.NotCapitalException, IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
      //  System.out.println("Enter an even number");
      //  int a = scanner.nextInt();
      //  validateEven(a);
      //  System.out.println("Enter a number from one to ten");
       // int b = scanner.nextInt();
       // validateFromOneToTen(b);
       // Person person = new Person("Alexey");
        System.out.println("Enter the month");
        int c = scanner.nextInt();
        yearMonth(c);

    }

    public static void validateEven(int number) throws NotEvenException {
        if (number % 2 != 0) {
            throw new NotEvenException("The number is not even");
        }
    }

    public static void validateFromOneToTen(int number) throws FromOneToTen {
        if (number < 1 && number > 10) {
            throw new FromOneToTen("not");
        }
    }
    /*
Реализовать метод возвращающий время года (зима|весна|лето|осень) по номеру месяца.
Месяца номеруются с 1 до 12. Январь - 1, Декабрь - 12.
В случае если в аргументе monthNumber будет недопустимое число,
метод должен кидать исключение IllegalArgumentException с сообщение вида
"monthNumber=-5 is invalid, the number of a month should be in a range of 1..12"
 */
    public static void yearMonth(int monthNumber) throws IllegalArgumentException{
        if (monthNumber == 1)
            System.out.println("yanvar");
        if (monthNumber < 1 || monthNumber > 12){
            throw new IllegalArgumentException(String.format(
                    "monthNumber=%d is invalid, the number of a month should be in a range of 1..12", monthNumber));
        }
    }
}
class IllegalArgumentException extends Exception {
    public IllegalArgumentException(String s) {
        super(s);
    }
}

class FromOneToTen extends Exception {
    public FromOneToTen(String s) {
        super(s);
    }
}

class NotEvenException extends Exception {
    public NotEvenException(String s) {
        super(s);
    }

}
class Person{
    private String name = "";
    Person(String name) throws NotCapitalException {
        this.name = name;
        validateName(name);
    }
    private void validateName(String name) throws NotCapitalException {
        if (isLowerCase(name.charAt(0))){
            throw new NotCapitalException("The first later of name " +name+ " must be capital");
        }
    }
    class NotCapitalException extends Exception{
        public NotCapitalException(String s){
            super(s);
        }
    }
}
