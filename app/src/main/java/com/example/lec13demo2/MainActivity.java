package com.example.lec13demo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] fruits = new String[] {"Tao", "Nho","Chuoi", "Wiki"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnToast = findViewById(R.id.button);
        Button btnAlert = findViewById(R.id.button2);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"hello Toast",Toast.LENGTH_LONG).show();
            }
        });
       btnAlert.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
              builder.setTitle("Xoa File");
              builder.setMessage("Ban co chac muon xoa File nay k?");
              builder.setPositiveButton("Có chứ", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      Toast.makeText(MainActivity.this,"Ban da xoa",Toast.LENGTH_LONG).show();
                  }
              });

               builder.setNegativeButton("Bỏ qua", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(MainActivity.this,"Bỏ qua",Toast.LENGTH_LONG).show();
                   }
               });

              AlertDialog dialog = builder.create();
              dialog.show();
           }
       });

       //phia cuoi cua onCreate
        ListView listView = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,fruits);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedFood = fruits[position];
                Toast.makeText(MainActivity.this,"You selected " + selectedFood,Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle item selection.
        if (item.getItemId() == R.id.menu_file)
            Toast.makeText(MainActivity.this,"File clicked", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"Edit option clicek ", Toast.LENGTH_LONG).show();
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

}