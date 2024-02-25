/*
 * Name: Aaditya Manami-Ratan
 * Date: 1/10/24
 *
 * */
public class Main {
    public static void main(String[] args) {
        System.out.println(sortString("natasha"));
        int[] arr = {3, 6,10, 19,22, -8, 0};

        System.out.println(binarySearchRotated(arr, -8));
    }

    public static String sortString(String s) {
        for(int i=0;i < s.length();i++){
            for(int j=i+1; j < s.length(); j++) {
                if(s.substring(i, i+1).compareTo(s.substring(j, j+1)) > 0) {
                    s = s.substring(0, i) + s.substring(j, j+1) + s.substring(i + 1, j)+s.substring(i, i + 1)+s.substring(j + 1);
                }
            }
        }
        return s;
    }

    public static int binarySearchRotated(int[] arr, int value) {
        int minIndex=0;
        int min = arr[0];
        for (int i=1; i < arr.length; i++) {
            if(arr[i] < min){
                minIndex = i;
                min = arr[i];
            }
        }

        int shift = -minIndex;
        int[] arrSorted = new int[arr.length];
        int currIndex = 0;

        for (int i =0; i < arrSorted.length; i++) {
            if (currIndex + shift<0){
                arrSorted[arr.length + shift + (currIndex)] = arr[currIndex];
            }
            else {
                arrSorted[currIndex + shift] = arr[currIndex];
            }
            currIndex++;
        }
        int index = -1;

        //binary search
        int left = (arrSorted.length - 1)/2;
        int right = arrSorted.length - 1;

        while(left <= right){
            if (value < arrSorted[left]) {
                right = left-1;
                left = (left)/2;

            }
            else if (value > arrSorted[left]) {
                left += ((right-left)/2)+1;
            }
            else if (value == arrSorted[left]) {
                index = left-shift;
                if (index >= arr.length) {
                    index = index-arr.length;
                }
                left = right + 1;
            }
        }
        return index;
    }


}