package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
    private Button buttonPlus;
    private Button buttonMoins;
    private Button buttonDiv;
    private Button buttonMul;
    private Button buttonAC;
    private Button buttonEgal;
    private Button buttonPoint;
    private Button buttonPlusMoins;
    private Button buttonModulo;
    private TextView result;


    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

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
        setContentView(R.layout.activity_main);

        this.result = findViewById(R.id.result);
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
        this.buttonPlus = findViewById(R.id.buttonPlus);
        this.buttonMoins = findViewById(R.id.buttonMoins);
        this.buttonMul = findViewById(R.id.buttonMul);
        this.buttonDiv = findViewById(R.id.buttonDiv);
        this.buttonEgal = findViewById(R.id.buttonEgal);
        this.buttonPoint = findViewById(R.id.buttonPoint);
        this.buttonModulo = findViewById(R.id.buttonModulo);
        this.buttonPlusMoins = findViewById(R.id.buttonPlusMoins);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plusClick();
            }
        });
        buttonMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moinsClick();
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                divClick();
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mulClick();
            }
        });
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetClick();
            }
        });
        buttonEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                egalClick();
            }
        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chiffreClick(".");
            }
        });
        buttonPlusMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plusMoinsClick();
            }
        });
        buttonModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moduloClick();
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

    }
    public void chiffreClick (String str) {
        if(update){
            update = false;
        }else{
            if(! result. getText (). equals ("0"))
                str = result.getText() + str;
        }
        result. setText (str);
    }

    public void plusMoinsClick(){
        chiffre1 = Double.parseDouble(result.getText().toString());
        chiffre1 = chiffre1 * (-1);
        Double.isNaN(chiffre1);
        result.setText(Double.toString(chiffre1));
    }

    public void plusClick() {

        if(clicOperateur){
            calcul ();
            result. setText (String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(result.getText().toString());
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }
    public void moinsClick() {
        if(clicOperateur){
            calcul ();
            result.setText(String.valueOf (chiffre1));
        }else{
            chiffre1 = Double.valueOf(result.getText().toString());
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }
    public void mulClick() {
        if(clicOperateur){
            calcul ();
            result.setText(String.valueOf (chiffre1));
        }else{
            chiffre1 = Double.valueOf(result.getText().toString());
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }
    public void divClick(){
        if(clicOperateur){
            calcul ();
            result.setText(String.valueOf (chiffre1));
        }else{
            chiffre1 = Double.valueOf(result.getText().toString());
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }
    public void moduloClick(){
        if(clicOperateur){
            calcul ();
            result.setText(String.valueOf (chiffre1));
        }else{
            chiffre1 = Double.valueOf(result.getText().toString());
            clicOperateur = true;
        }
        operateur = "%";
        update = true;
    }
    public void egalClick() {
        calcul ();
        update = true;
        clicOperateur = false;
    }
    public void resetClick() {
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        result. setText ("0");
    }
    private void calcul () {
        if (operateur. equals ("+")) {
            chiffre1 = chiffre1 + Double.parseDouble(result.getText().toString());
            result.setText(String.valueOf (chiffre1));
        }

        if(operateur. equals ("-")){
            chiffre1 = chiffre1 - Double.parseDouble(result.getText().toString());
            result.setText(String.valueOf (chiffre1));
        }

        if(operateur. equals ("*")){
            chiffre1 = chiffre1 * Double.parseDouble(result.getText().toString());
            result.setText(String.valueOf (chiffre1));
        }

        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 / Double.parseDouble(result.getText().toString());
                result.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                result. setText ("0");
            }
        }

        if(operateur. equals ("%")){
            chiffre1 = chiffre1 % Double.parseDouble(result.getText().toString());
            result.setText(String.valueOf (chiffre1));
        }
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
