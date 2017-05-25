package test.automation.school.utils;

import java.util.List;

public class Helper {
    public static boolean isListSortedInAscendingOrder(List<Integer> list) {
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
        }
        return sorted;
    }

    public static boolean isListSortedInDescendingOrder(List<Integer> list) {
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i-1)) > 0) sorted = false;
        }
        return sorted;
    }
}
