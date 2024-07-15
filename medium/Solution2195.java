import java.util.Arrays;

class Solution2195 {
    public long minimalKSum(int[] nums, int k) {
        long sum = 0;
        long prev = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (prev == nums[i])
                continue;

            while (k > 0) {
                if (nums[i] > prev && nums[i] - prev > 1) {
                    prev++;
                    sum += prev;
                    k--;
                } else if (i == nums.length - 1) {
                    sum += nums[i] + k;
                    k--;
                } else {
                    prev = nums[i];
                    break;
                }
            }

            if (k == 0)
                break;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution2195 s = new Solution2195();

        // int[] nums = { 1, 4, 25, 10, 25 };
        // int[] nums = { 5, 6 };
        int[] nums = { 6049679, 5303022, 9148745, 9067786, 4245986, 9346756, 8081232, 9336753, 9040954, 3074621,
                5273437, 3093620, 3975136, 3897863, 7955717, 6901772, 2138559, 2439378, 3858719, 4204884, 4573641,
                6550663, 6177508, 8031749, 2483491, 6645263, 6438637, 9261840, 4756750, 8576172, 1595840, 5184720,
                3910301, 4458357, 5557268, 654405, 9664478, 7431308, 64940, 9367507, 2489481, 1737124, 6691115, 4918022,
                8110526, 1482439, 6552012, 1072045, 1848540, 7916844, 6080007, 32144, 3517302, 9007326, 2540045,
                5379620, 1630573, 2250078, 680997, 5436990, 9270538, 4178598, 8268839, 5213087, 5367812, 5375592,
                5703639, 8951088, 696856, 2348182, 9559168, 9309320, 7048165, 6198843, 5168265, 175113, 2362709,
                4711182, 2402182, 4299096, 1530586, 760944, 4603711, 6580522, 6755622, 1994123, 2392559, 7636162,
                6705789, 6164832, 6083581, 2462207, 9923829, 7765873, 9728595, 7279731, 2178144, 967971, 3837661,
                9433952, 4696115, 2789730, 6019670, 4084835, 3343843, 691177, 4494803, 7441349, 9167310, 4635683,
                2839745, 9854787, 4497255, 4424579, 9627332, 2837150, 5739199, 2112566, 6300064, 8931599, 2837070,
                8623320, 85231, 4311202, 8110147, 764768, 224793, 1355001, 8660122, 3367430, 941086, 7488199, 6831004,
                1106508, 7917040, 4664820, 2377737, 631516, 7960689, 7698376, 9840885, 2400669, 4040709, 1074348,
                5701274, 8471371, 9978291, 6177429, 9714836, 4255441, 2951356, 8738416, 8002047, 7967256, 6849323,
                1658429, 9702325, 4514464, 7440820, 2706167, 3715922, 1589367, 6446979, 8169660, 6711357, 212889,
                617399, 5621601, 4312507, 1448432, 5879449, 1346740, 2314077, 1201877, 8469739, 3079405, 6330892,
                6408323, 915822, 5829015, 3188748, 3485561, 106153, 220442, 9152630, 9312652, 4672415, 3892683, 8695453,
                1066544, 6607582, 8049718, 1266539, 3134295, 4653998, 2268875, 2816238, 4038718, 4346629, 2449717,
                6706272, 3625779, 9125331, 4612548, 7475954, 8574795, 5909997, 6325319, 8069322, 9652017, 8368320,
                2588491, 1006288, 4319776, 3681652, 2819038, 9666197, 5390244, 5458151, 2785672, 2915528, 8948326,
                8893261, 6392391, 8196167, 1058124, 1626605, 7258563, 374151, 5777211, 380730, 9969350, 5315655,
                4642701, 4899243, 1731279, 203788, 4421594, 1935889, 8721056, 2084652, 4929908, 5187532, 5208601,
                9442367, 1849486, 5734686, 3331039, 6416191, 1816769, 9632174, 9626084, 71286, 3205083, 561134, 7794683,
                2731268, 8928020, 9304419, 7764733, 4647798, 6594484, 8584947, 257228, 5019204, 9311090, 8136790,
                4019288, 3006264, 5283556, 8619851, 4281242, 7969215, 109257, 5462637, 7756523, 5603826, 4120725,
                9089420, 4445444, 6794344, 9725853, 9149752, 4561382, 1259265, 7436698, 6433919, 5301845, 9438408,
                3214149, 7237446, 6572718, 3565320, 7543258, 7631630, 5655358, 5537327, 8210225, 6227858, 1394458,
                3195632, 9167587, 4760380, 5898992, 6264108, 2340078, 376819, 923683, 8222564, 7771697, 7696185,
                9641900, 1902932, 300827, 7716986, 572592, 6751168, 7967621, 9106576, 8510722, 8448029, 1315830,
                6029898, 2906819, 3871634, 697475, 1851757, 3720202, 9175178, 8073455, 6072240, 7593683, 2667517,
                9994804, 683091, 2837774, 519070, 8407325, 4346607, 1602101, 5447056, 5238698, 1112203, 1208563,
                7242375, 7390534, 2348333, 9840761, 8585788, 5069362, 4930798, 8450883, 3521367 };

        // PROFILING

        // Get the runtime instance
        Runtime runtime = Runtime.getRuntime();

        // Run the garbage collector to get a more accurate measurement of memory usage
        runtime.gc();

        // Record the start time and memory usage
        long startTime = System.nanoTime();
        long startMemory = runtime.totalMemory() - runtime.freeMemory();

        System.out.println(s.minimalKSum(nums, 7942263));
        // Your code here

        // Record the end time and memory usage
        long endTime = System.nanoTime();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        // Calculate the duration and memory usage
        long duration = endTime - startTime;
        double durationInMilliseconds = (double) duration / 1_000_000.0;
        long memoryUsed = endMemory - startMemory;

        // Print the results
        System.out.println("Execution time: " + durationInMilliseconds + " milliseconds");
        System.out.println("Memory used: " + memoryUsed + " bytes");
    }
}

/*
 * 2195. Append K Integers With Minimal Sum
 * 
 * You are given an integer array nums and an integer k. Append k unique
 * positive integers that do not appear in nums to nums such that the resulting
 * total sum is minimum.
 * 
 * Return the sum of the k integers appended to nums.
 * 
 * Example 1:
 * 
 * Input: nums = [1,4,25,10,25], k = 2
 * Output: 5
 * Explanation: The two unique positive integers that do not appear in nums
 * which we append are 2 and 3.
 * The resulting sum of nums is 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70, which is the
 * minimum.
 * The sum of the two integers appended is 2 + 3 = 5, so we return 5.
 * Example 2:
 * 
 * Input: nums = [5,6], k = 6
 * Output: 25
 * Explanation: The six unique positive integers that do not appear in nums
 * which we append are 1, 2, 3, 4, 7, and 8.
 * The resulting sum of nums is 5 + 6 + 1 + 2 + 3 + 4 + 7 + 8 = 36, which is the
 * minimum.
 * The sum of the six integers appended is 1 + 2 + 3 + 4 + 7 + 8 = 25, so we
 * return 25.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 108
 * 
 */