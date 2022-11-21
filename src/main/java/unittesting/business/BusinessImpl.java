package unittesting.business;

public class BusinessImpl {
    public int calculateSum(int[] data) {
        int sum = 0;
        for(int value:data) {
            sum += value;
        }
        return sum;
    }
}
