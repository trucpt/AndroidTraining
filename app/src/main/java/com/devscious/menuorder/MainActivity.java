package com.devscious.menuorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button btnConfirmation = (Button) findViewById(R.id.confirmation);
    btnConfirmation.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(view.getContext(), ConfirmOrder.class);
                    startActivityForResult(myIntent, 0);
                }
            }
    );
    ButterKnife.bind(this);
  }
}
