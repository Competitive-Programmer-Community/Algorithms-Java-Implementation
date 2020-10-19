package Math;

// Rejection Sampling: accept-reject sampling algorithm, not efficient sampling algorithm because it reject many samples
// randomly generate x and y
// if y > p(x) -> reject
// if y < p(x) -> accept

// time: O(1)
public class RejectionSampling {
    // use randM() to generate randN()

    // 1 if M > N: 使用rand10实现rand7()
    public static int rand7() {
        int candidate = 10;
        while(candidate >= 7) {
            candidate = rand10();
        }

        return candidate;
    }

    // !!!
    // 2 if M < N: 使用rand7()实现rand10()
    public static int rand10() {
        int sample = 40;
        while(sample >= 40) {
            sample = 7 * rand7() + rand7(); // use rand7() to generate rand49() -> rand40()
        }

        return sample % 10 + 1;
    }

    /**
     * 给定一个circle，需要在circle内部随机选取k个点
     * 将circle放入一个square，然后计算square的左下角坐标
     * 使用两个randon函数生成dx和dy，判断生成的new point是否在圆内
     * 如果在圆内则accept，如果在圆外则reject
     * @param r
     * @param x
     * @param y
     * @return
     */
    public double[] generatePointsInCircle(double r, double x, double y) {
        double x0 = x - r, y0 = y - r;

        while(true) {
            double cx = 2 * r * Math.random() + x0;
            double cy = 2 * r * Math.random() + y0;
            if (Math.pow(cx - x, 2) + Math.pow(cy - y, 2) <= r * r) {
                return new double[]{cx, cy};
            }
        }
    }

    public static void main(String[] args) {

    }
}
