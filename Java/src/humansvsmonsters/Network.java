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
class Network{
    private CharactersByID characterByID;
    
    public Network(CharactersByID characterByID){
        this.characterByID = characterByID;
    }
    
    public void send(String packet){
        //invia informazioni attaverso la rete...
    }
    
    public void receive(String packet){
        //riceve informazioni dalla rete...
        //utilizza la tabella per inviare il packet al Proxy corrispondente
        String id = packet.substring(0, 3);
        characterByID.get(id).decode(packet);
    }
}
