package com.example.parcelables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.parcelables.databinding.ActivityUsuarioBinding;

public class ActivityUsuario extends AppCompatActivity {
    public static final String USUARIO_KEY ="usuario";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUsuarioBinding binding = ActivityUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();
        Usuario usuario = extras.getParcelable(USUARIO_KEY);
        binding.setUsuario(usuario);
        String usua =usuario.getNombre();
        String contra =usuario.getContraseña();
        binding.txtNombre.setText(usua);
        int contador = 0;
        char arreglo[] = contra.toCharArray();
        for (int i = 0; i < contra.length(); i++) {
            if (arreglo[i]=='?' || arreglo[i]=='*' || arreglo[i]=='?' || arreglo[i]=='¡' || arreglo[i]=='!' || arreglo[i]=='#' || arreglo[i]=='$' || arreglo[i]=='%' || arreglo[i]=='&') {
                contador= contador+1;
            }
        }

        if(contra.length()>11 && contador>3 ){
        binding.valcontra.setRating(5);
        binding.txtvalcontra.setText("ALTA");
        }else if (contra.length()==10 || (contra.length()==11 && contador==2 ||  contador==3) ){
            binding.valcontra.setRating(4);
            binding.txtvalcontra.setText("MEDIA ALTA");
        }else if(contra.length()>7 && contra.length()<10  && contador==1 ){
            binding.valcontra.setRating(3);
            binding.txtvalcontra.setText("MEDIA   ");

        }else if(contra.length()>7 && contra.length()<10 && contador==0){
            binding.valcontra.setRating(2);
            binding.txtvalcontra.setText("BAJA");
        }
        else if(contra.length()==5 && contador==0){
            binding.valcontra.setRating(1);
            binding.txtvalcontra.setText("INSEGURA");
        }
    }
    public static boolean valid(String v) {
        return v.matches("(?=.*[*?¡!#$%&])");
    }
}