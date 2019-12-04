package ru.kalispeller.HackedClient.event.events;

import net.minecraft.network.Packet;
import ru.kalispeller.HackedClient.event.Event;

public class EventReceivePacket extends Event {
    private Packet packet;

    public EventReceivePacket(Packet packet) {
        this.packet = packet;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }
}
