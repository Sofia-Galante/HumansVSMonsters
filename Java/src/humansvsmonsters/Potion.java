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
class Potion extends ObjectBase {
    
    public Potion(int quantity){
        this.quantity = quantity;
        this.name = "Potion";
    }
    
    @Override public void use(Character owner, Character receiver){
        receiver.setHp(receiver.getHp()+20);
        quantity -= 1;
    }
}
