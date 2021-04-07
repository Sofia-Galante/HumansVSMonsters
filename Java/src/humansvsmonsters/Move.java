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
class Move implements Action {
    
    private Game game;
    
    public Move(Game game){
        this.game = game;
    }
    
    @Override public void execute(){
        game.showMoves();
    }
}
