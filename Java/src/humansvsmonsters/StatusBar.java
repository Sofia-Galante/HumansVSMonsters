/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humansvsmonsters;

import java.util.Queue;

/**
 *
 * @author Sofy
 */
class StatusBar implements Observer{
    CharactersByID characterByID;
    
    public StatusBar(CharactersByID characterByID){
        this.characterByID = characterByID;
    }
    
    @Override public void update(String id){
        Character c = characterByID.get(id);
        //se il personaggio è quello corrente, lo mostra a schermo, altrimenti lo ignora
        if(c.isCurrent()){
            //mostra il nome del personaggio, hp e mp.
        }
    }
    
    public void setOrder(Queue<Character> order){
        //mostra a schermo l'ordine di gioco
    }
}
