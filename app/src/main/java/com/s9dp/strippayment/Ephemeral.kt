package com.s9dp.strippayment


import com.google.gson.annotations.SerializedName

data class Ephemeral(
    @SerializedName("associated_objects") val associatedObjects: List<AssociatedObject>,
    @SerializedName("created") val created: Int,
    @SerializedName("expires") val expires: Int,
    @SerializedName("id") val id: String,
    @SerializedName("livemode") val livemode: Boolean,
    @SerializedName("object") val objectX: String,
    @SerializedName("secret") val secret: String
) {
    data class AssociatedObject(
        @SerializedName("id") val id: String, @SerializedName("type") val type: String
    )
}