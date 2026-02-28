import java.util.Arrays;
class Solution {
    public int[] sortArray(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;

        int[] left = sortArray(Arrays.copyOfRange(arr , 0 , mid));  // A new array is created from 0 to mid of exixting array.
        int[] right = sortArray(Arrays.copyOfRange(arr , mid , arr.length));

        return merge(left,right);
    }

    static int[] merge(int[] first , int[] second){   // This method merge these two sorted arrays.
        // First = left
        // Second = Right



        int[] mixArray = new int[first.length + second.length];

        int i = 0 ; // Pointer for LEFT part of array
        int j = 0 ; // Pointer for RIGHT part of an array
        int k = 0 ; // Pointer for new MIX array.

        while(i<first.length   &&   j<second.length){
            if(first[i] < second[j]){
                mixArray[k] = first[i];
                i++ ;
                k++ ;
            }
            else{
                mixArray[k] = second[j];
                j++ ;
                k++ ;
            }
        }

        // It may be poossible that one of the arrays is not complete or one of the array is completed and second were remaining.
        // Copy the remaining elements.

        while(i < first.length){
            mixArray[k] = first[i];
            i++;
            k++;
        }

        while(j < second.length){
            mixArray[k] = second[j];
            j++;
            k++;
        }


        return mixArray;

    }
}