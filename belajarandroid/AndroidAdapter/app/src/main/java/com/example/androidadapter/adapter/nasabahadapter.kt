package com.example.androidadapter.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.androidadapter.model.Nasabah
import com.example.androidadapter.R

class nasabahadapter(var context: Context, private val list: List<Nasabah>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            convertView = inflater.inflate(R.layout.item_nasabah, null)
        }
        val nasabah = list[position]
        val namaTextView = convertView.findViewById<View>(R.id.nama) as TextView
        val lokasiTextView = convertView.findViewById<View>(R.id.lokasi) as TextView
        namaTextView.text = nasabah.nama
        lokasiTextView.text = nasabah.alamat
        return convertView
    }

}