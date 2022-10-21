import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        System.out.println(repeat("mice", 5));
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("stop", 1));

        System.out.println("Задание 2");
        int[] array1 = new int[] {10, 4, 1, 4, -10, -50, 32, 21};
        int[] array2 = new int[] {44, 32, 86, 19};
        System.out.println(differenceMaxMin(array1));
        System.out.println(differenceMaxMin(array2));

        System.out.println("Задание 3");
        int[] array3 = new int[] {1, 3};
        int[] array4 = new int[] {1, 2, 3, 4};
        int[] array5 = new int[] {1, 5, 6};
        int[] array6 = new int[] {1, 1, 1};
        int[] array7 = new int[] {9, 2, 2, 5};
        System.out.println(isAvgWhole(array3));
        System.out.println(isAvgWhole(array4));
        System.out.println(isAvgWhole(array5));
        System.out.println(isAvgWhole(array6));
        System.out.println(isAvgWhole(array7));

        System.out.println("Задание 4");
        int[] array8 = new int[] {1, 2, 3};
        int[] array9 = new int[] {1, -2, 3};
        int[] array10 = new int[] {3, 3, -2, 408, 3, 3};
        System.out.println(Arrays.toString(cumulativeSum(array8)));
        System.out.println(Arrays.toString(cumulativeSum(array9)));
        System.out.println(Arrays.toString(cumulativeSum(array10)));

        System.out.println("Задание 5");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));

        System.out.println("Задание 6");
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(12));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(0));

        System.out.println("Задание 7");
        System.out.println(isValid("59001"));
        System.out.println(isValid("590a1"));
        System.out.println(isValid("590  01"));
        System.out.println(isValid("5977001"));
        System.out.println(isValid("123456"));
        System.out.println(isValid(""));
        System.out.println(isValid("5 1"));

        System.out.println("Задание 8");
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("blush", "hurbis"));
        System.out.println(isStrangePair("", ""));
        System.out.println(isStrangePair("", "a"));

        System.out.println("Задание 9");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("automation", "sub-"));
        System.out.println(isSuffix("arachnophobia", "-x"));

        System.out.println("Задание 10");
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));
        System.out.println(boxSeq(6));
    }
    // повторение каждого символа в строке n раз
    public static String repeat(String word, int n){
        String result = "";
        for (int i = 0; i < word.length(); i++){
            for (int j = 1; j <= n; j++){
                result += word.charAt(i);
            }
        }
        return result;
    }
    // функция принимает массив и возвращает разницу между самым большим и самым маленьким числами
    public static int differenceMaxMin(int[] myArray){
        Arrays.sort(myArray);
        return myArray[myArray.length - 1] - myArray[0];
    }
/*
реализция функции без использования функции Arrays.sort() из класса Arrays
     public static int differenceMaxMin(int[] myArray){
        int max = myArray[0];
        int min = myArray[0];
        for (int i = 1; i < myArray.length; i++){
            max = Math.max(max, myArray[i]);
            min = Math.min(min, myArray[i]);
        }
        return myArray[myArray.length - 1] - myArray[0];
   }
*/

    // проверка, является ли среднее значение элементов массива целым числом или нет
    public static boolean isAvgWhole(int[] myArray){
        int sum = 0;
        int numberOfElements = myArray.length;
        for (int i = 0; i < myArray.length; i++){
            sum += myArray[i];
        }
        return sum%numberOfElements == 0;
    }
    // возвращаем массив, в котором каждое целое число является суммой самого себя + всеех предыдущих чисел в исходном массиве
    public static int[] cumulativeSum(int[] myArray){
        int[] newArray = myArray.clone(); // создаём новый массив - копию исходного
        int sum = 0;
        for (int i = 0; i < myArray.length; i++){
            newArray[i] += sum;
            sum += myArray[i];
        }
        return newArray;
    }
    // возвращаем число десятичных знаков, которое имеет число (заданное в виде строки)
    public static int getDecimalPlaces(String number){
        int index = number.indexOf('.');
        if (index == -1){
            return 0;
        } else {
            return number.length() - index - 1; // index - число символов до точки, 1 - сама точка
        }
    }
    // при заданном числе функция возвращает число Фибоначчи (0 1 1 2 3 5 8 13 21 ...)
    public static int fibonacci(int number){
        int n0 = 0;
        int n1 = 1;
        int temp; // temporary (временная/вспомогательная переменная)

        if (number == 0){
            return 0;
        }

        for (int i = 0; i < number; i++){
            temp = n1;
            n1 += n0;
            n0 = temp;
        }
        return n1;
    }
    // проверить, действителен ли почтовый индекс (длина < 5, используются только цифры, нет пробелов)
    public static boolean isValid(String myString){
            return myString.matches("[0-9]{1,5}"); // регулярное выражение (цифры от 0 до 9, кол-во символов от 1 до 5)
    }
    // первая буква 1й строки = последней букве 2й строки, первая буква 2й строки = последней букве 1й строки
    public static boolean isStrangePair(String s1, String s2){
        if (s1.isEmpty() || s2.isEmpty()){
            return s1.isEmpty() && s2.isEmpty();
        }
        return (s1.charAt(0) == s2.charAt(s2.length() - 1) && s2.charAt(0) == s1.charAt(s1.length() - 1));
    }
    // true, если начинается с префиксного аргумента. иначе false
    public static boolean isPrefix(String word, String prefix){
        if (prefix.charAt(prefix.length() - 1) != '-') {
            return false;
        } else {
            prefix = prefix.substring(0, prefix.length() - 1);
            return word.startsWith(prefix);
        }
    }
    // true, если заканчивается аргуметном суффикса. иначе false
    public static boolean isSuffix(String word, String suffix){
        if (suffix.charAt(0) != '-') {
            return false;
        } else {
            suffix = suffix.substring(1, suffix.length());
            return word.endsWith(suffix);
        }
    }
    // Принимаем число (шаг) и возвращаем количество полей на этом шаге последовательности (начинаем с 0 -> +3 -> -1)
    public static int boxSeq(int step){
        int result = 0; // на нечётном шаге прибавляем 3, на чётном вычитаем 1
        if (step % 2 == 0) {
            // если кол-во шагов чётное - мы step/2 раз прибавляем 3 и столько же раз вычитаем 1
            // step/2 * 3 - step/2 = step/2 * 2
            return step / 2 * 2;
        } else {
            // иначе мы (step + 1) / 2 раз прибавляем 3 и step / 2 раз вычитаем 1
            return ((step + 1) / 2) * 3 - step / 2;
        }

    }

}