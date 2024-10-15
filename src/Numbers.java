public class Numbers {
    public static void main(String args[]){
            int[] a = {1,2,-1,3,4,10,10,-10,-1};
            int n =3;

        System.out.printf(java.util.Arrays.toString(windowPosSum(a,n)));
    }


    public static int[] windowPosSum(int[] a,int n){
        for(int i =0;i<a.length;i++){
            if(a[i]>0){
                for(int j =0;j<n;j++){
                    if(i+j<a.length){
                        a[i] += a[i+j];
                    }
                    break;
                }
            }
            continue;
        }
        return a;
    }
}
