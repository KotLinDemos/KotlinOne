package com.bwie.sctouxiang

/**
 * Created by 朝朝暮暮 on 2017/12/1.
 */

class UserBean {

    /**
     * msg : 获取用户信息成功
     * code : 0
     * data : {"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-19T20:09:24","email":null,"fans":0,"follow":0,"gender":0,"icon":"https://www.zhaoapi.cn/images/1512119101568com_lexue365_96x96.png","latitude":null,"longitude":null,"mobile":"13653637501","money":0,"nickname":"飞向大海的山贼","password":"123456","praiseNum":null,"token":"4B5DAF274221936555E01E5F7BC271F4","uid":552,"userId":null,"username":"13653637501"}
     */

    var msg: String? = null
    var code: String? = null
    var data: DataBean? = null

    class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-11-19T20:09:24
         * email : null
         * fans : 0
         * follow : 0
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/1512119101568com_lexue365_96x96.png
         * latitude : null
         * longitude : null
         * mobile : 13653637501
         * money : 0
         * nickname : 飞向大海的山贼
         * password : 123456
         * praiseNum : null
         * token : 4B5DAF274221936555E01E5F7BC271F4
         * uid : 552
         * userId : null
         * username : 13653637501
         */

        var age: Any? = null
        var appkey: Any? = null
        var appsecret: Any? = null
        var createtime: String? = null
        var email: Any? = null
        var fans: Int = 0
        var follow: Int = 0
        var gender: Int = 0
        var icon: String? = null
        var latitude: Any? = null
        var longitude: Any? = null
        var mobile: String? = null
        var money: Int = 0
        var nickname: String? = null
        var password: String? = null
        var praiseNum: Any? = null
        var token: String? = null
        var uid: Int = 0
        var userId: Any? = null
        var username: String? = null
    }
}
