package transport.service;

import transport.interfaces.*;

public class Aeroplane implements Transport
{
    public Double getPathDistance(){
        return new Double("829900020939020");
    }
    public String serviceProviderName(){
        return "Aeroplane service limited";
    }
}