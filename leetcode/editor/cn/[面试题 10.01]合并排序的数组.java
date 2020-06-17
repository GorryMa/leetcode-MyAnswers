/**
//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 暴力法
     * 方法一：从B开始一个一个与A的数字比较  大于A则A的数字往后挪一位  加进去

     }
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            int x=B[i];
            for (int j = a; j <=m; j++) {
                if (x<=A[j]){
                    for (int k = m; k >j ; k--) {
                        A[k]=A[k-1];
                    }
                    A[j]=x;
                    m=m+1;
                    break;
                }
                if (j == m) {
                    A[m]=x;
                    m=m+1;
                    break;
                }
            }
        }
     }
     */


    /**
     * 方法二：把B全填入A后面在重新排序
     * 使用快速排序方法巩固快排

    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            A[m]=B[i];
            m++;
        }
        quickSort(A,0,m-1);
    }
    /**
     * 快速排序   升序排序
     * @param arr  待排数组
     * @param left 左指针下标
     * @param right  右指针下标
     * @return
    public void quickSort(int[] arr,int left,int right){
        int L=left;
        int R=right;
        int mid=arr[(left+right)/2];
        while (left <right) {
            while (arr[left]<mid){
                left++;
            }
            while (arr[right]>mid){
                right--;
            }
            if (left<=right) {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
        if (L < right) {
            quickSort(arr,L,right);
        }
        if (left<R) {
            quickSort(arr,left,R);
        }
    }
    */
    /**
     * 方法三：双指针
     * 利用一个新数组从小到大存储
     * 由于A,B本身已经是有序的  因此每次没出A，B的最小值存入数组中即可
     * 当其中一个数组读满时  直接将另一个数组附到末尾即可
     * @param A
     * @param m
     * @param B
     * @param n

    public void merge(int[] A, int m, int[] B, int n) {
        int[] ans=new int[m+n];
        int matchA=0; int matchB=0;
        for (int i = 0; i < m + n; i++) {
            if (matchA == m) {
                ans[i]=B[matchB];
                matchB=matchB+1;
                continue;
            }
            if (matchB == n) {
                ans[i]=A[matchA];
                matchA=matchA+1;
                continue;
            }
            if (A[matchA]<=B[matchB]){
                ans[i]=A[matchA];
                matchA=matchA+1;
            }else {
                ans[i]=B[matchB];
                matchB=matchB+1;
            }
        }
        for (int i = 0; i < m + n; i++) {
            A[i]=ans[i];
        }
    }
     */
    /**
     * 方法四：利用双指针从大到小往A数组中村
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int matchA=m-1;
        int matchB=n-1;
        for (int i = m+n-1; i >=0 ; i--) {
            if (matchA <0) {
                A[i]=B[matchB];
                matchB--;
            }else if (matchB<0) {
                A[i]=A[matchA];
                matchA--;
            }else if (A[matchA]>=B[matchB]){
                A[i]=A[matchA];
                matchA--;
            }else {
                A[i]=B[matchB];
                matchB--;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

