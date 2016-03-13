package polistudio.fr.it.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private Button calcola;
    private EditText altezza, peso;
    private TextView risposta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcola=(Button)findViewById(R.id.calcola);
        altezza=(EditText)findViewById(R.id.altezza);
        peso=(EditText)findViewById(R.id.peso);
        risposta=(TextView)findViewById(R.id.risposta);
        calcola.setOnClickListener(this);
        calcola.setEnabled(true); // dovremmo farlo solo dopo l'input negli altri campi...
    }

    @Override
    public void onClick(View v) {
        if (v==calcola) {
            try {
                double a = Double.parseDouble(altezza.getText().toString());
                double p = Double.parseDouble(peso.getText().toString());
                double bmi = p / (a * a);
                risposta.setText(String.format("%2.1f", bmi));
            } catch (Exception e) {
                risposta.setText("?");
            }
        }
    }
}
