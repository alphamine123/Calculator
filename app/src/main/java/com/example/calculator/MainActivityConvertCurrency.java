package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivityConvertCurrency extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Spinner spinnerStart;
    Spinner spinnerEnd;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    ActionBar actionBar;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonAC;
    private Button buttonPoint;
    private TextView textCurrencyStart;
    private TextView textCurrencyEnd;

    private double chiffre1;
    private double chiffre2;
    private double coef;
    private String paysStart = "US-Dollar";
    private String paysEnd = "US-Dollar";
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_convert_currency);

        this.button0 = findViewById(R.id.button0);
        this.button1 = findViewById(R.id.button1);
        this.button2 = findViewById(R.id.button2);
        this.button3 = findViewById(R.id.button3);
        this.button4 = findViewById(R.id.button4);
        this.button5 = findViewById(R.id.button5);
        this.button6 = findViewById(R.id.button6);
        this.button7 = findViewById(R.id.button7);
        this.button8 = findViewById(R.id.button8);
        this.button9 = findViewById(R.id.button9);
        this.buttonAC = findViewById(R.id.buttonAC);
        this.buttonPoint = findViewById(R.id.buttonPoint);
        this.textCurrencyEnd = findViewById(R.id.textCurrencyEnd);
        this.textCurrencyStart = findViewById(R.id.textCurrencyStart);

        spinnerStart = findViewById(R.id.spinnerCurrencyStart);
        spinnerEnd = findViewById(R.id.spinnerCurrencyEnd);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setTitle(R.string.currency);

        ArrayAdapter<CharSequence> ar =
                ArrayAdapter.createFromResource(this, R.array.Currency,
                        android.R.layout.simple_list_item_1);
        ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinnerStart.setAdapter(ar);
        spinnerEnd.setAdapter(ar);

        spinnerEnd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    if(paysStart.equals("US-Dollar")){
                        if(adapterView.getItemAtPosition(i).toString().equals("US-Dollar")){
                            coef = 1;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Europe-Euro")){
                            coef = 0.95;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Canada-Dollar")){
                            coef = 1.36;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Morocco-Dirham")){
                            coef = 10.50;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("UK-Pound")){
                            coef = 0.82;
                            chiffre2 = chiffre1 * coef;
                        }
                    }else if(paysStart.equals("Europe-Euro")){
                        if(adapterView.getItemAtPosition(i).toString().equals("US-Dollar")){
                            coef = 1.05;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Europe-Euro")){
                            coef = 1;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Canada-Dollar")){
                            coef = 1.44;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Morocco-Dirham")){
                            coef = 11.12;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("UK-Pound")){
                            coef = 0.86;
                            chiffre2 = chiffre1 * coef;
                        }
                    }else if(paysStart.equals("Canada-Dollar")){
                        if(adapterView.getItemAtPosition(i).toString().equals("US-Dollar")){
                            coef = 0.73;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Europe-Euro")){
                            coef = 0.70;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Canada-Dollar")){
                            coef = 1;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Morocco-Dirham")){
                            coef = 7.74;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("UK-Pound")){
                            coef = 0.60;
                            chiffre2 = chiffre1 * coef;
                        }
                    }else if(paysStart.equals("Morocco-Dirham")){
                        if(adapterView.getItemAtPosition(i).toString().equals("US-Dollar")){
                            coef = 0.095;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Europe-Euro")){
                            coef = 0.090;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Canada-Dollar")){
                            coef = 0.13;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Morocco-Dirham")){
                            coef = 1;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("UK-Pound")){
                            coef = 0.077;
                            chiffre2 = chiffre1 * coef;
                        }
                    }else if(paysStart.equals("UK-Pound")){
                        if(adapterView.getItemAtPosition(i).toString().equals("US-Dollar")){
                            coef = 1.23;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Europe-Euro")){
                            coef = 1.17;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Canada-Dollar")){
                            coef = 1.68;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("Morocco-Dirham")){
                            coef = 12.97;
                            chiffre2 = chiffre1 * coef;
                        }else if(adapterView.getItemAtPosition(i).toString().equals("UK-Pound")){
                            coef = 1;
                            chiffre2 = chiffre1 * coef;
                        }
                    }
                textCurrencyEnd.setText(Double.toString(chiffre2));
                paysEnd = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(MainActivityConvertCurrency.this, paysEnd, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerStart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).toString().equals("US-Dollar")){
                    if(paysEnd.equals("US-Dollar")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Europe-Euro")){
                        coef = 0.95;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Canada-Dollar")){
                        coef = 1.36;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Morocco-Dirham")){
                        coef = 10.50;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("UK-Pound")){
                        coef = 0.82;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(adapterView.getItemAtPosition(i).toString().equals("Europe-Euro")){
                    if(paysEnd.equals("US-Dollar")){
                        coef = 1.05;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Europe-Euro")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Canada-Dollar")){
                        coef = 1.44;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Morocco-Dirham")){
                        coef = 11.12;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("UK-Pound")){
                        coef = 0.86;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(adapterView.getItemAtPosition(i).toString().equals("Canada-Dollar")){
                    if(paysEnd.equals("US-Dollar")){
                        coef = 0.73;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Europe-Euro")){
                        coef = 0.70;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Canada-Dollar")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Morocco-Dirham")){
                        coef = 7.74;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("UK-Pound")){
                        coef = 0.60;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(adapterView.getItemAtPosition(i).toString().equals("Morocco-Dirham")){
                    if(paysEnd.equals("US-Dollar")){
                        coef = 0.095;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Europe-Euro")){
                        coef = 0.090;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Canada-Dollar")){
                        coef = 0.13;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Morocco-Dirham")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("UK-Pound")){
                        coef = 0.077;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(adapterView.getItemAtPosition(i).toString().equals("UK-Pound")){
                    if(paysEnd.equals("US-Dollar")){
                        coef = 1.23;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Europe-Euro")){
                        coef = 1.17;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Canada-Dollar")){
                        coef = 1.68;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Morocco-Dirham")){
                        coef = 12.97;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("UK-Pound")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }
                }
                textCurrencyEnd.setText(Double.toString(chiffre2));

                paysStart = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(MainActivityConvertCurrency.this, paysStart, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button0.setOnClickListener(view -> chiffreClick("0"));
        button1.setOnClickListener(view -> chiffreClick("1"));
        button2.setOnClickListener(view -> chiffreClick("2"));
        button3.setOnClickListener(view -> chiffreClick("3"));
        button4.setOnClickListener(view -> chiffreClick("4"));
        button5.setOnClickListener(view -> chiffreClick("5"));
        button6.setOnClickListener(view -> chiffreClick("6"));
        button7.setOnClickListener(view -> chiffreClick("7"));
        button8.setOnClickListener(view -> chiffreClick("8"));
        button9.setOnClickListener(view -> chiffreClick("9"));
        buttonPoint.setOnClickListener(view -> chiffreClick("."));

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetClick();
            }
        });
    }


    public void chiffreClick (String str) {
        if(! textCurrencyStart.getText().equals("0")){
            str = textCurrencyStart.getText() + str;
        }
        textCurrencyStart.setText(str);
        chiffre1 = Double.parseDouble(str);
        if(paysStart.equals("US-Dollar")){
            if(paysEnd.equals("US-Dollar")){
                coef = 1;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Europe-Euro")){
                coef = 0.95;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Canada-Dollar")){
                coef = 1.36;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Morocco-Dirham")){
                coef = 10.50;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("UK-Pound")){
                coef = 0.82;
                chiffre2 = chiffre1 * coef;
            }
        }else if(paysStart.equals("Europe-Euro")){
            if(paysEnd.equals("US-Dollar")){
                coef = 1.05;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Europe-Euro")){
                coef = 1;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Canada-Dollar")){
                coef = 1.44;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Morocco-Dirham")){
                coef = 11.12;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("UK-Pound")){
                coef = 0.86;
                chiffre2 = chiffre1 * coef;
            }
        }else if(paysStart.equals("Canada-Dollar")){
            if(paysEnd.equals("US-Dollar")){
                coef = 0.73;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Europe-Euro")){
                coef = 0.70;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Canada-Dollar")){
                coef = 1;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Morocco-Dirham")){
                coef = 7.74;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("UK-Pound")){
                coef = 0.60;
                chiffre2 = chiffre1 * coef;
            }
        }else if(paysStart.equals("Morocco-Dirham")){
            if(paysEnd.equals("US-Dollar")){
                coef = 0.095;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Europe-Euro")){
                coef = 0.090;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Canada-Dollar")){
                coef = 0.13;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Morocco-Dirham")){
                coef = 1;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("UK-Pound")){
                coef = 0.077;
                chiffre2 = chiffre1 * coef;
            }
        }else if(paysStart.equals("UK-Pound")){
            if(paysEnd.equals("US-Dollar")){
                coef = 1.23;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Europe-Euro")){
                coef = 1.17;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Canada-Dollar")){
                coef = 1.68;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Morocco-Dirham")){
                coef = 12.97;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("UK-Pound")){
                coef = 1;
                chiffre2 = chiffre1 * coef;
            }
        }
        textCurrencyEnd.setText(Double.toString(chiffre2));
    }
    public void resetClick() {
        chiffre1 = 0;
        textCurrencyStart. setText ("0");
        textCurrencyEnd. setText ("0");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.standard){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.currency){
            Intent intent = new Intent(this,MainActivityConvertCurrency.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.length){
            Intent intent = new Intent(this,MainActivityConvertLength.class);
            startActivity(intent);
            return true;
        }
        return true;
    }
}