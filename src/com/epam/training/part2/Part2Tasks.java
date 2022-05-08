package com.epam.training.part2;

public class Part2Tasks {
    private static final String MSG_ARRAY_NULL = "Array is null";

    //1. В массив A [N] занесены натуральные числа.
    // Найти сумму тех элементов, которые кратны данному К.
    public int task1GetSum(int[] array, int k) {
        if (array == null) {
            throw new IllegalArgumentException(MSG_ARRAY_NULL);
        }
        int res = 0;
        for (int a : array) {
            if (a % k == 0) {
                res += a;
            }
        }
        return res;
    }

    //2. Дана последовательность действительных чисел а1 ,а2 ,..., ап.
    // Заменить все ее члены, большие данного Z, этим
    //числом. Подсчитать количество замен.
    public int task2GetChanges(float[] array, float z, float fReplace) {
        if (array == null) {
            throw new IllegalArgumentException(MSG_ARRAY_NULL);
        }
        int changes = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > z) {
                array[i] = fReplace;
                changes++;
            }
        }
        return changes;
    }

    //3. Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
    //положительных и нулевых элементов.
    public void task3PrintArrayInfo(float[] array) {
        if (array == null) {
            throw new IllegalArgumentException(MSG_ARRAY_NULL);
        }
        int positiveQty = 0;
        int negativeQty = 0;
        int zeroQty = 0;
        for (float f : array) {
            if (f > 0) {
                positiveQty++;
            } else if (f == 0) {
                zeroQty++;
            } else {
                negativeQty++;
            }
        }
        System.out.println(String.format("Positive count:%d", positiveQty));
        System.out.println(String.format("Zero count:%d", zeroQty));
        System.out.println(String.format("Negative count:%d", negativeQty));
    }

    //4. Даны действительные числа а1 ,а2 ,..., аn .
    // Поменять местами наибольший и наименьший элементы
    public void task4(float[] array) {
        if (array == null) {
            throw new IllegalArgumentException(MSG_ARRAY_NULL);
        }
        int ixMin = 0;
        int ixMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[ixMax]) {
                ixMax = i;
            }
            if (array[i] < array[ixMin]) {
                ixMin = i;
            }
        }
        if (ixMax != ixMin) {
            float f = array[ixMin];
            array[ixMin] = array[ixMax];
            array[ixMax] = f;
        }
    }

    //5. Даны целые числа а1 ,а2 ,..., аn .
    // Вывести на печать только те числа, для которых аi > i
    public void task5Print(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException(MSG_ARRAY_NULL);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > i) {
                System.out.println(array[i]);
            }
        }
    }

    //6. Задана последовательность N вещественных чисел.
    // Вычислить сумму чисел, порядковые номера которых
    // являются простыми числами.
    public float task6GetSum(float[] array) {
        if (array == null) {
            throw new IllegalArgumentException(MSG_ARRAY_NULL);
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int q = (int) Math.sqrt(i);
            for (int j = 2; j <= q; j++) {
                if (i % j == 0) {
                    sum += array[i];
                }
            }
        }
        return sum;
    }

    //7. Даны действительные числа  a1, ..., an
    // Найти  max(a1+a2n , a2+a2n-1 ,... , an + an+1 )
    //Условие некорректно

    //8. Дана последовательность целых чисел a, ..., an
    //. Образовать новую последовательность, выбросив из
    //исходной те члены, которые равны
    //min(a1 , ... , an)
    public int[] task8GetArrayWithoutMin(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException(MSG_ARRAY_NULL);
        }
        int min = array[0];
        int qMin = 0;
        for (int f : array) {
            if (f == min) {
                qMin++;
            } else if (min > f) {
                qMin = 1;
                min = f;
            }
        }
        if (array.length - qMin == 0) {
            return new int[0];
        }
        int[] res = new int[array.length - qMin];
        int i = 0;
        for (int a : array) {
            if (a > min) {
                res[i] = a;
                i++;
            }
        }
        return res;
    }

    //9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
    //чисел несколько, то определить наименьшее из них.
    public int task9GetMin(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException(MSG_ARRAY_NULL);
        }
        int[] repts = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    repts[i]++;
                }
            }
        }
        int maxQty = 0;
        int maxIdx = -1;
        int countMax = 0;
        for (int i = 0; i < repts.length; i++) {
            if (repts[i] > maxQty) {
                maxQty = repts[i];
                countMax = 1;
                maxIdx = i;
            } else if (repts[i] == maxQty) {
                countMax++;
            }
        }
        if (countMax == 1) {
            return array[maxIdx];
        } else if (countMax == 0) {
            return -1;
        }
        int minItem = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (repts[i] == countMax) {
                if (minItem > array[i]) {
                    minItem = array[i];
                }
            }
        }
        return minItem;
    }

    //10. Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
    //элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
    public void task10CompressArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException(MSG_ARRAY_NULL);
        }
        //заполняем нулями
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 1) {
                array[i] = 0;
            }
        }
        //сдвигаем нулевые значения вправо
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((array[i] == 0) && (array[j] != 0)) {
                    array[i] = array[j];
                    array[j] = 0;
                }
            }
        }
    }

    //1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
    public void task2_1_print(int[][] array) {
        if (array == null) {
            throw new IllegalArgumentException(MSG_ARRAY_NULL);
        }
        int rowCount = array.length;
        if (rowCount == 0) return;
        int colCount = array[0].length;
        for (int i = 0; i < colCount; i++) {
            if (i % 2 == 1) {
                if (array[0][i] > array[rowCount][i]) {
                    System.out.println(String.format("Column #%d", i));
                    for (int j = 0; j < rowCount; j++) {
                        System.out.println(array[j][i]);
                    }
                    System.out.println("--------------------");
                }
            }
        }
    }

    //2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
    public void task2_2_print(int[][] array) {
        if (array == null) {
            throw new IllegalArgumentException(MSG_ARRAY_NULL);
        }
        if (array.length == 0) return;
        if (array.length != array[0].length) {
            throw new IllegalArgumentException("Matrix is not square");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][i]);
        }
    }

    //3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
    public void task2_3_print(int[][] array, int k, int p) {
        if (array == null) {
            throw new IllegalArgumentException(MSG_ARRAY_NULL);
        }
        if (k >= array.length) {
            throw new IllegalArgumentException("K exceed row count");
        }
        if (array.length == 0) {
            return;
        }
        if (p >= array[0].length) {
            throw new IllegalArgumentException("P exceed volumn count");
        }
        for (int i = 0; i < array[k].length; i++) {
            System.out.print(String.format("%d\t", array[k][i]));
        }
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][p]);
        }
    }

    //4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
    // (1, 2, 3, ..., n)
    // (n, n-1, n-2, ..., 1)
    // (1, 2, 3, ..., n)
    // (n, n-1, n-2, ..., 1)
    // ............
    //(n, n-1, n-2, ..., 1)
    public int[][] task2_4_getArray(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N should be above 0");
        }
        if (n % 2 == 1) {
            throw new IllegalArgumentException("N should be even");
        }
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    res[i][j] = j;
                } else {
                    res[i][j] = n - j;
                }
            }
        }
        return res;
    }

    //5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
    // (1, 1, 1, ...1, 1, 1)
    // (2, 2, 2, ...2, 2, 0)
    // (3, 3, 3, ...3, 0, 0)
    // ....................
    //(n-1, n-1, 0,..,0, 0)
    //(n,   0, ..,    0, 0)
    public int[][] task2_5_getArray(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N should be above 0");
        }
        if (n % 2 == 1) {
            throw new IllegalArgumentException("N should be even");
        }
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + i >= n) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = i + 1;
                }
            }
        }
        return res;
    }

    //6. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
    // (1, 1, 1, ...1, 1, 1)
    // (0, 1, 1, ...1, 1, 0)
    // (0, 0, 1, ...1, 0, 0)
    // ....................
    // (0, 1, 1, ...1, 1, 0)
    // (1, 1, 1, ...1, 1, 1)


    //n должно быть нечетным, условие некорректно:
    // для n = 3  -
    // (1, 1, 1)
    // (0, 1, 0)
    // (1, 1, 1)
    public int[][] task2_6_getArray(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N should be above 0");
        }

        int[][] res = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((j < k) || ((j > n / 2) && (n - k <= j))) {
                    System.out.print(0);
                    res[i][j] = 0;
                } else {
                    System.out.print(1);
                    res[i][j] = 1;
                }
                System.out.print("\t");
            }
            if (i < n / 2) {
                k++;
            } else {
                k--;
            }

        }
        return res;
    }

    //7 Сформировать квадратную матрицу порядка N по правилу:
    //A[I,J] = sin((I*I - J*J)/N)
    //и подсчитать количество положительных элементов в ней.
    public double[][] task2_7_getArray(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should not be below 0");
        }
        int qPositive = 0;
        double[][] array = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = Math.sin((float) (i * i - j * j) / n);
                if (array[i][j] > 0) {
                    qPositive++;
                }
                System.out.print(array[i][j]);
                System.out.print("\t");
            }
            System.out.println("");
        }
        System.out.println("-----------------------");
        System.out.println(String.format("Positive count = %d", qPositive));
        return array;
    }


//    8. В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
//    на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
//    пользователь с клавиатуры.
    

}
