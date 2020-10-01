package edu.rit.cmp5987.kotlinlistview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlin.collections.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        //val redColor = Color.parseColor("#FF0000")
        //listView.setBackgroundColor(redColor)
        listView.adapter = MyCustomAdapter(this) //this is my customAdapterDefining how list will render
    }

    //inner class of main activity
    private class MyCustomAdapter(context: Context): BaseAdapter() {

        //keep context ref as a private
        private val mContext: Context
        private val names = arrayListOf<String>("Test Name", "Steve Jobs", "Catie Poggioli", "Tim Cook", "John Doe")

        init {
            this.mContext = context
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            //use layout inflator to use the return value
            val layoutInflater = LayoutInflater.from(mContext)

            //gives the ivew that belongs to row main file
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

            val namesTextView = rowMain.findViewById<TextView>(R.id.row_name_text_view)
            namesTextView.text = names[position]
            val positionTextView = rowMain.findViewById<TextView>(R.id.row_number_text_view)
            positionTextView.text = "Row Number: $position"

            return rowMain
        }

        //ignore
        override fun getItem(position: Int): Any {
            return "Test String"
        }

        //ingorable
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //how many rows in my list
        override fun getCount(): Int {
            return names.size
        }

    }
}