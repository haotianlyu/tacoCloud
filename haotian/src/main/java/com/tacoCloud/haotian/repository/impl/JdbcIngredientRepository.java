package com.tacoCloud.haotian.repository.impl;

import com.tacoCloud.haotian.Enums.Type;
import com.tacoCloud.haotian.models.Ingredient;
import com.tacoCloud.haotian.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class JdbcIngredientRepository {

}
/*
@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Ingredient> findAll() {
        String sql = "SELECT id, name, type from Ingredient";
        //return jdbc.query(sql, this::mapRowToIngredient);

        return jdbc.query(sql, new RowMapper<Ingredient>() {
            @Override
            public Ingredient mapRow(ResultSet res, int rowNum) throws SQLException {
                return new Ingredient(
                            res.getString("id"),
                            res.getString("name"),
                            Type.valueOf(res.getString("type")));
            }
        });

    }

    @Override
    public Ingredient findById(String id) {
        String sql = "SELECT id, name, type FROM Ingredient WHERE id=?";
        return jdbc.queryForObject(sql, this::mapRowToIngredient, id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        String sql = "INSERT INTO ingredient (id, name, type) values (?, ?, ?)";
        jdbc.update(sql, ingredient.getId(), ingredient.getName(), ingredient.getType());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet res, int rowNum) throws SQLException {
        return new Ingredient(
                res.getString("id"),
                res.getString("name"),
                Type.valueOf(res.getString("type")));
    }
}
*/
