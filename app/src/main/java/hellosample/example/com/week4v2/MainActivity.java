package hellosample.example.com.week4v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Single CheckBox
        CheckBox checkBox = (CheckBox) findViewById(R.id.singleCheckbox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            //implement the event handler method
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(getBaseContext(), "Single CheckBox Checked", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "Single CheckBox Unchecked", Toast.LENGTH_LONG).show();
                }
            }
        });

        //RadioGroups
        //create the radio group reference
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RadioGroup01);
        //register the radio group reference with a click listener
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            //implement the event handler method
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1 = (RadioButton) findViewById(R.id.RadioButton01);
                if (rb1.isChecked()) {
                    Toast.makeText(getBaseContext(), "Radio Button 1 checked", Toast.LENGTH_LONG).show();
                }
                RadioButton rb2 = (RadioButton) findViewById(R.id.RadioButton02);
                if (rb2.isChecked()) {
                    Toast.makeText(getBaseContext(), "Radio Button 2 checked", Toast.LENGTH_LONG).show();
                }
                RadioButton rb3 = (RadioButton) findViewById(R.id.RadioButton03);
                if (rb3.isChecked()) {
                    Toast.makeText(getBaseContext(), "Radio Button 3 checked", Toast.LENGTH_LONG).show();
                }
                RadioButton rb4 = (RadioButton) findViewById(R.id.RadioButton04);
                if (rb4.isChecked()) {
                    Toast.makeText(getBaseContext(), "Radio Button 4 checked", Toast.LENGTH_LONG).show();
                }

            }
        });

        // ToggleButton
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggle_button);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            //implement the event handler method
            public void onClick(View v) {
                if (((ToggleButton) v).isChecked())
                    Toast.makeText(getBaseContext(), "Toggle Button On", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "Toggle Button Off", Toast.LENGTH_LONG).show();
            }
        });


        // input validation
        // the layout limits us to 10 characters
        // the filter turns everything in uppercase
        final EditText text_filtered = (EditText) findViewById(R.id.validated_input);
        text_filtered.setFilters(new InputFilter[]{
                new InputFilter.AllCaps(), new InputFilter.LengthFilter(10)
        });


        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);
        spinner.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Specify the layout to use when the list of choices appears
        spinner.setAdapter(adapter);// Apply the adapter to the spinner



    }


    /*You need to implement AdapterView.OnItemSelectedListener on the main class for this to work !!!!!*/
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        Toast.makeText(this, "Selected planet : " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}
