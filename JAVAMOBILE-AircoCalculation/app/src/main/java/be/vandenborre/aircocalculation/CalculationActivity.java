package be.vandenborre.aircocalculation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CalculationActivity extends AppCompatActivity {

    Button btn_Calculate;
    RadioButton radioButton;
    EditText txt_Length, txt_Width, txt_Height;
    TextView txt_Error;
    double length, width, height, watt, btu, m3;
    RadioGroup btn_Rgroup;
    String str_length, str_width, str_height;
    Bundle args;

    DialogFragment solutionDialog = new SolutionDialog();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        //Set buttons and textfields

        btn_Calculate = findViewById(R.id.btn_calculate);
        btn_Rgroup = findViewById(R.id.RGroup);

        txt_Length = findViewById(R.id.txt_length);
        txt_Height = findViewById(R.id.txt_height);
        txt_Width = findViewById(R.id.txt_width);
        txt_Error= findViewById(R.id.txt_error);

        btn_Calculate.setOnClickListener((View.OnClickListener) view -> {
            str_height = txt_Height.getText().toString();
            str_length = txt_Length.getText().toString();
            str_width = txt_Width.getText().toString();
            if (str_length.length() == 0 || str_width.length() == 0 || str_height.length() == 0){
                txt_Error.setText("Je dient alle velden in te vullen.");
            }
            else{
            length = Double.parseDouble(str_length);
            width = Double.parseDouble(str_width);
            height = Double.parseDouble(str_height);
            m3 = (length/100)*(width/100)*(height/100);

            int selectedBtn = btn_Rgroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedBtn);

                switch(selectedBtn){
                    case R.id.btn_low:
                        calculation(30);
                        args = new Bundle();
                        args.putDouble("watt", watt);
                        args.putDouble("Btu", btu);
                        solutionDialog.setArguments(args);
                        solutionDialog.show(getSupportFragmentManager(), "SolutionDialog");
                        break;

                    case R.id.btn_medium:
                        calculation(40);
                        args = new Bundle();
                        args.putDouble("watt", watt);
                        args.putDouble("Btu", btu);
                        solutionDialog.setArguments(args);
                        solutionDialog.show(getSupportFragmentManager(), "SolutionDialog");
                        break;
                    case R.id.btn_high:
                        calculation(50);
                        args = new Bundle();
                        args.putDouble("watt", watt);
                        args.putDouble("Btu", btu);
                        solutionDialog.setArguments(args);
                        solutionDialog.show(getSupportFragmentManager(), "SolutionDialog");
                        break;
                }
            }

        });
    }
    public void calculation(int i){
        watt = m3*i;
        // 1 Watt is gelijk aan 3,41 BTU.
        btu = watt * 3.41;}
}