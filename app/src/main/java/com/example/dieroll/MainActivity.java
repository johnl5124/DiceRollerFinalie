package com.example.dieroll;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private EditText user_input;
    private int counter = 0;
    private TextView user_points;
    private TextView point_tracker;
    private TextView info1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        info1 = (TextView) findViewById(R.id.info);
        title = (TextView) findViewById(R.id.title);
        user_input = (EditText) findViewById(R.id.userInput);
        user_points = (TextView) findViewById(R.id.userpoints);
        point_tracker = (TextView) findViewById(R.id.counter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void on_button_click(View view)
    {
        //Rolling the die & button
        TextView tv = (TextView) this.findViewById(R.id.die_roll);
        Random r = new Random();
        int number = r.nextInt(6)+1;
        tv.setText(Integer.toString(number));

        //User input casted to int
        int n = Integer.parseInt(user_input.getText().toString());

        if (n < 1 || n > 6)
        {
            //User input validation
            Toast.makeText(this, "Error, please enter a number by 1 and 6", Toast.LENGTH_SHORT).show();
        }
        else if (n == number)
        {
            //Correct answer
            counter = counter + 5;
            user_points.setVisibility(View.VISIBLE);
            user_points.setText(Integer.toString(counter));
        }
        else
        {
            //Wrong answer
            counter = counter - 1;
            user_points.setVisibility(View.VISIBLE);
            user_points.setText(Integer.toString(counter));
        }
        if (counter <= -10)
        {
            //Lost game
            Toast.makeText(this, "Unlucky, you lost!", Toast.LENGTH_SHORT).show();
            TextView gameresult = (TextView) this.findViewById(R.id.info2);
            gameresult.setText("Better luck next time!");
            point_tracker.setText("You lost");
            user_points.setVisibility(View.INVISIBLE);
            info1.setVisibility(View.INVISIBLE);
            tv.setVisibility(View.INVISIBLE);
            user_input.setVisibility(View.INVISIBLE);
        }
        else if (counter >= 10)
        {
            //Won game
            Toast.makeText(this, "Well done! You had luck on your side", Toast.LENGTH_SHORT).show();
            TextView gameresult = (TextView) this.findViewById(R.id.info2);
            gameresult.setText("Congratulations!");
            point_tracker.setText("You beat the game!");
            user_points.setVisibility(View.INVISIBLE);
            info1.setVisibility(View.INVISIBLE);
            tv.setVisibility(View.INVISIBLE);
            user_input.setVisibility(View.INVISIBLE);
        }
    }

    public void d_ice_click(View view)
    {
        //Toast.makeText(this, "If you could go anywhere in the world, where would you go?", Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "If you were stranded on a desert island, what three thigs would you want to take with you?", Toast.LENGTH_SHORT).show();

        Random r = new Random();
        int number = r.nextInt(6)+1;

        if (number == 1)
        {
            Toast.makeText(this, "If you could go anywhere in the world, where would you go?", Toast.LENGTH_SHORT).show();
        }
        else if (number == 2)
        {
            Toast.makeText(this, "If you were stranded on a desert island, what three things would you want to take with you?", Toast.LENGTH_SHORT).show();
        }
        else if (number == 3)
        {
            Toast.makeText(this, "If you could eat only one food for the rest of your life, what would it be?", Toast.LENGTH_SHORT).show();
        }
        else if (number == 4)
        {
            Toast.makeText(this, "If you won a million dollars, what is the first thing you would buy?", Toast.LENGTH_SHORT).show();
        }
        else if (number == 5)
        {
            Toast.makeText(this, "If you could spend the day with one fictional character, who would it be?", Toast.LENGTH_SHORT).show();
        }
        else if(number == 6)
        {
            Toast.makeText(this, "If you found a magic lantern and a genie gave you three wishes, what would they be?", Toast.LENGTH_SHORT).show();
        }
    }

    public void add_new_icebreaker(View view)
    {
        Intent i = new Intent(getApplicationContext(),add_icebreaker.class);
        startActivity(i);
    }

    public void finish_menu(View view)
    {
        Intent i = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(i);
    }
}
