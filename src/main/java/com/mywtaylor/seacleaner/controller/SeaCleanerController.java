package com.mywtaylor.seacleaner.controller;

import com.mywtaylor.seacleaner.model.CoordinatesResponse;
import com.mywtaylor.seacleaner.model.Instructions;
import com.mywtaylor.seacleaner.service.SeaCleanerService;
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
