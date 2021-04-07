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
class Mage extends RealCharacter{
    //Il mago si muove a L
    static private Mage instance;
    
    private Mage(){
        id = "H03";
        name = "Mage";
        maxHp = 150;
        hp = maxHp;
        maxMp = 200;
        mp = maxMp;
        strength = 25;
        defence = 10;
        speed = 23;
        
        usables = new ArrayList();
        usables.add(new Potion(1));
        usables.add(new FortifyingLotion(3));
    }
    static public Mage instantiate(){
        if (instance == null){
            instance = new Mage();
        }
        return instance;
    }
    @Override public ArrayList<GameMapPosition> getMoves(){
        ArrayList<GameMapPosition> moves = new ArrayList();
       
        moves.add(new GameMapPosition(pos.getX()-2, pos.getY()+1));
        moves.add(new GameMapPosition(pos.getX()-2, pos.getY()-1));
        moves.add(new GameMapPosition(pos.getX()-1, pos.getY()+2));
        moves.add(new GameMapPosition(pos.getX()-1, pos.getY()-2));
        moves.add(new GameMapPosition(pos.getX()+2, pos.getY()+1));
        moves.add(new GameMapPosition(pos.getX()+2, pos.getY()-1));
        moves.add(new GameMapPosition(pos.getX()+1, pos.getY()+2));
        moves.add(new GameMapPosition(pos.getX()+1, pos.getY()-2));
        
        return moves;
    }
    @Override public void setInitialPosition(){
        pos = new GameMapPosition(2, 14);
        notifyObservers();
    }
}
