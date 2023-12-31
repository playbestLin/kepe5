package me.wcy.music.service.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint
import me.wcy.music.service.AudioPlayer
import javax.inject.Inject

/**
 * Created by wcy on 2017/4/18.
 */
@AndroidEntryPoint
class StatusBarReceiver : BroadcastReceiver() {
    @Inject
    lateinit var audioPlayer: AudioPlayer

    override fun onReceive(context: Context, intent: Intent?) {
        when (intent?.getStringExtra(EXTRA)) {
            EXTRA_NEXT -> audioPlayer.next()
            EXTRA_PLAY -> audioPlayer.startPlayer()
            EXTRA_PAUSE -> audioPlayer.pausePlayer()
        }
    }

    companion object {
        const val ACTION_STATUS_BAR = "me.wcy.music.STATUS_BAR_ACTIONS"
        const val EXTRA = "extra"
        const val EXTRA_NEXT = "next"
        const val EXTRA_PLAY = "play"
        const val EXTRA_PAUSE = "pause"
    }
}