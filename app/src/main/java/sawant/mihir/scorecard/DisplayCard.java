package sawant.mihir.scorecard;

import static java.util.ResourceBundle.getBundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ResourceBundle;

public class DisplayCard extends AppCompatActivity {

    TextView name;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_card);

        name = findViewById(R.id.displayName);
        score = findViewById(R.id.displayScore);

        Intent scoreSendIntent = getIntent();
        ResourceBundle appBundle = getBundle("values");

        // resource bundle used
        name.setText((CharSequence) scoreSendIntent.getExtras().get("studentName"));
        score.setText((CharSequence) scoreSendIntent.getExtras().get("studentScore"));
    }
}