package com.nytimes.android.external.registerlib

import android.app.Activity
import android.content.Context
import android.support.annotation.UiThread
import com.android.billingclient.api.*

class GoogleServiceProviderTesting(context: Context, listener: PurchasesUpdatedListener) : GoogleServiceProvider() {

    private val billingClient: BillingClientTesting = BillingClientTesting(context, listener)

    override fun isReady(): Boolean {
        return billingClient.isReady
    }

    override fun isFeatureSupported(feature: String): Int {
        return billingClient.isFeatureSupported(feature)
    }

    override fun startConnection(listener: BillingClientStateListener) {
        billingClient.startConnection(listener)
    }

    override fun endConnection() {
        billingClient.endConnection()
    }

    override fun launchBillingFlow(activity: Activity, params: BillingFlowParams): Int {
        return billingClient.launchBillingFlow(activity, params)
    }

    override fun queryPurchases(skuType: String): Purchase.PurchasesResult {
        return billingClient.queryPurchases(skuType)
    }

    override fun querySkuDetailsAsync(params: SkuDetailsParams, listener: SkuDetailsResponseListener) {
        billingClient.querySkuDetailsAsync(params, listener)
    }

    override fun consumeAsync(purchaseToken: String, listener: ConsumeResponseListener) {
        billingClient.consumeAsync(purchaseToken, listener)
    }

    override fun queryPurchaseHistoryAsync(skuType: String, listener: PurchaseHistoryResponseListener) {
        billingClient.queryPurchaseHistoryAsync(skuType, listener)
    }

    companion object {

        /**
         * Constructs a new [BillingClient.Builder] instance.
         *
         * @param context It will be used to get an application context to bind to the in-app billing
         * service.
         */
        @UiThread
        @JvmStatic
        fun newBuilder(context: Context): GoogleServiceProvider.Builder {
            return GoogleServiceProvider.Builder(context)
        }
    }
}
