package com.bwie.kotlinview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bwie.adapter.CorretionAdpter
import com.bwie.adapter.SearchAdapter
import com.bwie.bean.CorretionBean
import com.bwie.bean.MoviesBean
import com.bwie.presenter.CorrtionPresenter
import com.bwie.view.CorretionView
import com.bwie.view.DetailsActivity
import kotlinx.android.synthetic.main.activity_correlation.*
import kotlinx.android.synthetic.main.home_fragment.*

class CorrelationActivity : AppCompatActivity(), CorretionView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correlation)

        var correla_recyview=findViewById(R.id.correla_recyview) as RecyclerView
        var linearLayoutManager= LinearLayoutManager(this)
        correla_recyview.setLayoutManager(linearLayoutManager)
        var correemal_text=findViewById(R.id.correemal_text) as TextView
        var searc_imag=findViewById(R.id.searc_imag) as ImageView


        searc_imag.setOnClickListener(View.OnClickListener(function = {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }))

        var seach=intent.getStringExtra("seach")
        correemal_text.setText(seach+"相关与")
        var data=intent.getStringExtra("data")
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show()

        if(seach!=null){
            val corrtionPresenter = CorrtionPresenter(this)
            corrtionPresenter.cooretion(seach)
        }else if(data!=null){
            val corrtionPresenter = CorrtionPresenter(this)
            corrtionPresenter.cooretion(data)
        }


    }

    override fun showCorrtion(corerBean: CorretionBean) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val itemList = corerBean.itemList!!
        val corretionAdpter = CorretionAdpter(this, itemList)
        correla_recyview.adapter=corretionAdpter
        //Toast.makeText(this,itemList.get(1).data?.title,Toast.LENGTH_SHORT).show()
       var movies: MoviesBean = MoviesBean()
        corretionAdpter.setOniteClickListener(object :CorretionAdpter.OnItemClickLitener{
            override fun onItemClick(list: CorretionBean.ItemListBean.DataBean?) {

                var intent = Intent()
                intent.setClass(this@CorrelationActivity, DetailsActivity::class.java)

                movies.playUrl = list!!.playUrl!!
                movies.feed = list.cover!!.feed!!
                movies.blurred=list.cover!!.blurred!!
                movies.category=list.category!!
                movies.title=list.title!!
                movies.description=list.description!!
                movies.collectionCont=""+list.consumption!!.collectionCount!!
                movies.replyCount=""+list.consumption!!.replyCount!!
                movies.shareCount=""+list.consumption!!.shareCount!!

                intent.putExtra("movies",movies)
                startActivity(intent)
            }
        })

    }
}
