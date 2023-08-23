package com.example.app.SetDistance;

import com.example.app.model.LocationRequest;

public class SetDistance {

    LocationRequest inf = new LocationRequest();

    public double GenerateDistance(int budget) {
        inf.setBudget(budget/2);
        double distance;
        if (inf.getBudget()>=300){
            distance=(double)inf.getBudget()/50;
        }else{
            distance=2.0;
        }
        return distance;
    }
}
