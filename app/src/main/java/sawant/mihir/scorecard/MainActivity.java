package sawant.mihir.scorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {


    EditText studentName;
    EditText physicsMarks;
    EditText chemistryMarks;
    EditText mathsMarks;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentName = findViewById(R.id.studentName);
        physicsMarks = findViewById(R.id.phyMarks);
        chemistryMarks = findViewById(R.id.chemMarks);
        mathsMarks = findViewById(R.id.mathMarks);

        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(view  ->{
            String name = studentName.getText().toString();
            if(name == null || name.length() == 0){
                Toast errorToast = Toast.makeText(this,
                        "Please Enter Name", Toast.LENGTH_SHORT);
                errorToast.show();
            } else{

               String ph = physicsMarks.getText().toString();
                String ch = chemistryMarks.getText().toString();
                String ma = mathsMarks.getText().toString();

                if(ph.length() == 0 || ch.length() == 0 || ma.length() == 0){
                    Toast.makeText(this,
                            "Please enter marks", Toast.LENGTH_LONG).show();
                }



                int phy = Integer.parseInt(ph);
                int che = Integer.parseInt(ch);
                int mat = Integer.parseInt(ma);



                if(phy > 100 || che > 100 || mat > 100){
                    Toast.makeText(this, "Obtained marks cannot be greater than 100",
                            Toast.LENGTH_LONG).show();
                }

                double totalMarks = phy + che + mat;
                double avg = totalMarks / 3;


                String resultData = String.format(Locale.getDefault(),
                        "Your score is %.2f%%", avg);

                Toast.makeText(this, resultData , Toast.LENGTH_SHORT).show();

                Bundle appBundle = new Bundle();
                String[] values = {name, resultData};
                appBundle.putStringArray("values", values);

                Intent scoreSendIntent = new Intent(this, DisplayCard.class);
//                scoreSendIntent.putExtra("studentName", name);
//                scoreSendIntent.putExtra("studentScore", resultData);
                if(scoreSendIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(scoreSendIntent);
                }

            }
        });
    }
}