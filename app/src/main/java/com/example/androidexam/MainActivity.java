package com.example.androidexam;

        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText numberOfStudents;
    EditText aStudents;
    EditText bStudents;
    EditText cStudents;
    EditText dStudents;
    EditText fStudents;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    float classTotal, aTotal, bTotal, cTotal, dTotal, fTotal;

    float aPercent, bPercent, cPercent, dPercent, fPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOfStudents = (EditText)findViewById(R.id.eTNumberOfStudents);
        aStudents = (EditText)findViewById(R.id.eTAStudents);
        bStudents = (EditText)findViewById(R.id.eTBStudents);
        cStudents = (EditText)findViewById(R.id.eTCStudents);
        dStudents = (EditText)findViewById(R.id.eTDStudents);
        fStudents = (EditText)findViewById(R.id.eTFStudents);



    }

    public void computePercentage(View view) {
        sharedPref = getSharedPreferences("Percentages", MODE_PRIVATE);
        editor = sharedPref.edit();

        classTotal = Float.parseFloat(numberOfStudents.getText().toString());
        aTotal = Float.parseFloat(aStudents.getText().toString());
        bTotal = Float.parseFloat(bStudents.getText().toString());
        cTotal = Float.parseFloat(cStudents.getText().toString());
        dTotal = Float.parseFloat(dStudents.getText().toString());
        fTotal = Float.parseFloat(fStudents.getText().toString());

        aPercent = (aTotal/classTotal)*100;
        bPercent = (bTotal/classTotal)*100;
        cPercent = (cTotal/classTotal)*100;
        dPercent = (dTotal/classTotal)*100;
        fPercent = (fTotal/classTotal)*100;

        editor.putFloat("a%", aPercent);
        editor.commit();
        editor.putFloat("b%", bPercent);
        editor.putFloat("c%", cPercent);
        editor.putFloat("d%", dPercent);
        editor.putFloat("f%", fPercent);
        editor.commit();


        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("The percentages of grade distribution: \n \n" +
                "A's: " + aPercent + "% \n" + "B's: " + bPercent + "% \n" +
                "C's: " + cPercent + "% \n" + "D's: " + dPercent + "% \n" +
                "F's: " + fPercent + "% \n");
        dlgAlert.setTitle("");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(MainActivity.this, Graph.class));
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();


        }
    }

