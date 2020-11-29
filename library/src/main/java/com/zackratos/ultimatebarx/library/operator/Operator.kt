package com.zackratos.ultimatebarx.library.operator

import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.zackratos.ultimatebarx.library.UltimateBarXManager
import com.zackratos.ultimatebarx.library.bean.BarConfig

/**
 * @Author   : Zackratos
 * @Date     : 2020/11/27 1:41
 * @email    : 869649338@qq.com
 * @Describe :
 */
interface Operator {

    fun applyStatusBar()

    fun applyNavigationBar()

    fun config(config: BarConfig): Operator

    fun transparent(): Operator

    fun light(light: Boolean): Operator

    fun fitWindow(fitWindow: Boolean): Operator

    fun drawableRes(@DrawableRes drawableRes: Int): Operator

    fun colorRes(@ColorRes colorRes: Int): Operator

    fun colorInt(@ColorInt colorInt: Int): Operator

    companion object {
        internal fun get(activity: FragmentActivity): Operator {
            var operator = UltimateBarXManager.getInstance().getOperator(activity)
            if (operator == null) {
                operator = ActivityOperator.newInstance(activity)
                UltimateBarXManager.getInstance().putOperator(activity, operator)
            }
            return operator
        }

        internal fun get(fragment: Fragment): Operator {
            var operator = UltimateBarXManager.getInstance().getOperator(fragment)
            if (operator == null) {
                operator = FragmentOperator.newInstance(fragment)
                UltimateBarXManager.getInstance().putOperator(fragment, operator)
            }
            return operator
        }
    }
}