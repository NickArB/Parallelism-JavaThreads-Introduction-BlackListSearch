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
public class CountThreadsMain {
    
    public static void main(String a[]){
        CountThread tA = new CountThread(0, 99);
        CountThread tB = new CountThread(99, 199);
        CountThread tC = new CountThread(200, 299);
        tA.run();
        tB.run();
        tC.run();
    }
    
}
