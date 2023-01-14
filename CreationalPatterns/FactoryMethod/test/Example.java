import transport.interfaces.*;
import transport.service.*;

public class Example
{
    public static void main(String args[]){
        Transport t = new Truck(); t.serviceProviderName();
        Transport x = new Ship(); x.serviceProviderName();
        Transport y = new Aeroplane(); y.serviceProviderName();

    }
}