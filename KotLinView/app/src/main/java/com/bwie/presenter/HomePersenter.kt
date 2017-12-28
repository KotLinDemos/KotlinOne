package com.bwie.presenter

import com.bwie.bean.Homebean
import com.bwie.model.HomeMolder
import com.bwie.view.HomeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import org.jetbrains.anko.Android

/**
 * Created by dell on 2017/12/27.
 */
class HomePersenter(homeView: HomeView) {
    val molder:HomeMolder?= HomeMolder()
    val homeView:HomeView?=homeView

    fun home(){
        val flowable=molder!!.getDataMolder()
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<Homebean>() {
                    override fun onNext(t: Homebean?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        homeView!!.showDataa(t!!)
                    }

                    override fun onError(t: Throwable?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onComplete() {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
    }

}