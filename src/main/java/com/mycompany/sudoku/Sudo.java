/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;

/**
 *
 * @author Sergio
 */

public class Sudo {
    
    public static final int DIMENSION =9;
    
    public static boolean resolver(int[][] tablero) {

        boolean objetivo = false;
        int valor = 1;
        //while(!objetivo){

        for (int i = 0; i < DIMENSION; i++) {

            for (int j = 0; j < DIMENSION; j++) {
                if (tablero[i][j] == 0) {

                    while (valor <= 9 && !objetivo) {
                        if (esPosibleInsertar(tablero, i, j, valor)) {
                            tablero[i][j] = valor;
                            if (i == 8 && j == 8) {
                                objetivo = true;
                            } else {
                                objetivo = resolver(tablero);
                                if (!objetivo) {
                                    tablero[i][j] = 0;
                                }
                            }
                        }
                    }

                }

            }

        }
        return objetivo;
    }


    private static boolean esPosibleInsertar(int[][] tablero, int i, int j, int valor) {
        for (int a = 0; a < DIMENSION; a++) { //Comprueba columna
            if (a != i && tablero[a][j] == valor) {
                return false;
            }
        }
        for (int a = 0; a < DIMENSION; a++) { //Comprueba fila
            if (a != j && tablero[i][a] == valor) {
                return false;
            }
        }
        //Comprueba cuadrado
        int y = (i / 3) * 3; // coloco en la primera fila del cuadrado a comprobar
        int x = (j / 3) * 3; // coloco en la primera columna del cuadrado a comprobar
        for (int a = 0; a < 3; a++) { //cuadrado tiene 3 filas
            for (int b = 0; b < 3; b++) { //cuadrado tiene 3 columnas
                if (a != i && b != j && tablero[y + a][x + b] == valor) {
                    return false;
                }
            }
        }
        return true;

    }
}
