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
class Menu{
    private String title;
    private ArrayList<MenuItem> items;
    private MenuItem activeItem;
    
    public Menu(String title){
        items = new ArrayList();
        this.title = title;
    }
    
    public void addItem(MenuItem item){
        items.add(item);
    }
    
    public void hide(){
        //nasconde il Menu
    }
    public void show(){
        //mostra il Menu
    }
    public void enableAll(){
        for(int i=0; i<items.size(); i++)
            items.get(i).enable();
    }
    
    public void setActive(MenuItem item){
        activeItem = item;
    }
    
    public void disableActiveItem(){
        activeItem.disable();
        activeItem = null;
    }
}
