package transport.service;

import transport.interfaces.*;

public class Truck implements Transport
{
    public Double getPathDistance(){
        return new Double(10000000);
    }
    public String serviceProviderName(){
        return "Truck service limited";
    }
}