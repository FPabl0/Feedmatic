package com.lzro.feedmatic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzro.feedmatic.Instructions.Instructions;

public class InstructionActivity extends AppCompatActivity {

    private TextView textInst;
    private Button btInstNext;
    private Button btInstBack;
    private ImageView imgInst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        textInst = (TextView) findViewById(R.id.textInst);
        btInstNext = (Button) findViewById(R.id.btInstNext);
        btInstBack = (Button) findViewById(R.id.btInstBack);
        imgInst = (ImageView) findViewById(R.id.imgInst);

        Instructions.getInstance().setTextView(textInst);
        Instructions.getInstance().setImageView(imgInst);
        Instructions.getInstance().setPage(1);
        putInstructions();

        btInstNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current_page = Instructions.getInstance().getPage();
                if(!Instructions.getInstance().isFinish()) {
                    Instructions.getInstance().setPage(current_page + 1);
                }
                btInstBack.setVisibility(View.VISIBLE);
                putInstructions();
                if(Instructions.getInstance().isFinish()){
                    btInstNext.setText("LO TENGO!");
                    //Go to wifi selection activity
                }
            }
        });

        btInstBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current_page = Instructions.getInstance().getPage();
                btInstNext.setText("Siguiente");
                if(current_page > 1){
                    Instructions.getInstance().setPage(current_page-1);
                    putInstructions();
                    if((current_page-1)==1){
                        btInstBack.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

    }

    private void putInstructions(){
        switch (Instructions.getInstance().getPage()) {
            case 1:
                Instructions.getInstance().addNormal("Bienvenido, " +
                        "para configurar el equipo por primera vez, siga los siguientes pasos:");
                Instructions.getInstance().addNormal("");
                Instructions.getInstance().addBold("Paso 1.");
                Instructions.getInstance().addNormal("Reinicie el equipo manteniedo presionando el botón Principal.");
                Instructions.getInstance().addImage(R.mipmap.ic_launcher);
                Instructions.getInstance().commit(Instructions.getInstance().INST_NORMAL);
                break;
            case 2:
                Instructions.getInstance().addBold("Paso 2.");
                Instructions.getInstance().addNormal("Scrapy");
                Instructions.getInstance().addImage(R.drawable.pet_footprint);
                Instructions.getInstance().commit(Instructions.getInstance().INST_NORMAL);
                break;
            case 3:
                Instructions.getInstance().addBold("Paso 3.");
                Instructions.getInstance().addNormal("Coloque");
                Instructions.getInstance().commit(Instructions.getInstance().INST_LAST);
                break;
        }
    }
}
