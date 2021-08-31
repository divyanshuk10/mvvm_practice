package com.divyanshu.mvvmpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.divyanshu.mvvmpractice.model.RecyclerData
import kotlinx.android.synthetic.main.recycler_view_list_row.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    private var listData: List<RecyclerData>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_list_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return listData?.size ?: 0
    }

    fun setUpdatedData(data: List<RecyclerData>) {
        listData = data

    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagePic = view.img_pic
        val txtName = view.txt_name
        val txtDescription = view.txt_description
        fun bind(data: RecyclerData) {
            txtDescription.text = data.description
            txtName.text = data.name
            Glide.with(imagePic).load(data.owner?.avatar_url)
                .apply(RequestOptions.centerCropTransform()).into(imagePic)
        }
    }

}