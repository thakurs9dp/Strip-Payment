package com.s9dp.strippayment


import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("address") val address: Any,
    @SerializedName("balance") val balance: Int,
    @SerializedName("created") val created: Int,
    @SerializedName("currency") val currency: Any,
    @SerializedName("default_source") val defaultSource: Any,
    @SerializedName("delinquent") val delinquent: Boolean,
    @SerializedName("description") val description: Any,
    @SerializedName("discount") val discount: Any,
    @SerializedName("email") val email: Any,
    @SerializedName("id") val id: String,
    @SerializedName("invoice_prefix") val invoicePrefix: String,
    @SerializedName("invoice_settings") val invoiceSettings: InvoiceSettings,
    @SerializedName("livemode") val livemode: Boolean,
    @SerializedName("metadata") val metadata: Metadata,
    @SerializedName("name") val name: Any,
    @SerializedName("next_invoice_sequence") val nextInvoiceSequence: Int,
    @SerializedName("object") val objectX: String,
    @SerializedName("phone") val phone: Any,
    @SerializedName("preferred_locales") val preferredLocales: List<Any>,
    @SerializedName("shipping") val shipping: Any,
    @SerializedName("tax_exempt") val taxExempt: String,
    @SerializedName("test_clock") val testClock: Any
) {
    data class InvoiceSettings(
        @SerializedName("custom_fields") val customFields: Any,
        @SerializedName("default_payment_method") val defaultPaymentMethod: Any,
        @SerializedName("footer") val footer: Any,
        @SerializedName("rendering_options") val renderingOptions: Any
    )

    class Metadata
}