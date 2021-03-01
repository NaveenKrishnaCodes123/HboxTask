package in.hbox.hboxtask;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CountryDetails extends AppCompatActivity {

    TextView country, capital, currency;
    TextView dateOne, dateTwo, textView;
    Calendar c1, c2;
    Button button, buttonOne;
    EditText editText;
    Spinner spColors;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        country = findViewById(R.id.country);
        capital = findViewById(R.id.capital);
        currency = findViewById(R.id.currency);

        dateOne = findViewById(R.id.date_one);
        dateTwo = findViewById(R.id.date_two);
        button = findViewById(R.id.button);
        buttonOne = findViewById(R.id.button_one);
        textView = findViewById(R.id.textView);

        editText = findViewById(R.id.editText);
        spColors = findViewById(R.id.sp_colors);

        String countryValue = getIntent().getExtras().getString("country");
        String capitalValue = getIntent().getExtras().getString("capital");
        String currencyValue = getIntent().getExtras().getString("currency");

        country.setText(countryValue);
        capital.setText(capitalValue);
        currency.setText(currencyValue);

        textView.setTextColor(getResources().getColor(R.color.blue));
        buttonOne.setOnClickListener(v -> {
            if (TextUtils.isEmpty(editText.getText().toString())) {
                Toast.makeText(CountryDetails.this, "Please Enter Text", Toast.LENGTH_SHORT).show();
            } else {

                textView.setText(editText.getText().toString());

                if (spColors.getSelectedItemPosition() ==0) {
                    textView.setTextColor(getResources().getColor(R.color.blue));
                }else  if (spColors.getSelectedItemPosition() ==1) {
                    textView.setTextColor(getResources().getColor(R.color.red));
                }else  if (spColors.getSelectedItemPosition() ==2) {
                    textView.setTextColor(getResources().getColor(R.color.green));
                }


            }

        });

        button.setOnClickListener(view -> {

            try {
                String d1 = dateOne.getText().toString();
                String d2 = dateTwo.getText().toString();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                Date date1 = simpleDateFormat.parse(d1);
                Date date2 = simpleDateFormat.parse(d2);
                long difference = Math.abs(date1.getTime() - date2.getTime());

                long difftDays = difference / (24 * 60 * 60 * 1000);

                Toast.makeText(CountryDetails.this, String.valueOf(difftDays), Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                        CountryDetails.this);
                alertDialog2.setTitle("Task 3");
                alertDialog2.setMessage("In Between the days are : "+difftDays+" days");
                alertDialog2.setIcon(R.drawable.country);

                alertDialog2.setNegativeButton("Close",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog2.show();

            } catch (Exception ex) {

                ex.printStackTrace();
            }
        });

        dateOne.setOnClickListener(v -> {
            // calender class's instance and get current date , month and year from calender
            c1 = Calendar.getInstance();
            int mYear = c1.get(Calendar.YEAR); // current year
            int mMonth = c1.get(Calendar.MONTH); // current month
            int mDay = c1.get(Calendar.DAY_OF_MONTH); // current day
            // date picker dialog
            datePickerDialog = new DatePickerDialog(CountryDetails.this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    // set day of month , month and year value in the edit text

                    String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                    String mon = MONTHS[monthOfYear];

                    dateOne.setText(dayOfMonth + "-" + (mon) + "-" + year);

                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        });

        dateTwo.setOnClickListener(v -> {
            c2 = Calendar.getInstance();
            int mYear = c2.get(Calendar.YEAR); // current year
            int mMonth = c2.get(Calendar.MONTH); // current month
            int mDay = c2.get(Calendar.DAY_OF_MONTH); // current day
            // date picker dialog
            datePickerDialog = new DatePickerDialog(CountryDetails.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    // set day of month , month and year value in the edit text
                    String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                    String mon = MONTHS[monthOfYear];
                    dateTwo.setText(dayOfMonth + "-" + (mon) + "-" + year);

                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        });

    }
}