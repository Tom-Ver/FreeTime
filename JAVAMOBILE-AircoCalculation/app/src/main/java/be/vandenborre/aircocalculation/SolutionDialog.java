package be.vandenborre.aircocalculation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


public class SolutionDialog extends DialogFragment {

    double watt, btu;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        watt = getArguments().getDouble("watt");
        btu = getArguments().getDouble("Btu");
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("You need " + watt + " watt and " + btu + " BTU")
                .setTitle("Solution");
        Intent i = new Intent(getContext(), CalculationActivity.class);
        builder.setPositiveButton("Return", (dialog, id) -> startActivity(i));

        AlertDialog dialog = builder.create();

        return dialog;
    }
}
