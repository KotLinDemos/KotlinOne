package com.bwie.presenter

import com.bwie.bean.findbean
import com.bwie.model.FindModel
import com.bwie.view.IFindview
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by cll on 2017/12/27.
 */
class FindPresenter (findview:IFindview) {
    val model:FindModel?= FindModel()
    var findview:IFindview?=findview
    fun ff(){
        var flow=model!!.getFindData()
        flow.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<List<findbean>>(){
                    override fun onComplete() {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onNext(t: List<findbean>?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        findview!!.findData(t!!)
                    }

                    override fun onError(t: Throwable?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })


    }
}