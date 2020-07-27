package com.marshmallow.mywtaylortechnicalchallenge.model;

import java.util.List;

public class CoordinatesResponse {

  private final List<Integer> finalPosition;
  private final int oilPatchesCleaned;

  public CoordinatesResponse(
      List<Integer> finalPosition,
      int oilPatchesCleaned
  ) {
    this.finalPosition = finalPosition;
    this.oilPatchesCleaned = oilPatchesCleaned;
  }

  public List<Integer> getFinalPosition() {
    return finalPosition;
  }

  public int getOilPatchesCleaned() {
    return oilPatchesCleaned;
  }
}
