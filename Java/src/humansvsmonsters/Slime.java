/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humansvsmonsters;

import java.util.ArrayList;

/**
 *
 * @author Sofy
 */
class Slime extends RealCharacter{
    static private Slime instance;
    
    private Slime(){
        id = "M01";
        name = "Slime";
        maxHp = 100;
        hp = maxHp;
        maxMp = 200;
        mp = maxMp;
        strength = 10;
        defence = 30;
        speed = 10;
        
        usables = new ArrayList();
        usables.add(new SpeedUP());
        usables.add(new Cure());
    }
    static public Slime instantiate(){
        if (instance == null){
            instance = new Slime();
        }
        return instance;
    }
    @Override public ArrayList<GameMapPosition> getMoves(){
        ArrayList<GameMapPosition> moves = new ArrayList();
       
        moves.add(new GameMapPosition(pos.getX(), pos.getY()+3));
        moves.add(new GameMapPosition(pos.getX(), pos.getY()-3));
        moves.add(new GameMapPosition(pos.getX(), pos.getY()+1));
        moves.add(new GameMapPosition(pos.getX(), pos.getY()-1));
        moves.add(new GameMapPosition(pos.getX()+3, pos.getY()));
        moves.add(new GameMapPosition(pos.getX()-3, pos.getY()));
        moves.add(new GameMapPosition(pos.getX()+1, pos.getY()));
        moves.add(new GameMapPosition(pos.getX()-1, pos.getY()));
        
        return moves;
    }
    @Override public void setInitialPosition(){
        pos = new GameMapPosition(19, 2);
        notifyObservers();
    }
}
