package sg.edu.rp.c346.simpletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTask;
    Button btnAdd, btnClear;
    ListView lvTodo;
    ArrayList<String> alTodo = new ArrayList<String>();
    ArrayAdapter<String> aaTodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = (EditText)findViewById(R.id.editTextTask);
        btnAdd = (Button)findViewById(R.id.buttonAdd);
        btnClear = (Button)findViewById(R.id.buttonClear);
        lvTodo = (ListView)findViewById(R.id.ListViewTodo);

        aaTodo = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alTodo);
        lvTodo.setAdapter(aaTodo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etTask.getText().toString().isEmpty()){ //alternative way of ".trim().length() != 0"
                    String task = etTask.getText().toString();
                    etTask.setText("");
                    alTodo.add(task);
                    aaTodo.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please enter a task!"  , Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etTask.setText("");
                alTodo.clear();
                aaTodo.notifyDataSetChanged();
            }
        });
    }
}
