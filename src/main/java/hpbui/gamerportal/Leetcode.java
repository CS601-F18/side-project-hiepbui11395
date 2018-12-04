package hpbui.gamerportal;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode {
    public static void main(String[] args) {
        int[] pushed = new int[]{3, 2, 1, 2, 1, 7};
        System.out.print(minIncrementForUnique(pushed));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < pushed.length && j < popped.length) {
            stack.push(pushed[i]);
            i++;
            while (j < popped.length && !stack.empty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        if (i > j) {
            return false;
        } else {
            return true;
        }
    }

    public static int minIncrementForUnique(int[] A) {
        int[] arr = new int[100000];
        Arrays.fill(arr, 0);
        for (int i = 0; i < A.length; i++) {
            arr[A[i]]++;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                stack.push(i);
            }
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 1) {
                while (!stack.empty() && stack.peek() <= i) {
                    stack.pop();
                }
                result += stack.pop() - i;
                arr[i]--;
            }
        }
        return result;
    }

    public static int findNextIndex(int[] arr, int index) {
        int j = index + 1;
        while (arr[j] != 0) {
            j++;
        }
        return j;
    }
}
