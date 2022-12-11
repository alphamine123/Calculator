package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivityConvertLength extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

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
    private String paysStart = "";
    private String paysEnd = "";
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
        setContentView(R.layout.activity_main_convert_length);
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

        getSupportActionBar().setTitle(R.string.length);

        ArrayAdapter<CharSequence> ar =
                ArrayAdapter.createFromResource(this, R.array.Length,
                        android.R.layout.simple_list_item_1);
        ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinnerStart.setAdapter(ar);
        spinnerEnd.setAdapter(ar);

        spinnerEnd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(paysStart.equals("Nanometres")){
                    if(adapterView.getItemAtPosition(i).toString().equals("Nanometres")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Microns")){
                        coef = 0.001;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Millimeters")){
                        coef = 0.000001;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Centimeters")){
                        coef = 0.0000001;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Meter")){
                        coef = 0.000000001;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Inches")){
                        coef = 0.000000039370079;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Miles")){
                        coef = 0.000000000000621;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(paysStart.equals("Microns")){
                    if(adapterView.getItemAtPosition(i).toString().equals("Nanometres")){
                        coef = 1000;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Microns")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Millimeters")){
                        coef = 0.001;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Centimeters")){
                        coef = 0.0001;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Meter")){
                        coef = 0.000001;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Inches")){
                        coef = 0.000039;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Miles")){
                        coef = 0.000000000621371;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(paysStart.equals("Millimeters")){
                    if(adapterView.getItemAtPosition(i).toString().equals("Nanometres")){
                        coef = 1000000;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Microns")){
                        coef = 1000;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Millimeters")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Centimeters")){
                        coef = 0.1;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Meter")){
                        coef = 0.001;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Inches")){
                        coef = 0.03937;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Miles")){
                        coef = 0.000000621371192;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(paysStart.equals("Centimeters")){
                    if(adapterView.getItemAtPosition(i).toString().equals("Nanometres")){
                        coef = 10000000;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Microns")){
                        coef = 10000;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Millimeters")){
                        coef = 10;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Centimeters")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Meter")){
                        coef = 0.01;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Inches")){
                        coef = 0.393701;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Miles")){
                        coef = 0.000006;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(paysStart.equals("Meter")){
                    if(adapterView.getItemAtPosition(i).toString().equals("Nanometres")){
                        coef = 1000000000;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Microns")){
                        coef = 1000000;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Millimeters")){
                        coef = 1000;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Centimeters")){
                        coef = 100;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Meter")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Inches")){
                        coef = 39.37008;
                        chiffre2 = chiffre1 * coef;
                    }else if(adapterView.getItemAtPosition(i).toString().equals("Miles")){
                        coef = 0.000621;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(paysStart.equals("Inches")) {
                    if (adapterView.getItemAtPosition(i).toString().equals("Nanometres")) {
                        coef = 25400000;
                        chiffre2 = chiffre1 * coef;
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Microns")) {
                        coef = 25400;
                        chiffre2 = chiffre1 * coef;
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Millimeters")) {
                        coef = 25.4;
                        chiffre2 = chiffre1 * coef;
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Centimeters")) {
                        coef = 2.54;
                        chiffre2 = chiffre1 * coef;
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Meter")) {
                        coef = 0.0254;
                        chiffre2 = chiffre1 * coef;
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Inches")) {
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Miles")) {
                        coef = 0.000016;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(paysStart.equals("Miles")) {
                    if (adapterView.getItemAtPosition(i).toString().equals("Nanometres")) {
                        coef = 1609344000;
                        chiffre2 = chiffre1 * coef * 1000;
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Microns")) {
                        coef = 1609344000;
                        chiffre2 = chiffre1 * coef;
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Millimeters")) {
                        coef = 1609344;
                        chiffre2 = chiffre1 * coef;
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Centimeters")) {
                        coef = 160934.4;
                        chiffre2 = chiffre1 * coef;
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Meter")) {
                        coef = 1609.344;
                        chiffre2 = chiffre1 * coef;
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Inches")) {
                        coef = 63360;
                        chiffre2 = chiffre1 * coef;
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Miles")) {
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }
                }

                textCurrencyEnd.setText(Double.toString(chiffre2));
                paysEnd = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(MainActivityConvertLength.this, paysEnd, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerStart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).toString().equals("Nanometres")){
                    if(paysEnd.equals("Nanometres")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Microns")){
                        coef = 0.001;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Millimeters")){
                        coef = 0.000001;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Centimeters")){
                        coef = 0.0000001;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Meter")){
                        coef = 0.000000001;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Inches")){
                        coef = 0.000000039370079;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Miles")){
                        coef = 0.000000000000621;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(adapterView.getItemAtPosition(i).toString().equals("Microns")){
                    if(paysEnd.equals("Nanometres")){
                        coef = 1000;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Microns")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Millimeters")){
                        coef = 0.001;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Centimeters")){
                        coef = 0.0001;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Meter")){
                        coef = 0.000001;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Inches")){
                        coef = 0.000039;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Miles")){
                        coef = 0.000000000621371;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(adapterView.getItemAtPosition(i).toString().equals("Millimeters")){
                    if(paysEnd.equals("Nanometres")){
                        coef = 1000000;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Microns")){
                        coef = 1000;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Millimeters")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Centimeters")){
                        coef = 0.1;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Meter")){
                        coef = 0.001;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Inches")){
                        coef = 0.03937;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Miles")){
                        coef = 0.000000621371192;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(adapterView.getItemAtPosition(i).toString().equals("Centimeters")){
                    if(paysEnd.equals("Nanometres")){
                        coef = 10000000;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Microns")){
                        coef = 10000;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Millimeters")){
                        coef = 10;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Centimeters")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Meter")){
                        coef = 0.01;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Inches")){
                        coef = 0.393701;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Miles")){
                        coef = 0.000006;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(adapterView.getItemAtPosition(i).toString().equals("Meter")){
                    if(paysEnd.equals("Nanometres")){
                        coef = 1000000000;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Microns")){
                        coef = 1000000;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Millimeters")){
                        coef = 1000;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Centimeters")){
                        coef = 100;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Meter")){
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Inches")){
                        coef = 39.37008;
                        chiffre2 = chiffre1 * coef;
                    }else if(paysEnd.equals("Miles")){
                        coef = 0.000621;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(adapterView.getItemAtPosition(i).toString().equals("Inches")) {
                    if (paysEnd.equals("Nanometres")) {
                        coef = 25400000;
                        chiffre2 = chiffre1 * coef;
                    } else if (paysEnd.equals("Microns")) {
                        coef = 25400;
                        chiffre2 = chiffre1 * coef;
                    } else if (paysEnd.equals("Millimeters")) {
                        coef = 25.4;
                        chiffre2 = chiffre1 * coef;
                    } else if (paysEnd.equals("Centimeters")) {
                        coef = 2.54;
                        chiffre2 = chiffre1 * coef;
                    } else if (paysEnd.equals("Meter")) {
                        coef = 0.0254;
                        chiffre2 = chiffre1 * coef;
                    } else if (paysEnd.equals("Inches")) {
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    } else if (paysEnd.equals("Miles")) {
                        coef = 0.000016;
                        chiffre2 = chiffre1 * coef;
                    }
                }else if(adapterView.getItemAtPosition(i).toString().equals("Miles")) {
                    if (paysEnd.equals("Nanometres")) {
                        coef = 1609344000;
                        chiffre2 = chiffre1 * coef * 1000;
                    } else if (paysEnd.equals("Microns")) {
                        coef = 1609344000;
                        chiffre2 = chiffre1 * coef;
                    } else if (paysEnd.equals("Millimeters")) {
                        coef = 1609344;
                        chiffre2 = chiffre1 * coef;
                    } else if (paysEnd.equals("Centimeters")) {
                        coef = 160934.4;
                        chiffre2 = chiffre1 * coef;
                    } else if (paysEnd.equals("Meter")) {
                        coef = 1609.344;
                        chiffre2 = chiffre1 * coef;
                    } else if (paysEnd.equals("Inches")) {
                        coef = 63360;
                        chiffre2 = chiffre1 * coef;
                    } else if (paysEnd.equals("Miles")) {
                        coef = 1;
                        chiffre2 = chiffre1 * coef;
                    }
                }

                textCurrencyEnd.setText(Double.toString(chiffre2));

                paysStart = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(MainActivityConvertLength.this, paysStart, Toast.LENGTH_SHORT).show();
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
        if(paysStart.equals("Nanometres")){
            if(paysEnd.equals("Nanometres")){
                coef = 1;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Microns")){
                coef = 0.001;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Millimeters")){
                coef = 0.000001;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Centimeters")){
                coef = 0.0000001;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Meter")){
                coef = 0.000000001;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Inches")){
                coef = 0.000000039370079;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Miles")){
                coef = 0.000000000000621;
                chiffre2 = chiffre1 * coef;
            }
        }else if(paysStart.equals("Microns")){
            if(paysEnd.equals("Nanometres")){
                coef = 1000;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Microns")){
                coef = 1;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Millimeters")){
                coef = 0.001;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Centimeters")){
                coef = 0.0001;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Meter")){
                coef = 0.000001;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Inches")){
                coef = 0.000039;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Miles")){
                coef = 0.000000000621371;
                chiffre2 = chiffre1 * coef;
            }
        }else if(paysStart.equals("Millimeters")){
            if(paysEnd.equals("Nanometres")){
                coef = 1000000;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Microns")){
                coef = 1000;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Millimeters")){
                coef = 1;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Centimeters")){
                coef = 0.1;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Meter")){
                coef = 0.001;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Inches")){
                coef = 0.03937;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Miles")){
                coef = 0.000000621371192;
                chiffre2 = chiffre1 * coef;
            }
        }else if(paysStart.equals("Centimeters")){
            if(paysEnd.equals("Nanometres")){
                coef = 10000000;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Microns")){
                coef = 10000;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Millimeters")){
                coef = 10;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Centimeters")){
                coef = 1;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Meter")){
                coef = 0.01;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Inches")){
                coef = 0.393701;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Miles")){
                coef = 0.000006;
                chiffre2 = chiffre1 * coef;
            }
        }else if(paysStart.equals("Meter")){
            if(paysEnd.equals("Nanometres")){
                coef = 1000000000;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Microns")){
                coef = 1000000;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Millimeters")){
                coef = 1000;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Centimeters")){
                coef = 100;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Meter")){
                coef = 1;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Inches")){
                coef = 39.37008;
                chiffre2 = chiffre1 * coef;
            }else if(paysEnd.equals("Miles")){
                coef = 0.000621;
                chiffre2 = chiffre1 * coef;
            }
        }else if(paysStart.equals("Inches")) {
            if (paysEnd.equals("Nanometres")) {
                coef = 25400000;
                chiffre2 = chiffre1 * coef;
            } else if (paysEnd.equals("Microns")) {
                coef = 25400;
                chiffre2 = chiffre1 * coef;
            } else if (paysEnd.equals("Millimeters")) {
                coef = 25.4;
                chiffre2 = chiffre1 * coef;
            } else if (paysEnd.equals("Centimeters")) {
                coef = 2.54;
                chiffre2 = chiffre1 * coef;
            } else if (paysEnd.equals("Meter")) {
                coef = 0.0254;
                chiffre2 = chiffre1 * coef;
            } else if (paysEnd.equals("Inches")) {
                coef = 1;
                chiffre2 = chiffre1 * coef;
            } else if (paysEnd.equals("Miles")) {
                coef = 0.000016;
                chiffre2 = chiffre1 * coef;
            }
        }else if(paysStart.equals("Miles")) {
            if (paysEnd.equals("Nanometres")) {
                coef = 1609344000;
                chiffre2 = chiffre1 * coef * 1000;
            } else if (paysEnd.equals("Microns")) {
                coef = 1609344000;
                chiffre2 = chiffre1 * coef;
            } else if (paysEnd.equals("Millimeters")) {
                coef = 1609344;
                chiffre2 = chiffre1 * coef;
            } else if (paysEnd.equals("Centimeters")) {
                coef = 160934.4;
                chiffre2 = chiffre1 * coef;
            } else if (paysEnd.equals("Meter")) {
                coef = 1609.344;
                chiffre2 = chiffre1 * coef;
            } else if (paysEnd.equals("Inches")) {
                coef = 63360;
                chiffre2 = chiffre1 * coef;
            } else if (paysEnd.equals("Miles")) {
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