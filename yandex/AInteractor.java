package yandex;

import java.util.Scanner;
/*
* Лена руководит разработкой тестирующей системы, в которой реализованы интерактивные задачи.
* До заверщения очередной стадии проекта осталось написать модуль, определяющий итоговый вердикт системы для интерактивной задачи.
* Итоговый вердикт определяется из кода завершения задачи, вердикта интерактора и вердикта чекера по следующим правилам:

Вердикт чекера и вердикт интерактора — это целые числа от 0 до 7 включительно.
Код завершения задачи — это целое число от -128 до 127 включительно.
Если интерактор выдал вердикт 0, итоговый вердикт равен 3 в случае, если программа завершилась с ненулевым кодом, и вердикту чекера в противном случае.
Если интерактор выдал вердикт 1, итоговый вердикт равен вердикту чекера.
Если интерактор выдал вердикт 4, итоговый вердикт равен 3 в случае, если программа завершилась с ненулевым кодом, и 4 в противном случае.
Если интерактор выдал вердикт 6, итоговый вердикт равен 0.
Если интерактор выдал вердикт 7, итоговый вердикт равен 1.
В остальных случаях итоговый вердикт равен вердикту интерактора. Ваша задача — реализовать этот модуль.
Формат ввода
Входной файл состоит из трёх строк. В первой задано целое число r (−128≤r≤127) —
* код завершения задачи, во второй — целое число i (0≤i≤7) — вердикт интерактора, в третьей — целое число c (0≤c≤7) — вердикт чекера.
*  ##Формат вывода Выведите одно целое число от 0 до 7 включительно — итоговый вердикт системы.
* */
public class AInteractor {
    private final static int R = 0;
    private final static int I = 1;
    private final static int C = 2;
    private final int[] statuses = new int[3];

    private boolean checkR(int v) {
        return v != 0 && -128 <= v && v <= 127;
    }

    private int compute() {
        int res;
        switch (statuses[I]) {
            case 0:
                if (checkR(statuses[R])) {
                    res = 3;
                } else {
                    res = statuses[C];
                }
                break;
            case 1:
                res = statuses[C];
                break;
            case 4:
                if (checkR(statuses[R])) {
                    res = 3;
                } else {
                    res = 4;
                }
                break;
            case 6:
                res = 0;
                break;
            case 7:
                res = 1;
                break;
            default:
                res = statuses[I];
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        AInteractor i = new AInteractor();
        Scanner scanner = new Scanner(System.in);
        i.statuses[R] = scanner.nextInt();
        i.statuses[I] = scanner.nextInt();
        i.statuses[C] = scanner.nextInt();
        System.out.println(i.compute());
        scanner.close();
    }
}