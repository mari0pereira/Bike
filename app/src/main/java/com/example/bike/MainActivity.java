package com.example.bike;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bike.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Verifica se o usuário está logado
        BikeSession bikeSession = (BikeSession) getApplication();
        if (!bikeSession.isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        // Configura o ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Direciona para a página Mountain Bike
        binding.btnMTB.setOnClickListener(v -> {
            Intent intent = new Intent(this, BicicletasActivity.class);
            intent.putExtra("categoria", "Mountain Bike");
            startActivity(intent);
        });

        // Direciona para a página Gravel
        binding.btnGravel.setOnClickListener(v -> {
            Intent intent = new Intent(this, BicicletasActivity.class);
            intent.putExtra("categoria", "Gravel");
            startActivity(intent);
        });
    }
}