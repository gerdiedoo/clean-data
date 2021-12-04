import java.util.*;

public class HashMapDriver
{
   public static void main(String[] args)
   {
   
      HashMap h1 = new HashMap(3);
      
      //Standard Test Cases
      System.out.println(h1.load());
      System.out.println(h1.set("Yellow", "Banana"));
      System.out.println(h1.load());
      System.out.println("Yellow - > " + h1.get("Yellow"));
      System.out.println("Yellow - > " + h1.delete("Yellow"));
      System.out.println(h1.load());
      
      //Overflowing The HashMap
      System.out.println(h1.set("Red", "Apple"));
      System.out.println(h1.set("Purple", "Grape"));
      System.out.println(h1.set("Blue", "Berry"));
      System.out.println(h1.load());
      
      //Setting New Value For Key Already Existing In HashMap
      System.out.println(h1.set("Red", "Tomato"));
      System.out.println("Red - > " + h1.get("Red"));
      
      //Testing Delete Of Key In Map
      System.out.println(h1.delete("Red"));
      System.out.println(h1.load());
      
      //Testing Delete Of Key No Longer In Map
      System.out.println(h1.delete("Red"));
      
      //Testing Get Of Key No Longer In Map
      System.out.println("Red -> " + h1.get("Red"));
           
      //Setting Key That Maps To Same Bucket As Another Key (Orange and Blue are both index to 2)
      System.out.println(h1.set("Orange", "Orange"));
      System.out.println("Orange - > " + h1.get("Orange"));
      
      HashMap h2 = new HashMap(2);
      
      //Testing Load Factor When HashMap Empty
      System.out.println(h2.load());
      h2.set("A",1);
      h2.set("B",2);
      
      //Testing Load Factor When Full
      System.out.println(h2.load());
      h2.delete("A");
      
      //Testing Load After Delete
      System.out.println(h2.load());
      
      
      

     
      

   }
}

