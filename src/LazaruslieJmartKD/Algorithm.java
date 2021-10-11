package LazaruslieJmartKD;
import java.util.Iterator;


public class Algorithm {

    private Algorithm(){

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
            if(arrayVal.equals(value)) {
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
            if(val.equals(value)) {
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

    public static <T extends Comparable<? super T>>T min(T first, T second){
        if ((first.compareTo(second))>0) {
            return second;
        }
        else {
            return first;
        }
    }

}
