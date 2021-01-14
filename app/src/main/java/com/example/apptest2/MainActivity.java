package com.example.apptest2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button btn_login,btn_signup;
    private EditText txtname,txtemail,txtpassword,txtlastname,txttelephone;

    private FirebaseAuth auth;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    public void init() {
        txtname = (EditText) findViewById(R.id.txtFirstName);
        txtemail = (EditText) findViewById(R.id.txtRegEmail);
        txtpassword = (EditText) findViewById(R.id.txtRegPassword);
        txtlastname = (EditText) findViewById(R.id.txtLastName);
        txttelephone = (EditText) findViewById(R.id.txtPhone);

        auth = FirebaseAuth.getInstance();

        btn_signup = (Button) findViewById(R.id.btnSignUp);
        btn_login = (Button) findViewById(R.id.AlreadyHaveAccountButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValuesToDatabase();

                createNewAccount();

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginScreen();
            }
        });
    }


    private void createNewAccount() {

        String email = txtemail.getText().toString();
        String password = txtpassword.getText().toString();

        if(TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email Alanı Boş Olamaz!", Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Şifre Alanı Boş Olamaz!", Toast.LENGTH_LONG).show();
        }
        else {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Hesabınız Oluşturuldu!", Toast.LENGTH_LONG).show();
                        openLoginScreen();
                        finish();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Hesap Oluşturulamadı!", Toast.LENGTH_LONG).show();

                    }
                }
            });
        }

    }

    private void addValuesToDatabase(){
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        //get all the values
        String firstName = txtname.getText().toString();
        String lastName = txtlastname.getText().toString();
        String email = txtemail.getText().toString();
        String telephone = txttelephone.getText().toString();
        String password = txtpassword.getText().toString();

        UserHelperClass helperClass = new UserHelperClass(firstName, lastName, email, telephone, password);

        reference.child(firstName).setValue(helperClass);
    }

    public void openLoginScreen(){
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }
}
