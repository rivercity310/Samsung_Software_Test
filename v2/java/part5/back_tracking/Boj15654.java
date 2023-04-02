package part5.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj15654 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuffer sb = new StringBuffer();
    static final Deque<Integer> dq = new ArrayDeque<>();
    static StringTokenizer st;
    static int N, M;
    static int[] nums;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        checked = new boolean[N];
        nums = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        solve(0);
        System.out.print(sb);
    }

    static void solve(int depth) {
        if (depth == M) {
            for (int k : dq)
                sb.append(k).append(' ');

            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                dq.add(nums[i]);
                solve(depth + 1);
                checked[i] = false;
                dq.removeLast();
            }
        }
    }
}
