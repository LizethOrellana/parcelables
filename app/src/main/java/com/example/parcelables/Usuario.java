package com.example.parcelables;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
    private String Nombre;
    private String Contraseña;

    public Usuario(String nombre, String contraseña) {
        Nombre = nombre;
        Contraseña = contraseña;
    }

    protected Usuario(Parcel in) {
        Nombre = in.readString();
        Contraseña = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Nombre);
        dest.writeString(Contraseña);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }


}
