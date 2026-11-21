package Easy_Level;

public class MinimumStepstoRemoveArrayElements {
    private static int minimumSteps(int[] arr){
        int n = arr.length;
        if (n == 1) return 1;
        int i = 0;
        int j = n-1;
        int count = 0;
        while (i <= j){
            if (arr[i] != arr[j]){
                count++;
            } else {
                if (i != j ){
                    count += 2;
                } else {
                    count++;
                }
            }
            i++;
            j--;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] n = {2,2,3,3,1};
        System.out.println(minimumSteps(n));
    }
}
