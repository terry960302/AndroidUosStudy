package com.example.sendbird_chat.View

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sendbird_chat.R
import com.example.sendbird_chat.View.Item.ChatItem
import com.sendbird.android.BaseChannel
import com.sendbird.android.OpenChannel
import com.sendbird.android.SendBirdException
import com.sendbird.android.UserMessage
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class ChatActivity : AppCompatActivity() {

    lateinit var rv_chat: RecyclerView
    lateinit var chatAdapter: GroupAdapter<GroupieViewHolder>
    lateinit var sendBtn: Button
    lateinit var chatInput: EditText
    lateinit var channelUrl: String
    val TAG = "ChatActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        getChannelUrl()

        sendBtn = findViewById(R.id.btn_send)
        chatInput = findViewById(R.id.ev_chat)

        initRecyclerView()

        sendBtn.setOnClickListener {

            if (!TextUtils.isEmpty(chatInput.text.toString())) {
                sendMessage(chatInput.text.toString())
                chatInput.text.clear()
            } else {
                Toast.makeText(this, "빈칸을 채워주십시오.", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun getChannelUrl() {
        val intent = intent
        channelUrl = intent.getStringExtra("channelUrl") as String
    }

    private fun getAllChats(){
        OpenChannel.getChannel(channelUrl) { openChannel, exception ->
            if(exception !=  null){
                Log.e(TAG, "에러  : $exception")
            }
        }
    }

    private fun initRecyclerView() {
        rv_chat = findViewById(R.id.rv_chat)
        chatAdapter = GroupAdapter()

        rv_chat.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_chat.adapter = chatAdapter
    }

    private fun sendMessage(desc: String) {
        OpenChannel.getChannel(
            channelUrl
        ) { openChannel, exception ->
            if (exception != null) {
                Log.e(TAG, "채널 연결 에러 : $exception")
            }
            openChannel.enter {e ->
                if(e != null){
                    Log.e(TAG, "채널 입장 에러 : $e")
                }

                openChannel.sendUserMessage(desc
                ) { userMessage, e->
                    if(e != null){
                        Log.e(TAG, "메세지 보내기 에러 : $e")
                    }
                    chatAdapter.add(ChatItem(userMessage.message))
                    Log.d(TAG, "보낸 내용 : ${userMessage.message}")
                }
                chatAdapter.notifyDataSetChanged()
            }
        }
    }
}
