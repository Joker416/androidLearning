package com.example.uibestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();

    private Button send;

    private EditText inputText;

    private RecyclerView msgRecyclerView;

    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        inputText = findViewById(R.id.input_text);
        send = findViewById(R.id.send_btn);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        msgAdapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(msgAdapter);
        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String content = inputText.getText().toString();
                if(!content.equals("")){
                    Msg msg = new Msg(Msg.TYPE_SEND, content);
                    msgList.add(msg);
                    msgAdapter.notifyItemInserted(msgList.size() - 1);
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                }
            }
        });

    }

    private void initMsgs(){
        Msg msg1 = new Msg(Msg.TYPE_RECEIVED, "Hello guy!");
        msgList.add(msg1);
        Msg msg2 = new Msg(Msg.TYPE_SEND, "Hello, who's that?");
        msgList.add(msg2);
        Msg msg3 = new Msg(Msg.TYPE_RECEIVED, "This is Tom, nice to meet you.");
        msgList.add(msg3);
    }
}
