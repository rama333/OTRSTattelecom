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
                description = "Рекомендуем вам ознакомиться с базовым функциями приложения"
        ))
        addSlide(AppIntroFragment.newInstance(
                title = "Заявки",
                imageDrawable = R.mipmap.list,
                description = "На данном экране отображены заявки которые закреплены за вами"
        ))

        addSlide(AppIntroFragment.newInstance(
                title = "Меню",
                imageDrawable = R.mipmap.menu,
                description = "Здесь можно выбрать открытые/закрытые/доступные мне заявки  "
        ))

        addSlide(AppIntroFragment.newInstance(
                title = "Принятие заявки на себя",
                imageDrawable = R.mipmap.loc,
                description = "Чтобы закрепить заявку за собой, смахните нужную заявку вправо и нажмите ВЗЯТЬ"
        ))

        addSlide(AppIntroFragment.newInstance(
                title = "Закртытие заявки",
                imageDrawable = R.mipmap.close,
                description = "Чтобы закрыть заявку, смахните нужную заявку влево и нажмите ЗАКРЫТЬ"
        ))

        addSlide(AppIntroFragment.newInstance(
                title = "Чат",
                imageDrawable = R.mipmap.chat,
                description = "При закрытие обязательно указывайте в чате что было сделано"
        ))

        addSlide(AppIntroFragment.newInstance(
                title = "Детальная информация",
                imageDrawable = R.mipmap.detail,
                description = "Здесь можно получить детальную информацию"
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