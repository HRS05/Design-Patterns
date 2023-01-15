import java.lang.Double;

interface Transport
{
    public Double getPathDistance();
    public String getServiceProviderName();
    public void setPathDistance(Double distance);
    public void setServiceProviderName(String name);
}

class Aeroplane implements Transport
{
    private String serviceProviderName;
    private Double pathDistance;
    public Aeroplane(){
        this.serviceProviderName = "";
        this.pathDistance = new Double(0);;
    }
    public Aeroplane(String name,Double distance){
        this.serviceProviderName = name;
        this.pathDistance = distance;
    }
    public Double getPathDistance(){
        return this.pathDistance;
    }
    public String getServiceProviderName(){
        return this.serviceProviderName;
    }
    public void setPathDistance(Double distance){
        this.pathDistance = distance;
    }
    public void setServiceProviderName(String name){
        this.serviceProviderName = name;
    }
}

class Ship implements Transport
{
    private String serviceProviderName;
    private Double pathDistance;
    public Ship(){
        this.serviceProviderName = "";
        this.pathDistance = new Double(0);
    }
    public Ship(String name,Double distance){
        this.serviceProviderName = name;
        this.pathDistance = distance;
    }
    public Double getPathDistance(){
        return this.pathDistance;
    }
    public String getServiceProviderName(){
        return this.serviceProviderName;
    }
    public void setPathDistance(Double distance){
        this.pathDistance = distance;
    }
    public void setServiceProviderName(String name){
        this.serviceProviderName = name;
    }
}

class Truck implements Transport
{
    private String serviceProviderName;
    private Double pathDistance;
    public Truck(){
        this.serviceProviderName = "";
        this.pathDistance = new Double(0);;
    }
    public Truck(String name,Double distance){
        this.serviceProviderName = name;
        this.pathDistance = distance;
    }
    public Double getPathDistance(){
        return this.pathDistance;
    }
    public String getServiceProviderName(){
        return this.serviceProviderName;
    }
    public void setPathDistance(Double distance){
        this.pathDistance = distance;
    }
    public void setServiceProviderName(String name){
        this.serviceProviderName = name;
    }
}

class Main
{
    public static void main(String args[]){
        Transport t = new Truck(); 
        t.setServiceProviderName("Truck privated Limited");
        System.out.println(t.getServiceProviderName());
        Transport x = new Ship(); 
        x.setServiceProviderName("Ship privated Limited");
        System.out.println(x.getServiceProviderName());
        Transport y = new Aeroplane(); 
        y.setServiceProviderName("Aeroplane privated Limited");
        System.out.println(y.getServiceProviderName());

    }
}