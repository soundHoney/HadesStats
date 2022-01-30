package sample;



public class DisplayAndCalculate {
    private int max = 0;
    private int current = 0;
    private int min = 0;
    private int minCurrent = 0;
    private int average = 0;
    private int index;

    // determine worst run, best run and average.  Set index back to 41 (start)
    public void bestWorstAvg(int[] answer, int size) {
        index = 41;
        min = answer[0];
        for (int i = 0; i < size; i++) {
            index++;
            if (answer[i] > max) {
                max = answer[i];
                current = index;
            }
            if (min > answer[i]) {
                min = answer[i];
                minCurrent = index;
            }
            average += answer[i];
        }
    }

    // displays total kills for each recorded run
    public void displayKills(int[] answer, int size) {
        // display all kills
        index = 41;
        for (int i = 0; i < size - 1; i++) {
            index++;
            System.out.println("Attempt #" + index + " killed " + answer[i] + " enemies!");
        }
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getAverage() {
        return average;
    }

    public int getCurrent() {
        return current;
    }

    public int getMinCurrent() {
        return minCurrent;
    }
}
