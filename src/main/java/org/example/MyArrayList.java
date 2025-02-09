//package org.example;
//
//import java.lang.reflect.Array;
//import java.util.*;
//
//import jdk.internal.util.ArraysSupport;
//
//public class MyArrayList <E> extends AbstractList<E> implements List<E>{
//
//
//    private static final int DEFAULT_CAPACITY = 10;
//
//    private static final Object[] EMPTY_ELEMENTDATA = {};
//
//    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
//
//    transient Object[] elementData;
//
//    private int size;
//
//
//    public MyArrayList(int initialCapacity) {
//        if (initialCapacity > 0) {
//            this.elementData = new Object[initialCapacity];
//        } else if (initialCapacity == 0) {
//            this.elementData = EMPTY_ELEMENTDATA;
//        } else {
//            throw new IllegalArgumentException("Illegal Capacity: "+
//                    initialCapacity);
//        }
//    }
//
//    public MyArrayList() {
//        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
//    }
//
//
//
//    private Object[] grow(int minCapacity) {
//        int oldCapacity = elementData.length;
//        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
//            int newCapacity = ArraysSupport.newLength(oldCapacity,
//                    minCapacity - oldCapacity, /* minimum growth */
//                    oldCapacity >> 1           /* preferred growth */);
//            return elementData = Arrays.copyOf(elementData, newCapacity);
//        } else {
//            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
//        }
//    }
//
//    private Object[] grow() {
//        return grow(size + 1);
//    }
//
//    E elementData(int index) {
//        return (E) elementData[index];
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    @Override
//    public boolean contains(Object o) {
//        return indexOf(o) >= 0;
//    }
//
//    @Override
//    public E get(int index) {
//        Objects.checkIndex(index, size);
//        return elementData(index);
//    }
//
//    @Override
//    public E set(int index, E element) {
//        Objects.checkIndex(index, size);
//        E oldValue = elementData(index);
//        elementData[index] = element;
//        return oldValue;
//    }
//
//    @Override
//    public boolean add(E e) {
//        modCount++;
//        add(e, elementData, size);
//        return true;
//    }
//
//    private void add(E e, Object[] elementData, int s) {
//        if (s == elementData.length)
//            elementData = grow();
//        elementData[s] = e;
//        size = s + 1;
//    }
//
//    @Override
//    public void add(int index, E element) {
//        rangeCheckForAdd(index);
//        modCount++;
//        final int s;
//        Object[] elementData;
//        if ((s = size) == (elementData = this.elementData).length)
//            elementData = grow();
//        System.arraycopy(elementData, index,
//                elementData, index + 1,
//                s - index);
//        elementData[index] = element;
//        size = s + 1;
//    }
//
//    @Override
//    public E remove(int index) {
//        Objects.checkIndex(index, size);
//        final Object[] es = elementData;
//
//        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
//        fastRemove(es, index);
//
//        return oldValue;
//    }
//
//    private void fastRemove(Object[] es, int i) {
//        modCount++;
//        final int newSize;
//        if ((newSize = size - 1) > i)
//            System.arraycopy(es, i + 1, es, i, newSize - i);
//        es[size = newSize] = null;
//    }
//
//    @Override
//    public void clear() {
//        modCount++;
//        final Object[] es = elementData;
//        for (int to = size, i = size = 0; i < to; i++)
//            es[i] = null;
//    }
//
//    private void rangeCheckForAdd(int index) {
//        if (index > size || index < 0)
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//    }
//
//    private String outOfBoundsMsg(int index) {
//        return "Index: "+index+", Size: "+size;
//    }
//
//
//
//    @Override
//    public void sort(Comparator<? super E> c) {
//        final int expectedModCount = modCount;
//        sort((E[]) elementData, 0, size, c);
//        if (modCount != expectedModCount)
//            throw new ConcurrentModificationException();
//        modCount++;
//    }
//
//    public static <T> void sort(T[] original, int from, int to, Comparator<? super T> c) {
//        T[] aux = copyOfRange(original, from, to, (Class<? extends T[]>) original.getClass());
//        mergeSort(aux, original, from, to, -from, c);
//
//    }
//
//    public static <T,U> T[] copyOfRange(U[] original, int from, int to, Class<? extends T[]> newType) {
//        int newLength = to - from;
//        if (newLength < 0)
//            throw new IllegalArgumentException(from + " > " + to);
//        @SuppressWarnings("unchecked")
//        T[] copy = ((Object)newType == (Object)Object[].class)
//                ? (T[]) new Object[newLength]
//                : (T[]) Array.newInstance(newType.getComponentType(), newLength);
//        System.arraycopy(original, from, copy, 0,
//                Math.min(original.length - from, newLength));
//        return copy;
//    }
//
//    private static final int INSERTIONSORT_THRESHOLD = 7;
//
//    private static void mergeSort(Object[] src,
//                                  Object[] dest,
//                                  int low, int high, int off,
//                                  Comparator c) {
//        int length = high - low;
//
//        // Insertion sort on smallest arrays
//        if (length < INSERTIONSORT_THRESHOLD) {
//            for (int i=low; i<high; i++)
//                for (int j=i; j>low && c.compare(dest[j-1], dest[j])>0; j--)
//                    swap(dest, j, j-1);
//            return;
//        }
//
//        // Recursively sort halves of dest into src
//        int destLow  = low;
//        int destHigh = high;
//        low  += off;
//        high += off;
//        int mid = (low + high) >>> 1;
//        mergeSort(dest, src, low, mid, -off, c);
//        mergeSort(dest, src, mid, high, -off, c);
//
//        // If list is already sorted, just copy from src to dest.  This is an
//        // optimization that results in faster sorts for nearly ordered lists.
//        if (c.compare(src[mid-1], src[mid]) <= 0) {
//            System.arraycopy(src, low, dest, destLow, length);
//            return;
//        }
//
//        // Merge sorted halves (now in src) into dest
//        for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
//            if (q >= high || p < mid && c.compare(src[p], src[q]) <= 0)
//                dest[i] = src[p++];
//            else
//                dest[i] = src[q++];
//        }
//    }
//
//    private static void swap(Object[] x, int a, int b) {
//        Object t = x[a];
//        x[a] = x[b];
//        x[b] = t;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == this) {
//            return true;
//        }
//
//        if (!(o instanceof List)) {
//            return false;
//        }
//
//        final int expectedModCount = modCount;
//        boolean equal = (o.getClass() == MyArrayList.class)
//                ? equalsArrayList((MyArrayList<?>) o)
//                : equalsRange((List<?>) o, 0, size);
//
//        checkForComodification(expectedModCount);
//        return equal;
//    }
//
//    boolean equalsRange(List<?> other, int from, int to) {
//        final Object[] es = elementData;
//        if (to > es.length) {
//            throw new ConcurrentModificationException();
//        }
//        var oit = other.iterator();
//        for (; from < to; from++) {
//            if (!oit.hasNext() || !Objects.equals(es[from], oit.next())) {
//                return false;
//            }
//        }
//        return !oit.hasNext();
//    }
//
//    private boolean equalsArrayList(MyArrayList<?> other) {
//        final int otherModCount = other.modCount;
//        final int s = size;
//        boolean equal;
//        if (equal = (s == other.size)) {
//            final Object[] otherEs = other.elementData;
//            final Object[] es = elementData;
//            if (s > es.length || s > otherEs.length) {
//                throw new ConcurrentModificationException();
//            }
//            for (int i = 0; i < s; i++) {
//                if (!Objects.equals(es[i], otherEs[i])) {
//                    equal = false;
//                    break;
//                }
//            }
//        }
//        other.checkForComodification(otherModCount);
//        return equal;
//    }
//
//    private void checkForComodification(final int expectedModCount) {
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//    }
//
//    @Override
//    public int hashCode() {
//        int expectedModCount = modCount;
//        int hash = hashCodeRange(0, size);
//        checkForComodification(expectedModCount);
//        return hash;
//    }
//
//    int hashCodeRange(int from, int to) {
//        final Object[] es = elementData;
//        if (to > es.length) {
//            throw new ConcurrentModificationException();
//        }
//        int hashCode = 1;
//        for (int i = from; i < to; i++) {
//            Object e = es[i];
//            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
//        }
//        return hashCode;
//    }
//
//
//    @Override
//    public boolean addAll(Collection c) {
//        return false;
//    }
//
//    @Override
//    public boolean addAll(int index, Collection c) {
//        return false;
//    }
//
//    @Override
//    public Object[] toArray(Object[] a) {
//        return new Object[0];
//    }
//}
