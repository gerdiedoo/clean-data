package sorting;
import java.util.Scanner;
/*
Merge Sort 
    Based on devide and Conquer
    Less number of compares

    Stable(does not change the relative order of elements with equal keys) : Yes
    Online(can sort as it recieves input) : No
    Adaptable(faster for already sorted data) : No
    Inplace (doesnt require additional space) : No

Analysis
    Worst Case Running Time : O(NLogN) when the list is reverse sorted
    Best Case Running Time : O(NLogN) Already sorted list
    Space Complexity : O(N) auxilary space(left and right arrays)

*/
class mergeSort{
    
    static int[] merge(int a[],int b[]){
        int l_a=a.length;
        int l_b=b.length;
        //create new array to store sorted values
        int combined[] = new int[l_a+l_b];
        
        int ptr_c=0;
        
        int ptr_p=0,ptr_q=0;
        
        while(ptr_p<l_a && ptr_q<l_b){
            if(a[ptr_p]<b[ptr_q]){
                combined[ptr_c]=a[ptr_p];
                ptr_p++;
                ptr_c++;
            }
            else{
                combined[ptr_c]=b[ptr_q];
                ptr_q++;
                ptr_c++;
            }
            
        }
        
        //if l_a < l_b then copy the remaining array b to c
        if(ptr_p>=l_a){
            for(int i = 0;i<(l_b-ptr_q);i++){
                combined[ptr_c+i]=b[ptr_q+i];
            }
        }
        //if l_a < l_b then copy the remaining array a to c
        if(ptr_q>=l_b){
            for (int i = 0;i<(l_a-ptr_p); i++) {
                combined[ptr_c+i]=a[ptr_p+i];
            }
        }
        
        return combined;
    }
    
    static int[] mergeSort(int arr[]){
        int mid=0;
        if(arr.length>1){
            mid=(0+arr.length)/2;
        }
        // if the array has just one element
        else{
            return arr;
        }
        
        //create a array left to store the values from 0 to mid-1 of array
        int left[] = new int[mid];
        for(int i =0;i<mid;i++){
            left[i]=arr[i];
        }
        
        //create a array right to store the values from mid to a.length-1 of array
        int right[]=new int[arr.length-mid];
        for(int i =0;i<(arr.length-mid);i++){
            right[i]=arr[i+mid];
        }
        
        left=mergeSort(left);
        right=mergeSort(right);
        
        //merge the two subarrays
        int mergedArr[] = merge(left,right);
        return mergedArr;
    }
}