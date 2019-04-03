package com.example.vasus.atozdictionary;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dh;
    boolean isInserted;
    EditText editWord;
    Button search;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editWord = (EditText)findViewById(R.id.txtWord);
        search = (Button)findViewById(R.id.btnSearch);
        resultText = (TextView)findViewById(R.id.resultText);
        dh = new DatabaseHelper(this);
        isInserted =  dh.insertData("abate","Reduce");
        isInserted = dh.insertData("aberrant","Something unusual or unexpected");
        isInserted = dh.insertData("beneficent","Doing good");
        isInserted = dh.insertData("bogus","fake");
        isInserted = dh.insertData("cacophony","Harsh");
        isInserted = dh.insertData("cartography","Mapmaking");
        isInserted = dh.insertData("disinterested","Unbiased, Not interested");
        isInserted = dh.insertData("disjointed","Disconnected");
        isInserted = dh.insertData("enervate","Weaken, tire");
        isInserted = dh.insertData("euphony","Pleasing or sweet sound, especially as formed by a harmonious use of words");
        isInserted = dh.insertData("facilitate","Make easier");
        isInserted = dh.insertData("feasible","Possible");
        isInserted = dh.insertData("gauche","Awkward");
        isInserted = dh.insertData("gregarious","Enjoying the company of other people");
        isInserted = dh.insertData("hallmark","A mark indicationg quality, purity, genuineness, etc.");
        isInserted = dh.insertData("hapless","Unlucky");
        isInserted = dh.insertData("immutable","Unchangeable");
        isInserted = dh.insertData("indolent","Lazy");
        isInserted = dh.insertData("judicious","Using good judgement");
        isInserted = dh.insertData("juxtapose","Put side by side");
        isInserted = dh.insertData("keen","Sharp");
        isInserted = dh.insertData("kinetic","Pertaining to motion");
        isInserted = dh.insertData("laconic","Using few words");
        isInserted = dh.insertData("landmark","A very important place, event, etc.");
        isInserted = dh.insertData("mannered","Having a particular manner");
        isInserted = dh.insertData("mirth","Hapiness");
        isInserted = dh.insertData("nadir","Lowest point");
        isInserted = dh.insertData("negate","Deny or refute");
        isInserted = dh.insertData("opine","Express an opinion");
        isInserted = dh.insertData("oscillate","Swing back and forth");
        isInserted = dh.insertData("paradigm","Model or Pattern");
        isInserted = dh.insertData("paragon","perfectExample");
        isInserted = dh.insertData("qualified","Modified");
        isInserted = dh.insertData("quotidian","Daily; Everyday; Ordinary");
        isInserted = dh.insertData("refute","Prove to be false");
        isInserted = dh.insertData("repudiate","Reject");
        isInserted = dh.insertData("salient","Very important or noticeable");
        isInserted = dh.insertData("slew","A large number or quantity");
        isInserted = dh.insertData("timorous","Fearful");
        isInserted = dh.insertData("tyro","Beginner");
        isInserted = dh.insertData("ubiquitous","Existing everywhere a the same time");
        isInserted = dh.insertData("underscore","Emphasize");
        isInserted = dh.insertData("verbose","Wordy");
        isInserted = dh.insertData("veracity","Truthfulness");
        isInserted = dh.insertData("whereas","While on the contrary, considering that");
        isInserted = dh.insertData("wily","Crafty");
        isInserted = dh.insertData("zenith","High point");
//        if(isInserted==true)
//            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
//        else
//            Toast.makeText(MainActivity.this, "not Inserted", Toast.LENGTH_SHORT).show();
        readAll();
    }

    public void readAll(){
        search.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String wordToFind = editWord.getText().toString().toLowerCase();
                        if(editWord.getText().toString().equals("") )
                        {
                            resultText.setText("NULL is not accepted");
                        }
                        else {
                            Cursor res = dh.getAllData(wordToFind);
                            if (res.getCount() == 0) {
                                showMessage("Nothing Found");
                                return;
                            }
                            StringBuffer buffer = new StringBuffer();
                            int i = 1;
                            while (res.moveToNext() && i == 1) {
                                buffer.append(res.getString(1));
                                i++;
                            }
                            showMessage(buffer.toString());
                        }
                    }
                }
        );
    }

    public void showMessage(String Message){
        if(Message.equals("Nothing Found"))
        {
            resultText.setText("Nothing Found");
            editWord.setText("");
        }
        else
        {
            resultText.setText("Word: " + editWord.getText().toString() + "\n\n" + "Meaning: " + Message);
            editWord.setText("");
        }
    }
}
