package com.example.bike.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bike.models.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {
    @Query("SELECT * FROM usuarios")
    List<Usuario> getAll();

    @Query("SELECT * FROM usuarios WHERE email = :email AND senha = :senha LIMIT 1")
    Usuario login(String email, String senha);

    @Query("SELECT COUNT(*) FROM usuarios WHERE email = :email")
    int checkEmailExists(String email); // Verifica se já existe algum usuário com o email fornecido,
    // retornando a contagem (0 se não existir, número maior que 0 se existir).

    @Insert
    void insert(Usuario usuario);

    @Update
    void update(Usuario usuario);

    @Delete
    void delete(Usuario usuario);
<<<<<<< HEAD
=======

    // Alterar os dados do Usuário
    @Update
    void update(Usuario usuario);

    // Lista todos os usuários cadastrados
    @Query("SELECT * FROM usuarios")
    List<Usuario> getAllUsuarios();
>>>>>>> 3bbc52ef55c4b838b76e9e2cb4abb1ea17526c5e
}
