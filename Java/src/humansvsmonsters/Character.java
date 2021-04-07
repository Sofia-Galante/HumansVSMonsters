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

interface Character {
   public ArrayList<GameMapPosition> getMoves();
   public void attacked(int damage);
   public void attack(Character enemy);
   public void move(GameMapPosition pos);
   public ArrayList<ObjectOrAbility> getObjectsOrAbilities();
   public void use(ObjectOrAbility usable, Character ally);
   public void setInitialPosition();
   
   public String getName();
   public int getHp();
   public void setHp(int hp);
   public int getMaxHp();
   public int getMp();
   public void setMp(int mp);
   public int getMaxMp();
   public int getStrength();
   public void setStrength(int strength);
   public int getDefence();
   public void setDefence(int defence);
   public int getSpeed();
   public void setSpeed(int speed);
   public boolean isCurrent();
   public void setCurrent(boolean current);
   public boolean isAlive();
   public String getId();
   public GameMapPosition getPos();
}