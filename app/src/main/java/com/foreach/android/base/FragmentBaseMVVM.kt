package com.foreach.android.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import com.foreach.android.base.viewmodel.BaseViewModel


abstract class FragmentBaseMVVM<ViewModel : BaseViewModel, ViewBind : ViewBinding> : Fragment() {
    protected abstract val viewModel: ViewModel
    protected abstract val binding: ViewBind
    // TODO uncomment
//    private lateinit var navController: NavController
//    private val navOptions = NavOptions.Builder()
//            .setLaunchSingleTop(false)
//            .build()

    protected var callback: OnFragmentEventListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            callback = activity as OnFragmentEventListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                    activity.toString() + " must implement OnReviewSelectedListener"
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this) {
            navigateUp()
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // TODO uncomment
//        retainInstance = true

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO uncomment
//        navController = Navigation.findNavController(view)
        observes()
        initView()
        initViewClickListeners()
    }

    protected fun <T> observe(liveData: LiveData<T>, action: (T) -> Unit) = view?.run {
        if (!this@FragmentBaseMVVM.isAdded) return@run
        liveData.observe(viewLifecycleOwner, Observer { action(it ?: return@Observer) })
    }

    protected abstract fun initView()
    protected open fun initViewClickListeners() {}
    protected open fun observes() {}
    protected abstract fun navigateUp()

    protected fun navigateBackStack() {
        requireActivity().supportFragmentManager.popBackStack()
    }

    // TODO uncomment
//    protected fun navigateBackStack() {
//        navController.popBackStack()
//    }
//    protected fun finishApp() {
//        activity?.let {
//            (it as MainActivity).finish()
//        }
//    }

// TODO uncomment

//    protected fun navigateFragment(
//            destinationId: Int,
//            bundle: Bundle? = null
//    ) {
//        navController.navigate(
//                destinationId,
//                bundle,
//                navOptions
//        )
//    }
//
//    protected fun getStackCount() : Int{
//        return navController.graph.count()
//    }




    interface OnFragmentEventListener {
        fun progressIsVisible(isVisible: Boolean, title: String? = "", description: String? = "")
    }

}