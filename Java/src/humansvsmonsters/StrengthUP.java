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
class StrengthUP extends AbilityBase{
    public StrengthUP(){
        this.cost = 15;
        this.name = "StrengthUP";
    }
    
    @Override public void use(Character owner, Character receiver){
        receiver.setStrength(receiver.getStrength()+owner.getDefence()*15/100);
        owner.setMp(owner.getMp()-cost);
    }
}
