package unittesting.business;

import unittesting.data.DataService;

public class BusinessImpl {
    private DataService dataService;

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public int calculateSum(int[] data) {
        int sum = 0;
        for(int value:data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = dataService.retrieveAllData();
        for(int value:data) {
            sum += value;
        }
        return sum;
    }
}
