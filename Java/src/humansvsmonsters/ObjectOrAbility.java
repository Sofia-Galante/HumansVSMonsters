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
abstract class ObjectOrAbility {
    protected String name;
    public abstract void use(Character owner, Character receiver);
    public abstract boolean canUse(Character c);
    
    
    public abstract String getLabel();
   
    public String getName(){
        return name;
    }
    public Action getAction(Game g){
        return new UseObjectOrAbility(g, this);
    }
}
