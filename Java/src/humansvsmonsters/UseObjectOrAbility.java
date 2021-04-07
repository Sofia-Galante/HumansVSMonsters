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
class UseObjectOrAbility implements Action{
    private Game game;
    private ObjectOrAbility objOrAb;
    
    UseObjectOrAbility(Game game, ObjectOrAbility objOrAb){
        this.game = game;
        this.objOrAb = objOrAb;
    }
    
    @Override public void execute(){
        game.showAllies(objOrAb);
    }
    
}
