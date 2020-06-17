/**
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：把数组按最小到大排序  则前k项为所求
     * @param arr
     * @param k
     * @return

    public int[] getLeastNumbers(int[] arr, int k) {
        arr=reSort(arr);
        int[] a=new int[k];
        for (int i = 0; i < k; i++) {
            a[i]=arr[i];
        }
        return a;
    }
    /**
     * 对数组重排序
     * 冒泡法
     * @param arr

    public int[] reSort(int[] arr){
        //外层为排序的趟数
        for (int i = 0; i <arr.length-1; i++) {
            //内层为每趟排序比较次数
            for (int j = 0; j < arr.length - 1-i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
     */
    /**
     * 方法二：  每次取最小值然后重新得到新数组  重复k次

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] a=new int[k];
        for (int i = 0; i < k; i++) {
            int index=getMin(arr);
            a[i]=arr[index];
            arr=nextArr(arr,index);
        }
        return a;
    }
    /**
     *
     * 求一个数组的最小值的下标
     * @param arr
     * @return

    public int getMin(int[] arr){
        int minIndex=0;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[minIndex]>arr[i]){
                minIndex=i;
            }
        }
        return minIndex;
    }

    /**
     * 去除数组最小值后的数组
     * @param arr
     * @param index  最小值的下标
     * @return

    public int[] nextArr(int[] arr,int index){
        int[] a=new int[arr.length-1];
        for (int i = 0; i < index; i++) {
            a[i]=arr[i];
        }
        for (int i = index; i <a.length ; i++) {
            a[i]=arr[i+1];
        }
        return a;
    }
     */
    /**
     * 方法三：假设前k个数为最小值  如果后面的数比前面k个数的最大值小 替换
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] a=new int[k];
        if(k==0){
            return a;
        }
        for (int i = 0; i < a.length; i++) {
            a[i]=arr[i];
        }
        for (int i = k; i < arr.length; i++) {
            int max = getMax(a);
            if (arr[i]<a[max]){
                a[max]=arr[i];
            }
        }
        return a;
    }
        /**
         * 求一个数组最大值的坐标
         * @param arr
         * @return maxIndex
         */
    public int getMax(int[] arr){
        int maxIndex=0;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[maxIndex]<arr[i]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

