package com.example.otrstattelecom.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.otrstattelecom.R
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment

class Test : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme(R.style.AppThemeLogin);
        super.onCreate(savedInstanceState)
        // Make sure you don't call setContentView!

        // Call addSlide passing your Fragments.
        // You can use AppIntroFragment to use a pre-built fragment
        addSlide(AppIntroFragment.newInstance(
                title = "Добро пожаловать в OTRS Tattelecom...",
                imageDrawable = R.mipmap.slide2,
                description = "Рекомендуем вам ознакомиться с базовым функционалам приложения"
        ))
        addSlide(AppIntroFragment.newInstance(
                title = "Заявки",
                description = "На данном экране мы момжем видеть все наши тикеты, которые нам доступны. Так же можно выбрать открытые/закрытые "
        ))
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"

        val intent = Intent(this, Tasks::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        val intent = Intent(this, Tasks::class.java)
        startActivity(intent)
        finish()
    }
}