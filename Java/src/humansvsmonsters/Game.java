/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humansvsmonsters;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Sofy
 */
class Game implements Observer{
    private GameMap map;
    private Character currentCharacter;
    private ArrayList<Character> myTeam; 
    private ArrayList<Character> enemyTeam;
    private PriorityQueue<Character> order;
    private Menu actionMenu;
    private Menu useMenu;
    private ObjectOrAbility selectedUsable;
    private CharactersByID charactersByID;
    private StatusBar statusBar;
    
    public Game(ArrayList<Character> myTeam, ArrayList<Character> enemyTeam, CharactersByID characterByID, StatusBar statusBar){
        map = new GameMap(charactersByID);
        actionMenu = new Menu("Menu");
        useMenu = null;
        selectedUsable = null;
        
        actionMenu.addItem(new MenuItem(actionMenu, "Attack", new Attack(this)));
        actionMenu.addItem(new MenuItem(actionMenu, "Move", new Move(this)));
        actionMenu.addItem(new MenuItem(actionMenu, "Use", new Use(this)));
        actionMenu.addItem(new MenuItem(actionMenu, "Pass", new Pass(this)));
        
        this.myTeam = myTeam;
        this.enemyTeam = enemyTeam;
        this.charactersByID = characterByID;
        this.statusBar = statusBar;
        
        order = new PriorityQueue(new PriorityQueueComparator());
    }

    
    @Override public void update(String characterID){
        Character c = charactersByID.get(characterID);
        
        if(!c.isCurrent() && c==currentCharacter){
            currentCharacter = null;
            startTurn();
        }
        
        if(!c.isAlive()){
            if(myTeam.contains(c)){
                myTeam.remove(c);
                order.remove(c);
                statusBar.setOrder(order);
            }
            if(enemyTeam.contains(c)){
                enemyTeam.remove(c);
                order.remove(c);
                statusBar.setOrder(order);
            }
        }
        
        if(myTeam.isEmpty() || enemyTeam.isEmpty()){
            //chiede al FrontEnd di uscire dal programma
        }
    }
    
    public void startRound(){
        for (int i = 0; i<myTeam.size(); i++)
            order.add(myTeam.get(i));
        for (int i = 0; i<enemyTeam.size(); i++)
            order.add(enemyTeam.get(i));
    }
    
    public void startTurn(){
        if (order.isEmpty())
            startRound();
        currentCharacter = order.remove();
        statusBar.setOrder(order);
        currentCharacter.setCurrent(true);
        if(myTeam.contains(currentCharacter)){
            actionMenu.enableAll();
            actionMenu.show();
        }
    }
    
    public void onStartGame(){
        startTurn();
        for(int i=0; i<myTeam.size(); i++)
            myTeam.get(i).setInitialPosition();
        for(int i=0; i<enemyTeam.size(); i++)
            enemyTeam.get(i).setInitialPosition();
        
    }
    
    public void onCancel(){
        if(useMenu != null){
            selectedUsable = null;
            useMenu.setActive(null);
            useMenu.show();
        }
        else{
            actionMenu.setActive(null);
            actionMenu.show();
        }
    }
    
    public void onCancelUseMenu(){
        useMenu.hide();
        useMenu = null;
        onCancel();
    }
    
    public void onMoveCharacter(GameMapPosition click){
        currentCharacter.move(click);
        actionMenu.disableActiveItem();
        actionMenu.show();
    }
    
    public void onAttackWithCharacter(GameMapPosition click){
        Character enemy = map.getCharacter(click);
        currentCharacter.attack(enemy);
        actionMenu.disableActiveItem();
        actionMenu.show();
    }
    
    public void onUseWithCharacter(GameMapPosition click){
        Character ally = map.getCharacter(click);
        currentCharacter.use(selectedUsable, ally);
        selectedUsable = null;
        useMenu = null;
        actionMenu.disableActiveItem();
        actionMenu.show();
    }
    
    public void onPass(){
        currentCharacter.setCurrent(false);
    }
    
    public void showMoves(){
        
        ArrayList<GameMapPosition> possibleMoves = map.selectMoves(currentCharacter);
        actionMenu.hide();
        //mostra le mosse possibili a schermo
    }
    
    public void showEnemies(){
        ArrayList<GameMapPosition> enemiesPos = map.selectEnemies(currentCharacter, enemyTeam);
        actionMenu.hide();
        //mostra i nemici che puoi attaccare
    }
    
    public void showAllies(ObjectOrAbility usable){
        selectedUsable = usable;
        ArrayList<GameMapPosition> alliesPos = map.selectAllies(currentCharacter, myTeam);
        useMenu.hide();
        //mostra gli alleati su cui si può usare un oggetto/abilità
    }
    
    public void showObjectsOrAbilities(){
        ArrayList<ObjectOrAbility> usables = currentCharacter.getObjectsOrAbilities();
        useMenu = new Menu("Use");
        for (int i=0; i<usables.size(); i++){
            ObjectOrAbility item = usables.get(i);
            if(item.canUse(currentCharacter))
                useMenu.addItem(new MenuItem(useMenu, item.getLabel(), item.getAction(this)));
        }
        actionMenu.hide();
        useMenu.show();
    }
}
