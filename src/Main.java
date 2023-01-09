//import java.io.*;
//
//public class Main {
//    public static void triangle_func(int n){
//        int triangle_number = (n * (n + 1)) / 2;
//        System.out.println("-Результат решения через функцию-");
//        System.out.println("Ваше число: ");
//        System.out.println(triangle_number);
//    }
//
//    public static void triangle_cycle(int n){
//        int triangle_number_1 = 0;
//        for (int i = 0; i < n; i++){
//            triangle_number_1 += i + 1;
//        }
//        System.out.println("-Результат решения через цикл-");
//        System.out.println("Ваше число: ");
//        System.out.println(triangle_number_1);
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.out.println("Какое по счету треугольное число вы хотите увидеть?");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String n_str = reader.readLine();
//        while (!n_str.chars().allMatch( Character::isDigit )){
//            System.out.println("Введите цифру!");
//            n_str = reader.readLine();
//        }
//        int n = Integer.parseInt(n_str);
//
//        triangle_func(n);
//        triangle_cycle(n);
//    }
//}
import java.io.*;

interface TriangleNum {
    void showNum(int count);
}

class TriangleFunc implements TriangleNum {
    @Override
    public void showNum(int count) {
        System.out.println("Результат решения функцией: ");
        System.out.println((count * (count + 1)) / 2);
    }
}

class TriangleCycle implements TriangleNum {
    @Override
    public void showNum(int count) {
        int triangleNumber = 0;
        for (int i = 0; i < count; i++){
            triangleNumber += i + 1;
        }
        System.out.println("Результат решения циклом: ");
        System.out.println(triangleNumber);
    }
}
class TriangleNumCalc {
    TriangleNum num;

    public void setFormat(TriangleNum n) {
        num = n;
    }

    void calc(int n) {
        num.showNum(n);
    }
}

public class Main {
    public static int calcNum() throws IOException {
        System.out.println("Какое по счету треугольное число вы хотите увидеть?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n_str = reader.readLine();
        while (!n_str.chars().allMatch(Character::isDigit)) {
            System.out.println("Введите цифру!");
            n_str = reader.readLine();
        }
        return Integer.parseInt(n_str);
    }

    public static void main(String[] args) throws IOException {
        int n = calcNum();
        TriangleNumCalc result = new TriangleNumCalc();
        result.setFormat(new TriangleCycle());
        result.calc(n);
        result.setFormat(new TriangleFunc());
        result.calc(n);
    }
}
