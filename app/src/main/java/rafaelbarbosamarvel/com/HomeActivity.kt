package rafaelbarbosamarvel.com

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.*
import java.util.concurrent.TimeUnit


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        buscaPersonagens()
    }

    fun buscaPersonagens(){


       val uri = Uri.parse("https://gateway.marvel.com/v1/public/characters?ts=1&apikey=a6220ebb4f5777a529deb1fd896e86ae&hash=10385f70d19f671c00c7a1b89e2993cb")

        val client = OkHttpClient().newBuilder().readTimeout(5, TimeUnit.SECONDS).connectTimeout(10, TimeUnit.SECONDS).build()
        val request = Request.Builder().url(uri.toString()).build() //Erro no buscar webservice
        val response = client.newCall(request).execute()

        val json = response.body.toString()
        val gson = Gson()
        val Dados = gson.fromJson<Dados>(json, Dados::class.java)

        val recyclerview = findViewById<RecyclerView>(R.id.listConteudo)

        val dado = ArrayList<Dados>()

        dado.add(Dados(Dados.id, Dados.name, Dados.description, Dados.thumbnail))

        recyclerview.adapter = Adapter(dado, this)


    }

}