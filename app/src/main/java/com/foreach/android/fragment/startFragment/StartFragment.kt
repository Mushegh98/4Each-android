package com.foreach.android.fragment.startFragment

import android.os.Bundle
import android.view.View
import com.foreach.android.base.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.foreach.android.R
import com.foreach.android.base.FragmentBaseMVVM
import com.foreach.android.base.utils.extension.addFragment
import com.foreach.android.base.utils.extension.replaceFragment
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
                add(ThemesEntity("http://wall-papers.ru/main.php?g2_view=core.DownloadItem&g2_itemId=105063&g2_serialNumber=1","Hollywood_Stars"))
                add(ThemesEntity("https://mtdata.ru/u3/photo6E99/20153165747-0/original.jpg","Brands"))
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
                add(GameEntity("https://www.livestory.com.ua/images/157303890.jpg","Hollywood stars"))
                add(GameEntity("https://www.peoples.ru/art/cinema/actor/dicaprio/dicaprio_331.jpg","Hollywood stars"))
                add(GameEntity("https://4tololo.ru/sites/default/files/images/20141810170704.jpeg?itok=o6xIamrE","Hollywood stars"))
                add(GameEntity("https://www.startfilm.ru/images/base/person/02_03_17/38205_115.jpg","Hollywood stars"))
                add(GameEntity("https://avatars.mds.yandex.net/get-zen_doc/2380471/pub_5ebbbf688b21b41d48ffc426_5ebbd00004b9346516266843/scale_1200","Hollywood stars"))
                add(GameEntity("http://www.tele.ru/wp-content/uploads/2019/01/en_01357755_0029-745x1024.jpg","Hollywood stars"))
                add(GameEntity("https://m.aceshowbiz.com/images/wennpic/vin-diesel-premiere-riddick-03.jpg","Hollywood stars"))
                add(GameEntity("https://lifeinsta.ru/wp-content/uploads/2019/08/55823682_126824275053057_6753549641873779970_n.jpg","Hollywood stars"))
                add(GameEntity("https://ru.fishki.net/picsw/012011/18/bonus/zolglobus/004.jpg","Hollywood stars"))
                add(GameEntity("https://4tololo.ru/sites/default/files/images/20142406124136.jpg?itok=KXEmoGkV","Hollywood stars"))
                add(GameEntity("https://i.pinimg.com/736x/5e/0a/11/5e0a11dc7d1ac46ca7e3c26a6532aec5--jackie-chan-martial-arts.jpg","Hollywood stars"))
                add(GameEntity("https://imgpile.com/images/nJUPhx.jpg","Hollywood stars"))
                add(GameEntity("https://teleprogramma.pro/wp-content/uploads/2015/11/c153955689d603c3b412c80058d46bbe.jpg","Hollywood stars"))
                add(GameEntity("http://img.crazys.info/files/i/2009.5.18/1242644767_73456jenniferanistonpremiereof24marley8me91.jpg","Hollywood stars"))
                add(GameEntity("https://img2.imagetwist.com/i/00160/e5esg8urlqtq.jpg/Sasha_Grey_-_I_Melt_With_You_Sundance_Premiere_260111__17_.jpg","Hollywood stars"))
                add(GameEntity("https://www.peoples.ru/art/cinema/actor/portman/portman_201203260831121.jpg","Hollywood stars"))
                add(GameEntity("https://avatars.mds.yandex.net/get-zen_doc/1592246/pub_5d046e2470b0790d8ad5f3fe_5d0473b1f5dc000f8d03e7a6/scale_1200","Hollywood stars"))
                add(GameEntity("https://s0.tchkcdn.com/g--kkF5SB0L7bohbC2eMJV6w/11/421442/660x0/w/0/16a_gettyimages_1188115988.jpg","Hollywood stars"))
                add(GameEntity("https://www.toplumsal.com.tr/images/haberler/2019/10/putin213.jpg","Hollywood stars"))
                add(GameEntity("https://avatars.mds.yandex.net/get-zen_doc/3842094/pub_5f5fbdeb249b32282bb78f07_5f5fbf2e8169a87816478e0f/scale_1200","Brands"))
                add(GameEntity("https://www.technobezz.com/files/uploads/2015/12/Nokia_logo-4-912x912.jpg","Brands"))
                add(GameEntity("https://www.arabianbusiness.com/public/images/2015/05/26/2510532872_3dea51175d_o.png","Brands"))
                add(GameEntity("https://i.pinimg.com/736x/47/10/0c/47100ca0b423d29993bfde8300d6454e--apple-ipad-wallpaper-hd-wallpaper.jpg","Brands"))
                add(GameEntity("https://imag.one/storage/img/2019/6/25/1561488829_1561469171_ksiomi.jpg","Brands"))
                add(GameEntity("https://www.enjoywinebcn.com/img/p/1/1/5/1/9/11519-thickbox_default.jpg","Brands"))
                add(GameEntity("https://yt3.ggpht.com/ytc/AAUvwnjnGsXXfgI4wznBOgL1hOU-rvns8MGWBYi7-AEzdq4=s900-c-k-c0x00ffffff-no-rj","Brands"))
                add(GameEntity("https://cdn.wallpapersafari.com/78/7/QTudnr.jpg","Brands"))
                add(GameEntity("https://img.wallpapersafari.com/tablet/768/1024/7/51/PF5EVZ.jpg","Brands"))
                add(GameEntity("https://yt3.ggpht.com/a/AGF-l7_l2lEeLaP_8MrHOFdP8KzwFCBUjv79Oba6oA=s900-c-k-c0xffffffff-no-rj-mo","Brands"))
                add(GameEntity("https://pbs.twimg.com/media/CUvikcFWEAAQefj.png","Brands"))
                add(GameEntity("https://yt3.ggpht.com/a/AATXAJzdYwtkuFKp0QsXMrVhb0TJJAp2CLhpUVyEwZzI=s900-c-k-c0xffffffff-no-rj-mo","Brands"))
                add(GameEntity("https://www.beauticool.com/product_images/1562828163_1524980374_19095478_1917602878502032_7489678859328738015_o.jpg","Brands"))
                add(GameEntity("https://avatars.mds.yandex.net/get-zen_doc/1686231/pub_5ee1ea3b77292b742676a80b_5ee1ec801ea22143ab32690e/scale_1200","Brands"))
                add(GameEntity("https://sun9-57.userapi.com/impf/OAri8CqVkeyuAs38rfzHkVTrAtvw4nMPOp8IIA/5hFz5E4BusU.jpg?size=960x960&quality=96&proxy=1&sign=c48680deaa8818ae4aea13a13061f7f5&c_uniq_tag=dp1h35MvyWx9fKZ1rDU6XhPL4_MFWA0E5m0kpdJMka4&type=album","Brands"))
                add(GameEntity("https://img.pngio.com/starbucks-transparent-background-logo-starbucks-logo-transparent-transparent-starbucks-logo-820_860.png","Brands"))
                add(GameEntity("https://lpost.ru/wp-content/uploads/2012/11/Google-logo1-1024x1024.jpg","Brands"))
                add(GameEntity("https://арго-реклама.рф/wp-content/uploads/2016/05/Instagram_New_Logo.jpg","Brands"))
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
                activity?.supportFragmentManager?.replaceFragment(R.id.frame,SelectTeamsFragment.newInstance())
            }
            btnSettings.setOnClickListener {
                activity
                    ?.supportFragmentManager?.replaceFragment(
                        R.id.frame,
                        SettingsFragment.newInstance()
                    )
            }
            btnAboutTheGame.setOnClickListener {
                activity?.supportFragmentManager?.replaceFragment(R.id.frame,AboutGameFragment.newInstance())
            }
        }

    }
}