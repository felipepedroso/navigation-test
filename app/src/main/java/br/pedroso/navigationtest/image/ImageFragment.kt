package br.pedroso.navigationtest.image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import br.pedroso.navigationtest.BaseFragment
import br.pedroso.navigationtest.R
import br.pedroso.navigationtest.screen.FullScreenMode
import br.pedroso.navigationtest.screen.ScreenViewModel
import kotlinx.android.synthetic.main.fragment_image.*


class ImageFragment : BaseFragment(R.layout.fragment_image) {

    private val screenViewModel by lazy {
        ViewModelProviders.of(requireActivity())[ScreenViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        screenViewModel.apply {
            setFullScreenMode(FullScreenMode.ContentUnderSystemBars)
            hideSharedElement()
            hideBottomBar()
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        screenViewModel.apply {
            setFullScreenMode(FullScreenMode.Disabled)
            displaySharedElement()
            displayBottomBar()
        }
    }
}