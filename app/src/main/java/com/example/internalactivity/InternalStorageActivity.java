package com.example.internalactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String FILENAME = "namafile.txt";
    Button buatFile, ubahFile, bacaFile, hapusFile;
    TextView textBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_internal);
        buatFile = findViewById(R.id.btn_buatFile);
        ubahFile = findViewById(R.id.btn_ubahFile);
        bacaFile = findViewById(R.id.btn_readFile);
        hapusFile = findViewById(R.id.btn_hapus_File);
        textBaca = findViewById(R.id.textBaca);

        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        hapusFile.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        try {
            jalankanPerintah(view.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void jalankanPerintah(int id) throws IOException {
        switch (id){
            case R.id.btn_buatFile:
            buatFile();
            break;
            case R.id.btn_readFile:
            bacaFile();
            break;
            case R.id.btn_ubahFile:
            ubahFile();
            break;
            case R.id.btn_hapus_File:
            hapusFile();
            break;
        }
        }

    private void ubahFile() {
    }

    private void hapusFile() {
        File file = new File(getFilesDir(), FILENAME);
        if (file.exists()){
            file.delete();
        }
    }


    private void bacaFile() throws IOException {
        File file = new File(getFilesDir(),FILENAME);
        if (file.canRead()){
            file.canRead();
        }
    }


    private void buatFile() throws IOException {
        File file = new File (getFilesDir(), FILENAME);
        if (file.createNewFile()){
            file.createNewFile();
        }
    }


    public void actionCreate(View view) {
        String isiFile = "Coba Isi Data File Text";
        File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

   }