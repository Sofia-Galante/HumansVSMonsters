/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humansvsmonsters;

import java.util.HashMap;

/**
 *
 * @author Sofy
 */
class CharactersByID {
    private HashMap<String, ProxyCharacter> characterByID;
    
    public CharactersByID(){
        characterByID = new HashMap();
    }
    
    public void add(ProxyCharacter c){
        characterByID.put(c.getId(), c);
    }
    
    public ProxyCharacter get(String id){
        return characterByID.get(id);
    }
}
