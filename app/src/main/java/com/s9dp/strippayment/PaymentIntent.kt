package com.s9dp.strippayment


import com.google.gson.annotations.SerializedName

data class PaymentIntent(
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("amount_capturable")
    val amountCapturable: Int,
    @SerializedName("amount_details")
    val amountDetails: AmountDetails,
    @SerializedName("amount_received")
    val amountReceived: Int,
    @SerializedName("application")
    val application: Any,
    @SerializedName("application_fee_amount")
    val applicationFeeAmount: Any,
    @SerializedName("automatic_payment_methods")
    val automaticPaymentMethods: AutomaticPaymentMethods,
    @SerializedName("canceled_at")
    val canceledAt: Any,
    @SerializedName("cancellation_reason")
    val cancellationReason: Any,
    @SerializedName("capture_method")
    val captureMethod: String,
    @SerializedName("client_secret")
    val clientSecret: String,
    @SerializedName("confirmation_method")
    val confirmationMethod: String,
    @SerializedName("created")
    val created: Int,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("customer")
    val customer: String,
    @SerializedName("description")
    val description: Any,
    @SerializedName("id")
    val id: String,
    @SerializedName("invoice")
    val invoice: Any,
    @SerializedName("last_payment_error")
    val lastPaymentError: Any,
    @SerializedName("latest_charge")
    val latestCharge: Any,
    @SerializedName("livemode")
    val livemode: Boolean,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("next_action")
    val nextAction: Any,
    @SerializedName("object")
    val objectX: String,
    @SerializedName("on_behalf_of")
    val onBehalfOf: Any,
    @SerializedName("payment_method")
    val paymentMethod: Any,
    @SerializedName("payment_method_configuration_details")
    val paymentMethodConfigurationDetails: PaymentMethodConfigurationDetails,
    @SerializedName("payment_method_options")
    val paymentMethodOptions: PaymentMethodOptions,
    @SerializedName("payment_method_types")
    val paymentMethodTypes: List<String>,
    @SerializedName("processing")
    val processing: Any,
    @SerializedName("receipt_email")
    val receiptEmail: Any,
    @SerializedName("review")
    val review: Any,
    @SerializedName("setup_future_usage")
    val setupFutureUsage: Any,
    @SerializedName("shipping")
    val shipping: Any,
    @SerializedName("source")
    val source: Any,
    @SerializedName("statement_descriptor")
    val statementDescriptor: Any,
    @SerializedName("statement_descriptor_suffix")
    val statementDescriptorSuffix: Any,
    @SerializedName("status")
    val status: String,
    @SerializedName("transfer_data")
    val transferData: Any,
    @SerializedName("transfer_group")
    val transferGroup: Any
) {
    data class AmountDetails(
        @SerializedName("tip")
        val tip: Tip
    ) {
        class Tip
    }

    data class AutomaticPaymentMethods(
        @SerializedName("allow_redirects")
        val allowRedirects: String,
        @SerializedName("enabled")
        val enabled: Boolean
    )

    class Metadata

    data class PaymentMethodConfigurationDetails(
        @SerializedName("id")
        val id: String,
        @SerializedName("parent")
        val parent: Any
    )

    data class PaymentMethodOptions(
        @SerializedName("card")
        val card: Card
    ) {
        data class Card(
            @SerializedName("installments")
            val installments: Any,
            @SerializedName("mandate_options")
            val mandateOptions: Any,
            @SerializedName("network")
            val network: Any,
            @SerializedName("request_three_d_secure")
            val requestThreeDSecure: String
        )
    }
}