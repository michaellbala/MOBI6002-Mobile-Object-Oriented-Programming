package battle.gameplay;

public class WoodCastle extends Castle{

    public WoodCastle(){
        this.CastleType = Castle.WOOD;
    }

    @Override
    public double calculatePower() {
        double power = 0;
        for (Armies arm: this.ArmyToBattle){
            if (arm.ArmyType == Armies.ARCHER){
                power += arm.numbers + arm.numbers * Armies.ARCHER_BOOST;
            }else{
                power += arm.numbers;
            }
        }
        return power;
    }

    @Override
    public Castle battleTo(Castle ct2) {
        return null;
    }

    @Override
    public void setArmies(Armies[] ArmyToBattle) {

    }
}
