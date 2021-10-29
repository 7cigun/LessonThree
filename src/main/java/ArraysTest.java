import java.util.Arrays;
import java.util.Random;

public class ArraysTest {
    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";

        //Проверка метода первого задания
        System.out.println(ANSI_RED + "##########################");
        System.out.println("# Проверяем первый метод #");
        System.out.println("##########################" + ANSI_RESET);
        zeroAgainstOne();
        System.out.println("");
        System.out.println("");

        //Проверка метода второго задания
        System.out.println(ANSI_RED + "##########################");
        System.out.println("# Проверяем второй метод #");
        System.out.println("##########################" + ANSI_RESET);
        oneToHundred();
        System.out.println("");
        System.out.println("");

        //Проверка метода третьего задания
        System.out.println(ANSI_RED + "##########################");
        System.out.println("# Проверяем третий метод #");
        System.out.println("##########################" + ANSI_RESET);
        lessSixTwice();
        System.out.println("");
        System.out.println("");

        //Проверка метода четвертого задания
        System.out.println(ANSI_RED + "#############################");
        System.out.println("# Проверяем четвертый метод #");
        System.out.println("#############################" + ANSI_RESET);
        diagonalOne();
        System.out.println("");

        //Проверка метода пятого задания
        System.out.println(ANSI_RED + "#########################");
        System.out.println("# Проверяем пятый метод #");
        System.out.println("#########################" + ANSI_RESET);
        int[] filledArray = arrayFill(10, 5);
        System.out.println(Arrays.toString((filledArray)));
        System.out.println("");

        //Проверка метода шестого задания
        System.out.println(ANSI_RED + "##########################");
        System.out.println("# Проверяем шестой метод #");
        System.out.println("##########################" + ANSI_RESET);
        minMax();
        System.out.println("");

        //Проверка метода седьмого задания
        System.out.println(ANSI_RED + "###########################");
        System.out.println("# Проверяем седьмой метод #");
        System.out.println("###########################" + ANSI_RESET);
        int[] testEqual = {3, 5, 2, 4, 6};
        System.out.print("Передан массив: ");
        printIntArray(testEqual);
        System.out.println("");
        System.out.println(lefRightEqual(testEqual));
        int[] testNotEqual = {7, 6, 5, 3, 4, 10};
        System.out.print("Передан массив: ");
        printIntArray(testNotEqual);
        System.out.println("");
        System.out.println(lefRightEqual(testNotEqual));
        System.out.println("");

        //Проверка метода восьмого задания
        System.out.println(ANSI_RED + "###########################");
        System.out.println("# Проверяем восьмой метод #");
        System.out.println("###########################" + ANSI_RESET);
        int[] arrayToShift = {4, 5, 6, 7, 8, 9, 1};
        System.out.println("Передан массив:");
        printIntArray(arrayToShift);
        System.out.println("");
        shiftArray(arrayToShift, 2);
        printIntArray(arrayToShift);
        System.out.println("");
        System.out.println("");

        System.out.println("Передан массив:");
        printIntArray(arrayToShift);
        System.out.println("");
        shiftArray(arrayToShift, -2);
        printIntArray(arrayToShift);


    }


    // Метод для вывода массива
    public static void printIntArray(int[] arrayName) {
        System.out.print("[ ");
        for (int i = 0; i < arrayName.length; i++) {
            System.out.print(arrayName[i]);
            //Пытаемся выровнять вывод
            if (arrayName[i] < 10) {
                System.out.printf("   ");
            } else if (arrayName[i] < 100) {
                System.out.printf("  ");
            } else {
                System.out.printf(" ");
            }
            //Если массив большой, то организуем перенос строк
            if ((i + 1) % 20 == 0 && i + 1 != arrayName.length) {
                System.out.println("");
                System.out.printf("  ");
            }
        }
        System.out.printf("]");
    }

    // Метод первого задания (инверсия значений)
    private static void zeroAgainstOne() {
        int[] zeroOne = {1, 0, 0, 0, 1, 1, 0, 1};
        System.out.print("Исходный массив:        ");
        printIntArray(zeroOne);
        for (int i = 0; i < zeroOne.length; i++) {
            if (zeroOne[i] == 0) {
                zeroOne[i] = 1;
            } else {
                zeroOne[i] = 0;
            }
        }
        System.out.println("");
        System.out.print("Инвертированный массив: ");
        printIntArray(zeroOne);
    }

    //Метод второго задания. Инициализация м заполнение массива с 1 по 100.
    private static void oneToHundred() {
        int[] hundredArr = new int[200];
        for (int i = 0; i < hundredArr.length; i++) {
            hundredArr[i] = i + 1;
        }
        printIntArray(hundredArr);
    }

    //Метод третьего задания. Числа меньше 6 в массиве умножаются на 2.
    private static void lessSixTwice() {
        int[] lessSix = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Исходный массив:   ");
        printIntArray(lessSix);
        System.out.println("");
        for (int i = 0; i < lessSix.length; i++) {
            if (lessSix[i] < 6) {
                lessSix[i] *= 2;   //element = element * 2
            }
        }
        System.out.print("Измененный массив: ");
        printIntArray(lessSix);

    }

    //Метод четвертого задания. Заполнить диагонали массива единицами.
    private static void diagonalOne() {

        final int SIZE = 10;

        int[][] array = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j || j == (SIZE - 1 - i)) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    //Метод пятого задания. Заполнение массива.
    private static int[] arrayFill(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    //Метод шестого задания. Найти min и max в массиве.
    private static void minMax() {
        int[] array = new int[10];
        //Заполнение массива случайными числами
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        int min = array[0];
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.printf("Исходный массив: ");
        printIntArray(array);
        System.out.println("");
        System.out.println("Минимальное число в массиве: " + min);
        System.out.println("Максимальное число в массиве: " + max);
    }

    //Метод седьмого задания.
    private static boolean lefRightEqual(int[] array) {
        // Посчитаем сумму элементов массива.
        int arraySum = 0;
        int leftSum = 0;
        for (int i = 0; i < array.length; i++) {
            arraySum += array[i];
        }
        //Проверка на вероятность выполнения условия равности двух частей массива.
        if (arraySum % 2 != 0) {
            return false;
        }

        int rightSum = arraySum / 2;
        for (int i = 0; i < array.length; i++) {
            leftSum += array[i];
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    private static void shiftArray(int[] array, int size) {
        int timesToMove = size % array.length;

        if (timesToMove < 0) {
            for (int i = 0; i < Math.abs(timesToMove); i++) {
                int tmp = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = tmp;
            }

        } else {
            for (int i = 0; i < timesToMove; i++) {
                int tmp = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = tmp;
            }
        }
        System.out.println("Смещение на " + size);
    }
}
