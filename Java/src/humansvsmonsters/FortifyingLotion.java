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
class FortifyingLotion extends ObjectBase{
    FortifyingLotion(int quantity){
        this.quantity = quantity;
        this.name = "Fortifying Lotion";
    }
    
    @Override public void use(Character owner, Character receiver){
        receiver.setDefence(receiver.getDefence()+4);
        quantity -= 1;
    }
}
