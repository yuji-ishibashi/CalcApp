package jp.techacademy.yuji.ishibashi.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calc_result.*

class CalcResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_result)

        val result = intent.getDoubleExtra("calcResult", 0.0)
        textView_result.text = result.toString()
    }
}