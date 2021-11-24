package exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BuildInException {
    public static void main(String[] args) {
        // processInputException();
        //  processIoException();
        // processDivideByZero();
       // processIndexOutOfBounds();
     //   processClassNotFound();
     //   processNullPointer();
    }

    public static void processInputException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int a = 0;
        try {
            a = scanner.nextInt();
            System.out.println("a = " + a);
        } catch (InputMismatchException e) {
            // e.printStackTrace();
            System.err.println("Не правильный ввод числа");
        }
    }

    public static void processIoException() {
        try {
            InputStream input = new FileInputStream("C:\\Users\\гк\\IdeaProjects\\Ladik\\src\\exceptions\\test.txt");
            System.out.println("File opened");
        } catch (IOException e) {
            System.err.println("File not opened");
        }
    }

    public static void processDivideByZero() {
        int a = 1, b;
        try {
            b = a / 0;
        } catch (ArithmeticException e) {
            System.err.println("Деление на ноль");
        }
    }

    public static void processIndexOutOfBounds() {
        int[] a = {1, 2, 3};
        try {
            int b = a[3];
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    public static void processClassNotFound() {
        try {
          //  Class clas = Class.pr
            Class.forName("src.exceptions.BuildInException");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void processNoSuchMethod(){
        TestClass testClass = new TestClass();
        Class <?> clas = testClass.getClass();
        try {
            Method method = clas.getDeclaredMethod("print");
            Field field = clas.getDeclaredField("1");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static void processNullPointer(){
        TestClass testClass = null;
        try {
            testClass.print();
        } catch (NullPointerException e) {
        }


    }

}
class TestClass{
    private int i = 0;
    public void print(){
    }
}
