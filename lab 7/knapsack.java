import java.util.*;

public class knapsack {
    static class ItemValue {
        int weight, value;

        public ItemValue(int v, int w) {
            weight = w;
            value = v;
        }
    }

    private static double getMaxValue(ItemValue[] arr, int capacity) {
        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue item1, ItemValue item2) {
                double cp1 = (double) item1.value / (double) item1.weight;
                double cp2 = (double) item2.value / (double) item2.weight;

                if (cp1 < cp2)
                    return 1;
                else
                    return -1;
            }
        });

        double soln = 0.0;
        for (ItemValue i : arr) {
            int currwt = (int) i.weight;
            int currval = (int) i.value;
            if (capacity - currwt >= 0) {
                capacity -= currwt;
                soln += currval;
            } else {
                double fraction = ((double) currval / (double) currwt);
                soln += (capacity * fraction);
                capacity = (int) (capacity - (currwt * fraction));
                break;
            }
        }
        return soln;
    }

    public static void main(String[] args) {
        ItemValue[] arr = { new ItemValue(60, 15), new ItemValue(40, 20), new ItemValue(30, 10) };
        System.out.println("max value= " + getMaxValue(arr, 30));
    }

}
