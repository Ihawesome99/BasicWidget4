package smktelkom.learn.basicwidget4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    CheckBox cbBC, cbOR, cbGB, cbNL, cbNF;
    TextView tvHasil, tvHobi;
    int nHobi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbBC = findViewById(R.id.checkBoxBC);
        cbOR = findViewById(R.id.checkBoxOR);
        cbGB = findViewById(R.id.checkBoxGB);
        cbNL = findViewById(R.id.checkBoxNL);
        cbNF = findViewById(R.id.checkBoxNF);

        cbBC.setOnCheckedChangeListener(this);
        cbOR.setOnCheckedChangeListener(this);
        cbGB.setOnCheckedChangeListener(this);
        cbNL.setOnCheckedChangeListener(this);
        cbNF.setOnCheckedChangeListener(this);

        tvHasil = findViewById(R.id.textViewHasil);
        tvHobi = findViewById(R.id.textViewHobi);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }

            private void doClick() {
                String hasil = "Hobi Anda :\n";
                int startlen = hasil.length();
                if (cbBC.isChecked()) hasil += cbBC.getText() + "\n";
                if (cbOR.isChecked()) hasil += cbOR.getText() + "\n";
                if (cbGB.isChecked()) hasil += cbGB.getText() + "\n";
                if (cbNL.isChecked()) hasil += cbNL.getText() + "\n";
                if (cbNF.isChecked()) hasil += cbNF.getText() + "\n";

                if (hasil.length() == startlen) hasil += "Tidak ada pada pilihan";
                tvHasil.setText(hasil);
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) nHobi += 1;
        else nHobi -= 1;

        tvHobi.setText("Hobi (" + nHobi + " terpilih)");
    }
}
