public enum Variante {
    ZOCKER (1),
    SICHERHEIT (2);

    public int menueNummer;

    private Variante(int menueNummer){
        this.menueNummer = menueNummer;
    }

    public static Variante getMenueNummer(int nummer){
        switch (nummer){
            case 1: return Variante.ZOCKER;
            case 2: return Variante.SICHERHEIT;
        }
        return Variante.SICHERHEIT;
    }

    public String getCanonicalName(){
        switch(menueNummer){
            case 1: return "Zocker-Variante";
            case 2: return "Sicherheits-Variante";
        }
        return "Sicherheits-Variante";
    }
}
