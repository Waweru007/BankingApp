package com.example.root.sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAccounts extends AppCompatActivity {
    EditText inputAccountNumber;
    TextView txtAccName;
    TextView txtAccNumber;
    TextView txtAccBalance;

    Db database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_accounts);
        inputAccountNumber=findViewById(R.id.inputAccountNumber);
        txtAccName= findViewById(R.id.txtAccName);
        txtAccBalance=findViewById(R.id.txtAccBalance);
        txtAccNumber= findViewById(R.id.txtAccNo);
        database=new Db(this);
    }

    public void search(View view) {
        String input = inputAccountNumber.getText().toString().trim();
        if(input.isEmpty())
            return;
        Account x= database.fetchAccount(input);
        txtAccName.setText("Name :" +x.getName());
        txtAccNumber.setText("Name :" +x.getAccNo());
        txtAccBalance.setText("Name :" +x.getBalance());


    }

    public void delete(View view) {
        String input = inputAccountNumber.getText().toString().trim();
        if(input.isEmpty())
            return;
        database.delete1(input);

        Toast.makeText(this, "# "+database.count_records(), Toast.LENGTH_SHORT).show();



    }
}
