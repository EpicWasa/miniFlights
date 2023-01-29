package com.epicwasa
package ua.epicwasa

import ua.epicwasa.kafka.Producer

import com.epicwasa.ua.epicwasa.flight.FlightClient
import com.google.gson.Gson

object Main {

  def main(args: Array[String]): Unit = {

    val gson = new Gson()

    while (true) {
      try {

        val flights = FlightClient.getFlights
        flights.foreach( f=> Producer.write(f.id, gson.toJson(f)))

      } catch {
        case e: Throwable => e.printStackTrace()
      }

      Thread.sleep(500)
    }
  }
}