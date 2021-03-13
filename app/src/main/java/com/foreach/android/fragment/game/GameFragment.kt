package com.foreach.android.fragment.game

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    var count = 0

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) = GameFragment(bundle)
    }

    override fun initView() {
        val command1 = bundle.getString("command1")
        val command2 = bundle.getString("command2")
        val title = bundle.getString("title")

        viewModel.setStringData("command2","0")
        viewModel.setStringData("command1","0")

        if (title != null) {
            viewModel.getGameData(title)
        }

        if(viewModel.getStringData("points").isNullOrEmpty()){
            viewModel.setStringData("points","15")
        }

        binding.command.text = command1
        var duration : Long? = TimeUnit.MINUTES.toMillis(1)
        if(!viewModel.getStringData("time").isNullOrEmpty()){
            duration = viewModel.getStringData("time")?.toLong()?.let { TimeUnit.MINUTES.toMillis(it) }
        }

        count++
        duration?.let {
            timer = object: CountDownTimer(duration, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val sDuartion = String.format(Locale.ENGLISH,"%02d : %02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))
                    binding.time.text = sDuartion
                }

                override fun onFinish() {

                    if(count % 2 == 0){
                        if(viewModel.getStringData("command2").isNullOrEmpty()){
                            viewModel.setStringData("command2","0")
                        }else{
                            viewModel.setStringData("command2",(viewModel.getStringData("command2")!!.toInt() + binding.points.text.toString().toInt()).toString())
                        }

                    }else{
                        if(viewModel.getStringData("command1").isNullOrEmpty()){
                            viewModel.setStringData("command1","0")
                        }
                        else{
                            viewModel.setStringData("command1",(viewModel.getStringData("command1")!!.toInt() + binding.points.text.toString().toInt()).toString())
                        }

                    }
                    val dialog = AlertDialog.Builder(context)
                        .setCancelable(false)
                        .setTitle("Время вышло")
                        .setPositiveButton(
                            "Ok",
                            DialogInterface.OnClickListener { dialog, which ->
                                if(count % 2 == 0){
                                    binding.command.text = command1
                                }else{
                                    binding.command.text = command2
                                }

                                if (viewModel.getStringData("command1")!!.toInt() >= viewModel.getStringData("points")!!.toInt() || viewModel.getStringData("command2")!!.toInt()  >= viewModel.getStringData("points")!!.toInt()) {
                                    dialog?.dismiss()
                                    Toast.makeText(context, "Поздровляем вы выиграли", Toast.LENGTH_SHORT).show()
                                    navigateBackStack()
                                } else {
                                    binding.points.text = 0.toString()
                                    count++
                                    gameList = gameList?.shuffled()
                                    timer?.start()
                                }


                            })
                        .setMessage("Вы набирали ${binding.points.text.toString()} очков, в общем ${if(count %2 ==0) viewModel.getStringData("command2")!!.toInt()  else viewModel.getStringData("command1")!!.toInt()  } очков.")
                        dialog.show()

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
            confirm.setOnClickListener {
                var points = binding.points.text.toString().toInt()
                points++
                if(points % 5 == 0){
                    gameList = gameList?.shuffled()
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
                binding.points.text = points.toString()
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
        viewModel.clearTeamPoints()
    }
}