/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humansvsmonsters;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Ignore;

import java.util.ArrayList;

/**
 *
 * @author Sofy
 */
public class GameTest {
    
    public GameTest() {
    }
    
    static RealCharacterImp h1;
    static RealCharacterImp h2;
    static RealCharacterImp h3;
    static RealCharacterImp m1;
    static RealCharacterImp m2;
    static RealCharacterImp m3;
    
    static ProxyCharacter pH1;
    static ProxyCharacter pH2;
    static ProxyCharacter pH3;
    static ProxyCharacter pM1;
    static ProxyCharacter pM2;
    static ProxyCharacter pM3;
    
    static ArrayList<Character> myTeam;
    static ArrayList<Character> enemyTeam;
    
    static Game g;
    
    
    
    @BeforeClass
    public static void setUpClass() {
        CharactersByID cID = new CharactersByID();
        
        
        h1 = new RealCharacterImp("H01", "archer");
        h2 = new RealCharacterImp("H02", "warrior");
        h3 = new RealCharacterImp("H03", "mage");
        m1 = new RealCharacterImp("M01", "slime");
        m2 = new RealCharacterImp("M02", "goblin");
        m3 = new RealCharacterImp("M03", "dragon");
        Network network = new Network(cID);
        pH1 = new ProxyCharacter(h1, network);
        pH2 = new ProxyCharacter(h2, network);
        pH3 = new ProxyCharacter(h3, network);
        pM1 = new ProxyCharacter(m1, network);
        pM2 = new ProxyCharacter(m2, network);
        pM3 = new ProxyCharacter(m3, network);
        
        
        myTeam = new ArrayList();
        enemyTeam = new ArrayList();
        cID.add(pH1);
        cID.add(pH2);
        cID.add(pH3);
        cID.add(pM1);
        cID.add(pM2);
        cID.add(pM3);
        myTeam.add(pH1);
        myTeam.add(pH2);
        myTeam.add(pH3);
        enemyTeam.add(pM1);
        enemyTeam.add(pM2);
        enemyTeam.add(pM3);
        
        StatusBar sB = new StatusBar(cID);
        
        g = new Game(myTeam, enemyTeam, cID, sB);
        
        
        h1.attach(g);
        h2.attach(g);
        h3.attach(g);
        m1.attach(g);
        m2.attach(g);
        m3.attach(g);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp(){
        h1.reset();
        h2.reset();
        h3.reset();
        m1.reset();
        m2.reset();
        m3.reset();
    }

    /**
     * Test of update method, of class Game.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        assertTrue(myTeam.contains(pH1));
        m1.attack(h1);
        assertFalse(h1.isAlive());
        assertFalse(myTeam.contains(pH1));
        
        assertTrue(enemyTeam.contains(pM1));
        h2.attack(m1);
        assertFalse(m1.isAlive());
        assertFalse(enemyTeam.contains(pM1));
    } 

    /**
     * Test of startRound method, of class Game.
     */
    @Test
    public void test1OnPass() {
        System.out.println("onPass: checkOrderQueue(differentSpeed)");
        h1.setSpeed(1);
        h2.setSpeed(2);
        h3.setSpeed(3);
        m1.setSpeed(4);
        m2.setSpeed(5);
        m3.setSpeed(6);
        
        assertFalse(h1.isCurrent());
        assertFalse(h2.isCurrent());
        assertFalse(h3.isCurrent());
        assertFalse(m1.isCurrent());
        assertFalse(m2.isCurrent());
        assertFalse(m3.isCurrent());
        
        g.onStartGame();
        assertTrue(m3.isCurrent());
        g.onPass();
        assertFalse(m3.isCurrent());
        assertTrue(m2.isCurrent());
        g.onPass();
        assertFalse(m2.isCurrent());
        assertTrue(m1.isCurrent());
        g.onPass();
        assertFalse(m1.isCurrent());
        assertTrue(h3.isCurrent());
        g.onPass();
        assertFalse(h3.isCurrent());
        assertTrue(h2.isCurrent());
        g.onPass();
        assertFalse(h2.isCurrent());
        assertTrue(h1.isCurrent());
    }
    
    @Test
    public void test2OnPass() {
        System.out.println("onPass: checkOrderQueue(sameSpeed)");
        
        assertFalse(h1.isCurrent());
        assertFalse(h2.isCurrent());
        assertFalse(h3.isCurrent());
        assertFalse(m1.isCurrent());
        assertFalse(m2.isCurrent());
        assertFalse(m3.isCurrent());
        
        g.onStartGame();
        assertTrue(h1.isCurrent());
        g.onPass();
        assertFalse(h1.isCurrent());
        assertTrue(h2.isCurrent());
        g.onPass();
        assertFalse(h2.isCurrent());
        assertTrue(h3.isCurrent());
        g.onPass();
        assertFalse(h3.isCurrent());
        assertTrue(m1.isCurrent());
        g.onPass();
        assertFalse(m1.isCurrent());
        assertTrue(m2.isCurrent());
        g.onPass();
        assertFalse(m2.isCurrent());
        assertTrue(m3.isCurrent());
    }
    
    static public class RealCharacterImp extends RealCharacter{
        RealCharacterImp(String id, String name){
            this.id = id;
            this.name = name;
            maxHp = 1;
            hp = maxHp;
            maxMp = 10;
            mp = maxMp;
            strength = 10;
            defence = 2;
            speed = 10;
        
            usables = new ArrayList();
        }
        
        public void reset(){
            speed = 10;
            current = false;
        }
                
        public ArrayList<GameMapPosition> getMoves(){
        return new ArrayList();
        }
        public void setInitialPosition(){
        }
    }
}
