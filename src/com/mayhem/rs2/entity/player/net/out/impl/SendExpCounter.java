package com.mayhem.rs2.entity.player.net.out.impl;

import com.mayhem.core.network.StreamBuffer;
import com.mayhem.rs2.entity.player.net.Client;
import com.mayhem.rs2.entity.player.net.out.OutgoingPacket;

public class SendExpCounter extends OutgoingPacket {

	private  int skill;

	private final int exp;

	public SendExpCounter(int skill, int exp) {
		this.skill = skill;
		this.exp = exp;
	}

	@Override
	public void execute(Client client) {
		if(skill == 21) {
			skill = 22;
		}
		StreamBuffer.OutBuffer out = StreamBuffer.newOutBuffer(10);
		client.getPlayer().addCounterExp(exp);
		out.writeHeader(client.getEncryptor(), 127);
		out.writeByte(skill);
		out.writeInt(exp);
		out.writeInt((int) client.getPlayer().getCounterExp());
		client.send(out.getBuffer());
		
	}

	@Override
	public int getOpcode() {
		return 127;
	}

}
