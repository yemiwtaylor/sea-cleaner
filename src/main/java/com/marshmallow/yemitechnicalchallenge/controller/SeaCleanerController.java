package com.marshmallow.yemitechnicalchallenge.controller;

import com.marshmallow.yemitechnicalchallenge.model.CoordinatesResponse;
import com.marshmallow.yemitechnicalchallenge.model.Instructions;
import com.marshmallow.yemitechnicalchallenge.service.SeaCleanerService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeaCleanerController {

  private final SeaCleanerService seaCleanerService;

  @Autowired
  public SeaCleanerController(SeaCleanerService seaCleanerService) {
    this.seaCleanerService = seaCleanerService;
  }

  @PutMapping(
      value = "instructions",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public CoordinatesResponse calculateCoordinates(@RequestBody @NotNull @Valid Instructions instructions) {
    return seaCleanerService.processCleaning(instructions);
  }
}
