package com.example.myrapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.*
import com.example.myrapp.Pojitos.Posts
import kotlinx.android.synthetic.main.activity_eject.*
import retrofit2.*
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class EjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eject)

        var lay = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        var api = retrofit.create(ApiSer::class.java)
        var numberpost: ArrayList<Posts> = ArrayList()
        val myadapter = MyAdapter(numberpost)
        for (i in 0..100) {
            numberpost.add(Posts())

        }
        bfav.text = "FAVORITOS"
        bremove.text = "REMOVE"
        brefresh.text = "REFRESH"

        var ith = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                myadapter.removeitem(viewHolder)
            }
        }//Fini temtouchhelper

        api.getpost().enqueue(object : Callback<List<Posts>> {
            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                d("Error XX11XX11XX","No está cargando la info del JSon (al parecer)")
            }//Fin on failure heeree

            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                d("CONGRATS","we, made it")
                var response = response.body()
            }//Fin on responsse here

        })//fin api.getpost
        reclist.apply {
            adapter = myadapter
            layoutManager = lay
            addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }//fin reclistaply
    }//Oncreate

}//Ejectactiviy

