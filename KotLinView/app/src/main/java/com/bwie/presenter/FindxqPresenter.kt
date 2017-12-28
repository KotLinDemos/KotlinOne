package com.bwie.presenter

import android.util.Log
import com.bwie.bean.findxqbean
import com.bwie.model.FindxqModel
import com.bwie.view.IFindxqView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by cll on 2017/12/28.
 */
class FindxqPresenter (findxqvire:IFindxqView){
    val model:FindxqModel?= FindxqModel()
    val view:IFindxqView?=findxqvire
    fun xq(){
        val findxq=model!!.getServerData()
        findxq.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<List<findxqbean.ItemListBean>>() {
                    override fun onComplete() {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onError(t: Throwable?) {
                       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onNext(t: List<findxqbean.ItemListBean>?) {
                       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                       Log.i("xxx",t.toString())
                        view!!.showData(t!!)
                    }

                })
    }
}