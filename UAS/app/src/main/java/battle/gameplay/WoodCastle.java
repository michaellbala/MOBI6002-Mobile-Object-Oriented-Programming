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
    public Castle battleTo(Castle c2) {

        double myPower = this.calculatePower();
        double enemyPower = c2.calculatePower();

        if (myPower <= enemyPower)
            return this;
        else
            return c2;
    }

    @Override
    public void setArmies(Armies[] ArmyToBattle) {

    }
}
