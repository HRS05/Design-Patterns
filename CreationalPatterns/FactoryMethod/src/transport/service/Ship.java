package transport.service;

import transport.interfaces.*;

public class Ship implements Transport
{
    public Double getPathDistance(){
        return new Double(849938290);
    }
    public String serviceProviderName(){
        return "Ship service limited";
    }
}