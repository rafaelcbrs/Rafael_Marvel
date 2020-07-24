package rafaelbarbosamarvel.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import java.util.*
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.navigationBarColor = ContextCompat.getColor(this, R.color.corBranco)

        val timer = Timer()
        timer.schedule(timerTask { val intent = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(intent)
            finish() }, 1000)
    }
}