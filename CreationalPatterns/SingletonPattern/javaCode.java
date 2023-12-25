class Singleton {
    private static Singleton instace;
     private Singleton(){
        System.out.println("instance created");
     }
    public static Singleton getInstace(){
        if(instace == null){
            instace = new Singleton();
        }
        else {
            System.out.println("Already created");
        }
        return instace;
    }
}

class main {
    public static void main(String gg[]){
        Singleton instace1 = Singleton.getInstace();
        Singleton instace2 = Singleton.getInstace();
        if(instace1 == instace2) {
             System.out.println("Both instance have same reference");
        }
    }
}