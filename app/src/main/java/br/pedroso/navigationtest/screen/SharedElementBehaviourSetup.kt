package br.pedroso.navigationtest.screen

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import br.pedroso.navigationtest.items.NestedScrollListenerBehaviour

fun setupSharedElementBehaviour(view: View, screenViewModel: ScreenViewModel) {
    view.layoutParams
        .let { it as? CoordinatorLayout.LayoutParams }
        .let { it?.behavior as? NestedScrollListenerBehaviour }
        ?.run {
            setNestedScrollListener(object :
                NestedScrollListenerBehaviour.NestedScrollListener {
                override fun onScrollDown() {
                    screenViewModel.hideSharedElement()
                }

                override fun onScrollUp() {
                    screenViewModel.displaySharedElement()
                }
            })
        }
}