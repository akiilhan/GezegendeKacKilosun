package com.example.gezegendekackilosun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{

    
    val KILO_TO_POUND:Double = 2.2045
    val POUND_TO_KILO:Double = 0.45
    val MARS:Double= 0.38 //pound
    val VENUS:Double = 0.91
    val URANUS:Double = 0.92
    val SATURN:Double = 1.06
    val JUPITER:Double = 2.34


     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         checkJupiter.setOnClickListener(this)
         checkUranus.setOnClickListener(this)
         checkSaturn.setOnClickListener(this)



         var kullanicikilo = kilo.text


        calculateBtn.setOnClickListener {
            Log.e("aki2", "butona basıldı.")
            // yukarıdaki kısım butona atamak için yapıldı.
              var kullaniciAgirlikPound = kilotoPound(kullanicikilo.toString().toDouble()) //kiloyu pounda cevirdik
            var marstakiAgirlikPound =kullaniciAgirlikPound*MARS //mars ağırlıgı
            var marstakiAgırlıkKilo = poundToKilo(marstakiAgirlikPound)
            var merkurdekiAgırlıkKilo = marstakiAgırlıkKilo
            var VenustekiAgırlıkPound = kullaniciAgirlikPound*VENUS
            var VenustekiAgırlıkKilo = poundToKilo(VenustekiAgırlıkPound)


            sonucMars.text = marstakiAgırlıkKilo.formatla(2).toString() + " kg"
            sonucMercury.text = marstakiAgırlıkKilo.formatla(2).toString() + " kg"
            sonucVenus.text = VenustekiAgırlıkKilo.formatla(2).toString() + " kg"

            Log.e("test","venus calıstı")
        }

    }
    fun kilotoPound(kilo:Double):Double{


        return kilo*KILO_TO_POUND
    }



    fun poundToKilo(pound:Double):Double{

        return pound*POUND_TO_KILO
    }



override fun onClick(p0: View?) {


        p0 as CheckBox // P0 değeri nin bir checkbox olacağını söylüyorum.
        var isCheck:Boolean = p0.isChecked // checkbox eğer check edildiyse "true" edilmediyse "false" değeri alacak.
        when(p0.id){

            R.id.sonucJupiter -> if (isCheck && !TextUtils.isEmpty(kilo.text.toString())){

                var kiloKullanıcı = kilo.text
                var poundKullanici = kilotoPound(kiloKullanıcı.toString().toDouble())
                var jupiterPound = poundKullanici *JUPITER
                var jupiterKilo = poundToKilo(jupiterPound)
                sonucJupiter.text = jupiterKilo.formatla(2).toString() + " kg"
                Log.e("test","jupiter calıstı")

            }
            R.id.sonucUranus -> if (isCheck && TextUtils.isEmpty(kilo.text.toString())){
                var kiloKullanıcı = kilo.text
                var poundKullanici = kilotoPound(kiloKullanıcı.toString().toDouble())
                var UranusPound = poundKullanici *URANUS
                var uranusKilo = poundToKilo(UranusPound)
                sonucJupiter.text = uranusKilo.formatla(2).toString() + " kg"
                Log.e("test","jupiter calıstı")

            }
            R.id.sonucSaturn -> if (isCheck && !TextUtils.isEmpty(kilo.text.toString())){


            }
        }



    }



    fun Double.formatla(kacTaneRakam:Int) = java.lang.String.format("%.${kacTaneRakam}f",this)
}

