package qihui.sun.jdk;

/**
 * 使用位运算时间就是0，自己用String来计算就会很糟糕
 */
public class HighestOneBit {
    public static void main(String[] args) {
        int num = 1111111111;
        int times = Integer.MAX_VALUE;
//        System.out.println(highestOneBit(num));
//        System.out.println(myHighestOneBit(num));
//        System.out.println(roundUpToPowerOf2(num));
//        System.out.println(myRoundUpToPowerOf2(num));

        long l = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            roundUpToPowerOf2(num);
        }
        System.out.println("官方时间"+(System.currentTimeMillis()-l));
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            myRoundUpToPowerOf2(num);
        }
        System.out.println("我的时间"+(System.currentTimeMillis()-l1));
    }

    //求小于等于一个数的最大2次幂

    private static int highestOneBit(int num) {
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 16;
        return num - (num >>> 1);
    }

    //求小于等于一个数的最大2次幂
    public static int myHighestOneBit(int num) {
        String binaryString = Integer.toBinaryString(num);
        int length = binaryString.length();
        return (int) Math.pow(2, length - 1);
    }

    public static int roundUpToPowerOf2(int num) {
        return highestOneBit((num - 1) << 1);
    }

    //求大于等于一个数的最小2次幂
    public static int myRoundUpToPowerOf2(int num) {
        String binaryString = Integer.toBinaryString(num);
        int length = binaryString.length();
        int i = binaryString.lastIndexOf('1');
//        System.out.println(binaryString + "------" + length + "last index" + i);
        int powNum = i == 0 ? length - 1 : length;
        return (int) Math.pow(2, powNum);
    }
}
