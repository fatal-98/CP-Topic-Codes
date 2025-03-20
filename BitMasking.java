import java.util.*;
public class BitMasking {
    public static int cnt_SetBits(int n){
        int cnt = 0;
        while(n>0){
            cnt += (n & 1);
            n >>=1;
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Bit Masking
        int num_worker = in.nextInt();
        int [] a = new int[num_worker];
        for(int i=0;i<num_worker;i++){
            int days = in.nextInt();
            int mask=0;
            for(int j=0;j<days;j++){
                int day = in.nextInt();
                mask = (mask | (1<< day));
            }

            a[i] = mask;
        }

        int max_days = 0;
        int person1 = -1;
        int person2 =-1;
        // select any two workers, the common days are maximum so that work is so fast
        for(int i=0;i<num_worker;i++){
            for(int j=i+1;j<num_worker;j++){
                // a[i] & a[j] -> cnt how many sets are there
                int inter = a[i] & a[j];
                int common_days= cnt_SetBits(inter); //  int common_days= Integer.bitCount(inter);
                if(common_days > max_days){
                    max_days = common_days;
                    person1 = i;
                    person2 = j;
                }
            }
        }

        System.out.println(person1 + " " + person2 + " " +  max_days);
    }
}
