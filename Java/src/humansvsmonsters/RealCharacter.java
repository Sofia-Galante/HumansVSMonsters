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
abstract class RealCharacter implements Character{
    protected String id;
    protected String name;
    protected int maxHp;
    protected int maxMp;
    protected int hp;
    protected int mp;
    protected int strength;
    protected int defence;
    protected int speed;
    protected GameMapPosition pos;
    protected ArrayList<Observer> observers;
    protected ArrayList<ObjectOrAbility> usables;
    protected boolean current;
    protected boolean alive;
    
    RealCharacter(){
        observers = new ArrayList();
        alive = true;
        current = false;
    }
    
    
    @Override public String getName(){
        return name;
    }
    @Override public int getHp(){
        return hp;
    }
    @Override public void setHp(int hp){
        if(hp > maxHp)
            hp = maxHp;
        this.hp = hp;
        notifyObservers();
    }
    @Override public int getMaxHp(){
        return maxHp;
    }
    @Override public int getMp(){
        return mp;
    }
    @Override public void setMp(int mp){
        if(mp > maxMp)
            mp = maxMp;
        this.mp = mp;
    }
    @Override public int getMaxMp(){
        return maxMp;
    }
    @Override public int getStrength(){
        return strength;
    }
    @Override public void setStrength(int strength){
        this.strength = strength;
    }
    @Override public int getDefence(){
        return defence;
    }
    @Override public void setDefence(int defence){
        this.defence = defence;
    }
    @Override public int getSpeed(){
        return speed;
    }
    @Override public void setSpeed(int speed){
        this.speed = speed;
    }
    @Override public boolean isCurrent(){
        return current;
    }
    @Override public void setCurrent(boolean current){
        this.current = current;
        notifyObservers();
    }
    @Override public boolean isAlive(){
        return alive;
    }
    @Override public String getId(){
        return id;
    }
    @Override public GameMapPosition getPos(){
        return pos;
    }

    
    public void notifyObservers(){
        for(int i=0; i<observers.size(); i++){
            observers.get(i).update(id); //passa l'id
        }
    }
    public void attach(Observer o){
        observers.add(o);
    }
    void detach(Observer o){
        observers.remove(o);
    }
    
    @Override public void attacked(int damage){
        hp -= damage;
        if(hp <= 0){
            hp = 0;
            alive = false;
        }
        notifyObservers();
    }
    @Override public void attack(Character enemy){
        int damage = (this.strength - enemy.getDefence())/enemy.getMaxHp();
        enemy.attacked(damage);
    }
    @Override public void move(GameMapPosition pos){
        this.pos = pos;
        notifyObservers();
    }
    @Override public ArrayList<ObjectOrAbility> getObjectsOrAbilities(){
        return usables;
    }
    
    @Override public void use(ObjectOrAbility usable, Character ally){
        usable.use(this, ally);
    }
}