package Math;

// given streaming data that is very large and cannot get the length
// randomly select m elements from the streaming data and return
// probability = k / n -> k = 1 -> 1 / n = 1 / (i + 1)
// k is the # of sampling data
// i is the index of the candidate data
// n is the # of streaming data, maybe very large
// 通过ReservoirSampling实现对流数据的等概率抽样
// time: O(n)
// space: O(1)

import java.util.Arrays;
import java.util.Random;

public class ReservoirSampling {

    public static int[] samplingFromStream(int[] stream, int k) {
        Random rand = new Random();
        int[] reservoir = new int[k];
        for (int i = 0; i < k; i++) {
            reservoir[i] = stream[i];
        }

        for (int i = k; i < stream.length; i++) {
            int j = rand.nextInt(i + 1); // 在[0, i]之间随机生成一个数字
            if (j < k) {
                reservoir[j] = stream[i];
            }
        }

        return reservoir;
    }

    public static void main(String[] args) {
        int[] stream = {0, 3, 5, 7};
        System.out.println(Arrays.toString(samplingFromStream(stream, 1)));
    }

}
