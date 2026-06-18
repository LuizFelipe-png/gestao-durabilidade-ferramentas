/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferramental.monitoramento.model;

/**
 *
 * @author Usuario
 */
public class FerramentaDTO {
    private int id;
    private String nome;
    private int horasUso;
    private int vidaUtilMax;

    public FerramentaDTO() {
    }

    public FerramentaDTO(int id, String nome, int horasUso, int vidaUtilMax) {
        this.id = id;
        this.nome = nome;
        this.horasUso = horasUso;
        this.vidaUtilMax = vidaUtilMax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasUso() {
        return horasUso;
    }

    public void setHorasUso(int horasUso) {
        this.horasUso = horasUso;
    }

    public int getVidaUtilMax() {
        return vidaUtilMax;
    }

    public void setVidaUtilMaxima(int vidaUtilMaxima) {
        this.vidaUtilMax = vidaUtilMax;
    }
    
    
    public double getPercentualDesgaste() {
        return (horasUso / vidaUtilMax) * 100;
    }
}
