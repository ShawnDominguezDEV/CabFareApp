package txstate.edu.sdd65;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CarWashActivity extends AppCompatActivity {

    double dblExteriorWashPrice = 0;
    double dblInteriorWashPrice = 0;
    double dblWashPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_wash);

        final EditText txtNumberOfWashes = findViewById(R.id.txtNumberOfWashes);
        final RadioButton radExterior = findViewById(R.id.radExteriorOnly);
        final RadioButton radPoundToKilo = findViewById(R.id.radExteriorAndInterior);
        final TextView txtWashResults = findViewById(R.id.txtWashResults);

        Button btnCalculate = findViewById(R.id.btnCalcPackage);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strNumberOfWashes = txtNumberOfWashes.getText().toString();

                int intNumberOfWashes = 0;

                try {
                    intNumberOfWashes = Integer.parseInt(strNumberOfWashes);
                } catch (Exception ex){
                    Toast.makeText(CarWashActivity.this, "Please enter a number", Toast.LENGTH_LONG).show();
                    return;
                }

                if(intNumberOfWashes < 12)
                {
                    Toast.makeText(CarWashActivity.this, "You must buy at least 12 washes to receive a discount.", Toast.LENGTH_LONG).show();
                }

                if (radExterior.isChecked()) {
                    if ( intNumberOfWashes >= 10) {
                        dblExteriorWashPrice = 8.5;

                        dblWashPrice = dblExteriorWashPrice * intNumberOfWashes;
                    } else {
                        dblExteriorWashPrice = 10.5;

                        dblWashPrice = dblExteriorWashPrice * intNumberOfWashes;
                    }
                }
                else {
                    if ( intNumberOfWashes >= 10) {
                        dblInteriorWashPrice = 12.5;

                        dblWashPrice = dblInteriorWashPrice * intNumberOfWashes;

                    } else {
                        dblInteriorWashPrice = 15.5;

                        dblWashPrice = dblInteriorWashPrice * intNumberOfWashes;
                    }
                }

                DecimalFormat currency = new DecimalFormat("$###,###.00");

                txtWashResults.setText("Cost: " + currency.format(dblWashPrice));

            }
        });
    }
}
