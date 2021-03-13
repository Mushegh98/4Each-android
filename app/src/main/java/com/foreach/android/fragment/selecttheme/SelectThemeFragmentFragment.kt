package com.foreach.android.fragment.selecttheme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.foreach.android.R
import com.foreach.android.adapter.ThemesAdapter
import com.foreach.android.base.FragmentBaseMVVM
import com.foreach.android.base.utils.extension.addFragment
import com.foreach.android.base.utils.viewBinding
import com.foreach.android.databinding.FragmentSelectThemeFragmentBinding
import com.foreach.android.fragment.game.GameFragment
import com.foreach.entities.roommodel.ThemesEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectThemeFragmentFragment(private val bundle: Bundle) : FragmentBaseMVVM<SelectThemeFragmentViewModel, FragmentSelectThemeFragmentBinding>(), ThemesAdapter.OnThemesItemClickListener {


    override val viewModel by viewModel<SelectThemeFragmentViewModel>()
    override val binding by viewBinding<FragmentSelectThemeFragmentBinding>()
    var adapter : ThemesAdapter? = null


    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) = SelectThemeFragmentFragment(bundle)
    }

    override fun initView() {
        adapter = ThemesAdapter(this)
        binding.themes.adapter = adapter
        binding.themes.layoutManager = LinearLayoutManager(context)
        viewModel.getThemes()
    }

    override fun navigateUp() {
        navigateBackStack()
    }

    override fun initViewClickListeners() {

    }

    override fun observes() {
        with(viewModel){
            observe(themesMutableLiveData){
                adapter?.setList(ArrayList(it))
            }
        }
    }

    override fun onThemeClick(themesEntity: ThemesEntity) {
        bundle.apply {
            putString("title",themesEntity.title)
        }
        activity?.supportFragmentManager?.addFragment(R.id.frame,GameFragment.newInstance(bundle))
    }
}