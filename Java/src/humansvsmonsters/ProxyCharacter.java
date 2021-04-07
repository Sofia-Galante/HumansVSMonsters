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
class ProxyCharacter implements Character{
    final private RealCharacter character;
    final private Network network;
    
    ProxyCharacter(RealCharacter character, Network network){
        this.character = character;
        this.network = network;
    }
    
    public void decode(String packet){
        //decodifica i dati ricevuti dal network e modifica il personaggio di conseguenza
    }
    
    @Override public String getName(){
        return character.getName();
    }
    @Override public int getHp(){
        return character.getHp();
    }
    @Override public void setHp(int hp){
        network.send(this.getId());
        character.setHp(hp);
    }
    @Override public int getMaxHp(){
        return character.getMaxHp();
    }
    @Override public int getMp(){
        return character.getMp();
    }
    @Override public void setMp(int mp){
        network.send(this.getId());
        character.setHp(mp);
    }
    @Override public int getMaxMp(){
        return character.getMaxMp();
    }
    @Override public int getStrength(){
        return character.getStrength();
    }
    @Override public void setStrength(int strength){
        character.setStrength(strength);
    }
    @Override public int getDefence(){
        return character.getDefence();
    }
    @Override public void setDefence(int defence){
        character.setDefence(defence);
    }
    @Override public int getSpeed(){
        return character.getSpeed();
    }
    @Override public void setSpeed(int speed){
        character.setSpeed(speed);
    }
    @Override public boolean isCurrent(){
        return character.isCurrent();
    }
    @Override public void setCurrent(boolean current){
        String packet = character.getId()+" setCurrent ";
        if (current)
            packet+= "1";
        else
            packet+="0";
        network.send(packet);
        character.setCurrent(current);
    }
    @Override public boolean isAlive(){
        return character.isAlive();
    }
    @Override public String getId(){
        return character.getId();
    }
    
    @Override public GameMapPosition getPos(){
        return character.getPos();
    }
    
    @Override public void setInitialPosition(){
        character.setInitialPosition();
    }
    
    @Override public ArrayList<GameMapPosition> getMoves(){
        return character.getMoves();
    }
    @Override public void attacked(int damage){
        character.attacked(damage);
    }
    @Override public void attack(Character enemy){
        String packet = character.getId()+" attacks "+enemy.getId();
        network.send(packet);
        character.attack(enemy);
    }
    @Override public void move(GameMapPosition pos){
        String packet = character.getId()+" movesTo "+pos.getX()+","+pos.getY();
        network.send(packet);
        character.move(pos);
    }
    @Override public ArrayList<ObjectOrAbility> getObjectsOrAbilities(){
        return character.getObjectsOrAbilities();
    }
    @Override public void use(ObjectOrAbility usable, Character ally){
        String packet = character.getId()+" uses "+usable.getName()+" on "+ally.getId();
        network.send(packet);
        character.use(usable, ally);
    }
}
