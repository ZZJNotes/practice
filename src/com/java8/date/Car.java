package com.java8.date;

/**
 * @Author zzj
 * @Date 2021/5/19 10:21
 * @Description
 */

class Car extends Vehicle
{
    public static void main (String[] args)
    {
        new  Car(). run();
    }
    private final void run()
    {
        System. out. println ("Car");
    }
}
class Vehicle
{
    private final void run()
    {
        System. out. println("Vehicle");
    }
}