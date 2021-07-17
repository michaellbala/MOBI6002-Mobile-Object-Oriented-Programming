package battle.gameplay;

public class SteelCastle extends Castle{

    public SteelCastle(){
        this.CastleType = Castle.STEEL;
    }

    @Override
    public double calculatePower() {
        double power = 0;
        for (Armies arm: this.ArmyToBattle){
            if (arm.ArmyType == Armies.INFANTRY){
                power += arm.numbers + arm.numbers * Armies.INFANTRY_BOOST;
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
