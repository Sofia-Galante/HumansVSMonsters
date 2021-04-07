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


class Goblin extends RealCharacter{
    //Il Goblin si muove dritto di 4 caselle
    static private Goblin instance;
    
    private Goblin(){
        id = "M02";
        name = "Goblin";
        maxHp = 200;
        hp = maxHp;
        maxMp = 50;
        mp = maxMp;
        strength = 35;
        defence = 12;
        speed = 19;
        
        usables = new ArrayList();
        usables.add(new SpeedUP());
        usables.add(new StrengthUP());
    }
    static public Goblin instantiate(){
        if (instance == null){
            instance = new Goblin();
        }
        return instance;
    }
    @Override public ArrayList<GameMapPosition> getMoves(){
        ArrayList<GameMapPosition> moves = new ArrayList();
       
        moves.add(new GameMapPosition(pos.getX()+4, pos.getY()));
        moves.add(new GameMapPosition(pos.getX(), pos.getY()+4));
        moves.add(new GameMapPosition(pos.getX()-4, pos.getY()));
        moves.add(new GameMapPosition(pos.getX(), pos.getY()-4));
        
        
        return moves;
    }
    @Override public void setInitialPosition(){
        pos = new GameMapPosition(17, 0);
        notifyObservers();
    }
}
