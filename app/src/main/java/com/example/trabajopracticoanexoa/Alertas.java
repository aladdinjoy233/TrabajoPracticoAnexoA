package com.example.trabajopracticoanexoa;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Alertas {

    public static void mostrarDialogoSalida(Context context) {
        new AlertDialog.Builder(context)
            .setTitle("Salida")
            .setMessage("¿Desea cerrar el programa?")
            .setPositiveButton("Si", (dialog, which) -> ((AppCompatActivity) context).finishAndRemoveTask())
            .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
            .show();
    }
}
