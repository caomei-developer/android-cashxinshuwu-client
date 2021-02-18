package com.xinshuwu.util

import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator

class AnimationUtil {

    var LINEAR_INTERPOLATOR: Interpolator = LinearInterpolator()
    val FAST_OUT_SLOW_IN_INTERPOLATOR: Interpolator = FastOutSlowInInterpolator()
    val FAST_OUT_LINEAR_IN_INTERPOLATOR: Interpolator = FastOutLinearInInterpolator()
    val LINEAR_OUT_SLOW_IN_INTERPOLATOR: Interpolator = LinearOutSlowInInterpolator()
    val DECELERATE_INTERPOLATOR: Interpolator = DecelerateInterpolator()

    fun lerp(startValue: Float, endValue: Float, fraction: Float): Float {
        return startValue + (fraction * (endValue - startValue))
    }

    fun lerp(startValue: Int, endValue: Int, fraction: Float): Int {
        return startValue + Math.round(fraction * (endValue - startValue))
    }

    class AnimationListenerAdapter : Animation.AnimationListener {
        override fun onAnimationRepeat(animation: Animation?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onAnimationEnd(animation: Animation?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onAnimationStart(animation: Animation?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }


}