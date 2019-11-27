package com.example.uibestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.LinkAddress;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();

    private EditText inputText;

    private Button sendButton;

    private RecyclerView msgRecyclerView;

    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        inputText = findViewById(R.id.input_text);
        sendButton = findViewById(R.id.send_button);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(manager);
        msgAdapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(msgAdapter);
        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String content = inputText.getText().toString();
                if(!content.equals("")){
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    msgAdapter.notifyItemInserted(msgList.size() - 1); //当有新消息时刷新ListView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                }
            }
        });
    }

    private void initMsgs(){
        Msg msg1 = new Msg("Hello", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello, who's that?", Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("This is lhx, nice to meet you.", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
