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
class Cure extends AbilityBase{
    public Cure(){
        this.cost = 10;
        this.name = "Cure";
    }
    
    @Override public void use(Character owner, Character receiver){
        receiver.setHp(receiver.getHp()+owner.getHp()*20/100);
        owner.setMp(owner.getMp()-cost);
    }
}