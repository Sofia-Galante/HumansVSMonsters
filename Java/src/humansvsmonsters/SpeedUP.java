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
class SpeedUP extends AbilityBase{
    public SpeedUP(){
        this.cost = 15;
        this.name = "SpeedUP";
    }
    
    @Override public void use(Character owner, Character receiver){
        receiver.setSpeed(receiver.getSpeed()+owner.getHp()*20/100);
        owner.setMp(owner.getMp()-cost);
    }
}
