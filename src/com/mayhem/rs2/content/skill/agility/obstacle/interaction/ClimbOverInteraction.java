package com.mayhem.rs2.content.skill.agility.obstacle.interaction;

import com.mayhem.core.task.TaskQueue;
import com.mayhem.core.task.impl.ForceMoveTask;
import com.mayhem.rs2.entity.Animation;
import com.mayhem.rs2.entity.Location;
import com.mayhem.rs2.entity.player.Player;

public interface ClimbOverInteraction extends ObstacleInteraction {
	
	@Override
	public default void start(Player player) {
		// Climbing has nothing special on start up.
	}
	
	@Override
	public default void onExecution(Player player, Location start, Location end) {
		player.getUpdateFlags().sendAnimation(new Animation(getAnimation()));
		TaskQueue.queue(new ForceMoveTask(player, 1, player.getLocation(), new Location(2, 0), 839, 0, 45, 1));
	}
	
	@Override
	public default void onCancellation(Player player) {
		// Climbing has nothing special on cancellation.
	}
}