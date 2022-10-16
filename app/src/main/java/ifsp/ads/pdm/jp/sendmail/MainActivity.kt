package ifsp.ads.pdm.jp.sendmail

import android.content.Intent
import android.content.Intent.*
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ifsp.ads.pdm.jp.sendmail.databinding.ActivityMainBinding

lateinit var amb : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)
        amb.cleanBt.setOnClickListener{
            with(amb) {
                toEt.setText("")
                ccEt.setText("")
                bccEt.setText("")
                subjectEt.setText("")
                msgEt.setText("")
            }

        }

        amb.sendBt.setOnClickListener{
            val mailIntent = Intent(ACTION_SENDTO)
            with(mailIntent) {
                putExtra(EXTRA_EMAIL, arrayOf(amb.toEt.text.toString()))
                putExtra(EXTRA_CC, arrayOf(amb.ccEt.text.toString()))
                putExtra(EXTRA_BCC, arrayOf(amb.bccEt.text.toString()))
                putExtra(EXTRA_SUBJECT, arrayOf(amb.subjectEt.text.toString()))
                putExtra(EXTRA_TEXT, arrayOf(amb.msgEt.text.toString()))
                type = "message/rfc822"
                data = Uri.parse("mailto:")
            }

            val chooserIntent = Intent(ACTION_CHOOSER)
            chooserIntent.putExtra(EXTRA_INTENT, mailIntent)
            startActivity(chooserIntent)
        }
    }

}