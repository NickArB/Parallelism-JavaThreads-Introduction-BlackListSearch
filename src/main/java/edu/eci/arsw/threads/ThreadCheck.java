package edu.eci.arsw.threads;

import java.util.LinkedList;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class ThreadCheck extends Thread{

    private HostBlacklistsDataSourceFacade skds;
    private int rangeLimitA;
    private int rangeLimitB;
    private String ipAdress;
    private LinkedList<Integer> indexes;
    private int serversChecked;

    private int ocurrences;

    public ThreadCheck(HostBlacklistsDataSourceFacade skds, int rangeLimitA, int rangeLimitB, String ipAdress){
        setServerList(skds, rangeLimitA, rangeLimitB);
        setIpToLookFor(ipAdress);
        this.indexes = new LinkedList<>();
        this.serversChecked = 0;
    }

    public static void main(String[] args){
        ThreadCheck t = new ThreadCheck(HostBlacklistsDataSourceFacade.getInstance(), 0000,9000, "202.24.34.55");
        t.start();
        //System.out.println("No. de servers:");
        //System.out.println(HostBlacklistsDataSourceFacade.getInstance().getRegisteredServersCount());
    }
    
    @Override
    public void run(){
        countOccurrences();
        //System.out.println("No. de ocurrencias:");
        //System.out.println(getOccurrences());
    }

    public void setServerList(HostBlacklistsDataSourceFacade skds, int rangeLimitA, int rangeLimitB){
        this.skds = skds;
        this.rangeLimitA = rangeLimitA;
        this.rangeLimitB = rangeLimitB;
    }

    public void setIpToLookFor(String ipAdress){
        this.ipAdress = ipAdress;
    }

    public void countOccurrences(){
        ocurrences = 0;
        for(int i = rangeLimitA; i < rangeLimitB; i++){
            this.serversChecked++;
            if(skds.isInBlackListServer(i, ipAdress)){
                ocurrences++;
                indexes.add(i);
            }
        }
    }

    public int getOccurrences(){
        return this.ocurrences;
    }

    public int getServersChecked() {
        return serversChecked;
    }

    public LinkedList<Integer> getIndexes(){
        return this.indexes;
    }

}
