package pl.lo3.list;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class ParameterActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText inputLand, inputCity, inputFrom, inputDown;
    private TextInputLayout inputLayoutLand, inputLayoutCity;
    private Button btnSave;
    private Spinner inputStop, inputLine;
    private int CalendarHour, CalendarMinute;

    Calendar calendar;
    TimePickerDialog timepickerdialog;
    ArrayAdapter<CharSequence> adapterStop;
    ArrayAdapter<CharSequence> adapterLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputLayoutLand = (TextInputLayout) findViewById(R.id.input_layout_land);
        inputLayoutCity = (TextInputLayout) findViewById(R.id.input_layout_city);
        inputLand = (EditText) findViewById(R.id.input_land);
        inputCity = (EditText) findViewById(R.id.input_city);
        inputStop = (Spinner) findViewById(R.id.input_stop);
        inputLine = (Spinner) findViewById(R.id.input_line);
        inputFrom =(EditText) findViewById(R.id.input_from);
        inputDown =(EditText) findViewById(R.id.input_down);

        //TODO zasilenie z zasobu (bazy, pliku) listy przystanków do przemyslenia ułatwienie wyszukania z długiej listy
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapterStop = ArrayAdapter.createFromResource(this,
                R.array.stop_array, android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        inputStop.setAdapter(adapterStop);

        //TODO zasilenie z zasobu (bazy, pliku) listy linii do przemyslenia ułatwienie wyszukania z długiej listy
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapterLine = ArrayAdapter.createFromResource(this,
                R.array.line_array, android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        inputLine.setAdapter(adapterLine);

        // ustawienie domyslne na inną wartość inputStop.setSelection(2);

        if(getIntent() != null)
        {
            // pobranie parametru
            String info = getIntent().getStringExtra("land");
            inputLand.setText(info);
            info = getIntent().getStringExtra("city");
            inputCity.setText(info);
        }

        btnSave = (Button) findViewById(R.id.btn_save);

        inputLand.addTextChangedListener(new MyTextWatcher(inputLand));
        inputCity.addTextChangedListener(new MyTextWatcher(inputCity));


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
        inputFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                CalendarHour = calendar.get(Calendar.HOUR_OF_DAY);
                CalendarMinute = calendar.get(Calendar.MINUTE);

                timepickerdialog = new TimePickerDialog(ParameterActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                   inputFrom.setText(hourOfDay + ":" + minute +":00");
                            }
                        }, CalendarHour, CalendarMinute, true);
                timepickerdialog.show();

            }
        });

        inputDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                CalendarHour = calendar.get(Calendar.HOUR_OF_DAY);
                CalendarMinute = calendar.get(Calendar.MINUTE);

                timepickerdialog = new TimePickerDialog(ParameterActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                inputDown.setText(hourOfDay + ":" + minute +":00");
                            }
                        }, CalendarHour, CalendarMinute, true);
                timepickerdialog.show();

            }
        });

        inputStop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedClass = parent.getItemAtPosition(position).toString();
                switch (selectedClass.substring(0,3)) {
                    case "250":
                        //TODO obsługa

                        break;
                    case "260":
                        //TODO obsługa

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });
    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateLand()) {
            return;
        }

        if (!validateCity()) {
            return;
        }




        Toast.makeText(getApplicationContext(), R.string.Conform, Toast.LENGTH_SHORT).show();
    }

    private boolean validateCity() {
        if (inputCity.getText().toString().trim().isEmpty()) {
            inputLayoutCity.setError(getString(R.string.err_msg_city));
            requestFocus(inputCity);
            return false;
        } else {
            inputLayoutCity.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateLand() {
        if (inputLand.getText().toString().trim().length()<3) {
            inputLayoutLand.setError(getString(R.string.err_msg_land));
            requestFocus(inputLand);
            return false;
        } else {
            inputLayoutLand.setErrorEnabled(false);
        }

        return true;
    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_city:
                    validateCity();
                    break;
                case R.id.input_land:
                    validateLand();
                    break;

            }
        }
    }
}
