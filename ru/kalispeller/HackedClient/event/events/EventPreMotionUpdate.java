package ru.kalispeller.HackedClient.event.events;

import ru.kalispeller.HackedClient.event.Event;

public class EventPreMotionUpdate extends Event {
    private float yaw, pitch;
    private boolean ground;
    private double posX, posY, posZ;

    public EventPreMotionUpdate(float yaw, float pitch, boolean ground, double posX, double posY, double posZ){
        this.yaw = yaw;
        this.pitch = pitch;
        this.ground = ground;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;

    }

    public float getYaw(){
        return yaw;
    }
    public void setYaw(float yaw){
        this.yaw = yaw;
    }

    public float getPitch() {
        return pitch;
    }
    public void setPitch(float pitch){
        this.pitch = pitch;
    }

    public boolean onGround(){
        return ground;
    }
    public void setGround(boolean ground){
        this.ground = ground;
    }


}
