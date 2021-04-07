/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humansvsmonsters;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sofy
 */
public class GameMapTest {
    
    static GameMap map;
    
    static RealCharacterImp h1;
    static RealCharacterImp h2;
    static RealCharacterImp m1;
    static RealCharacterImp m2;
    
    static ArrayList<Character> Humans;
    static ArrayList<Character> Monsters;
    
    public GameMapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        CharactersByID charactersByID = new CharactersByID();
                
        h1 = new RealCharacterImp("H01", "human1");
        h2 = new RealCharacterImp("H02", "human2");
        m1 = new RealCharacterImp("M01", "monster1");
        m2 = new RealCharacterImp("M02", "monster2");
        
        Network network = new Network(charactersByID);
        
        ProxyCharacter pH1 = new ProxyCharacter(h1, network);
        ProxyCharacter pH2 = new ProxyCharacter(h2, network);
        ProxyCharacter pM1 = new ProxyCharacter(m1, network);
        ProxyCharacter pM2 = new ProxyCharacter(m2, network);
        
        Humans = new ArrayList();
        Humans.add(pH1);
        Humans.add(pH2);
        
        Monsters = new ArrayList();
        Monsters.add(pM1);
        Monsters.add(pM2);
        
        charactersByID.add(pH1);
        charactersByID.add(pH2);
        charactersByID.add(pM1);
        charactersByID.add(pM2);
        
        map = new GameMap(charactersByID);
        
        h1.attach(map);
        h2.attach(map);
        m1.attach(map);
        m2.attach(map);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        h1.setInitialPosition(new GameMapPosition(0,0));
        h2.setInitialPosition(new GameMapPosition(0, 1));
        m1.setInitialPosition(new GameMapPosition(1, 0));
        m2.setInitialPosition(new GameMapPosition(1, 1));
    }
    
    @After
    public void tearDown() {
        
    }
    

    /**
     * Tests of selectMoves method, of class GameMap.
     */
    @Test
    public void test1SelectMoves() {
        System.out.println("selectMoves: noObstacles");
        
        h1.move(new GameMapPosition(11, 8));
        
        ArrayList<GameMapPosition> moves = map.selectMoves(h1);
        ArrayList<GameMapPosition> expMoves = h1.getMoves();
        assertEquals(expMoves, moves);
    }
    
    @Test
    public void test2SelectMoves() {
        System.out.println("selectMoves: withObstacles");
        
        h1.move(new GameMapPosition(11, 8));
        
        h2.move(new GameMapPosition(13, 8));
        m1.move(new GameMapPosition(11, 10));
        m2.move(new GameMapPosition(10, 7));
                
        ArrayList<GameMapPosition> moves = map.selectMoves(h1);
        ArrayList<GameMapPosition> expMoves = h1.getMoves();
        GameMapPosition h2Pos = h2.getPos();
        GameMapPosition m1Pos = m1.getPos();
        GameMapPosition m2Pos = m2.getPos();
        
        expMoves.remove(h2Pos);
        expMoves.remove(h2Pos);
        expMoves.remove(m1Pos);
        
        assertEquals(expMoves, moves);
    }
    
    @Test
    public void test3SelectMoves(){
        System.out.println("selectMoves: outOfMap");
        h1.move(new GameMapPosition(19, 13));
        
        ArrayList<GameMapPosition> moves = map.selectMoves(h1);
        ArrayList<GameMapPosition> expMoves = h1.getMoves();
        
        expMoves.remove(new GameMapPosition(20, 12));
        expMoves.remove(new GameMapPosition(21, 13));
        expMoves.remove(new GameMapPosition(20, 14));
        expMoves.remove(new GameMapPosition(19, 15));
        
        assertEquals(expMoves, moves);
    }

    /**
     * Tests of selectEnemies method, of class GameMap.
     */
    @Test
    public void test1SelectEnemies() {
        System.out.println("selectEnemies: noEnemiesOrAllies");
        h1.move(new GameMapPosition(19, 13));
        
        ArrayList<GameMapPosition> enemiesPos = map.selectEnemies(h1, Monsters);
        assertTrue(enemiesPos.isEmpty());
    }
    
    @Test
    public void test2SelectEnemies() {
        System.out.println("selectEnemies: withEnemiesAndAllies");
        h1.move(new GameMapPosition(19, 13));
        
        h2.move(new GameMapPosition(19, 12));
        m1.move(new GameMapPosition(18, 13));
        m2.move(new GameMapPosition(19, 14));
        
        ArrayList<GameMapPosition> enemiesPos = map.selectEnemies(h1, Monsters);
        ArrayList<GameMapPosition> expEnemiesPos = new ArrayList();
        expEnemiesPos.add(m1.getPos());
        expEnemiesPos.add(m2.getPos());
        assertTrue(enemiesPos.size()==expEnemiesPos.size());
        assertEquals(expEnemiesPos, enemiesPos);
    }

    /**
     * Test of selectAllies method, of class GameMap.
     */
    @Test
    public void test1SelectAllies() {
        System.out.println("selectAllies: noEnemiesOrAllies");
        h1.move(new GameMapPosition(19, 13));
        
        ArrayList<GameMapPosition> alliesPos = map.selectEnemies(h1, Humans);
        assertTrue(alliesPos.isEmpty());
    }
    
    @Test
    public void test2SelectAllies() {
        System.out.println("selectAllies: withEnemiesAndAllies");
        h1.move(new GameMapPosition(19, 13));
        
        h2.move(new GameMapPosition(19, 12));
        m1.move(new GameMapPosition(18, 13));
        m2.move(new GameMapPosition(19, 14));
        
        ArrayList<GameMapPosition> alliesPos = map.selectAllies(h1, Humans);
        ArrayList<GameMapPosition> expAlliesPos = new ArrayList();
        expAlliesPos.add(h2.getPos());
        expAlliesPos.add(h1.getPos());
        
        assertTrue(expAlliesPos.size() == alliesPos.size());
        assertEquals(expAlliesPos, alliesPos);
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
                
        public ArrayList<GameMapPosition> getMoves(){
        ArrayList<GameMapPosition> moves = new ArrayList();
        return moves;
        }
        public void setInitialPosition(GameMapPosition pos){
            this.pos = pos;
            setInitialPosition();

        }
        public void setInitialPosition(){
            notifyObservers();
        }
    }
    
}
