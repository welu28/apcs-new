import java.util.*;
import java.io.*;

public class Problem_1_Berry_Picking{
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int n = io.nextInt(); // # trees
        int[] trees = new int[n];
        for(int i = 0; i < n; i++) trees[i] = io.nextInt();
        Arrays.sort(trees);
        int k = io.nextInt();
        io.close();
    }

    static class FastIO{
        BufferedReader br;
        StringTokenizer st;
        BufferedWriter bw;

        public FastIO(){
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }

        public void print(Object object) {
            try {
                bw.append("" + object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void println(Object object) {
            print(object);
            try {
                bw.append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void close() {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
