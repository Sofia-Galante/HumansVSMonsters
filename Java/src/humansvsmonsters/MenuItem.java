/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humansvsmonsters;

/**
 *
 * @author Sofy
 */
class MenuItem{
    private String text;
    private Action action;
    private Menu menu;
    
    public MenuItem(Menu menu, String text, Action action){
        this.text = text;
        this.action = action;
        this.menu = menu;
    }
    
    public void onClicked(){
        menu.setActive(this);
        action.execute();
    }
    
    public void disable(){
        //disabilità il bottone
    }
    public void enable(){
        //abilità il bottone
    }
}
