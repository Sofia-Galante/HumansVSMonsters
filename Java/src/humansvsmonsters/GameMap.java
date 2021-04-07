/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humansvsmonsters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Sofy
 */

class GameMap implements Observer{
    
    private int width;
    private int height;
    private HashMap<Character, GameMapPosition> takenPositions;
    private CharactersByID charactersByID;
    
    public GameMap(CharactersByID charactersByID){
        width = 20;
        height = 15;
        takenPositions = new HashMap();
        this.charactersByID = charactersByID;
    }
    
    public boolean isMovePossible(GameMapPosition move){ 
        if((move.getX() < 0) || (move.getX() >= width))
            return false;
        else if((move.getY() < 0) || (move.getY() >= height))
            return false;
        else if(takenPositions.containsValue(move))
            return false;
        else
            return true;
    }
    
    @Override public void update(String id){
        Character c = charactersByID.get(id);
        if(c.isAlive())
            takenPositions.put(c,c.getPos());
        else
            takenPositions.remove(c);
    }
    
    public ArrayList<GameMapPosition> selectMoves(Character c){
        ArrayList<GameMapPosition> possibleMoves = c.getMoves();
        for(int i=0; i < possibleMoves.size(); i++){
            if (isMovePossible(possibleMoves.get(i)))
                highlight(possibleMoves.get(i));
            else{
                possibleMoves.remove(i);
                i--;
            }
        }
        return possibleMoves;
    }
    
    public ArrayList<GameMapPosition> selectEnemies(Character c, ArrayList<Character> enemies){
        ArrayList<GameMapPosition> enemiesPos = new ArrayList();
        
        for (int i=0; i<enemies.size(); i++){
            Character enemy = enemies.get(i);
            if (c.getPos().isNextTo(enemy.getPos())){
                highlight(enemy.getPos());
                enemiesPos.add(enemy.getPos());
            }
        }
        return enemiesPos;
    }
    
    public ArrayList<GameMapPosition> selectAllies(Character c, ArrayList<Character> allies){
        ArrayList<GameMapPosition> alliesPos = new ArrayList();
        
        for (int i=0; i<allies.size(); i++){
            Character ally = allies.get(i);
            if (c.getPos().isNextTo(ally.getPos())){
                highlight(ally.getPos());
                alliesPos.add(ally.getPos());
            }
        }
        alliesPos.add(c.getPos());
        return alliesPos;
    }
    
    public Character getCharacter(GameMapPosition pos){
        Character c = null;
        Iterator iter = takenPositions.entrySet().iterator();
        while (iter.hasNext()) {
            HashMap.Entry entry = (HashMap.Entry) iter.next();
            if(entry.getValue() == pos)
                c = (Character) entry.getKey();
        }
        assert(c != null);
        return c;
      }
    
    public void highlight(GameMapPosition position){
        //illumina la casella e la rende cliccabile                
    }
}
