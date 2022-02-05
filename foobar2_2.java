
import java.util.ArrayList;
import java.util.Collections;

public class foobar2_2 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(5);
        list.add(5);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        int[] l = new int[]{3, 1, 4, 1,5,9};
        System.out.println(answer(l));
    }

    static int answer(int[] l) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < l.length; i++) {
            list.add(l[i]);
        }
        return solution(list);
    }

    private static int solution(ArrayList list) {
        Collections.sort(list, Collections.reverseOrder());
        ArrayList a0=new ArrayList();
        ArrayList a1=new ArrayList();
        ArrayList a2=new ArrayList();
        int sum = sumN(list);
        for(Object a:list){
        if((int)a%3==0)a0.add(a);
        else if((int)a%3==1)a1.add(a);
        else a2.add(a);
        }
        if (sum % 3 == 0) {
            return makeN(list);
        } 
        else if (sum % 3 == 1) {
            ArrayList res1 = new ArrayList();
            if(!a1.isEmpty()){
                a1.remove(a1.size()-1);
            }
            else{
            a2.remove(a2.size()-1);
            a2.remove(a2.size()-1);
            }
            res1.addAll(a0);
            res1.addAll(a1);
            res1.addAll(a2);
            Collections.sort(res1, Collections.reverseOrder());
            return makeN(res1);
        } else if (sum % 3 == 2) {
            ArrayList res2 = new ArrayList();
            if(!a2.isEmpty()){
                a2.remove(a2.size()-1);
            }
            else{
            a1.remove(a1.size()-1);
            a1.remove(a1.size()-1);
            }
            res2.addAll(a0);
            res2.addAll(a1);
            res2.addAll(a2);
            Collections.sort(res2, Collections.reverseOrder());
            return makeN(res2);
        }
        return 0;
    }

    private static int makeN(ArrayList list) {
        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            num = num * 10 + (int) list.get(i);
        }
        return num;
    }

    static int sumN(ArrayList list) {
            int sum = 0;
        for (Object i : list) {
            sum += (int) i;
        }
            return sum;
    }
}
