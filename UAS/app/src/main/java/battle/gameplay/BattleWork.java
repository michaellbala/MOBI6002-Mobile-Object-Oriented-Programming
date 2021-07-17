package battle.gameplay;

import android.app.Activity;
import android.widget.Toast;

public class BattleWork implements Runnable{

    private Castle c1,c2;
    private Activity a;
    private Castle winner;

    public BattleWork (Activity ac, Castle c1, Castle c2){
        this.a = ac;
        this.c1 = c1;
        this.c2 = c2;
        this.winner = null;
    }


    @Override
    public void run() {

        winner = c1.battleTo(c2);
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Castle winner = c1.battleTo(c2);
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        if (winner.equals(c1)){
            Toast.makeText(a.getApplicationContext(),"Winner is " + c1.CastleType, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(a.getApplicationContext(),"Winner is " + c2.CastleType, Toast.LENGTH_SHORT).show();
        }

    }

    public Castle getWinner(){
        return this.winner;
    }



}
