package com.yasin.materialplayground.mergeAdapter.model

import com.google.gson.annotations.SerializedName
import com.yasin.rxjavalearn.networkCallWithRx.Geo

data class Address(@SerializedName("zipcode")
                   val zipcode: String = "",
                   @SerializedName("geo")
                   val geo: Geo,
                   @SerializedName("suite")
                   val suite: String = "",
                   @SerializedName("city")
                   val city: String = "",
                   @SerializedName("street")
                   val street: String = "")