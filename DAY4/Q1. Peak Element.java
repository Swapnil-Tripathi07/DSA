static int findPeakElement(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1]){
                //you are in decreasing part of array
                //this may be the answer, but look at left
                //this is why end!= mid-1
                end = mid;
            }
            else{
                //you are in ascending part of the ara+ray
                start = mid+1; // because we know that mid+1 element>mid element
            }
            // In the end, start==end and pointing to the largest number because of the 2 checks above.
            // start and end are always trying to find max element in the above 2 chacks
            // hence , when they are pointing to just one element , that is the max.
        }
        return start; // Or you can return end because start and end pointing to the same element at the end.
    }
