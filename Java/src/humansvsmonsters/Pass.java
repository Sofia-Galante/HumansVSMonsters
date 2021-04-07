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
class Pass implements Action {
    private Game game;
    
    public Pass(Game game){
        this.game = game;
    }
    
    @Override public void execute(){
        game.onPass();
    }
}
