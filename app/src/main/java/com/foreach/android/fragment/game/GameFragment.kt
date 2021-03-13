package com.foreach.android.fragment.game

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.foreach.android.R
import com.foreach.android.base.FragmentBaseMVVM
import com.foreach.android.base.utils.viewBinding
import com.foreach.android.databinding.FragmentGameBinding
import com.foreach.entities.roommodel.GameEntity
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import java.util.concurrent.TimeUnit


class GameFragment(private val bundle: Bundle) : FragmentBaseMVVM<GameViewModel,FragmentGameBinding>() {


    override val viewModel by viewModel<GameViewModel>()
    override val binding by viewBinding<FragmentGameBinding>()
    var timer : CountDownTimer? = null
    var gameList : List<GameEntity>? = null

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) = GameFragment(bundle)
    }

    override fun initView() {
        var command1 = bundle.getString("command1")
        var command2 = bundle.getString("command2")
        val title = bundle.getString("title")

        if (title != null) {
            viewModel.getGameData(title)
        }


        var duration : Long? = TimeUnit.MINUTES.toMillis(1)
        if(!viewModel.getStringData("time").isNullOrEmpty()){
            duration = viewModel.getStringData("time")?.toLong()?.let { TimeUnit.MINUTES.toMillis(it) }
        }

        val points = viewModel.getStringData("points")
        duration?.let {
            timer = object: CountDownTimer(duration, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val sDuartion = String.format(Locale.ENGLISH,"%02d : %02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))
                    binding.time.text = sDuartion
                }

                override fun onFinish() {

                }
            }
            timer?.start()
        }


    }

    override fun navigateUp() {
        navigateBackStack()
    }

    override fun initViewClickListeners() {
        with(binding){
            image1.setOnClickListener {
                Glide.with(bigImage.context).load(gameList?.get(0)?.url)
                    .into(bigImage)
            }
            image2.setOnClickListener {
                Glide.with(bigImage.context).load(gameList?.get(1)?.url)
                    .into(bigImage)
            }
            image3.setOnClickListener {
                Glide.with(bigImage.context).load(gameList?.get(2)?.url)
                    .into(bigImage)
            }
            image4.setOnClickListener {
                Glide.with(bigImage.context).load(gameList?.get(3)?.url)
                    .into(bigImage)
            }
            image5.setOnClickListener {
                Glide.with(bigImage.context).load(gameList?.get(4)?.url)
                    .into(bigImage)
            }
        }
    }

    override fun observes() {
        with(viewModel){
            observe(gameData){
                gameList = it.shuffled()
                with(binding){
                    gameList?.let {
                        Glide.with(bigImage.context).load(it[0].url)
                            .into(bigImage)
                        Glide.with(image1.context).load(it[0].url)
                            .into(image1)
                        Glide.with(image2.context).load(it[1].url)
                            .into(image2)
                        Glide.with(image3.context).load(it[2].url)
                            .into(image3)
                        Glide.with(image4.context).load(it[3].url)
                            .into(image4)
                        Glide.with(image5.context).load(it[4].url)
                            .into(image5)
                    }

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}