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
import org.junit.Ignore;
import static org.junit.Assert.*;

/**
 *
 * @author Sofy
 */
public class PotionTest {
    
    public PotionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of use method, of class Potion.
     */
    @Test
    public void test1Use() {
        System.out.println("use: notOverMaxHP");
        Potion potion= new Potion(1);
        Human human = new Human(3, potion);
        assertTrue(potion.canUse(human));
        human.use(potion, human);
        assertEquals(23, human.getHp());
        assertFalse(potion.canUse(human));
    }
    
    @Test
    public void test2Use() {
        System.out.println("use: overMaxHP");
        Potion potion= new Potion(1);
        Human human = new Human(12, potion);
        assertTrue(potion.canUse(human));
        human.use(potion, human);
        assertEquals(human.getMaxHp(), human.getHp());
    }
    
    
    public class Human extends RealCharacter {
        public Human(int hp, ObjectOrAbility obj){
            id = "H00";
            name = "Human";
            maxHp = 30;
            this.hp = hp;
            maxMp = 10;
            mp = maxMp;
            strength = 10;
            defence = 10;
            speed = 10;
            pos = new GameMapPosition(0, 0);
        
            usables = new ArrayList();
            usables.add(obj);
        }
        
        public ArrayList<GameMapPosition> getMoves(){
        ArrayList<GameMapPosition> moves = new ArrayList();
        return moves;
        }
        public void setInitialPosition(){
            
        }   
    }
    
    
}
