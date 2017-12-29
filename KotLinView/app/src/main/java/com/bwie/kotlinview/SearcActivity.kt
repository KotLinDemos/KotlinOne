package com.bwie.kotlinview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bwie.adapter.SearchAdapter
import com.bwie.bean.Homebean
import com.bwie.bean.MoviesBean
import com.bwie.presenter.CorrtionPresenter
import com.bwie.view.DetailsActivity
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import kotlinx.android.synthetic.main.activity_searc.*

class SearcActivity : AppCompatActivity() {
    var data : MutableList<String> = arrayListOf("脱口秀","城会玩","666","笑cry","漫威",
            "清新","匠心","VR","心理学","舞蹈","品牌广告","粉丝自制","电影相关","萝莉","魔性"
            ,"第一视角","教程","毕业设计","奥斯卡","燃","冰与火之歌","温情","线下campaign","公益")
    lateinit var mAdatper : SearchAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searc)

        var search_edit=findViewById(R.id.search_edit) as EditText
        var searc_imag1=findViewById(R.id.searc_imag1) as ImageView
        var search_recyview=findViewById(R.id.search_recyview) as RecyclerView

        searc_imag1.setOnClickListener(View.OnClickListener {
            var seach:String=search_edit.getText().toString()
            val intent = Intent(this, CorrelationActivity::class.java)
            intent.putExtra("seach",seach)
            //Toast.makeText(this,seach,Toast.LENGTH_SHORT).show()
            startActivity(intent)
        })
        //var seach=intent.getStringExtra("seach")
        setData()

    }
    val manager = FlexboxLayoutManager()

    private fun setData() {
        var linearLayoutManager= LinearLayoutManager(this)
        search_recyview.setLayoutManager(linearLayoutManager)
        mAdatper = SearchAdapter(this, data as ArrayList<String>)
       // Toast.makeText(this,data as ArrayList<String>,Toast.LENGTH_SHORT).show()
        Toast.makeText(this,data.get(1),Toast.LENGTH_SHORT).show()

        var movies: MoviesBean = MoviesBean()
        mAdatper.setOniteClickListener(object :SearchAdapter.OnItemClickLitener{
            override fun onItemClick(list: Homebean.IssueListBean.ItemListBean.DataBean?) {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                var intent = Intent()
                intent.setClass(this@SearcActivity, DetailsActivity::class.java)

                //intent.putExtra("data",data)
                movies.playUrl = list!!.playUrl!!
                movies.feed = list.cover!!.feed!!
                movies.blurred=list.cover!!.blurred!!
                movies.category=list.category!!
                movies.title=list.title!!
                movies.description=list.description!!
                movies.collectionCont=""+list.consumption!!.collectionCount!!
                movies.replyCount=""+list.consumption!!.replyCount!!
                movies.shareCount=""+list.consumption!!.shareCount!!
               intent.putExtra("data",data as ArrayList<String>)

                intent.putExtra("movies",movies)
                startActivity(intent)
            }


        })
        manager.flexDirection = FlexDirection.ROW
        //设置是否换行
        manager.flexWrap = FlexWrap.WRAP
        search_recyview.layoutManager = manager
        search_recyview.itemAnimator = DefaultItemAnimator()
        search_recyview.adapter=mAdatper

    }
}
