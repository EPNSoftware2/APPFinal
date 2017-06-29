package com.example.usuario.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText editUsuario;
    EditText editemail;
    EditText editpassword;
    RadioButton editgender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void registrarUsuario(View view){

        String usuario = editUsuario.getText().toString();
        String email = editemail.getText().toString();
        String password = editpassword.getText().toString();
        String gender = editgender.getText().toString();

        //validacion para el ingreso de datos
        if(usuario.length() > 0 && email.length() > 0 && password.length() > 0
                && editgender.length() > 0){
            //Llamada al manejador de la base de datos
            HandlerBaseUsuario ddb = new HandlerBaseUsuario(this.getBaseContext());
            ddb.adduSUARIO(new Usuario(0,usuario,email,password,gender));
            Toast.makeText(this, "El CASO ha sido registrado con éxito", Toast.LENGTH_SHORT).show();
            //editIdentificacion.setText("");
            //editCliente.setText("");
            //editFechaIni.setText("");
            //editFechaFin.setText("");
            //editEstado.setText("");
        }
        else{
            Toast.makeText(this, "Debe ingresar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }
}
