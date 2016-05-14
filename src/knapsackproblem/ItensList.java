/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ivo
 * @param <Item>
 */
public class ItensList<Item> extends ArrayList<Item> {

    @Override
    public String toString() {
        String toReturn = "";
        Iterator<Item> itemIterator = this.iterator();
        while (itemIterator.hasNext()) {
            Item temp=itemIterator.next();
            toReturn=toReturn.concat(temp.toString());
            toReturn =toReturn+"\n";
        }
        return "\n" + toReturn + "\n";
    }

}
