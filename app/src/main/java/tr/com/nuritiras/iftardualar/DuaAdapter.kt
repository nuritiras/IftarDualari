package tr.com.nuritiras.iftardualar

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tr.com.nuritiras.iftardualar.databinding.RecyclerRowBinding

class DuaAdapter(val duaList:ArrayList<IftarDua>):RecyclerView.Adapter<DuaAdapter.DuaViewHolder>() {
    class DuaViewHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DuaViewHolder {
        val binding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DuaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return duaList.size
    }

    override fun onBindViewHolder(holder: DuaViewHolder, position: Int) {
        holder.binding.textViewHicri.text=duaList[position].ramazan
        holder.binding.imageView.setImageResource(duaList[position].resim)

        holder.itemView.setOnClickListener {
            val intent= Intent(holder.itemView.context,DuaActivity::class.java)
            intent.putExtra("ramazan",duaList[position])
            holder.itemView.context.startActivity(intent)
        }
    }

}