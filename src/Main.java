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

}