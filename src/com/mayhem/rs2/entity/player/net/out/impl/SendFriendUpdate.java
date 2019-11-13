package com.mayhem.rs2.entity.player.net.out.impl;

import com.mayhem.core.network.StreamBuffer;
import com.mayhem.rs2.entity.player.net.Client;
import com.mayhem.rs2.entity.player.net.out.OutgoingPacket;

public class SendFriendUpdate extends OutgoingPacket {

	private final long name;

	private final int world;

	public SendFriendUpdate(long name, int world) {
		super();
		this.name = name;
		this.world = world;
	}

	@Override
	public void execute(Client client) {
		StreamBuffer.OutBuffer out = StreamBuffer.newOutBuffer(10);
		out.writeHeader(client.getEncryptor(), 50);
		out.writeLong(name);
		int w = world;
		if (w != 0) {
			w += 9;
		}
		out.writeByte(w);
		client.send(out.getBuffer());
	}

	@Override
	public int getOpcode() {
		return 50;
	}

}
