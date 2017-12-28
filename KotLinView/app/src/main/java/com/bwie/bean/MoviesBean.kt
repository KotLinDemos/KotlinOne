package com.bwie.bean

import java.io.Serializable

/**
 * Created by 朝朝暮暮 on 2017/12/28.
 */

class MoviesBean : Serializable {
    lateinit var playUrl: String
    lateinit var feed: String
    lateinit var blurred: String
    lateinit var category: String
    lateinit var title: String
    lateinit var description: String

    lateinit var collectionCont: String
    lateinit var replyCount: String
    lateinit var shareCount: String
}
