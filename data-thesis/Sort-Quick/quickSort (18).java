package sorting;
/*
Merge Sort 
    Based on devide and Conquer
    faster than merge sort and heap sort
    uses spatial locality — it walks neighboring elements, comparing them to 
        the pivot value (which can be stored in a register). It makes very effective use of caching.

    Stable(does not change the relative order of elements with equal keys) : NO
    Online(can sort as it recieves input) : No
    Adaptable(faster for already sorted data) : No
    Inplace (doesnt require additional space) : No

Analysis
    Worst Case Running Time : O(N^2)  unbalanced partition occurs when the pivot 
        divides the list into two sublists of sizes 0 and n − 1. This may occur if the 
        pivot happens to be the smallest or largest element in the list
    Best Case Running Time : O(NLogN) most balanced case, each time we perform 
        a partition we divide the list into two nearly equal pieces.
    Space Complexity : O(LogN) auxilary space

*/
class quickSort {
    static void quicksort(int a[],int low,int high){
        int p = partition(a,low,high);
        if(low<p-1){
            quicksort(a, low, p-1);
        }
        if(p<high){
            quicksort(a, p, high);
        }
    }
    static int partition(int a[],int low,int high){
        //take low as the pivot
        int i=low,j=high;
        int temp;
        int pivot = a[(low+high)/2];
        
        while(i<=j){
            while(a[i]<pivot){i++;}
            while(a[j]>pivot){j--;}
            
            if(i<=j){
                swap(a,i,j);
                i++;
                j--;
            }
        }
        return i;
    }
    static void swap(int a[],int p,int q){
                    int temp = a[p];
                    a[p]=a[q];
                    a[q]=temp;
    }
}
