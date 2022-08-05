package com.app.recyclerview.json_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.recyclerview.databinding.RowPahlawanJsonItemBinding
import com.bumptech.glide.Glide

class PahlawanAdapter(private val listPahlawan: MutableList<ModelPahlawan>) :
    RecyclerView.Adapter<PahlawanAdapter.PahlawanViewHolder>() {
    inner class PahlawanViewHolder(val itemPahlawan: RowPahlawanJsonItemBinding) :
        RecyclerView.ViewHolder(itemPahlawan.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = PahlawanViewHolder(
        RowPahlawanJsonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PahlawanAdapter.PahlawanViewHolder, position: Int) {
        holder.itemPahlawan.apply {
            with(listPahlawan[position]) {
                tvNamaLengkap.text = nama
                tvNamaPahlawan.text = namaLengkap
                Glide.with(imagePahlawan.context).load(image).into(imagePahlawan)
            }
        }
    }

    override fun getItemCount() = listPahlawan.size
}