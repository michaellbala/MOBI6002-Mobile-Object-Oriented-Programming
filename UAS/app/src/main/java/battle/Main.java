package battle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uas.R;

import javax.crypto.CipherOutputStream;

import battle.gameplay.ArcherArmy;
import battle.gameplay.Armies;
import battle.gameplay.BattleWork;
import battle.gameplay.Castle;
import battle.gameplay.CavalryArmy;
import battle.gameplay.HeroArcher;
import battle.gameplay.HeroCavalry;
import battle.gameplay.Heroes;
import battle.gameplay.HorseCastle;
import battle.gameplay.InfantryArmy;
import battle.gameplay.WoodCastle;

public class Main extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        Activity myActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        HorseCastle c1 = new HorseCastle();
        WoodCastle c2 = new WoodCastle();

        //        init armies
        HeroArcher harch = new HeroArcher();
        HeroCavalry hcav = new HeroCavalry();

        Heroes[] h1 = new Heroes[1];
        Heroes[] h2 = new Heroes[1];
        h1[0] = harch; h2[0] = hcav;

        CavalryArmy cav = new CavalryArmy();
        ArcherArmy arch = new ArcherArmy();
        InfantryArmy inf = new InfantryArmy();
        inf.numbers = 1000;
        cav.numbers = 1000; arch.numbers=1000;


        Armies[] armi1 = new Armies[2];
        armi1[0] = cav;
        armi1[1] = arch;

        Armies[] armi2 = new Armies[1];
        armi1[0] = inf;

        Castle fightCastle[] = new Castle[2];
        fightCastle[0] = c1;
        fightCastle[1] = c2;

        c1.setArmies(armi1);
        c2.setArmies(armi2);
        c1.Heroes = h1;
        c2.Heroes = h2;


        initCastleImageBattle(fightCastle);

        final Button btn = findViewById(R.id.fightBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BattleWork bw = new BattleWork(myActivity, c1,c2);
                new Thread(bw).run();
            }
        });


    }

    private void initCastleImageBattle(Castle[] fightCastle) {
        Castle left = fightCastle[0];
        Castle right = fightCastle[1];

        loadCastleImage(findViewById(R.id.castleLeft),left);
        loadCastleImage(findViewById(R.id.castleRight),right);

    }

    private void loadCastleImage(ImageView iView, Castle ct) {
        if (ct instanceof HorseCastle){
            iView.setBackgroundResource(R.drawable.horse);
        }else if(ct instanceof WoodCastle){
            iView.setBackgroundResource(R.drawable.wood);
        }else{
            iView.setBackgroundResource(R.drawable.castle);
        }
    }

}
