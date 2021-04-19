/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humansvsmonsters;

/**
 *
 * @author Sofy
 */
abstract class AbilityBase extends ObjectOrAbility{
    int cost;
    
    @Override public String getLabel(){
        return name + " " + cost + " MP";
    }
    
    @Override public boolean canUse(Character c){
        return cost<=c.getMp();
    }
}
