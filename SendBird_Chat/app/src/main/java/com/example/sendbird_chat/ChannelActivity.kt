package com.example.sendbird_chat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sendbird_chat.RecyItems.ChannelItem
import com.sendbird.android.OpenChannel
import com.sendbird.android.OpenChannelListQuery
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder

class ChannelActivity : AppCompatActivity() {

    val TAG = "ChannelActivity.class"
    lateinit var rv_channels: RecyclerView
    lateinit var _channelAdapter: GroupAdapter<GroupieViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channel)

        setRecyclerView()

        val _openChannelListQuery: OpenChannelListQuery = OpenChannel.createOpenChannelListQuery()
        _openChannelListQuery.next(OpenChannelListQuery.OpenChannelListQueryResultHandler() { openChannels: List<OpenChannel>, e ->
            if (e != null) {
                Log.e(TAG, e.message)
            }
            openChannels.forEach { channel: OpenChannel ->
                _channelAdapter.add(ChannelItem(this@ChannelActivity, channel.url))
            }
        })
    }

    fun setRecyclerView() {
        rv_channels = findViewById(R.id.rv_channels)
        _channelAdapter = GroupAdapter()

        rv_channels.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_channels.adapter = _channelAdapter
    }
}
