package textgame;

public class Player {

	public int HP;
	public int maxHP;
	public int xp;
	public int atk;
	public int def;
	public int lvl;
	public int attackDamage;
	public int healAmount;
	public int numPotions;
	public int dropChance;
	
	public Player() {
		HP = maxHP;
		lvl = 1;
		xp = 0;
		HP = 150;
		atk = 10;
		def = 10;
		attackDamage = 50;
		healAmount = 30;
		numPotions = 3;
		dropChance = 50;
	}

	public int getHp() {
		return HP;
	}

	public void setHP(int hp) {
		HP = hp;
	}
	
	public boolean isAlive(){
	    return HP > 0;
	}
	
	public void heal(){
	    if(numPotions > 0){
	        numPotions--;
	        HP = maxHP;
	       
	    }
	  
	    
	

}
}

