/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humansvsmonsters;

import java.util.Comparator;

/**
 *
 * @author Sofy
 */
class PriorityQueueComparator implements Comparator{
    @Override public int compare(Object o1, Object o2){
        Character c1 = (Character) o1;
        Character c2 = (Character) o2;
        
        if(c1.getSpeed() < c2.getSpeed())
            return 1;
        else if (c1.getSpeed() > c2.getSpeed())
            return -1;
        else
            return (c1.getId().compareTo(c2.getId()));
    }
}
