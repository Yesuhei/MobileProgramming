package com.example.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryInfo extends AppCompatActivity {
    private TextView infodesc;
    private ImageView infoimg;

    String infoDescription[] = {"China: Diversity is synonymous to China. Its rich culture is simply extraordinary and its people amazingly hold-on to its tradition despite the urbanity most of China's regions face. Beijing, the country's capital, exposes its natural richness, while Shanghai and Guangzhou emerge as the country's shopping centers. China's remote provinces are proud of its awe-inspiring landscapes, particularly Xinjiang, where snow-caped Tianshan Mountain is sighted. Adding to the interesting features China owns is its exemplary cuisine comprising of the world-famous Peking duck, chow mien, dumplings and spring rolls. \n",
            "France: The largest country in Western Europe is hailed as one of the world's most-visited countries. Because France has a wealth of tourist attractions, all travelers list France at the top of their bucket-list. France owns some of the priceless treasures in Europe. Its countryside exhibits prosperity and growth while its big cities remain to be the centers for business and commerce. France has various points of interests ranging from the Atlantic's stunning beaches to French Alps' winter sports resorts. France is more than just Eiffel Tower, Arc de Triomphe, Champs-Elysees, and Parisian fashion--this country is also a picture of lush lavender fields, lengthy vineyards, beautiful bays, art and history museums and medieval villages.",
            "Italy: Some of the most renowned cities in the world, such as Vatican City, Rome and Venice, lie in the majestic Italy. Despite its modernity and urbanity, Italy continues to hold-on to its cultural gems and traditional treasures which make this country even more interesting. Further, its remarkable natural scenery remains intact up to this day which allows Italy to be the best place for appreciating the wealth of nature. In every turn, varied interests make Italy more exciting, such as Florence's ancient architecture, Sicily's vineyards, Naples' authentic cuisine, and Milan's up-to-date fashion trends.\n",
            "Spain: From immaculate-white Mediterranean villages to bustling and sophisticated commercial centers, Spain can be regarded as one of the most diverse countries in the world. This country has an eclectic mix of attributes including a relaxed atmosphere, comfortable living, traditional festivals, and world-favorite cuisine. Madrid and Barcelona are two cities that exhibit vibrancy as they play hosts to modern buildings, lively nightlife, awesome architecture and a number of shopping malls, while Ibiza is known for clubbing, partying and home to world's best DJs. Almeria and Valencia are not only known for their authentic tapas but also for their majestic beaches, while Tenerife takes pride of its virgin forests, splendid coastlines and exotic deserts.",
            "USA: America may be the world's most influential country, but there is more to USA than influence and power. In fact, when it comes to nature, USA has the best of natural treasures. Alaska, for instance, has the world's well-preserved wildlife and Lake Tahoe has unparalleled clear waters and ski resorts. It cannot be denied that USA's prime spots have direct links to shopping malls, fast food joints, flashy billboards, and unbelievably busy people, but these traits add to the reasons why the USA is such an interesting country for both work and leisure."
    };
    int images[] = {
            R.drawable.china,
            R.drawable.france,
            R.drawable.italy,
            R.drawable.spain,
            R.drawable.usa
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_info);

        infodesc = (TextView) findViewById(R.id.infodesc);
        infoimg = (ImageView) findViewById(R.id.infoimg);


        Bundle bundle = getIntent().getExtras();

        if(bundle.getInt("int") == 0){
            infodesc.setText(infoDescription[bundle.getInt("int")]);
            infoimg.setImageResource(images[0]);
        }else if(bundle.getInt("int") == 1){
            infodesc.setText(infoDescription[bundle.getInt("int")]);
            infoimg.setImageResource(images[bundle.getInt("int")]);
        }else if(bundle.getInt("int") == 2){
            infodesc.setText(infoDescription[bundle.getInt("int")]);
            infoimg.setImageResource(images[bundle.getInt("int")]);
        }else if(bundle.getInt("int") == 3){
            infodesc.setText(infoDescription[bundle.getInt("int")]);
            infoimg.setImageResource(images[bundle.getInt("int")]);
        }else if(bundle.getInt("int") == 4){
            infodesc.setText(infoDescription[bundle.getInt("int")]);
            infoimg.setImageResource(images[bundle.getInt("int")]);
        }
    }
}