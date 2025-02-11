package org.example.utils;

import java.util.List;
import java.util.ArrayList;

public class MergeSort<T extends Comparable<T>> implements SortStrategy<T> {

    // Метод сортировки
    @Override
    public void sortirovka(List<T> list) {
        if (list.size() < 2) {
            return; // Если размер списка меньше 2, он уже отсортирован
        }

        int size = list.size();
        int mid = size / 2;

        List<T> left = new ArrayList<>(list.subList(0, mid)); // Левый подсписок
        List<T> right = new ArrayList<>(list.subList(mid, size)); // Правый подсписок

        if (left.size() > 1) {
            sortirovka(left); // Рекурсивная сортировка для левой половины
        }
        if (right.size() > 1) {
            sortirovka(right); // Рекурсивная сортировка для правой половины
        }

        sliyanie(list, left, right); // Вызов метода слияния
    }

    // Переименованный метод слияния
    private void sliyanie(List<T> result, List<T> left, List<T> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                result.set(k++, left.get(i++)); // Элемент из левой половины
            } else {
                result.set(k++, right.get(j++)); // Элемент из правой половины
            }
        }

        while (i < left.size()) {
            result.set(k++, left.get(i++)); // Остальные элементы левой половины
        }

        while (j < right.size()) {
            result.set(k++, right.get(j++)); // Остальные элементы правой половины
        }
    }
}
