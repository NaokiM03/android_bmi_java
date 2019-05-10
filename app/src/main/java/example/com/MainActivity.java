package example.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 使う部品を紐づける (インスタンス化)
        // 身長・体重の入力欄 (EditText)
        final EditText etHeight = findViewById(R.id.hValue);
        final EditText etWeight = findViewById(R.id.wValue);

        // 計算ボタン (Button)
        Button btCalc = findViewById(R.id.calculate);

        // 計算結果の表示欄 (TextView)
        final TextView tvResult = findViewById(R.id.resultText);

        // クリックイベントの取得
        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String output = "";

                // クリック時の処理を記述する
                // 入力された身長・体重で取得する
                String height_str = etHeight.getText().toString();
                String weight_str = etWeight.getText().toString();

                // 取得した文字列を数値に変換する
                float height_float = Float.parseFloat(height_str);
                float weight_float = Float.parseFloat(weight_str);

                float bmi_float = weight_float / (height_float/100) / (height_float/100);
                String bmi_str = String.format("%.1f", bmi_float);
                output = "BMI: " + bmi_str + "\n";

                float std_weight_float = Float.parseFloat("22.00") * (height_float/100) * (height_float/100);
                String std_weight_str = String.format("%.1f", std_weight_float);
                output = output + "標準体重: " + std_weight_str + "kg\n";

                String fat_score = "";
                if (bmi_float < 18.5) {
                    fat_score = "低体重";
                } else if (bmi_float < 25) {
                    fat_score = "標準体重";
                } else if (bmi_float < 30) {
                    fat_score = "肥満１";
                } else if (bmi_float < 35) {
                    fat_score = "肥満２";
                } else if (bmi_float < 40) {
                    fat_score = "肥満３";
                } else {
                    fat_score = "肥満４";
                }

                output = output + "肥満度: " + fat_score;

                // 例 結果表示欄のメッセージを変える
                tvResult.setText(output);
            }
        });
    }
}
