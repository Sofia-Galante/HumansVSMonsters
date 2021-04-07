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
public class SpeedUPTest {
    
    public SpeedUPTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of use method, of class SpeedUP.
     */
    @Test
    public void testUse() {
        System.out.println("use");
        SpeedUP speedUP = new SpeedUP();
        Monster monster = new Monster(speedUP);
        assertTrue(speedUP.canUse(monster));
        monster.use(speedUP, monster);
        assertEquals(10+monster.getHp()*20/100, monster.getSpeed());
        
        assertEquals(monster.getMaxMp()-15,monster.getMp());
        assertFalse(speedUP.canUse(monster));
    }
    
    
    public class Monster extends RealCharacter {
        public Monster(ObjectOrAbility ability){
            id = "M00";
            name = "Monster";
            maxHp = 30;
            hp = maxHp;
            maxMp = 15;
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