package com.example.dailyjourney.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.dailyjourney.R

data class BibleInfo(
    @StringRes val day: Int,
    @StringRes val verse: Int,
    @DrawableRes val image: Int,
    @StringRes val text: Int
)

/**
 * List containing all Bible info
*/
object BibleRepo {
    val list = listOf<BibleInfo>(
        BibleInfo(R.string.day1, R.string.verse1, R.drawable.im_1, R.string.text1),
        BibleInfo(R.string.day2, R.string.verse2, R.drawable.im_2, R.string.text2),
        BibleInfo(R.string.day3, R.string.verse3, R.drawable.im_3, R.string.text3),
        BibleInfo(R.string.day4, R.string.verse4, R.drawable.im_4, R.string.text4),
        BibleInfo(R.string.day5, R.string.verse5, R.drawable.im_5, R.string.text5),
        BibleInfo(R.string.day6, R.string.verse6, R.drawable.im_6, R.string.text6),
        BibleInfo(R.string.day7, R.string.verse7, R.drawable.im_7, R.string.text7),
        BibleInfo(R.string.day8, R.string.verse8, R.drawable.im_8, R.string.text8),
        BibleInfo(R.string.day9, R.string.verse9, R.drawable.im_9, R.string.text9),
        BibleInfo(R.string.day10, R.string.verse10, R.drawable.im_10, R.string.text10),
        BibleInfo(R.string.day11, R.string.verse11, R.drawable.im_11, R.string.text11),
        BibleInfo(R.string.day12, R.string.verse12, R.drawable.im_12, R.string.text12),
        BibleInfo(R.string.day13, R.string.verse13, R.drawable.im_13, R.string.text13),
        BibleInfo(R.string.day14, R.string.verse14, R.drawable.im_14, R.string.text14),
        BibleInfo(R.string.day15, R.string.verse15, R.drawable.im_15, R.string.text15),
        BibleInfo(R.string.day16, R.string.verse16, R.drawable.im_16, R.string.text16),
        BibleInfo(R.string.day17, R.string.verse17, R.drawable.im_17, R.string.text17),
        BibleInfo(R.string.day18, R.string.verse18, R.drawable.im_18, R.string.text18),
        BibleInfo(R.string.day19, R.string.verse19, R.drawable.im_19, R.string.text19),
        BibleInfo(R.string.day20, R.string.verse20, R.drawable.im_20, R.string.text20),
        BibleInfo(R.string.day21, R.string.verse21, R.drawable.im_21, R.string.text21),
        BibleInfo(R.string.day22, R.string.verse22, R.drawable.im_22, R.string.text22),
        BibleInfo(R.string.day23, R.string.verse23, R.drawable.im_23, R.string.text23),
        BibleInfo(R.string.day24, R.string.verse24, R.drawable.im_24, R.string.text24),
        BibleInfo(R.string.day25, R.string.verse25, R.drawable.im_25, R.string.text25),
        BibleInfo(R.string.day26, R.string.verse26, R.drawable.im_26, R.string.text26),
        BibleInfo(R.string.day27, R.string.verse27, R.drawable.im_27, R.string.text27),
        BibleInfo(R.string.day28, R.string.verse28, R.drawable.im_28, R.string.text28),
        BibleInfo(R.string.day29, R.string.verse29, R.drawable.im_29, R.string.text29),
        BibleInfo(R.string.day30, R.string.verse30, R.drawable.im_30, R.string.text30)
    )
}