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
class GameMapPosition {
    private int x;
    private int y;
    
    public GameMapPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override public boolean equals(Object o){
        if (this == o)
            return true;
        
        if (!(o instanceof GameMapPosition)) {
            return false;
        }
        
        GameMapPosition pos = (GameMapPosition) o;
        
        if(pos.x==this.x && pos.y==this.y)
            return true;
        
        return false;
    }
    
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean isNextTo(GameMapPosition pos){
        int dX = Math.abs(pos.x - this.x);
        int dY = Math.abs(pos.y - this.y);
        if ((dX == 1 && dY == 0) || (dX == 0 && dY == 1))
            return true;
        return false;
    }
}
