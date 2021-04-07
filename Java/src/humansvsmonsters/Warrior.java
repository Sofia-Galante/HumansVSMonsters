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
class Warrior extends RealCharacter{
    //Il guerriero si muove di 1 casella in diagonale o 2 caselle in avanti
    static private Warrior instance;
    
    private Warrior(){
        id = "H02";
        name = "Warrior";
        maxHp = 300;
        hp = maxHp;
        maxMp = 60;
        mp = maxMp;
        strength = 30;
        defence = 20;
        speed = 6;
        
        usables = new ArrayList();
        usables.add(new FortifyingLotion(2));
        usables.add(new SpeedWings(2));
    }
    static public Warrior instantiate(){
        if (instance == null){
            instance = new Warrior();
        }
        return instance;
    }
    @Override public ArrayList<GameMapPosition> getMoves(){
        ArrayList<GameMapPosition> moves = new ArrayList();
       
        moves.add(new GameMapPosition(pos.getX(), pos.getY()+2));
        moves.add(new GameMapPosition(pos.getX(), pos.getY()-2));
        moves.add(new GameMapPosition(pos.getX()+1, pos.getY()-1));
        moves.add(new GameMapPosition(pos.getX()+1, pos.getY()+1));
        moves.add(new GameMapPosition(pos.getX()-1, pos.getY()+1));
        moves.add(new GameMapPosition(pos.getX()-1, pos.getY()-1));
        moves.add(new GameMapPosition(pos.getX()+2, pos.getY()));
        moves.add(new GameMapPosition(pos.getX()-2, pos.getY()));
        
        return moves;
    }
    @Override public void setInitialPosition(){
        pos = new GameMapPosition(0, 14);
        notifyObservers();
    }
}
