/**
 * Vehicle - a vehicle
 * 
 * Author: David Ogor
 * Date 05-30-2015
 * Purpose: practice inheritance
 */ 
package ch2;

public class Vehicle {

  private enum Color {BLUE, GREEN, RED};
  private Color color;

  public void setColor(int choice) {
    color = Color.BLUE;
  }

  public String getColor() {
    String val = "";
    if (color == Color.BLUE) {
      val = "Blue";
    }
    return val;
  }
}