package com.mayhem.rs2.content;

import com.mayhem.core.util.Utility;
import com.mayhem.rs2.entity.Animation;
import com.mayhem.rs2.entity.Graphic;
import com.mayhem.rs2.entity.World;
import com.mayhem.rs2.entity.item.Item;
import com.mayhem.rs2.entity.player.Player;
import com.mayhem.rs2.entity.player.net.out.impl.SendMessage;

/**
 * Handles crystal chest
 * 
 * @author Daniel
 *
 */
public class YanChest {
	
	static int yanchest;
	
	public static final Item[] RARE_CHEST_REWARDS = { new Item(2577), new Item(2579), new Item(2581), };

	/**
	 * Searches the chest
	 * 
	 * @param player
	 * @param x
	 * @param y
	 */

	public static void searchChest(final Player player, final int x, final int y) {
		if(System.currentTimeMillis() - player.yanchestTimer > yanchest){
			yanchest = 10000;
			player.yanchestTimer = System.currentTimeMillis();
			player.getUpdateFlags().sendAnimation(new Animation(881));
			Item itemReceived;
			switch (Utility.random(5)) {
			case 5:
				player.getUpdateFlags().sendGraphic(Graphic.lowGraphic(223, 0));
				itemReceived = Utility.randomElement(RARE_CHEST_REWARDS);
				player.getInventory().addOrCreateGroundItem(itemReceived.getId(), itemReceived.getAmount(), true);
				player.send(new SendMessage("You find " + Utility.determineIndefiniteArticle(itemReceived.getDefinition().getName()) + " " + itemReceived.getDefinition().getName() + " in the chest."));
				World.sendGlobalMessage("<col=FF2D00><shad=0>" + player.getPlayer().getUsername() + " recieved: " + itemReceived.getDefinition().getName() + " from the Yanille Chest!.");
				break;
			default:
				player.getInventory().add(new Item(995, Utility.random(10000)));
			}
	} else {
		player.send(new SendMessage("This chest is currently cooling down."));
		}
	}
}

