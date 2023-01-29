package com.epicwasa
package ua.epicwasa.flight

import com.google.gson.annotations.SerializedName

import java.time.LocalDate

class FlightObject {

  var id: String = ""
  var serviceType: String = ""
  var airlineCode: Int = 0
  var scheduleDate: String = ""

  @SerializedName("route/destinations")
  var destinations: List[String] = List()

  val flightDirection: String = ""
}
