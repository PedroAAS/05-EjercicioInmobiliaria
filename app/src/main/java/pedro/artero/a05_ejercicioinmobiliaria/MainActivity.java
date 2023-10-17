package pedro.artero.a05_ejercicioinmobiliaria;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;

import pedro.artero.a05_ejercicioinmobiliaria.databinding.ActivityMainBinding;
import pedro.artero.a05_ejercicioinmobiliaria.modelos.Inmueble;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<Inmueble> listaInmuebles;

    private ActivityResultLauncher<Intent> addInmuebleLauncher;
    private ActivityResultLauncher<Intent> editInmuebleLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        listaInmuebles = new ArrayList<>();
        inicializarLaunchers();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInmuebleLauncher.launch(new Intent(MainActivity.this, CrearInmuebleActivity.class));

            }
        });
    }

    private void inicializarLaunchers() {

        addInmuebleLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // que hago a la vuelta de crear inmuble
                    }
                }
        );
        editInmuebleLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // que hago a la vuelta de editar inmueble
                    }
                }
        );
    }

}