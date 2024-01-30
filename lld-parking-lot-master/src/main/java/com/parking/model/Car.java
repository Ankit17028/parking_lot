package com.parking.model;

/**
 * Model object to represent a car.
 */
public class Car {
  private String registrationNumber;
  private String color;

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public String getColor() {
    return color;
  }

  public Car(final String registrationNumber, final String color) {
    this.registrationNumber = registrationNumber;
    this.color = color;
  }
}
