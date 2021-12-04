package sorting;
/*
Insertion Sort 
    Efficient for small data set


    Stable(does not change the relative order of elements with equal keys) : Yes
    Online(can sort as it recieves input) : Yes
    Adaptable(faster for already sorted data) : Yes
    Inplace (doesnt require additional space) : Yes

Analysis
    Worst Case Running Time : O(N^2) when the list is reverse sorted
    Best Case Running Time : O(N) Already sorted list
    Space Complexity : O(1)

*/
class insertionSort {
    //here we are inserting the element in already sorted list
    static void insertionsort(int a[]){
        for(int i=1;i<a.length;i++){
            //move backward till 0
            for(int j=i;j>0;j--){
                
                if(a[j]<a[j-1]){
                    swap(a,j,j-1);
                }
            }
        }
    }
    static void swap(int a[],int p,int q){
                    int temp = a[p];
                    a[p]=a[q];
                    a[q]=temp;
    }
}
