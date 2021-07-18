package battle.gameplay;

public abstract class Castle {
    public static final String HORSE = "HORSE";
    public static final String WOOD = "WOOD";
    public static final String STEEL = "STEEL";
    public static final String STONE = "STONE";

    public String CastleType;
    public Heroes[] Heroes;
    public Armies[] ArmyToBattle;

    public String getCastleType(){
        return this.CastleType;
    }

    public abstract double calculatePower();

    public abstract Castle battleTo(Castle c2);

    public abstract void setArmies(Armies[] ArmyToBattle);

}
