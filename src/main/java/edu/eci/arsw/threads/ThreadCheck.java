package edu.eci.arsw.threads;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class ThreadCheck extends Thread{

    private HostBlacklistsDataSourceFacade skds;
    private int rangeLimitA;
    private int rangeLimitB;
    private String ipAdress;

    private int ocurrences;

    public ThreadCheck(HostBlacklistsDataSourceFacade skds, int rangeLimitA, int rangeLimitB, String ipAdress){
        setServerList(skds, rangeLimitA, rangeLimitB);
        setIpToLookFor(ipAdress);

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
        for(int i = rangeLimitA; i <= rangeLimitB; i++){
            if(skds.isInBlackListServer(i, ipAdress)){
                ocurrences++;
            }
        }
    }

    public int getOccurrences(){
        return this.ocurrences;
    }

}
