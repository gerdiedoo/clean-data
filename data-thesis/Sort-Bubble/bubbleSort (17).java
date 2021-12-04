package sorting;

import static sorting.Sorting.print;
/*
Bubble Sort 
    Tiny code size
    ability to detect that the list is sorted efficiently is built into the algorithm.
    Not optimal

    Stable(does not change the relative order of elements with equal keys) : Yes
    Online(can sort as it recieves input) : No
    Adaptable(faster for already sorted data) : Yes
    Inplace (doesnt require additional space) : Yes

Analysis
    Worst Case Running Time : O(N^2)
    Best Case Running Time : O(N) Already sorted list
    Space Complexity : O(1)

*/
class bubbleSort {
    static void bubblesort(int a[]){
        boolean swappedElement = false;
        sort:for(int i=0;i<a.length;i++){
                for (int j=0; j < a.length-1; j++) {
                    if(a[j]>a[j+1]){
                        swap(a, j, j+1);
                        swappedElement=true;
                    }
                    
                }
                
                if(!swappedElement){
                  break sort;
                }
            }
    }
    
    static void swap(int a[],int p,int q){
                    int temp = a[p];
                    a[p]=a[q];
                    a[q]=temp;
    }
}
