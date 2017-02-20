package com.example.effie.cleverpet;

import android.media.Image;

import static java.lang.Math.sqrt;


/**
 * Created by Effie on 2/19/2017.
 */

public class Pet {
    String name;
    String breed;
    String description;
    double[]factors;
    String pic;
    String sheltName;
    String phoneNum;
    String latAndLong;

    public Pet(String name, double hgt, double ind, double shy, String descrip, String brd, String pic, String sheltName, String phoneNum, String latAndLong){
        this.name = name;
        this.breed = brd;
        this.description = descrip;
        this.pic = pic;
        this.sheltName = sheltName;
        this.phoneNum = phoneNum;
        this.latAndLong = latAndLong;
        factors = new double[4];
        this.populateFactsArr(hgt, ind, shy, brd);
    }

    public void populateFactsArr(double hgt, double ind, double shy, String brd){
        double sum = 0;
        factors[0] = ind;
        sum += ind*ind;
        double norHgt = 30;
        factors[1] = (this.getCuteness(breed)+(hgt/norHgt))/2;
        sum += ((this.getCuteness(breed)+(hgt/norHgt))/2) * ((this.getCuteness(breed)+(hgt/norHgt))/2);
        factors[2] = 1-ind;
        sum += (1 - ind) * (1 - ind);
        factors[3] = shy;
        sum += shy * shy;

        sum = sqrt(sum);
        for (int i = 0; i < 4; i++) {
            factors[i] /= sum;
        }
    }

    public void setBreed(String brd){
        this.breed = brd;
    }

    public void setDescription(String dscrp){
        description = dscrp;
    }

    public double getCuteness(String breed){
        if (breed.equals("German Shepherd")){
            return 0.35;
        } else if (breed.equals("Maltese")){
            return 0.9;
        } else if (breed.equals("N/A")){
            return 0.3;
        } else if (breed.equals("Chihuahua")){
            return 0.02;
        } else if (breed.equals("Dachshund")){
            return 0.7;
        } else if (breed.equals("Pit Bull")){
            return 0.11;
        } else if (breed.equals("Samoyed")){
            return 0.1;
        }
        return 0.5;
    }
}