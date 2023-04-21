package com.example.ktlan2_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ktlan2_sqlite.dal.SQLiteHelper;
import com.example.ktlan2_sqlite.model.Item;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{
    public Spinner spinerCategory;
    private EditText edtTitle, edtPrice, edtDate;
    private Button btnUpdate, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        anhXa();
        btnUpdate.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        edtDate.setOnClickListener(this);
    }

    private void anhXa() {
        spinerCategory = findViewById(R.id.spinerCategory);
        edtTitle = findViewById(R.id.edtTitle);
        edtPrice = findViewById(R.id.edtPrice);
        edtDate = findViewById(R.id.edtDate);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnCancel = findViewById(R.id.btnCancel);
        spinerCategory.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spiner,
                        getResources().getStringArray(R.array.category)));
    }

    @Override
    public void onClick(View v) {
        if(v == edtDate){
            final Calendar c = Calendar.getInstance();
            int y = c.get(Calendar.YEAR);
            int m = c.get(Calendar.MONTH);
            int d = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(AddActivity.this, (view, year, month, dayOfMonth) -> {
                String date = "";
                if(month > 8){
                    date = dayOfMonth + "/" + (month + 1) + "/" + y;
                }
                else{
                    date = dayOfMonth + "/0" + (month + 1) + "/" + y;
                }
                edtDate.setText(date);
            }, y, m , d);
            dialog.show();
        }
        if (v== btnCancel) {
            finish();
        }
        if (v == btnUpdate){
            String title = edtTitle.getText().toString();
            String price = edtPrice.getText().toString();
            String date = edtDate.getText().toString();
            String catory = spinerCategory.getSelectedItem().toString();
            if(!title.isEmpty() && price.matches("\\d+")){
                Item item = new Item(title, catory, price, date);
                SQLiteHelper db = new SQLiteHelper(this);
                db.addItem(item);
                finish();
            }
        }
    }
}