package battle.gameplay;

public class HorseCastle extends Castle{

    public HorseCastle(){
        this.CastleType = Castle.HORSE;
    }

    @Override
    public double calculatePower() {
        double power = 0;
        for (Armies arm: this.ArmyToBattle){
            if (arm.ArmyType == Armies.CAVALRY){
            power += arm.numbers + arm.numbers * Armies.CAVALRY_BOOST;
            }else{
                power += arm.numbers;
            }
        }
        return power;
    }

    @Override
    public Castle battleTo(Castle ct2) {
        double myPower = this.calculatePower();
        double enemyPower = ct2.calculatePower();

        if (myPower <= enemyPower)
            return this;
        else
            return ct2;

    }

    @Override
    public void setArmies(battle.gameplay.Armies[] ArmyToBattle) {

    }
}