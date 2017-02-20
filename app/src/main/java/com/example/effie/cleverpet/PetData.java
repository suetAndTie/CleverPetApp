package com.example.effie.cleverpet;
/**
 * Class: PetData
 * --------------
 * This class has the getData function that takes in a url and uses the IBM Watson
 * Alchemy NLP API to analyze the posts on the website.
 * Created by T on 2/19/2017.
 *
 */

import android.os.AsyncTask;

import java.net.URL;
import java.util.*;
import com.ibm.watson.developer_cloud.alchemy.v1.*;
import com.ibm.watson.developer_cloud.alchemy.v1.model.*;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class PetData extends AsyncTask<URL, Integer, Double[]> {
//    public static void main(String[] args) {
//        getData("https://twitter.com/suet_and_tie");
//        System.out.println("Hello, World!");
//    }


    private Exception exception;

    protected Double[] doInBackground(URL... urls) {
        try {
            String url = urls[0].toString();
            Double[] result = new Double[4];
            String api_key = "fdc2baa279d2cc824ac04f9ccfebf86795432fc3";
            AlchemyLanguage service = new AlchemyLanguage();
            service.setApiKey(api_key);

            Map<String, Object> params = new HashMap<String, Object>();
            params.put(AlchemyLanguage.URL, url);
            DocumentEmotion emotion = service.getEmotion(params).execute();
            DocumentEmotion.Emotion emstats = emotion.getEmotion();

            result[0] = emstats.getDisgust();
            result[1] = emstats.getFear();
            result[2] = emstats.getJoy();
            result[3] = emstats.getSadness();

            return result;
        } catch (Exception e) {
            this.exception = e;

            return null;
        }
    }
}

