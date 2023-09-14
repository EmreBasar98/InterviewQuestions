import java.util.*;

public class TravelingCollectors {
    public static void main(String[] args) {
        System.out.println(shortestRoute("asdfkjeghfalawefhaef"));
    }

    public static int shortestRoute(String route) {
        ArrayList<Character> namesList = new ArrayList<>(uniqueItems(route));
        StringBuilder str = new StringBuilder();
        namesList.forEach(c -> str.append(c.toString()));
        System.out.println(str);
        minWindow(route, str.toString());
        return 0;
    }


    //    public static int shortestRoute(String route) {
//        Set<Character> uniqueItems = uniqueItems(route);
//        int routeLen = route.length();
//        int numOfUniqueItems = uniqueItems.size();
//        int minLen = routeLen;
//        for (int i = 0; i < routeLen ; i++) {
//            for (int j = numOfUniqueItems; i + j < routeLen + 1  ; j++) {
//                String subRoute =  route.substring(i,i+j);
//                if (subRoute.length() < minLen && uniqueItems(subRoute).size() == numOfUniqueItems) minLen = subRoute.length();
//            }
//        }
//        return minLen;
//    }
//
    public static Set<Character> uniqueItems(String s) {
        Set<Character> uniqueItems = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueItems.add(c);
        }
        return uniqueItems;
    }

    public static int minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();

        int l = 0, r = 0;
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }
            while (l <= r && formed == required) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }

        return ans[0] == -1 ? 0 : s.substring(ans[1], ans[2] + 1).length();
    }
}
