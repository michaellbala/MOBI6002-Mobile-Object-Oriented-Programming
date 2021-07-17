package battle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uas.R;

import battle.gameplay.BattleWork;
import battle.gameplay.Castle;
import battle.gameplay.HorseCastle;
import battle.gameplay.WoodCastle;

public class Main extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        Activity myActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        HorseCastle c1 = new HorseCastle();
        WoodCastle c2 = new WoodCastle();

//        init armies

        Castle fightCastle[] = new Castle[2];
        fightCastle[0] = c1;
        fightCastle[1] = c2;

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
