package ua.pp.msk.julia.my.interviewtask;

import java.util.HashMap;
import java.util.Map;


public class IsDictionary implements Dictionary {

    private final Map<String, Integer> map;
    private static Dictionary dictionary = null;

    private IsDictionary() {
        map = new HashMap<>();
    }

    public static Dictionary getDictionary() {
        if (dictionary == null) {
            synchronized (IsDictionary.class) {
                if (dictionary == null) {
                    dictionary = new IsDictionary();
                }
            }
        }
        return dictionary;
    }

    @Override
    public void store(String word) {
        map.compute(word.trim().toLowerCase(), (w, c) -> (c == null) ? 1 : c + 1);
    }

    @Override
    public int getOccurence(String word) {
        return map.containsKey(word.trim().toLowerCase()) ? map.get(word.trim().toLowerCase()) : 0;
    }

}
