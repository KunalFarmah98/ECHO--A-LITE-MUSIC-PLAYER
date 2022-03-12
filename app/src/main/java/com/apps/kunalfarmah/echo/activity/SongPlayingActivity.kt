package com.apps.kunalfarmah.echo.activity

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.apps.kunalfarmah.echo.R
import com.apps.kunalfarmah.echo.databinding.ActivitySongPlayingBinding
import com.apps.kunalfarmah.echo.fragment.SongPlayingFragment
import com.apps.kunalfarmah.echo.util.BottomBarUtils

class SongPlayingActivity : AppCompatActivity() {
    lateinit var binding : ActivitySongPlayingBinding
    companion object{
        var songPlayingFragment = SongPlayingFragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongPlayingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_queue_music_white_24dp)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.colorPrimary)))
        val args = intent.extras
        songPlayingFragment.arguments = args
        supportFragmentManager.beginTransaction().replace(R.id.container, songPlayingFragment)
            .commit()
    }

    override fun onBackPressed() {
        BottomBarUtils.bottomBarBinding?.root?.visibility = View.VISIBLE
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}