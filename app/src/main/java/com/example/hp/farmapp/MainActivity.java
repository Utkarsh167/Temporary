package com.example.hp.farmapp;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {



    Button loginbutt;
    EditText edittext,password,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //final EditText edittext= (EditText)findViewById(R.id.email);
        loginbutt=(Button)findViewById(R.id.loginbutt);
        edittext= (EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.pass);
        mobile =(EditText)findViewById(R.id.mobile);


        loginbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int length = password.getText().toString().trim().length();

                if (!emailValidator(edittext.getText().toString().trim())) {
                    edittext.setError(getString(R.string.invalid_email));
                }

                else  if(!isValidMobile(mobile.getText().toString().trim()))
                {
                    mobile.setError("Invalid Mobile Number");
                }
                else if (!(length > 7 && length < 33)) {
                    password.setError(getString(R.string.password_er));
            //        Toast.makeText(MainActivity.this, length, Toast.LENGTH_SHORT).show();


                }
                else
                {
                    Toast.makeText(MainActivity.this, "yeah done", Toast.LENGTH_SHORT).show();
                }

            }
        });






       /* Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Your Back4app application ID")
                .clientKey("You can find it on Features -> Core Settings -> Server")
                .server("https://parseapi.back4app.com/").build()
        );

        Button bt= (Button)findViewById(R.id.buttlogin);
        bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground("Username", "Password", new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (parseUser != null) {
                            //Login Successful
                            //You may choose what to do or display here
                            //For example: Welcome + ParseUser.getUsername()

                        } else {
                            //Login Fail
                            //get error by calling e.getMessage()
                        }
                    }
                });
            }
        });

*/
    }


    public static boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidMobile(String phone) {
        boolean check=false;
        if(!Pattern.matches("[a-zA-Z]+", phone)) {
           // if(phone.length() < 6 || phone.length() > 13) {
                 if(phone.length() != 10) {
                check = false;
                //txtPhone.setError("Not Valid Number");
            } else {
                check = true;
            }
        } else {
            check=false;
        }
        return check;
    }

}
