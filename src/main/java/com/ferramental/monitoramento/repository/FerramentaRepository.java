/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferramental.monitoramento.repository;

import com.ferramental.monitoramento.model.FerramentaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class FerramentaRepository {
    
    public int criar(FerramentaDTO ferramenta) {
        int linhas = 0;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement(
                    "INSERT INTO tb_ferramenta "
                    + "(nome, horas_uso, vida_util_maxima) "
                    + "VALUES(?,?,?)");
            stmt.setString(1, ferramenta.getNome());
            stmt.setInt(2, ferramenta.getHorasUso());
            stmt.setInt(3, ferramenta.getVidaUtilMaxima());
            
            linhas = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return linhas;
    }
    
    public List<FerramentaDTO> listar() {
        List<FerramentaDTO> lista = new ArrayList<>();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM tb_ferramenta");
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
                FerramentaDTO ferramenta = new FerramentaDTO();
                ferramenta.setId(rs.getInt("id_ferramenta"));
                ferramenta.setNome(rs.getString("nome"));
                ferramenta.setHorasUso(rs.getInt("horas_uso"));
                ferramenta.setVidaUtilMaxima(rs.getInt("vida_util_max"));
                lista.add(ferramenta);
            }           
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public int editar(FerramentaDTO ferramenta) {
        int linhas = 0;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("UPDATE tb_ferramenta SET nome = ?, "
                    + "horas_uso = ?, vida_util_maxima = ? WHERE id = ?");
            stmt.setString(1, ferramenta.getNome());
            stmt.setInt(2, ferramenta.getHorasUso());
            stmt.setInt(3, ferramenta.getVidaUtilMaxima());
            stmt.setInt(4, ferramenta.getId());
            
            linhas = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return linhas;
    }
    
    public int deleteById(int id) {
        int linhas = 0;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("DELETE FROM tb_ferramenta"
                    + " WHERE id = ?");
            stmt.setInt(1, id);
            linhas = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return linhas;
    }
}
