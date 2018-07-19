package com.fungo.socialgo.pay.entityimport android.text.TextUtils/** * @author Pinger * @since 18-7-19 下午7:45 * 支付宝支付结果实体 */class ALiPayResult(rawResult: Map<String, String>?) {    private var resultStatus: String? = null    private var result: String? = null    private var memo: String? = null    companion object {        const val PAY_OK_STATUS = "9000"// 支付成功        const val PAY_WAIT_CONFIRM_STATUS = "8000"// 交易待确认        const  val PAY_FAILED_STATUS = "4000"// 交易失败        const  val PAY_CANCLE_STATUS = "6001"// 交易取消        const val PAY_NET_ERR_STATUS = "6002"// 网络出错        const  val PAY_UNKNOWN_ERR_STATUS = "6004"// 结果未知    }    init {        if (rawResult != null) {            for (key in rawResult.keys)                when {                    TextUtils.equals(key, "resultStatus") -> resultStatus = rawResult[key]                    TextUtils.equals(key, "result") -> result = rawResult[key]                    TextUtils.equals(key, "memo") -> memo = rawResult[key]                }        }    }    override fun toString(): String {        return ("resultStatus={" + resultStatus + "};memo={" + memo                + "};result={" + result + "}")    }    /**     * @return the resultStatus     */    fun getResultStatus(): String? {        return resultStatus    }    /**     * @return the memo     */    fun getMemo(): String? {        return memo    }    /**     * @return the result     */    fun getResult(): String? {        return result    }}