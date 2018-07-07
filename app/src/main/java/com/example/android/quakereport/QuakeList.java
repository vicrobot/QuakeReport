//package name
package com.example.android.quakereport;

// class defining

/**
 * This is the class that is used to get specific object containing a double, a string, and
 * an integer. There are getters methods for accessing them too.
 */
public class QuakeList {

    //Declaring the necessary variables in a global environment
    private double mVar1;
    private String mVar2;
    private int mVar3;

    QuakeList(double var1, String var2, int var3){

        // assigning the values to the global variables.
        mVar1 = var1;
        mVar2 = var2;
        mVar3 = var3;
    }

    // getters method
    public double getIntensity(){ return mVar1;}
    public String getPlace(){ return mVar2;}
    public int getDate(){ return mVar3;}

}

