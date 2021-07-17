package com.example.lessonslist.data

import com.example.lessonslist.R
import com.example.lessonslist.data.model.Class
import com.example.lessonslist.data.model.Homework
import java.util.*
import kotlin.Comparator

class MockedRepository: IRepository {
    private val curDateAdd2: Date
    private val curDateAdd5: Date
    init {
        val curDate = Calendar.getInstance()
        curDate.time = Date()
        curDate.add(Calendar.DATE, 2)
        curDateAdd2 = curDate.time
        curDate.add(Calendar.DATE, 3)
        curDateAdd5 = curDate.time
    }

    val mockClasses = listOf(
        Class("History", 8, 0, 8, 45, R.drawable.ic_bow_and_arrow, "Mrs Thomas"),
        Class("Literature", 9, 0, 9, 45, R.drawable.ic_baseline_book_24, "Mrs Barros"),
        Class("History", 13, 0, 13, 45, R.drawable.ic_bow_and_arrow),
        Class("Literature", 15, 0, 15, 45, R.drawable.ic_baseline_book_24),
        Class("History", 17, 0, 17, 45, R.drawable.ic_bow_and_arrow),
        Class("Literature", 18, 0, 18, 45, R.drawable.ic_baseline_book_24),
        Class("History", 22, 0, 22, 45, R.drawable.ic_bow_and_arrow),
        Class("Literature", 23, 0, 23, 45, R.drawable.ic_baseline_book_24)
    )

    val mockHomeworks = listOf(
        Homework("Literature", curDateAdd2, "Read scenes 1.1 - 1.2 of The Master and Margarita", R.drawable.ic_baseline_book_24),
        Homework("Physics", curDateAdd5, "Learn Newton's laws of motion", R.drawable.ic_baseline_lightbulb_24),
    )

    val mockFaculties = listOf(
        Class("Physical Education", 10, 0, 11, 35, R.drawable.ic_baseline_sports_basketball_24,
                "Mr Barros","Intensive preparation for The Junior World Championship in Los Angeles", true),
    )


    override fun getClasses() = mockClasses

    override fun getCurrentClassIndex(): Int {
        val curHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val curMinute = Calendar.getInstance().get(Calendar.MINUTE)
        val cur = curHour*60 + curMinute
        //find current
        var ret = mockClasses.indexOfFirst { cl ->
            val start = cl.startHour*60 + cl.startMinute
            val end = cl.endHour*60 + cl.endMinute
            start >= cur && end <= cur
        }
        if (ret == -1) {
            //find next
            ret = mockClasses.indexOfFirst { cl -> cl.startHour*60 + cl.startMinute >= cur }
        }
        return ret
    }

    override fun getHomeworks(): List<Homework> = mockHomeworks
    override fun getClassesAndFaculties(): List<Class> {
        val cf = mutableListOf<Class>()
        cf.addAll(mockClasses)
        cf.addAll(mockFaculties)
        cf.sortWith { c1, c2 ->
            (c1.startHour * 60 + c1.startMinute) - (c2.startHour * 60 + c2.startMinute)
        }
        return cf
    }

}