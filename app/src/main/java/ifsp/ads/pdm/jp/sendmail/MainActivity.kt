package ifsp.ads.pdm.jp.sendmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ifsp.ads.pdm.jp.sendmail.databinding.ActivityMainBinding

lateinit var amb : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)
    }
}