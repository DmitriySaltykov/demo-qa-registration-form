
package hwjava;

public class HWJavaTest {


    public static void main(String[] args) {

        // установка значений переменных
        int a = 89;
        int b =32 ;

        //арифметика
        System.out.println("Арифметика:");
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println("a++   = " +  (++a));
        System.out.println("b--   = " +  (--b));

        //сравнение
        System.out.println("Сравнение:");
        System.out.println("a > b");
        System.out.println("a >= b");
        System.out.println("a < b");
        System.out.println("a <= b");


        if (a == 2) {
            System.out.println("true");
        } else if (a < 100) {
            System.out.println("yep");
        } else {
            System.out.println("No ");
        }

        System.out.println("Логические операции:");
        boolean isTrue = true;
        boolean isFalse = false;

        System.out.println("isTrue && isFalse : " + (isTrue && isFalse));
        System.out.println("isTrue || isFalse : " + (isTrue || isFalse));
        System.out.println("!isTrue : " + !isTrue);


        // переполнение при вычислениях
        System.out.println("Переполнение при вычислениях:");
        int overflow = Integer.MAX_VALUE;
        System.out.println("So many" + (overflow + 1));

        // вычисления комбинаций типов данных (int и double)
        System.out.println("вычисления комбинаций типов данных:");
        double c = 9.87;
        System.out.println("Сложение int и double: " + (a + c));
        System.out.println("Вычитание int и double: " + (a * c));
    }
}
