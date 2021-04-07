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
public class FortifyingLotionTest {
    
    public FortifyingLotionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of use method, of class FortifyingLotion.
     */
    @Test
    public void testUse() {
        System.out.println("use");
        FortifyingLotion lotion= new FortifyingLotion(1);
        Human human = new Human(lotion);
        assertTrue(lotion.canUse(human));
        human.use(lotion, human);
        assertEquals(14, human.getDefence());
        
        assertFalse(lotion.canUse(human));
    }
    
    
    public class Human extends RealCharacter {
        public Human(ObjectOrAbility obj){
            id = "H00";
            name = "Human";
            maxHp = 30;
            hp = maxHp;
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