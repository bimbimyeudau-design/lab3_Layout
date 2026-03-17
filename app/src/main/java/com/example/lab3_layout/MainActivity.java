package com.example.lab3_layout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtSoA, edtSoB;
    private Button btnCong, btnTru, btnNhan, btnChia;
    private TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        tvKetQua = findViewById(R.id.tvKetQua);

        // Gán sự kiện cho các nút
        btnCong.setOnClickListener(v -> calculate('+'));
        btnTru.setOnClickListener(v -> calculate('-'));
        btnNhan.setOnClickListener(v -> calculate('*'));
        btnChia.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {
        String sA = edtSoA.getText().toString().trim();
        String sB = edtSoB.getText().toString().trim();

        if (sA.isEmpty() || sB.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập số A và B", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double a = Double.parseDouble(sA);
            double b = Double.parseDouble(sB);
            double result = 0;

            switch (operator) {
                case '+': result = a + b; break;
                case '-': result = a - b; break;
                case '*': result = a * b; break;
                case '/':
                    if (b == 0) {
                        tvKetQua.setText("Kết quả: Lỗi chia cho 0");
                        return;
                    }
                    result = a / b;
                    break;
            }
            tvKetQua.setText("Kết quả: " + result);
        } catch (Exception e) {
            tvKetQua.setText("Kết quả: Lỗi định dạng");
        }
    }
}