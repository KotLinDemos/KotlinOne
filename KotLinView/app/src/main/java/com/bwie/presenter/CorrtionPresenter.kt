package com.bwie.presenter

import com.bwie.adapter.CorretionAdpter
import com.bwie.bean.CorretionBean
import com.bwie.model.CorrtionMolder
import com.bwie.view.CorretionView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by dell on 2017/12/29.
 */
class CorrtionPresenter(corrview:CorretionView){
    var corrmolder:CorrtionMolder?=CorrtionMolder()
    var corrview:CorretionView?=corrview

    fun cooretion(query:String){
        val flowable = corrmolder!!.getCoortion(query)
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSubscriber<CorretionBean>(){
                    override fun onNext(t: CorretionBean?) {
                       corrview!!.showCorrtion(t!!)
                    }

                    override fun onComplete() {

                    }

                    override fun onError(t: Throwable?) {

                    }

                })

    }
}