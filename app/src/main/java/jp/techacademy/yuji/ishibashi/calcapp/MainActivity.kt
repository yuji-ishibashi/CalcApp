package jp.techacademy.yuji.ishibashi.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add.setOnClickListener(this)
        button_sub.setOnClickListener(this)
        button_mul.setOnClickListener(this)
        button_div.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val num1: Double? = if (editText_first.text.isNullOrEmpty()) null else editText_first.text.toString().toDouble()
        val num2: Double? = if (editText_second.text.isNullOrEmpty()) null else editText_second.text.toString().toDouble()

        if(num1 == null || num2 == null) {
            Snackbar.make(v, "数値が未入力です。", Snackbar.LENGTH_SHORT).show()
            return
        }

        when(v.id){
            R.id.button_add -> add(num1, num2)
            R.id.button_sub -> sub(num1, num2)
            R.id.button_mul -> mul(num1, num2)
            R.id.button_div -> div(num1, num2)
        }
    }

    private fun add(num1: Double, num2: Double) {
        //小数点第二位（三位以下四捨五入）まで出力
        val result: Double = Math.round((num1 + num2) * 100.0) / 100.0

        val intent = Intent(this, CalcResultActivity::class.java)
        intent.putExtra("calcResult", result)
        startActivity(intent)
    }

    private fun sub(num1: Double, num2: Double) {
        //小数点第二位（三位以下四捨五入）まで出力
        val result: Double = Math.round((num1 - num2) * 100.0) / 100.0

        val intent = Intent(this, CalcResultActivity::class.java)
        intent.putExtra("calcResult", result)
        startActivity(intent)
    }

    private fun mul(num1: Double, num2: Double) {
        //小数点第二位（三位以下四捨五入）まで出力
        val result: Double = Math.round((num1 * num2) * 100.0) / 100.0

        val intent = Intent(this, CalcResultActivity::class.java)
        intent.putExtra("calcResult", result)
        startActivity(intent)
    }

    private fun div(num1: Double, num2: Double) {
        //小数点第二位（三位以下四捨五入）まで出力
        val result: Double = Math.round((num1 / num2) * 100.0) / 100.0

        val intent = Intent(this, CalcResultActivity::class.java)
        intent.putExtra("calcResult", result)
        startActivity(intent)
    }
}