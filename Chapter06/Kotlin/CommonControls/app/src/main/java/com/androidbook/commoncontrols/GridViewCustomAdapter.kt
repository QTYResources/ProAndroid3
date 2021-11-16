package com.androidbook.commoncontrols

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GridViewCustomAdapter: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gridviewcustom)

        val gv = findViewById<GridView>(R.id.gridview)

        val adapter = ManateeAdapter(this)

        gv.adapter = adapter
    }

    companion object {

        class ManateeAdapter(private val context: Context): BaseAdapter() {

            private val mInflater = LayoutInflater.from(context)

            private val manatees = intArrayOf(
                R.drawable.manatee00, R.drawable.manatee01, R.drawable.manatee02,
                R.drawable.manatee03, R.drawable.manatee04, R.drawable.manatee05,
                R.drawable.manatee06, R.drawable.manatee07, R.drawable.manatee08,
                R.drawable.manatee09, R.drawable.manatee10, R.drawable.manatee11,
                R.drawable.manatee12, R.drawable.manatee13, R.drawable.manatee14,
                R.drawable.manatee15, R.drawable.manatee16, R.drawable.manatee17,
                R.drawable.manatee18, R.drawable.manatee19, R.drawable.manatee20,
                R.drawable.manatee21, R.drawable.manatee22, R.drawable.manatee23,
                R.drawable.manatee24, R.drawable.manatee25, R.drawable.manatee26,
                R.drawable.manatee27, R.drawable.manatee28, R.drawable.manatee29,
                R.drawable.manatee30, R.drawable.manatee31, R.drawable.manatee32,
                R.drawable.manatee33
            )

            private var manateeImages = ArrayList<Bitmap>()
            private var manateeThumbs = ArrayList<Bitmap>()

            init {
                for (i in manatees.indices) {
                    manateeImages.add(BitmapFactory.decodeResource(context.resources, manatees[i]))
                    manateeThumbs.add(Bitmap.createScaledBitmap(manateeImages[i],
                        100, 100, false))
                }
            }

            override fun getCount(): Int {
                return manatees.size
            }

            override fun getItem(position: Int): Bitmap {
                return manateeImages[position]
            }

            override fun getItemId(position: Int): Long {
                return position.toLong()
            }

            override fun getViewTypeCount(): Int {
                Log.v(TAG, "in getViewTypeCount()")
                return 1
            }

            override fun getItemViewType(position: Int): Int {
                Log.v(TAG, "in getItemViewType() for position $position")
                return 0
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                var holder: ViewHolder? = null
                var view: View?

                Log.v(TAG, "in getView for position $position, covertView is ${if (convertView == null)  "null" else "being recycled"}")

                if (convertView == null) {
                    view = mInflater.inflate(R.layout.gridimage, null)
                    convertViewCounter++
                    Log.v(TAG, "$convertViewCounter convertViews have been created")

                    holder = ViewHolder()
                    holder.image = view.findViewById(R.id.gridImageView)

                    view.tag = holder
                } else {
                    holder = convertView.tag as ViewHolder
                    view = convertView
                }

                holder.image.setImageBitmap(manateeImages[position])

                return view!!
            }

            companion object {
                const val TAG = "ManateeAdapter"
                var convertViewCounter = 0

                class ViewHolder {
                    lateinit var image: ImageView
                }
            }
        }
    }
}