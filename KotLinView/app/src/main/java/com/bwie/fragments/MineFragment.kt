package com.bwie.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bwie.api.ApiService
import com.bwie.kotlinview.AdviseActivity
import com.bwie.kotlinview.R
import com.bwie.kotlinview.SaveActivity
import com.bwie.kotlinview.WatchActivity
import com.bwie.sctouxiang.ResultBean
import com.bwie.sctouxiang.UserBean
import com.bwie.utils.RetrofitUtil2s
import com.facebook.drawee.view.SimpleDraweeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

/**
 * Created by ${单巨廷} on 2017/12/27.
 */
class MineFragment : Fragment(),View.OnClickListener{

    private var pic: SimpleDraweeView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.mine_fragment, container, false)
        val save = view.findViewById(R.id.tv_save) as TextView
        pic=view.findViewById(R.id.pic) as SimpleDraweeView
        pic!!.setOnClickListener(this)
        val watch = view.findViewById(R.id.tv_watch) as TextView
        val advise = view.findViewById(R.id.tv_advise) as TextView
        watch.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var it3=Intent(activity, WatchActivity::class.java)
                startActivity(it3)
            }
        })

        advise.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var it2=Intent(activity,AdviseActivity::class.java)
                startActivity(it2)
            }
        })
        save.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                var it=Intent(activity, SaveActivity::class.java)
                startActivity(it)
            }
        })
        return view
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //获取图片路径
        if (requestCode == IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImage = data.data
            val filePathColumns = arrayOf(MediaStore.Images.Media.DATA)
            val contentResolver = activity.getContentResolver()
            val c = contentResolver.query(selectedImage, filePathColumns, null, null, null)
            c!!.moveToFirst()
            val columnIndex = c.getColumnIndex(filePathColumns[0])
            val imagePath = c.getString(columnIndex)

            val apiService = RetrofitUtil2s.instance.getApiService("https://www.zhaoapi.cn/", ApiService::class.java)

            c.close()

            val file = File(imagePath)
            val requestBody = RequestBody.create(MediaType.parse("application/otcet-stream"), file)
            val body = MultipartBody.Part.createFormData("file", file.name, requestBody)
            val uid = RequestBody.create(MediaType.parse("multipart/form-data"), "552")
            val call = apiService.uploadPic(uid, body)

            call.enqueue(object : Callback<ResultBean> {
                override fun onResponse(call: Call<ResultBean>, response: Response<ResultBean>) {
                    val resultBean = response.body()
                    Log.e("xxx", resultBean.msg)
                }

                override fun onFailure(call: Call<ResultBean>, t: Throwable) {
                    Log.e("xxx", "失败")
                }
            })
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.pic -> {
                //调用相册
                val intent = Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                //设置取回的数据类型
                //           intent.setType("image/*");
                startActivityForResult(intent, IMAGE)
                val retrofit = RetrofitUtil2s.getRetrofit("https://www.zhaoapi.cn/")
                val apiService2 = retrofit!!.create<ApiService>(ApiService::class.java)
                val observable = apiService2.getdd()
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSubscriber<UserBean>() {
                            override fun onNext(userBean: UserBean) {
                                pic!!.setImageURI(Uri.parse(userBean.data!!.icon))

                            }

                            override fun onError(t: Throwable) {

                            }

                            override fun onComplete() {

                            }
                        })
            }
            else -> {
            }
        }
    }

    companion object {

        //调用系统相册-选择图片
        private val IMAGE = 1
    }
}