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


class Dragon extends RealCharacter{
    static private Dragon instance;
    
    private Dragon(){
        id = "M03";
        name = "Dragon";
        maxHp = 150;
        hp = maxHp;
        maxMp = 120;
        mp = maxMp;
        strength = 30;
        defence = 20;
        speed = 25;

        usables = new ArrayList();
        usables.add(new StrengthUP());
        usables.add(new Cure());
    }
    static public Dragon instantiate(){
        if (instance == null){
            instance = new Dragon();
        }
        return instance;
    }
    @Override public ArrayList<GameMapPosition> getMoves(){
        ArrayList<GameMapPosition> moves = new ArrayList();
       
        moves.add(new GameMapPosition(pos.getX()+3, pos.getY()+3));
        moves.add(new GameMapPosition(pos.getX()+3, pos.getY()-3));
        moves.add(new GameMapPosition(pos.getX()+1, pos.getY()-1));
        moves.add(new GameMapPosition(pos.getX()+1, pos.getY()+1));
        moves.add(new GameMapPosition(pos.getX()-1, pos.getY()+1));
        moves.add(new GameMapPosition(pos.getX()-1, pos.getY()-1));
        moves.add(new GameMapPosition(pos.getX()-3, pos.getY()+3));
        moves.add(new GameMapPosition(pos.getX()-3, pos.getY()-3));
        
        return moves;
    }
    @Override public void setInitialPosition(){
        pos = new GameMapPosition(19, 0);
        notifyObservers();

    }
}
