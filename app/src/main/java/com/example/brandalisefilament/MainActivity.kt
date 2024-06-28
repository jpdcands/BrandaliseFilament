package com.example.brandalisefilament

import android.os.Bundle
import android.view.SurfaceView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.brandalisefilament.ui.theme.BrandaliseFilamentTheme
import com.example.brandalisefilament.ui.theme.ModelRenderer
import com.google.android.filament.utils.Utils

class MainActivity : ComponentActivity() {

    companion object {
        init {
            Utils.init()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AndroidView(factory = { context ->
                        val renderer = ModelRenderer()

                        SurfaceView(context).apply {
                            renderer.onSurfaceAvailable(this, lifecycle)
                        }
                    })
                }
            }
        }
    }
}


