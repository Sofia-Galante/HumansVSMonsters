/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humansvsmonsters;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sofy
 */
public class CureTest {
    
    public CureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of use method, of class Cure.
     */
    @Test
    public void test1Use() {
        System.out.println("use: notOverMaxHP");
        Cure cure = new Cure();
        Monster monster = new Monster(10, cure);
        assertTrue(cure.canUse(monster));
        monster.use(cure, monster);
        assertEquals(10+monster.getHp()*20/100, monster.getHp());
        
        assertEquals(monster.getMaxMp()-10,monster.getMp());
        assertFalse(cure.canUse(monster));
    }
    
    @Test
    public void test2Use() {
        System.out.println("use: overMaxHP");
        Cure cure = new Cure();
        Monster monster = new Monster(19, cure);
        assertTrue(cure.canUse(monster));
        monster.use(cure, monster);
        assertEquals(monster.getMaxHp(), monster.getHp());
        
        assertEquals(monster.getMaxMp()-10,monster.getMp());
        assertFalse(cure.canUse(monster));
    }
    
    
    public class Monster extends RealCharacter {
        public Monster(int hp, ObjectOrAbility ability){
            id = "M00";
            name = "Monster";
            maxHp = 20;
            this.hp = hp;
            maxMp = 10;
            mp = maxMp;
            strength = 10;
            defence = 10;
            speed = 10;
            pos = new GameMapPosition(0, 0);
        
            usables = new ArrayList();
            usables.add(ability);
        }
        
        public ArrayList<GameMapPosition> getMoves(){
        ArrayList<GameMapPosition> moves = new ArrayList();
        return moves;
        }
        public void setInitialPosition(){
            
        }
    }
}