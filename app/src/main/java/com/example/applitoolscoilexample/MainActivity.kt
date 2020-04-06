package com.example.applitoolscoilexample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.ImageLoader
import coil.api.load
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.decode.SvgDecoder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val imageLoader by lazy {
        ImageLoader(this) {
            componentRegistry {
                add(SvgDecoder(this@MainActivity))

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    add(ImageDecoderDecoder())
                } else {
                    add(GifDecoder())
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        load_svg.setOnClickListener {
            image.load("https://image.flaticon.com/icons/svg/617/617590.svg", imageLoader)
        }

        load_png.setOnClickListener {
            image.load(
                "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/320/google/241/fire_1f525.png",
                imageLoader
            ) {
                // https://coil-kt.github.io/coil/api/coil-base/coil/-image-loader-builder/allow-hardware/
                // NOTE: uncomment this make applitools test pass
                // allowHardware(false)
            }
        }
    }
}
