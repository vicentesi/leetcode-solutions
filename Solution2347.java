import java.util.HashMap;

class Solution2347 {

    public String bestHand(int[] ranks, char[] suits) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        boolean pair = false;
        boolean three = false;
        boolean flush = true;

        for (int i = 0; i < 5; i++) {
            if (map.containsKey(ranks[i])) {
                map.put(ranks[i], map.get(ranks[i]) + 1);

                if (map.get(ranks[i]) >= 3)
                    three = true;
                else if (map.get(ranks[i]) >= 2)
                    pair = true;
            } else {
                map.put(ranks[i], 1);
            }

            if (suits[i] != suits[0])
                flush = false;
        }

        System.out.println("MAP => " + map.toString());

        if (flush) return "Flush";
        if (three) return "Three of a Kind";
        if (pair) return "Pair";
        return "High Card";
    }

    public static void main(String[] args) {
        Solution2347 s = new Solution2347();

        int[] ranks = { 1, 2, 3, 3, 2 };
        char[] suits = { 'a', 'a', 'a', 'a', 'a' };

        String result = s.bestHand(ranks, suits);
        System.out.println(result);
    }
}
