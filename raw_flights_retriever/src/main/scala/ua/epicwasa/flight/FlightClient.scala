package com.epicwasa
package ua.epicwasa.flight

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.apache.hc.client5.http.classic.HttpClient
import org.apache.hc.client5.http.classic.methods.HttpGet
import org.apache.hc.client5.http.impl.classic.{BasicHttpClientResponseHandler, HttpClients}

object FlightClient {
  private val appId = "d19a6eab"
  private val appKey = "0960580f382d2faf48530e205f3e1b7c"
  private val resourceVersion = "v4"
  private val requestUrl = "https://api.schiphol.nl/public-flights/flights"

  private val flightsType = new TypeToken[Array[FlightObject]](){}.getType
  private val gson = new Gson()

  private val httpClient: HttpClient = HttpClients.createDefault()

  def getFlights: List[FlightObject] = {
    val request: HttpGet = new HttpGet(requestUrl)
    request.addHeader("ResourceVersion", resourceVersion)
        request.addHeader("app_id", appId)
        request.addHeader("app_key", appKey)
        request.addHeader("Accept", "application/json")

    val response: String = httpClient.execute(request, new BasicHttpClientResponseHandler())
    val json = response.replaceFirst("\"flights\":", "")
      .replaceFirst("\\{", "").dropRight(1)

    val flights: Array[FlightObject] = gson.fromJson(json, flightsType)

//    val jsonObject = new JSONObject(response)
//
//    val array = jsonObject.get("flights").asInstanceOf[JSONArray]
//
//    array.toList.map(_.toString).toList

    flights.toList
  }
}
