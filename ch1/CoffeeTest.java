/**
 * CoffeeTest - a coffee cup
 * Author - David Ogor
 * Date - 5/21/2015
 * Purpose - Testing out concepts of an enum with variables and contructors.
 */
package chapter1;

enum CoffeeSize {
  SMALL(6), MEDIUM(8), LARGE(10);
  
  CoffeeSize(int ounces) {
    this.ounce = ounces;
  }
  private int ounce;

  public int getOunces() {
    return this.ounce;
  } 
}

public class CoffeeTest {
  public static void main(String[] args) {
    CoffeeSize cs = CoffeeSize.SMALL;
  
    System.out.printf("Small is %d\n", cs.getOunces());
  }
}