package pl.agh.arc.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arek on 2016-02-27.
 */
public class IterableToListConverter {

    public static <T> List<T> convertToList(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        for (T item : iterable) {
            list.add(item);
        }
        return list;
    }
}
