package battle.gameplay;

public class StoneCastle extends Castle{

    public StoneCastle(){
        this.CastleType = Castle.STONE;
    }

    @Override
    public double calculatePower() {
        double power = 0;
        for (Armies arm: this.ArmyToBattle){
            if (arm.ArmyType == Armies.CATAPULT){
                power += arm.numbers + arm.numbers * Armies.CATAPULT_BOOST;
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
