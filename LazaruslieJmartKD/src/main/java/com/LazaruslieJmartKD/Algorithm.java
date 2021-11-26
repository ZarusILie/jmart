package com.LazaruslieJmartKD;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Algorithm {

    private Algorithm(){

    }

    public static <T> List<T> collect(T[] array, T value) {
        List<T> list = new ArrayList<T>();
        for (T val : array) {
            if (val.equals(value)) {
                list.add(val);
            }
        }
        return list;
    }

    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        List<T> list = new ArrayList<T>();
        for (T val : iterable) {
            if (val.equals(value)) {
                list.add(val);
            }
        }
        return list;
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        List<T> list = new ArrayList<T>();
        while (iterator.hasNext()) {
            T val = iterator.next();
            if (val.equals(value)) {
                list.add(val);
            }
        }
        return list;
    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T val : array) {
            if (pred.predicate(val)) {
                list.add(val);
            }
        }
        return list;
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T val : iterable) {
            if (pred.predicate(val)) {
                list.add(val);
            }
        }
        return list;
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        while (iterator.hasNext()) {
            T val = iterator.next();
            if (pred.predicate(val)) {
                list.add(val);
            }
        }
        return list;
    }

    public static <T> int count(T[] array, T value) {
        int counter = 0;
        for (T arrayVal : array) {
            if (arrayVal.equals(value)) {
                counter++;
            }
        }
        return counter;
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        int counter = 0;
        for (T val : iterable) {
            if (val.equals(value)) {
                counter++;
            }
        }
        return counter;
    }

    public static <T> int count(Iterator<T> iterator, T value) {
        int counter = 0;
        while (iterator.hasNext()) {
            if (iterator.next().equals(value)) {
                counter++;
            }
        }
        return counter;
    }
    public static <T> int count(T[] array, Predicate<T> pred) {
        int counter = 0;
        for (T arrayVal : array) {
            if (pred.predicate(arrayVal)) {
                counter++;
            }
        }
        return counter;
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        int counter = 0;
        for (T val : iterable) {
            if (pred.predicate(val)) {
                counter++;
            }
        }
        return counter;
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int counter = 0;
        while (iterator.hasNext()) {
            if (pred.predicate(iterator.next())) {
                counter++;
            }
        }
        return counter;
    }

    public static <T> boolean exists(T[] array, T value) {
        for (T arrayVal : array) {
            if (arrayVal.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        for (T val : iterable) {
            if (val.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        while (iterator.hasNext()) {
            if (iterator.next().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        for (T arrayVal : array) {
            if (pred.predicate(arrayVal)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        for (T val : iterable) {
            if (pred.predicate(val)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            if (pred.predicate(iterator.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> T find(T[] array, T value) {
        for (T arrayVal : array) {
            if (arrayVal.equals(value)) {
                return arrayVal;
            }
        }
        return null;
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        for (T val : iterable) {
            if (val.equals(value)) {
                return val;
            }
        }
        return null;
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        while (iterator.hasNext()) {
            if (iterator.next().equals(value)) {
                return value;
            }
        }
        return null;
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        for (T arrayVal : array){
            if (pred.predicate(arrayVal)){
                return arrayVal;
            }
        }
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        for (T val : iterable) {
            if (pred.predicate(val)) {
                return val;
            }
        }
        return null;
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T value = iterator.next();
            if (pred.predicate(value)) {
                return value;
            }
        }
        return null;
    }

    public static <T extends Comparable<? super T>>T max(T first, T second){
        if ((first.compareTo(second))>0) {
            return first;
        }
        else {
            return second;
        }
    }

    public static <T extends Comparable<? super T>>T max(T[] array) {
        T maksimum = null;
        for (T val : array) {
            if (val.compareTo(maksimum) > 0) {
                maksimum = val;
            }
            else {
                maksimum = maksimum;
            }
        }
        return maksimum;
    }

    public static <T extends Comparable<? super T>>T max(Iterable<T> iterable) {
        T maximum = iterable.iterator().next();
        for (T val : iterable) {
            if (val.compareTo(maximum) > 0) {
                maximum = val;
            }
        }
        return maximum;
    }

    public static <T extends Comparable<? super T>>T max(Iterator<T> iterator) {
        T maksimum = iterator.next();
        while (iterator.hasNext()) {
            T val = iterator.next();
            if (val.compareTo(maksimum) > 0) {
                maksimum = val;
            }
        }
        return maksimum;
    }

    public static <T extends Comparable<? super T>>T max(T first, T second, Comparator<? super T> comparator) {
        if (comparator.compare(first, second) > 0) {
            return first;
        }
        else {
            return second;
        }
    }

    public static <T extends Comparable<? super T>>T max(T[] array, Comparator<? super T> comparator) {
        T maximum = null;
        for (T val : array) {
            if (comparator.compare(val, maximum) > 0) {
                maximum = val;
            }
        }
        return maximum;
    }

    public static <T extends Comparable<? super T>>T max(Iterable<T> iterable, Comparator<? super T> comparator) {
        T maximum = iterable.iterator().next();
        for (T val : iterable) {
            if (comparator.compare(val, maximum) > 0) {
                maximum = val;
            }
        }
        return maximum;
    }

    public static <T extends Comparable<? super T>>T max(Iterator<T> iterator, Comparator<? super T> comparator) {
        T maximum = iterator.next();
        while (iterator.hasNext()) {
            T val = iterator.next();
            if (comparator.compare(val, maximum) > 0) {
                maximum = val;
            }
        }
        return maximum;
    }


    public static <T extends Comparable<? super T>>T min(T first, T second){
        if ((first.compareTo(second)) > 0) {
            return second;
        }
        else {
            return first;
        }
    }

    public static <T extends Comparable<? super T>>T min(T[] array) {
        T minimum = null;
        for (T val : array) {
            if (val.compareTo(minimum) > 0) {
                minimum = val;
            }
            else {
                minimum = minimum;
            }
        }
        return minimum;
    }

    public static <T extends Comparable<? super T>>T min(Iterable<T> iterable) {
        T minimum = iterable.iterator().next();
        for (T val : iterable) {
            if (val.compareTo(minimum) < 0) {
                minimum = val;
            }
        }
        return minimum;
    }

    public static <T extends Comparable<? super T>>T min(Iterator<T> iterator) {
        T minimum = iterator.next();
        while (iterator.hasNext()) {
            T val = iterator.next();
            if (val.compareTo(minimum) < 0) {
                minimum = val;
            }
        }
        return minimum;
    }

    public static <T extends Comparable<? super T>>T min(T first, T second, Comparator<? super T> comparator) {
        if (comparator.compare(first, second) < 0) {
            return first;
        }
        else {
            return second;
        }
    }

    public static <T extends Comparable<? super T>>T min(T[] array, Comparator<? super T> comparator) {
        T minimum = null;
        for (T val : array) {
            if (comparator.compare(val, minimum) < 0) {
                minimum = val;
            }
        }
        return minimum;
    }

    public static <T extends Comparable<? super T>>T min(Iterable<T> iterable, Comparator<? super T> comparator) {
        T minimum = iterable.iterator().next();
        for (T val : iterable) {
            if (comparator.compare(val, minimum) < 0) {
                minimum = val;
            }
        }
        return minimum;
    }

    public static <T extends Comparable<? super T>>T min(Iterator<T> iterator, Comparator<? super T> comparator) {
        T minimum = iterator.next();
        while (iterator.hasNext()) {
            T val = iterator.next();
            if (comparator.compare(val, minimum) < 0) {
                minimum = val;
            }
        }
        return minimum;
    }

    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred) {
        // Converting array to List
        List<T> newList = new ArrayList<>();
        for(T val : array){
            newList.add(val);
        }
        try{
            List<T> filteredList = newList.stream().filter(pred::predicate).collect(Collectors.toList());
            int index = (page * pageSize) + pageSize;
            if(index > filteredList.size()){
                index = filteredList.size();
            }
            return filteredList.subList((page * pageSize), index);
        }catch (Exception t){
            return newList.subList(0 ,0);
        }
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
        //Converting array to List
        List<T> newList = new ArrayList<>();
        for(T val : iterable){
            newList.add(val);
        }
        try{
            List<T> filteredList = newList.stream().filter(pred::predicate).collect(Collectors.toList());
            int index = (page * pageSize) + pageSize;
            if(index > filteredList.size()){
                index = filteredList.size();
            }
            return filteredList.subList((page * pageSize), index);
        }catch (Exception y){
            return newList.subList(0 ,0);
        }
    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        //Converting array to List
        List<T> newList = new ArrayList<>();
        while (iterator.hasNext()) {
            newList.add(iterator.next());
        }
        try {
            List<T> filteredList = newList.stream().filter(pred::predicate).collect(Collectors.toList());
            int index = (page * pageSize) + pageSize;
            if (index > filteredList.size()) {
                index = filteredList.size();
            }
            return filteredList.subList((page * pageSize), index);
        } catch (Exception t) {
            return newList.subList(0, 0);
        }
    }

}
