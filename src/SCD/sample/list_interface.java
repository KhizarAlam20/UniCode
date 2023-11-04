package SCD.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class list_interface {
    public static void main(String[] args) throws Exception {

        //in list interface we can add values add certain index
//        List<Integer> value = new ArrayList();
//        value.add(3,1);


        //iterator , for each fro collection fetch values
//        Iterator itr = value.iterator();
//
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }

//        advance for loop
//        for(Object i: value) //Object used as we have not specified a langguage
//        {
//            System.out.println(i);
//        }
        Object a;
        ArrayList<Number> b = new ArrayList<>();

        printer p = new printer(5,"Khizar");
        p.print();
    }
}

class printer<T extends Number,T2 extends String>  {
    T a;
    T2 str;

    public printer(T a, T2 str) {
        this.a = a;
        this.str = str;
    }

    void print() {
        System.out.println(a); System.out.println(str);
    }
}
