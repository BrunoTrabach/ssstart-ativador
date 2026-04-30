package com.aiwa.ativador
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.LinearLayout
import java.io.File

class MainActivity: Activity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        val layout = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        val btn = Button(this).apply { text = "Gerar Pasta AIWA_SYNC" }
        btn.setOnClickListener { gerar() }
        layout.addView(btn)
        setContentView(layout)
    }
    private fun gerar() {
        val base = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Pacote_Aiwa_${System.currentTimeMillis()}")
        val sync = File(base, "AIWA_SYNC")
        val videos = File(sync, "videos")
        listOf(File(videos,"32"), File(videos,"43"), File(videos,"50"), File(videos,"55"), File(videos,"65")).forEach { it.mkdirs() }
        File(sync, "codigo.txt").writeText("AIWA2026")
        File(sync, "videos_32.txt").writeText("# coloque um nome por linha")
        // Abre pasta
        startActivity(Intent(Intent.ACTION_VIEW).setDataAndType(Uri.fromFile(base), "*/*"))
    }
}
