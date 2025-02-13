package org.example.utils;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Sorter<T>{

    private final List<T> originalList;

    public Sorter(List<T> originalList) {
        this.originalList = originalList;
    }

    public void mergeSort(Comparator<? super T> comparator) {
        sorting(originalList, comparator);
    }

    private void sorting(List<T> original, Comparator<? super T> comparator) {
        if (original.size() <= 1) {
            return;
        }
        int center = original.size() / 2;
        List<T> left = new MyArrayList<>(center);
        List<T> right = new MyArrayList<>(original.size() - center);
        for (int i = 0; i < center; i++) {
            left.add(original.get(i));
        }
        for (int i = center; i < original.size(); i++) {
            right.add(original.get(i));
        }
//        IntStream.range(0, center).forEach(i -> left.add(original.get(i)));
//        IntStream.range(center, original.size()).forEach(i -> right.add(original.get(i)));

        sorting(left, comparator);
        sorting(right, comparator);
        merge(left, right, original, comparator);
    }

    private void merge(List<T> left, List<T> right, List<T> original, Comparator<? super T> comparator) {
        int leftIndex = 0;
        int rightIndex = 0;
        int originalIndex = 0;

        while(leftIndex < left.size() && rightIndex < right.size()) {

            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) <= 0 ) {
                original.set(originalIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                original.set(originalIndex, right.get(rightIndex));
                rightIndex++;
            }
            originalIndex++;
        }

        while(leftIndex < left.size()) {
            original.set(originalIndex, left.get(leftIndex));
            originalIndex++;
            leftIndex++;
        }
        while(rightIndex < right.size()) {
            original.set(originalIndex, right.get(rightIndex));
            originalIndex++;
            rightIndex++;
        }
    }


    public void additionalSort(Comparator<? super T> comparator, Predicate<T> predicate) {
        sortingHelper(originalList, comparator, predicate);
    }

    private void sortingHelper(List<T> original, Comparator<? super T> comparator, Predicate<T> predicate) {
        if (original.size() <= 1) {
            return;
        }

        //save the positions of odd elements
        List<Integer> oddIndices = new MyArrayList<>();
        List<T> evenElements = new MyArrayList<>();

        for (int i = 0; i < original.size(); i++) {
            //original.get(i).getValue() % 2 == 0
            if ( predicate.test(original.get(i)) ) evenElements.add(original.get(i));
            else oddIndices.add(i);
        }

        // sort only even elements
        sorting(evenElements, comparator);

        // insert even elements
        int evenIndex = 0;
        for (int i = 0; i < original.size(); i++) {
            if (!oddIndices.contains(i)) {
                original.set(i, evenElements.get(evenIndex++));
            }
        }
    }

}
