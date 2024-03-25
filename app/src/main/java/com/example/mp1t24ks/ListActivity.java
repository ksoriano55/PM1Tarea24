package com.example.mp1t24ks;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

import Configurations.SQLiteConexion;
import Configurations.Transaccion;
import Models.Signatures;

public class ListActivity extends AppCompatActivity {

    ListView listImages;
    ArrayList<Signatures> lista;
    SimpleAdapter adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listImages = (ListView) findViewById(R.id.listView);
        ObtenerListado();
    }

    private void ObtenerListado() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transaccion.DBName, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();
        Signatures signture = null;
        lista = new ArrayList<Signatures>();

        Cursor cursor = db.rawQuery(Transaccion.SelectAllFirma, null);

        while(cursor.moveToNext()){
            signture = new Signatures();
            signture.setId(cursor.getInt(0));
            signture.setDescripcion(cursor.getString(1));
            signture.setFirmaDigital(cursor.getBlob(2));
            lista.add(signture);
        }

        SignatureAdapter adapter = new SignatureAdapter(this, R.layout.list_items, lista);
        listImages.setAdapter(adapter);
    }
}