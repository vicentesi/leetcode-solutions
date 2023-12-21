import java.util.Arrays;

class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int length = students.length; // == sandwiches.length

        for (int sand = 0; sand < length; sand++) {
            boolean eaten = false;

            for (int stud = 0; stud < length; stud++) {
                if (sandwiches[sand] == students[stud] && students[stud] != -1) {
                    sandwiches[sand] = -1; // eaten
                    students[stud] = -1; // leaves queue
                    eaten = true;
                    break; // next sandwiche
                } else {
                    continue; // next student
                }
            }

            if (!eaten) { // sandwiche wasnt eated and students are still in the queue
                return Arrays.stream(students)
                        .filter(s -> s != -1)
                        .toArray().length;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution1700 s = new Solution1700();
    
        int[] sandwiches = { 0,0,0,1,0,1,1,1,1,0,1 };
        int[] students = { 0,0,0,1,0,0,0,0,0,1,0 };
    
        System.out.println(s.countStudents(students, sandwiches));
      }
}

/*
 * 1700. Number of Students Unable to Eat Lunch
 * 
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 * 
 * The school cafeteria offers circular and square sandwiches at lunch break,
 * referred to by numbers 0 and 1 respectively. All students stand in a queue.
 * Each student either prefers square or circular sandwiches.
 * 
 * The number of sandwiches in the cafeteria is equal to the number of
 * students. The sandwiches are placed in a stack. At each step:
 * 
 * If the student at the front of the queue prefers the sandwich on the top of
 * the stack, they will take it and leave the queue. Otherwise, they will leave
 * it and go to the queue's end. This continues until none of the queue
 * students want to take the top sandwich and are thus unable to eat.
 * 
 * Example 1:
 * 
 * Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
 * Output: 0
 * 
 * Explanation:
 * - Front student leaves the top sandwich and returns to the end of the line
 * making students = [1,0,0,1]. 
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1]. 
 * - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0]. 
 * - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,1]. 
 * - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1]. 
 * - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
 * Hence all students are able to eat.
 * 
 * Example 2:
 * 
 * Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * Output: 3
 * 
 * Constraints:
 * 
 * 1 <= students.length, sandwiches.length <= 100
 * students.length == sandwiches.length
 * sandwiches[i] is 0 or 1.
 * students[i] is 0 or 1.
 */