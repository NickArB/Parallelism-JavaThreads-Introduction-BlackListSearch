/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author NickArB
 */
public class CountThread extends Thread{
    private int valueA;
    private int valueB;

    CountThread(int a, int b){
        this.valueA=a;
        this.valueB=b;
    }

    @Override
    public void run(){
        int a = this.valueA;
        int b = this.valueB;
        for (int i=a; i <= b; i++){
            System.out.println(""+i);
        }
    }

    public static void main(String[] args){
        CountThread t = new CountThread(0, 5);
        t.start();
    }
}
