package com.foreach.android.fragment.startFragment

import android.os.Bundle
import android.view.View
import com.foreach.android.base.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.foreach.android.R
import com.foreach.android.base.FragmentBaseMVVM
import com.foreach.android.base.utils.extension.addFragment
import com.foreach.android.databinding.FragmentStartBinding
import com.foreach.android.fragment.aboutGame.AboutGameFragment
import com.foreach.android.fragment.selectTeams.SelectTeamsFragment
import com.foreach.android.fragment.settings.SettingsFragment
import com.foreach.entities.roommodel.GameEntity
import com.foreach.entities.roommodel.ThemesEntity

class StartFragment : FragmentBaseMVVM<StartFragmentViewModel,FragmentStartBinding>() {

    override val viewModel by viewModel<StartFragmentViewModel>()
    override val binding by viewBinding<FragmentStartBinding>()


    companion object {
        fun newInstance(): StartFragment {
            return StartFragment()
        }
    }

    @ExperimentalStdlibApi
    override fun initView() {
        if(viewModel.getStringData("room").isNullOrEmpty()){
            val listEntity = buildList<ThemesEntity> {
                add(ThemesEntity("https://s3-eu-west-1.amazonaws.com/uploads.playbaamboozle.com/uploads/images/82626/1594704748_77856","Football"))
            }
            val gameAllData = buildList<GameEntity> {
                add(GameEntity("https://idsb.tmgrup.com.tr/ly/uploads/images/2020/09/12/57778.jpg","Football"))
                add(GameEntity("https://upload.wikimedia.org/wikipedia/commons/9/9a/Cristiano_Ronaldo_Portugal.jpg","football"))
                add(GameEntity("https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F5ec595d45f39760007b05c07%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D989%26cropX2%3D2480%26cropY1%3D74%26cropY2%3D1564","Football"))
                add(GameEntity("https://s.hs-data.com/bilder/spieler/gross/87809.jpg","Football"))
                add(GameEntity("https://cdn.footboom.net/img/upload/3/73a13-Mokhamed-Salakh.jpeg","Football"))
                add(GameEntity("https://cdn23.img.ria.ru/images/07e4/09/0d/1577158620_0:0:3072:1728_1920x0_80_0_0_075ef6554b3b28dabaf0cbf529d8b3ae.jpg","Football"))
                add(GameEntity("https://s.hs-data.com/bilder/spieler/gross/19198.jpg","Football"))
                add(GameEntity("https://upload.wikimedia.org/wikipedia/commons/6/67/Andr%C3%A9s_Iniesta.jpg","Football"))
            }
            viewModel.insertThemes(listEntity)
            viewModel.insertGameAllData(gameAllData)
            viewModel.setStringData("room","room")

        }else{

        }
    }

    override fun navigateUp() {
        activity?.finish()
    }

    override fun initViewClickListeners() {
        with(binding){
            btnStartGame.setOnClickListener {
                activity?.supportFragmentManager?.addFragment(R.id.frame,SelectTeamsFragment.newInstance())
            }
            btnSettings.setOnClickListener {
                activity
                    ?.supportFragmentManager?.addFragment(
                        R.id.frame,
                        SettingsFragment.newInstance()
                    )
            }
            btnAboutTheGame.setOnClickListener {
                activity?.supportFragmentManager?.addFragment(R.id.frame,AboutGameFragment.newInstance())
            }
        }

    }
}