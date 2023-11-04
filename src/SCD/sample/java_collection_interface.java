package SCD.sample;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

//dynamic array
public class java_collection_interface {

    public static void main(String[] args) {

//        INTERFACE ITERATOR <- COLLECTION INTERFACE <- LIST INTERFACE <- CLASSES

        Collection<Integer> value = new ArrayList();
        ArrayList<Integer> e = new ArrayList();
        Vector v = new Vector();

        value.add(3);
//        value.add("navin");
//        value.add(1.2);

        //iterator , for each fro collection fetch values
        Iterator itr = value.iterator();
//
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }

//        advance for loop
        for(Object i: value) //Object used as we have not specified a langguage
        {
            System.out.println(i);
        }

        //in list interface we can add values add certain index
    }
}
