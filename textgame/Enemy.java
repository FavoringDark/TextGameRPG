package textgame;

import java.util.Random;
import java.util.Scanner;

public class Enemy {
	
	private int hp;
	private int maxhp;
	private int damage;
	private int atk;
	private int def;
	static String[] enemies = {"Undead", "Orc", "Goblin", "Slime", "Beast"};
	int maxEnemyHealth = 100;
	static int enemyAttackDamage = 25;
	
	public Enemy(int hp, int damage, int atk, int def) {
		
		this.hp = hp;
		hp = maxhp;
		this.damage = damage;
		this.atk = atk;
		this.def = def;
	}
	
	   public int getHp() {
	        return hp;
	    }

	    public int getDamage() {
	        return damage;
	    }

	    public int getAtk() {
	        return atk;
	    }

	    public int getDef() {
	        return def;
	    }
	    
	    public boolean isAlive(){
	        return hp > 0;
	    }
	    
	    static Scanner keyboard = new Scanner(System.in);
		static Random rand = new Random();
		
	public static void combat(Enemy enemy) {
		
		Player player = new Player();
		
		
boolean running = true;
		
		System.out.println("Welcome to the dungeon");
		
		GAME:
		while(running) {
			System.out.println("----------------------------------------------------");
			
			enemy.hp = rand.nextInt(enemy.maxEnemyHealth);
			String mob = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# A wild " + mob + " came out of nowhere! #\n");
			
			//when enemy is still alive
			while(enemy.hp > 0) {
				System.out.println("\tYour HP: " + player.HP);
				System.out.println("\t" + mob + "'s HP: " + enemy.hp);
				System.out.println("\nWhat do you want to do against the wild " + mob + "?");
				System.out.println("\n\t1. Fight!");
				System.out.println("\t2. Heal up!");
				System.out.println("\t3. Run!");
				
				String input = keyboard.nextLine();
				if(input.equals("1")) {
					int damageDealt = rand.nextInt(player.attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					enemy.hp -= damageDealt;
					player.HP -= damageTaken;
					
					System.out.println("\t> You attacked the wild " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t> " + enemy + " struck back and dealt " + damageTaken + " damage in retaliation!");
					
					if(player.HP < 1) {
						System.out.println("\t> You have taken too much damage, you are too weak to continue...");
						break;
					}
					
				} else if(input.equals("2")) {
					if(player.numPotions > 0) {
						player.heal();
						System.out.println("\t> You drink the potion, healing for " + player.healAmount + "."
										 + "\n\t> You now have " + player.HP + " HP."
										 + "\n\t> You now have " + player.numPotions + " health potions left.\n");
											
					} else {
						System.out.println("You have no health potions left.");
					}
					
				} else if(input.equals("3")) {
					System.out.println("\tYou run away from the wild " + enemy + "!");
					continue GAME;
				} else {
					System.out.println("\tPress an option (1-3)");
				}
				
			}
			//when you die
			if(player.HP <1) {
				System.out.println("You slump to the ground and slowly drift away...");
				break;
			}
			//when enemy is dead
			
			int expPoints = rand.nextInt(50, 100);
			player.xp += expPoints;
			System.out.println("----------------------------------------------------");
			System.out.println(" # " + mob + " was defeated! # ");
			
			//EXPERIENCE SYSTEM (WIP)
//			boolean leveledAlready1 = true;
//			var leveledAlready2 = true;
//			var leveledAlready3 = true;
//			var leveledAlready4 = true;
//			var leveledAlready5 = true;
//			var leveledAlready6 = true;
//			var leveledAlready7 = true;
//			var leveledAlready8 = true;
//			
//			
//			System.out.println("You gained " + expPoints + " experience! You know have " + playerexp + " points!");
//			if(playerexp >= requiredXP[0] && playerexp < requiredXP[1] && leveledAlready1 == true) {
//				System.out.println("You begin to learn about the world around you. You are now a " + currentLevel[0] + " at best.");
//				leveledAlready1 = false;
//			} else if (playerexp >= requiredXP[1] && playerexp < requiredXP[2] && leveledAlready2) {
//				System.out.println("Congratulations. You are now a " + currentLevel[1] + "!");
//				leveledAlready2 = false;
//			} else if (playerexp >= requiredXP[2] && playerexp < requiredXP[3] && leveledAlready3) {
//				System.out.println("Congratulations. You are now a " + currentLevel[2] + "!");
//				leveledAlready3 = false;
//			} else if (playerexp >= requiredXP[3] && playerexp < requiredXP[4] && leveledAlready4) {
//				System.out.println("Congratulations. You are now a " + currentLevel[3] + "!");
//				leveledAlready4 = false;
//			} else if (playerexp >= requiredXP[4] && playerexp < requiredXP[5] && leveledAlready5) {
//				System.out.println("Congratulations. You are now a " + currentLevel[4] + "!");
//				leveledAlready5 = false;
//			} else if (playerexp >= requiredXP[5] && playerexp < requiredXP[6] && leveledAlready6) {
//				System.out.println("Congratulations. You are now a " + currentLevel[5] + "!");
//				leveledAlready6 = false;
//			} else if (playerexp >= requiredXP[6] && playerexp < requiredXP[7] && leveledAlready7) {
//				System.out.println("Congratulations. You are now a " + currentLevel[6] + "!");
//				leveledAlready7 = false;
//			} else if (playerexp >= requiredXP[7] && leveledAlready8) {
//				System.out.println("Congratulations. You are now a " + currentLevel[7] + "!");
//				leveledAlready8 = false;
//			} 
	
			System.out.println(" # You have " + player.HP + " HP left! # ");
			if(rand.nextInt(100) < player.dropChance) {
				player.numPotions++;
				System.out.println(" # The " + mob + " faded away and left a health potion in its place!");
				System.out.println(" # You now have " + player.numPotions + " health potions in your inventory.");
			}
				System.out.println("----------------------------------------------------");
				System.out.println("What do you want to do now?");
				System.out.println("1. Continue fighting");
				System.out.println("2. Give up");
				
				String input = keyboard.nextLine();
				
				while(!input.equals("1") && !input.equals("2")) {
					System.out.println("Invalid command...");
					input = keyboard.nextLine();
				}
				
				if(input.equals("1")) {
					System.out.println("You continue walking through the area...");
				} else if(input.equals("2")) {
					System.out.println("You fall to the floor in defeat and sleep forever");
					break;
				}
	}
}
}


		
	
	

