package com.bwie.presenter

import com.bwie.bean.HotBean
import com.bwie.model.HotModel
import com.bwie.view.IHotView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by 朝朝暮暮 on 2017/12/28.
 */
class HotPresenter(iHotView: IHotView) {


    var hotModel:HotModel = HotModel()

    var ihotview : IHotView = iHotView
    fun lianjie(bin:String){
        var bin : String = bin
        val flowable = hotModel.getData(bin)
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<HotBean>(){
                    override fun onComplete() {

                    }

                    override fun onError(t: Throwable?) {

                    }

                    override fun onNext(t: HotBean?) {
                        ihotview.getData(t!!)
                    }

                })
    }
}