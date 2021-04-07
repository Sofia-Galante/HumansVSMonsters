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
class Archer extends RealCharacter{
    static private Archer instance;
    
    private Archer(){
        id = "H01";
        name = "Archer";
        maxHp = 200;
        hp = maxHp;
        maxMp = 90;
        mp = maxMp;
        strength = 20;
        defence = 10;
        speed = 15;
        
        usables = new ArrayList();
        usables.add(new Potion(3));
        usables.add(new SpeedWings(1));
    }
    static public Archer instantiate(){
        if (instance == null){
            instance = new Archer();
        }
        return instance;
    }
    @Override public ArrayList<GameMapPosition> getMoves(){
        ArrayList<GameMapPosition> moves = new ArrayList();
        moves.add(new GameMapPosition(pos.getX()+2, pos.getY()+2));
        moves.add(new GameMapPosition(pos.getX()+2, pos.getY()-2));
        moves.add(new GameMapPosition(pos.getX()-2, pos.getY()+2));
        moves.add(new GameMapPosition(pos.getX()-2, pos.getY()-2));
        
        return moves;
    }
    @Override public void setInitialPosition(){
        pos = new GameMapPosition(0, 12);
        notifyObservers();
    }
}
