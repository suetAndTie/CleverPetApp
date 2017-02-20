package com.example.effie.cleverpet;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentEmotion;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import stanford.androidlib.SimpleActivity;

public class PetInfo extends SimpleActivity {

    ArrayList<Pet> pets;
    Double[] personTraits = new Double[4];
    int magicNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_info);
        int chosenDog = doMagic();
        magicNumber = chosenDog;
        //Scanner scan = new Scanner(getResources().openRawResource(getResourceId(pets.get(chosenDog).name, "drawable")));
        $IV(R.id.foundDogPic).setImageResource(getResourceId(pets.get(chosenDog).pic, "drawable"));
        $TV(R.id.petDetails).setText(pets.get(chosenDog).description);
        $TV(R.id.meetDogTxt).setText("Meet " + pets.get(chosenDog).name + "!");
    }

    public int doMagic() {
        try {
            Intent intent = getIntent();
            String urlStr = intent.getStringExtra("URL");
            URL myURL = new URL(urlStr);
            PetData data = new PetData();
            data.execute(myURL);

            System.arraycopy((Double[])data.get(),0, personTraits, 0, 4);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(personTraits[i]);
        }
        pets  = new ArrayList<Pet>();

        //Pet(String name, double hgt, double ind, double shy, String descrip, String brd, String pic, String sheltName, String phoneNum, String latAndLong)
        Pet
        temp = new Pet("Fred T", 26, 0.2, 0.9, "Fred is a handsome and sweet 10 year old male German Shepherd that was owner surrendered to the Ramona Humane Society Shelter in S. Cal. His owner had him for about 6 months after they took him from his original owner which had to move to China... but decided he was too big for their home. They were very complimentary of Fred in other areas... such as he is already skilled in home-living and knows how to use a dog door and is house-trained. They also advised that he is good with kids of all sizes and also good with other dogs. In addition he has a very effective bark to alert you (and possible intruders) that this is not the right house for \"funny\" business. Fred is a big boy. At 81 lbs for his frame size, he is just a little underweight. He wants to love and be loved by his people. Although he seems to get along well with most everyone, he (like many GSDs) seems to pick a favorite person and spends allot of his time being around his favorite. At our volunteer's home this was her husband...even though she spent countless hours getting him from a precarious shelter life to a safe and loving Thulani Program temporary foster home. Fred may have some difficulty hearing high pitched or soft sounds. We need to evaluate this more however. On longer walks or during play time we noticed that Fred can sometimes tire quickly and may stop to take a break. This may be an indication that he would benefit from some more frequent and consistent moderate exercise and-or some early stage joint pain medication. Fred rode nicely in a crate in our transport car. It was a long and stressful day for him however (see last photo below) and he was a little car sick after the long drive. We are still learning more about Fred so we will be updating his bio with more details as we learn them. Fred has been accepted into the GSRNC Thulani Program and he will be headed to a Thulani Foster home where he will receive lots of the normal comforts of home as he settle in. The Thulani Program will also see that he receives updated vaccinations and other medical care necessary to his well being. In addition, The Thulani Program is starting a search for his next adoptive home that will care for him for the rest of his life. He will also come with a supply of food, a cushy pad if wanted, and other goodies such as toys. Fred's medical expenses will be covered for the rest of his life by The Thulani Program! If you want to learn more about Fred, or are possibly interested in providing an adoptive or foster home, please send us an email at thulanidogs@gsrnc.org.", "German Shepherd", "germanshep", "GERMAN SHEPHERD RESCUE OF NORTHERN CALIFORNIA", "1-800-728-3473", "geo: 32.761441, -117.065376");
        pets.add(temp);
        //URL: https://www.petfinder.com/petdetail/37366694
        temp = new Pet("Sir Fir", 8.5, 0.45, 0.5, "Sir Fur is a 2-year-old, 25 pound Maltipoo. Sir Fur is quite handsome and it's easy to be smitten with his good looks! He's a little bashful around new people and new dogs, but wants to be friendly and warms up quickly (treats are helpful). He's good with dogs of all sizes - his best friend is a Saint Bernard! Sir Fur does well with gentle children and has lived with kitties in his family. At night, he sleeps quietly in his bed and prefers to be near his person. He walks well on leash and even knows some basic commands. Sir Fur's guardian had to go into assisted living and could not keep him. Her caretaker lovingly took Sir Fur into her home but can't keep him permanently.", "Maltese", "maltese", "Peace of Mind Dog Rescue", "(831) 718-9122", "geo: 36.616600, -121.919593");
        pets.add(temp);
        //URL: https://www.petfinder.com/petdetail/37381264
        temp = new Pet("Dottie", 8, 0.2, 0.93, "12 mo to 18 mon old, 11.8 lb Dottie was a stray in SF. She was super adorable but was made available to rescue only due to her behavior. She wanted nothing to do with anyone in the scary shelter. We were picking up an equally scared doxie mix from from this shelter, so we happily added Dottie too. Dottie is still a little shy with strangers but is very good with people given a little bit of time. She has been find with all the other dogs and she is cat safe!Dottie has been spayed, microchipped, and she is current on her vaccinations. If you are interested in Dottie, please fill out the online adoption application and email Nicole at nicolesalacain@gmail.com", "Dachshund", "dottie", "SOUTHERN CALIFORNIA DACHSHUND RELIEF, INC.", "", "geo: 34.697561, -118.135234");
        pets.add(temp);
        //URL: https://www.petfinder.com/petdetail/37442091

        temp = new Pet("Chuckie", 10, 0.7, 0.3, "Tommy, Chuckie, Phil and Lil are 10-12 week old pit mix pups we rescued from Kerman. weigh around 12-15 lbs each. Friendly, happy pups. More to come! FOSTER NEEDED â??FOSTER-TO-ADOPT ELIGIBLE â??This dog is in need of a foster home and is eligible for foster-to-adopt. Learn more: fostering & foster to adopt", "Pit Bull", "chuckie", "COPPER'S DREAM RESCUE", "", "geo: 37.500252, -122.250318");
        pets.add(temp);
        //URL: https://www.petfinder.com/petdetail/37374366
        temp = new Pet("Snow Kitty", 23, 0.99, 0.8, "Sanctuary Update: He is a lovely and playful boy, but he is an alpha confidant guy and can be possessive over toys/food etc so ideally he would be in an adult only home that would work with him on this and help to set rules so he can learn to follow their lead. He stands up on his back feet and does an adorable little swimming motion with his feet when he sees someone that he knows and loves approaching. He has a good heart and is a very intelligent guy. He is going to be just a fantastic dog for the right confidant and Nordic breed experienced person/people.; Original Bio: One big furry fluff ball! Snow Kitty needs someone who is familiar with Nordic breeds and can give him the space, exercise, training, and leadership he needs. He is dog-friendly and does not appear to be outwardly cat-aggressive, though we believe he'd be best in a no cat and no kid home! He is stubborn, willful and possessive - he had a stuffed animal and was very possessive and unwilling to let it go. He is a bit of a touchy fellow and needs adults who can allow him the space he needs - and also provide friendship and activity - he does really like playing with other dogs - males or females.Snow Kitty also had the name Griffin which is a bit more regal -- but this is not a joker, rather he has an independent streak, he is prideful and dominant in that he feels secure in himself and his right to have what he wants and do what he wants and really doesn't want a person telling him otherwise or demanding of such... he can get angry and takes some time to let him calm down - thus a savvy adult home is what he needs.", "Samoyed", "samoyed", "THE MILO FOUNDATION", "(510) 900-2275", "geo: 37.928823, -122.379944");
        pets.add(temp);
        //URL: https://www.petfinder.com/petdetail/35746301

        int winnerIndex = 0;
        double best = 0;
        for(int i = 0; i < 5 ; i++){
            double tempo = 0;
            for (int j = 0; j < 4; j++){
                tempo += personTraits[j]*pets.get(i).factors[j];
            }
            if (tempo > best) {
                best = tempo;
                winnerIndex = i;
            }
        }
        return winnerIndex;
    }


    public void directionsClick(View view) {
        String location = pets.get(magicNumber).latAndLong;
        //Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        Uri gmmIntentUri = Uri.parse(location);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
           startActivity(mapIntent);
        }
//        Intent intent = new Intent(this, MapsActivity.class);
//        startActivity(intent);
    }

    public void phoneClick(View view) {

        String phone_number = pets.get(magicNumber).phoneNum;
        Intent intent = new Intent(Intent.ACTION_DIAL);
        if (!phone_number.isEmpty()) {
            String uri = "tel:" + phone_number.trim();
            intent.setData(Uri.parse(uri));
        }
        startActivity(intent);
    }

    public void goToShelterInfo(View view) {
        Intent intent = new Intent(this, ShelterInfo.class);
        startActivity(intent);
    }
}

