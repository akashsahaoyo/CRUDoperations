/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.akash.demo.thrift;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum Booktype implements org.apache.thrift.TEnum {
  FICTION(0),
  DRAMA(1),
  COMIC(2);

  private final int value;

  private Booktype(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static Booktype findByValue(int value) { 
    switch (value) {
      case 0:
        return FICTION;
      case 1:
        return DRAMA;
      case 2:
        return COMIC;
      default:
        return null;
    }
  }
}
