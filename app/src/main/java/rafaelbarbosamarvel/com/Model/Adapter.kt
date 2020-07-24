package rafaelbarbosamarvel.com

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.marvel_list.view.*

class Adapter(private val dados : ArrayList<Dados>, private val ctx : Context) : RecyclerView.Adapter<Adapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.marvel_list, parent, false)
        val vh = VH(v)
        return vh
    }

    override fun onBindViewHolder(holder: Adapter.VH, position: Int) {
        val (id : String, name, description : String) = dados[position]

            val urlimg = dados[position].thumbnail
            Glide.with(ctx).load(urlimg).into(holder.itemView.img)

            holder.txtNome.text = name

            holder.txtDetalhes.text = "Detalhes"
            holder.txtDetalhes.id = id.toInt()


    }
    override fun getItemCount(): Int = dados.size

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView){

        val txtNome : TextView = itemView.nome
        val  txtDetalhes :TextView = itemView.detalhes


    }

}