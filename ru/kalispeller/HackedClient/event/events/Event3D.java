package ru.kalispeller.HackedClient.event.events;

import ru.kalispeller.HackedClient.event.Event;

public class Event3D extends Event {
    private float partialTicks;

    public Event3D(float partialTicks){
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks(){
        return partialTicks;
    }
}
