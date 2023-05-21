package yandex;

import java.util.HashMap;
import java.util.Map;

public class BoringLecture {
    public static void main(String[] args) {
        String s = "hello";
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0, j = s.length() - 1; i < (s.length() - 1) / 2; i++, j--) {
            m.putIfAbsent(s.charAt(i), 0);
            m.putIfAbsent(s.charAt(j), 0);
            m.computeIfPresent(s.charAt(i), (k, v) -> v + 1);
            m.computeIfPresent(s.charAt(j), (k, v) -> v + 1);
        }
        StringBuilder sb = new StringBuilder();
        int mm = s.length() - 1;
//        while (mm > 0) {
//            m.putIfAbsent(s.charAt(0), 0);
//            m.computeIfPresent(s.charAt(0), (k, v) -> v + 1);
//            for (int j = 1; j < (s.length() - 1) - (mm - 1); j++) {
//                m.putIfAbsent(s.charAt(j), 0);
//                m.computeIfPresent(s.charAt(j), (k, v) -> v + 1);
//            }
//            mm--;
//        }
        mm = s.length() - 1;
//            m.putIfAbsent(s.charAt(s.length() - 1), s.length() - 1);
//            m.computeIfPresent(s.charAt(s.length() - 1), (k, v) -> v + 1);
//                m.putIfAbsent(s.charAt(j), 0);
//                m.computeIfPresent(s.charAt(j), (k, v) -> v + 1);
        int tmp = mm - 1;
        while (mm > 0) {
            sb.append(s.charAt(s.length() - 1));
//            int tmp = mm == s.length() - 1 ? mm - 1 : mm - 1;
//            System.out.println("mm -- " +  (mm == s.length() - 1) );
//            System.out.println("tmp == " + tmp);
            for (int i = tmp; i >= 1; i--) {
                sb.append(s.charAt(i));
            }
            tmp--;
            mm--;
            sb.append("\n");
        }
        System.out.println(sb);
        for (Map.Entry<Character, Integer> map : m.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }
/*
*
h: 5
* e: 8
l: 17
o: 5*/
}
