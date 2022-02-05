
import java.util.ArrayList;
import java.util.Collections;

public class Foobar2_1 {

    public static void main(String[] args) {
        String n = "1211";
        ArrayList list = new ArrayList();
        System.out.println(answer(n, 10, list));
    }

    private static int answer(String n, int b, ArrayList list) {
        int k = n.length();
        int x = sortD(Integer.parseInt(n));
        int y = sortA(Integer.parseInt(n));
        int z = 0;
        if (b == 10) {
            z = x - y;
        } else {
            z = dtn(ntd(x, b) - ntd(y, b), b);
        }
        String m = addLeadingZeroes(z, k);
        if (list.contains(m)) {
            return list.size() - list.indexOf(m);
        }
        list.add(m);
        return answer(m, b, list);
    }

    static int sortA(int n) {
        ArrayList D = new ArrayList();
        while (n > 0) {
            D.add(n % 10);
            n = n / 10;
        }
        Collections.sort(D, Collections.reverseOrder());
        int sorted = 0;
        for (int i = 0; i < D.size(); i++) {
            sorted += ((int) D.get(i) * ((int) Math.pow(10, i)));
        }
        return sorted;
    }

    static int sortD(int n) {
        ArrayList D = new ArrayList();
        while (n > 0) {
            D.add(n % 10);
            n = n / 10;
        }
        Collections.sort(D);
        int sorted = 0;
        for (int i = 0; i < D.size(); i++) {
            sorted += ((int) D.get(i) * ((int) Math.pow(10, i)));
        }
        return sorted;
    }

    private static int ntd(int n, int b) {
        int rv = 0;
        int p = 1;
        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            rv += p * rem;
            p = p * b;
        }
        return rv;
    }

    private static int dtn(int n, int b) {
        int rv = 0;
        int p = 1;
        while (n > 0) {
            int rem = n % b;
            n = n / b;
            rv += p * rem;
            p = p * 10;
        }
        return rv;
    }

    private static String addLeadingZeroes(int z, int k) {
        String s = Integer.toString(z);
        if (s.length() < k) {
            String zeros = "";
            for (int i = 0; i < (k - s.length()); i++) {
                zeros += "0";
            }
            return zeros + s;
        }
        return s;
    }

}
