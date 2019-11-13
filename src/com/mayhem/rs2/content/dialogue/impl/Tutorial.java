package com.mayhem.rs2.content.dialogue.impl;

import com.mayhem.rs2.content.StarterKit;
import com.mayhem.rs2.content.dialogue.Dialogue;
import com.mayhem.rs2.content.dialogue.DialogueManager;
import com.mayhem.rs2.content.dialogue.Emotion;
import com.mayhem.rs2.entity.Location;
import com.mayhem.rs2.entity.player.Player;
import com.mayhem.rs2.entity.player.controllers.DefaultController;
import com.mayhem.rs2.entity.player.net.out.impl.SendInterface;
import com.mayhem.rs2.entity.player.net.out.impl.SendSidebarInterface;

public class Tutorial extends Dialogue {

	public static class TutorialController extends DefaultController {

		@Override
		public boolean canAttackNPC() {
			return false;
		}

		@Override
		public boolean canClick() {
			return false;
		}

		@Override
		public boolean canMove(Player p) {
			return false;
		}

		@Override
		public boolean canTeleport() {
			return false;
		}

		@Override
		public boolean canTrade() {
			return false;
		}

		@Override
		public void onDisconnect(Player p) {
		}

		@Override
		public boolean transitionOnWalk(Player p) {
			return false;
		}
	}

	public static final TutorialController TUTORIAL_CONTROLLER = new TutorialController();

	public static final int GUIDE = 306;

	public Tutorial(Player player) {
		this.player = player;
		player.setController(TUTORIAL_CONTROLLER);
	}

	@Override
	public boolean clickButton(int id) {
		switch (id) {
		case 9157:
			if (option == 1) {
				next = 3;
				execute();
			}
			return true;
		case 9158:
			if (option == 1) {
				next = 2;
				execute();
			}
			return true;
		}
		return false;
	}

	public static final int[] SIDEBAR_INTERFACE_IDS = { -1, -1, -1, 3213, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

	@Override
	public void execute() {

		for (int i = 0; i < SIDEBAR_INTERFACE_IDS.length; i++) {
			player.send(new SendSidebarInterface(i, SIDEBAR_INTERFACE_IDS[i]));
		}
		
		switch (next) {
		
		case 0:
			end();
			StarterKit.handle(player, 202051);
			player.send(new SendInterface(51750));
			break;
		}

	}

	public void nChat(String[] chat) {
		DialogueManager.sendNpcChat(player, GUIDE, Emotion.HAPPY_TALK, chat);
		next += 1;
	}

	public void pChat(String[] chat) {
		DialogueManager.sendPlayerChat(player, Emotion.HAPPY, chat);
		next += 1;
	}

	public void tele(int x, int y) {
		player.teleport(new Location(x, y, 0));
	}

	public void tele(int x, int y, int z) {
		player.teleport(new Location(x, y, z));
	}
}
