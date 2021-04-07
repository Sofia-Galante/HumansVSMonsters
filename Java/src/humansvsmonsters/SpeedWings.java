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
class SpeedWings extends ObjectBase {
    SpeedWings(int cost){
        this.quantity = cost;
        this.name = "Speed Wings";
    }
    
    @Override public void use(Character owner, Character receiver){
        receiver.setSpeed(receiver.getSpeed()+3);
        quantity -= 1;
    }
}            

