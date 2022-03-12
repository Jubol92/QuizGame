public enum Level {
    HUNDRED(100),
    TWOHUNDRED(200),
    THREEHUNDRED(300),
    FIVEHUNDRED(500),
    ONETHOUSAND(1000);

    private int levelNumber;

    Level(int levelNumber){
        this.levelNumber = levelNumber;
    }

    public int getLevelNumber(){
        return levelNumber;
    }

    public static Level getLevel(int level){
        switch(level){
            case 100: return Level.HUNDRED;
            case 200: return Level.TWOHUNDRED;
            case 300: return Level.THREEHUNDRED;
            case 500: return Level.FIVEHUNDRED;
            case 1000: return Level.ONETHOUSAND;
        }
        return Level.HUNDRED;
    }
}
