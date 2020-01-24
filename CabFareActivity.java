package txstate.edu.sdd65;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CabFareActivity extends AppCompatActivity {

    //Initial Fee + Rate per Mile
    double dblInitialFee = 3.00;
    double dblMileageRate = 3.25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab_fare);

        final EditText txtMileage = findViewById(R.id.txtMileage);
        final Spinner txtCabs = findViewById(R.id.spnRequestedCab);
        final TextView txtFareResults = findViewById(R.id.txtFareResults);

        Button btnCalculate = findViewById(R.id.btnCalculateFare);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Data Processing
                String strMileage = txtMileage.getText().toString();
                double dblMileageEntered = 0;

                try {
                    dblMileageEntered  = Double.parseDouble(strMileage) ;
                } catch (Exception ex){
                    Toast.makeText(CabFareActivity.this, "Please enter a number", Toast.LENGTH_LONG).show();
                    return;
                }

                String strSelectedCab = txtCabs.getSelectedItem().toString();
                double dblTotalCost = dblInitialFee + (dblMileageRate * dblMileageEntered);

                DecimalFormat currency = new DecimalFormat("$###,###.00");

                txtFareResults.setText("Cost: " + currency.format(dblTotalCost) + " for cab type: " + strSelectedCab);
            }
        });



    }
}