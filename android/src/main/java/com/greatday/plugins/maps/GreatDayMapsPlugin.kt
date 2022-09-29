package com.greatday.plugins.maps

import android.content.Intent
import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin
import com.senjuid.location.LocationPlugin
import com.senjuid.location.LocationPlugin.LocationPluginListener
import com.senjuid.location.LocationPluginOptions
import com.senjuid.location.util.LocaleHelper
import org.json.JSONException
import org.json.JSONObject


@CapacitorPlugin(name = "Maps")
class GreatDayMapsPlugin : Plugin() {

    private var locationPlugin: LocationPlugin? = null

    @PluginMethod
    fun getLocation(call: PluginCall) {
        this.getLocation(call, null)
    }

    @PluginMethod
    fun getLocationRadius(call: PluginCall) {
        val workLocation = call.getString("workLocationData")
        this.getLocation(call, workLocation)
    }

    @PluginMethod
    fun getLocationLabelLanguage(call: PluginCall) {
        val label1 = call.getString("label1")
        val label2 = call.getString("label2")
        val language = call.getString("language")
        this.getLocationWithLanguage(call, null, label1, label2, language)
    }

    @PluginMethod
    fun getLocationLabelRadiusLanguage(call: PluginCall) {
        val label1 = call.getString("label1")
        val label2 = call.getString("label2")
        val language = call.getString("language")
        val location = call.getString("location")
        this.getLocationWithLanguage(call, location, label1, label2, language)
    }

    @Throws(JSONException::class)
    private fun getLocation(call: PluginCall, location: String?) {
        val locationPluginListener: LocationPluginListener =
            object : LocationPluginListener {
                override fun onLocationRetrieved(lon: Double, lat: Double, isMock: Boolean?) {
                    val jsonLocation = JSONObject()
                    try {
                        val address: String = locationPlugin!!.getCompleteAddress(lon, lat)
                        jsonLocation.put("latitude", lat.toString())
                        jsonLocation.put("longitude", lon.toString())
                        jsonLocation.put("address", address)
                        jsonLocation.put("mock", isMock)
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    val ret = JSObject()
                    ret.put("result", jsonLocation.toString())
                    call.resolve(ret)
                }

                override fun onCanceled() {
                    val ret = JSObject()
                    ret.put("result", "error location")
                    call.resolve(ret)
                }
            }
        locationPlugin = LocationPlugin(activity)
        locationPlugin?.setLocationPluginListener(locationPluginListener)
        val options: LocationPluginOptions = LocationPluginOptions.Builder()
            .setData(location)
            .build()
        val intent: Intent = locationPlugin!!.getIntent(options)
        startActivityForResult(call, intent, LocationPlugin.REQUEST)
    }

    @Throws(JSONException::class)
    private fun getLocationWithLanguage(
        call: PluginCall,
        location: String?,
        message1: String?,
        message2: String?,
        language: String?
    ) {
        if (language != null) {
            LocaleHelper.setLocale(context, language)
        }
        val locationPluginListener: LocationPluginListener = object : LocationPluginListener {
            override fun onLocationRetrieved(lon: Double, lat: Double, isMock: Boolean) {
                val jsonLocation = JSONObject()
                try {
                    val address = locationPlugin!!.getCompleteAddress(lon, lat)
                    jsonLocation.put("latitude", lat.toString())
                    jsonLocation.put("longitude", lon.toString())
                    jsonLocation.put("address", address)
                    jsonLocation.put("mock", isMock)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
                val ret = JSObject()
                ret.put("result", jsonLocation.toString())
                call.resolve(ret)
            }

            override fun onCanceled() {
                val ret = JSObject()
                ret.put("result", "error location")
                call.resolve(ret)
            }
        }
        locationPlugin = LocationPlugin(activity)
        locationPlugin!!.setLocationPluginListener(locationPluginListener)
        val options = LocationPluginOptions.Builder()
            .setData(location)
            .setMessage(message1, message2)
            .build()
        val intent = locationPlugin!!.getIntent(options)
        startActivityForResult(call, intent, LocationPlugin.REQUEST)
    }
}