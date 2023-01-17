interface Lower {
    public void lower();
}

class NikeLower implements Lower {
    public void lower(){
        System.out.println("Nike lower");
    }
}

class PumaLower implements Lower {
    public void lower(){
        System.out.println("Puma lower");
    }
}

class AdidasLower implements Lower {
    public void lower(){
        System.out.println("Adidas lower");
    }
}


interface Tshirt {
    public void tshirt();
}

class NikeTshirt implements Tshirt {
    public void tshirt(){
        System.out.println("Nike Tshirt");
    }
}

class PumaTshirt implements Tshirt {
    public void tshirt(){
        System.out.println("Puma Tshirt");
    }
}

class AdidasTshirt implements Tshirt {
    public void tshirt(){
        System.out.println("Adidas Tshirt");
    }
}


interface Upper {
    public void upper();
}

class NikeUpper implements Upper {
    public void upper(){
        System.out.println("Nike Upper");
    }
}

class PumaUpper implements Upper {
    public void upper(){
        System.out.println("Puma Upper");
    }
}

class AdidasUpper implements Upper {
    public void upper(){
        System.out.println("Adidas Upper");
    }
}

interface TrackSuit {
    public Lower getLower();
    public Tshirt getTshirt();
    public Upper getUpper();
}

class NikeTrackSuit implements TrackSuit {
    public Lower getLower(){
        return new NikeLower();
    }
    public Tshirt getTshirt(){
        return new NikeTshirt();
    }
    public Upper getUpper(){
        return new NikeUpper();
    }
}

class PumaTrackSuit implements TrackSuit {
    public Lower getLower(){
        return new PumaLower();
    }
    public Tshirt getTshirt(){
        return new PumaTshirt();
    }
    public Upper getUpper(){
        return new PumaUpper();
    }
}


class AdidasTrackSuit implements TrackSuit {
    public Lower getLower(){
        return new AdidasLower();
    }
    public Tshirt getTshirt(){
        return new AdidasTshirt();
    }
    public Upper getUpper(){
        return new AdidasUpper();
    }
}


class main{
    public static void main(String args[]){
        TrackSuit nike,puma,adidas;
        nike = new NikeTrackSuit();
        defineTrackSuit(nike);
        puma = new PumaTrackSuit();
        defineTrackSuit(puma);
        adidas = new AdidasTrackSuit();
        defineTrackSuit(adidas);
    }

    public static void defineTrackSuit(TrackSuit suit){
        suit.getLower().lower(); 
        suit.getTshirt().tshirt(); 
        suit.getUpper().upper(); 
        
    }

}



