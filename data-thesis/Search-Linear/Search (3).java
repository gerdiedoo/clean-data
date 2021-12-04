import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.exit;

/**
 * Created by Akshay Chandrashekhar Pandit on 2/16/2017.
 *
 * Program that uses 2 searching methods which are crucial part of data structures
 * We perform the famous algorithm implementation of linear search and binary search
 */
public class Search {
    private static int search_array[];
    private static int size;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //The menu will keep on popping after every function of the selected choice
        while (true) {
            System.out.println("==============================MENU==============================");
            System.out.println("1.Linear Search");
            System.out.println("2.Binary Search");
            System.out.println("3.Exit");
            System.out.println("================================================================");

            System.out.println("Please give the choice from the above menu: ");
            int choice = scanner.nextInt();

            //Usage of switch instead of if-elseif, to make it look simple and clutter-free
            switch (choice) {
                case 1:
                    linearSearch();
                    break;
                case 2:
                    binarySearch();
                    break;
                case 3:
                    exit(0);
                    break;
                default:
                    System.out.println("Please choose the right option, refer the above menu!");
            }
        }
    }

    //Linear search algorithm, the easiest to implement in code
    private static void linearSearch(){
        //found flag is used to validate whether the element is found or not
        int found = 0;

        //Array creation function invoked
        createArray();

        //Normal display of array to check the given elements are in
        displayArray();

        //The linear search algorithm starts from here
        System.out.println("Now give the element to be searched in linear fashion: ");
        int searchItem = scanner.nextInt();

        //Searching up every element to that of the given element in a very linear way
        //matching every element in the iteration to check with the required number
        //Slower compared to binary search
        for (int i = 0; i < size; i++){
            if(search_array[i] == searchItem){
                System.out.println("The item " + searchItem + " found at position " + (i+1));
                found = 1;
            }
        }
        if(found == 0) {
            System.out.println("Please give the correct item to be searched! It looks as if there is no such item! Please check again");
        }
    }

    //Array creation logic, almost same in every program
    private static void createArray(){
        System.out.println("Give the size of the array to insert elements: ");
        size = scanner.nextInt();
        search_array = new int[size];

        System.out.println("Now give " + size + " elements to insert into the array: ");

        //Can also use advanced for loop to insert element in each of index in a modular fashion
        for (int i = 0; i < size; i++){
            search_array[i] = scanner.nextInt();
        }
    }

    //The next logic is of binary search which is quite complex compared to linear
    //But easier to implement once logic is understood, faster than linear
    //Requires the items to be sorted in order to be searched faster
    //This logic always finds the number in the mid only
    //If not possible then we shift head and tail in such a way so as to make mid == search_element
    private static void binarySearch(){
        createArray();

        displayArray();

        //Binary search requires the array to be sorted, hence the sort function
        System.out.println("Sorting the array...");
        Arrays.sort(search_array);

        displayArray();

        System.out.println("Now give the element to be searched in binary fashion: ");
        int searchItem = scanner.nextInt();

        //Initializing the head to be on the first index and tail to be on the last index
        int head = 0;

        // Putting size that is defined universally for the array is used as maximum array length
        int tail = size;

        //used to find the mid-point of the array by adding the first and last element and then dividing it by 2
        int mid;

        //Run the loop till the head and tail (first and last element) collide with each other,
        // That is, when head == tail
        while (head < tail){

            //This is where the logic of mid is implemented inside the loop every time it runs
            mid = (head + tail)/2;

            //Check the mid point to that with the item to be searched
            //If mid point is less than the element to be searched
            //then shift the end point to one index before mid (towards head)
            //If mid point is more than the element to be searched
            //then shift the start point to one index more after mid (towards tail)
            if(search_array[mid] == searchItem){
                System.out.println("The item " + searchItem + " found at position " + (mid+1));
                break;
            }else if (search_array[mid] > searchItem){
                tail = mid - 1;
            }else{
                head = mid + 1;
            }
        }

        //If the element is not found, the iteration will collide the head and tail together
        if(head > tail){
            System.out.println("Number not found! Please check again!");
        }
    }

    //Normal logic of displaying the array using advanced for-loop
   private static void displayArray(){
        System.out.println("The elements are as follows: \n");
        for (int x: search_array){
            System.out.print(x + "\t");
        }
        System.out.println();
    }
}
