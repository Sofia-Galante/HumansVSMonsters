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
public class StrengthUPTest {
    
    public StrengthUPTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of use method, of class StrengthUP.
     */
    @Test
    public void testUse() {
        System.out.println("use");
        StrengthUP strengthUP = new StrengthUP();
        Monster monster = new Monster(strengthUP);
        assertTrue(strengthUP.canUse(monster));
        monster.use(strengthUP, monster);
        assertEquals(10+monster.getDefence()*15/100, monster.getStrength());
        
        assertEquals(monster.getMaxMp()-15,monster.getMp());
        assertFalse(strengthUP.canUse(monster));
    }
    
    
    public class Monster extends RealCharacter {
        public Monster(ObjectOrAbility ability){
            id = "M00";
            name = "Monster";
            maxHp = 30;
            hp = maxHp;
            maxMp = 20;
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
        }public void setInitialPosition(){
            
        }  
    }
}
