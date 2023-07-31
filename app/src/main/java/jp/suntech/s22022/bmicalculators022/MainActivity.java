package jp.suntech.s22022.bmicalculators022;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCal = findViewById(R.id.btCal);
        HelloListener listener = new HelloListener();
        btCal.setOnClickListener(listener);

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }
    private class HelloListener implements View.OnClickListener {
        @SuppressLint("SetTextI18n")
        public void onClick(View view){
            EditText age = findViewById(R.id.etAge);
            EditText height = findViewById(R.id.etHeight);
            EditText weight = findViewById(R.id.etWeight);
            TextView output1 = findViewById(R.id.tvOutput1);
            TextView output2 = findViewById(R.id.tvOutput2);
            TextView output3 = findViewById(R.id.tvOutput3);
            TextView output4 = findViewById(R.id.tvOutput4);

            String SAge = age.getText().toString();
            int Age = Integer.parseInt(SAge);
            String SHeight = height.getText().toString();
            float Height = Float.parseFloat(SHeight);
            String SWeight = weight.getText().toString();
            float Weight = Float.parseFloat(SWeight);
            float BMI = Weight / (Height / 100 * Height / 100);
            float IBW = (Height / 100 * Height / 100) * 22;

            int id = view.getId();
            if(id==R.id.btCal&&16 > Age){
                ConfirmDialogFragment dialogFragment = new ConfirmDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "ConfirmDialogFragment");
            }
            else if (id==R.id.btCal&&16 <= Age) {
                if (18.5 > BMI){
                    String under = getString(R.string.deg_under);
                    output1.setText("あなたの肥満度は");
                    output2.setText(under);
                    output3.setText("あなたの適正体重は");
                    output4.setText(String.format("%.1f  kg",Float.valueOf(IBW)));
                }
                else if (18.5<=BMI&&25>BMI){
                    String normal = getString(R.string.deg_normal);
                    output1.setText("あなたの肥満度は");
                    output2.setText(normal);
                    output3.setText("あなたの適正体重は");
                    output4.setText(String.format("%.1f  kg",Float.valueOf(IBW)));
                }
                else if (25<=BMI&&30>BMI){
                    String lv1 = getString(R.string.deg_lv1);
                    output1.setText("あなたの肥満度は");
                    output2.setText(lv1);
                    output3.setText("あなたの適正体重は");
                    output4.setText(String.format("%.1f  kg",Float.valueOf(IBW)));
                }
                else if (30<=BMI&&35>BMI) {
                    String lv2 = getString(R.string.deg_lv2);
                    output1.setText("あなたの肥満度は");
                    output2.setText(lv2);
                    output3.setText("あなたの適正体重は");
                    output4.setText(String.format("%.1f  kg",Float.valueOf(IBW)));
                }
                else if (35<=BMI&&40>BMI) {
                    String lv3 = getString(R.string.deg_lv3);
                    output1.setText("あなたの肥満度は");
                    output2.setText(lv3);
                    output3.setText("あなたの適正体重は");
                    output4.setText(String.format("%.1f  kg",Float.valueOf(IBW)));
                }
                else if (40<=BMI) {
                    String lv4 = getString(R.string.deg_lv4);
                    output1.setText("あなたの肥満度は");
                    output2.setText(lv4);
                    output3.setText("あなたの適正体重は");
                    output4.setText(String.format("%.1f  kg",Float.valueOf(IBW)));
                }
            }
        }
    }
}