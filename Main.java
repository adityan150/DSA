import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// program with user defined FastReader
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(
                new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

public class Main {
    public static void main(String[] args) {
        final FastReader fr = new FastReader();
        final Solver solver = new Solver();
        final StringBuffer sb = new StringBuffer();

        for (int testcases = fr.nextInt(); testcases >= 0; testcases--) {
            int n = fr.nextInt();
            sb.append(solver.solve(n)).append("\n");
        }
        System.out.println(sb);
    }
}

// Solution logic
class Solver {
    public String solve(int n) {
        return "Solution " + n;
    }
}
