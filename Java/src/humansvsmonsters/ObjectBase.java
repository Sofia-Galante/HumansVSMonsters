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
abstract class ObjectBase extends ObjectOrAbility{
    protected int quantity;
    
    @Override public String getLabel(){
        return name + " x" + quantity;
    }
    
    @Override public boolean canUse(Character c){
        return quantity>0;
    }
}
