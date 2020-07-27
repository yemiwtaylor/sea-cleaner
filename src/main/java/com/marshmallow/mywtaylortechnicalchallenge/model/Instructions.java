package com.marshmallow.mywtaylortechnicalchallenge.model;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Instructions {

  @NotEmpty
  @Size(min=2, max=2)
  private final List<Integer> areaSize;
  @NotEmpty
  @Size(min=2, max=2)
  private final List<Integer> startingPosition;
  @NotEmpty
  @Valid
  private final List<@NotEmpty @Size(min=2, max=2) List<Integer>> oilPatches;
  @NotBlank
  private final String navigationInstructions;

  public Instructions(
      @NotEmpty @Size(min = 2, max = 2) List<Integer> areaSize,
      @NotEmpty @Size(min = 2, max = 2) List<Integer> startingPosition,
      @NotEmpty @Valid List<@NotEmpty @Size(min = 2, max = 2) List<Integer>> oilPatches,
      @NotBlank String navigationInstructions
  ) {
    this.areaSize = areaSize;
    this.startingPosition = startingPosition;
    this.oilPatches = oilPatches;
    this.navigationInstructions = navigationInstructions;
  }

  public List<Integer> getAreaSize() {
    return areaSize;
  }

  public List<Integer> getStartingPosition() {
    return startingPosition;
  }

  public List<List<Integer>> getOilPatches() {
    return oilPatches;
  }

  public String getNavigationInstructions() {
    return navigationInstructions;
  }
}
