package lukasz.pl.aplikacja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button button;
    Button clearButton;

    EditText editText1;
    EditText editText2;

    int a,b,sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        clearButton = findViewById(R.id.clearButton);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        Toast.makeText(getBaseContext(), "Witaj w aplikacji!!", Toast.LENGTH_SHORT).show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a = Integer.parseInt(editText1.getText().toString());
                b = Integer.parseInt(editText2.getText().toString());
                sum = getSum(a,b);
                text.setText(String.valueOf(sum));

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clear();

            }
        });


    }

    public int getSum(int a, int b) {
        return a+b;
    }

    public void clear(){
        text.setText("");
        editText1.setText("");
        editText2.setText("");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        sum = savedInstanceState.getInt("sum");
        text.setText(String.valueOf(sum));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("sum", sum);
        super.onSaveInstanceState(outState);
    }


}
