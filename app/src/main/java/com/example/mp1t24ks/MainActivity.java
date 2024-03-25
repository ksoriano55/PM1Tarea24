package com.example.mp1t24ks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import Configurations.SQLiteConexion;
import Configurations.Transaccion;

public class MainActivity extends AppCompatActivity {
    private Signature signature;
    private MaterialButton btnLimpiarfirma, btnGuardar, btnVerListado;
    private TextInputEditText txtDescripcion;
    private byte[] firma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDescripcion =  findViewById(R.id.txtDescripcion);
        signature = findViewById(R.id.Signature);
        btnLimpiarfirma = findViewById(R.id.btnLimpiar);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnVerListado = findViewById(R.id.btnVerFirmas);

        btnLimpiarfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signature.limpiarFirma();
            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregarRegistro();
            }
        });
        btnVerListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AgregarRegistro()
    {
        SQLiteConexion conexion = new SQLiteConexion(this, Transaccion.DBName, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        firma = signature.obtenerFirma();
        ContentValues valores = new ContentValues();
        valores.put(Transaccion.descripcion, txtDescripcion.getText().toString());
        valores.put(Transaccion.firmadigital, firma);

        Long resultado = db.insert(Transaccion.TableFirmas, Transaccion.id, valores);

        Toast.makeText(getApplicationContext(), "Registro Ingresado con exito " + resultado.toString(),
                Toast.LENGTH_LONG).show();

        db.close();
    }
}