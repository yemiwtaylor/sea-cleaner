package com.marshmallow.yemitechnicalchallenge.service;

import com.marshmallow.yemitechnicalchallenge.SeaCleanerException;
import com.marshmallow.yemitechnicalchallenge.model.CoordinatesResponse;
import com.marshmallow.yemitechnicalchallenge.model.Instructions;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SeaCleanerService {

  public CoordinatesResponse processCleaning(Instructions instructions) {
    String[] instructionsArray = instructions.getNavigationInstructions().split("");
    Integer[] currentCleanerPosition = instructions.getStartingPosition().toArray(new Integer[2]);
    Integer[] areaSize = instructions.getAreaSize().toArray(new Integer[2]);

    // LinkedList to allow for remove operations
    List<List<Integer>> oilPatches = new LinkedList<>(instructions.getOilPatches());

    int cleanedPatches = 0;

    for (String instruction : instructionsArray) {
      switch (instruction) {
        case "N":
          currentCleanerPosition[1] += 1;
          break;
        case "E":
          currentCleanerPosition[0] += 1;
          break;
        case "S":
          currentCleanerPosition[1] -= 1;
          break;
        case "W":
          currentCleanerPosition[0] -= 1;
          break;
        default:
          throw new SeaCleanerException.BadRequestError("unrecognised direction, must be N, E, S, W");
      }

      if (currentCleanerPosition[0] > areaSize[0]-1 || currentCleanerPosition[1] > areaSize[1]-1) {
        throw new SeaCleanerException.BadRequestError("invalid instructions: cleaner out of bounds");
      }

      // remove patch once cleaned
      if (oilPatches.contains(Arrays.asList(currentCleanerPosition))) {
        cleanedPatches++;
        oilPatches.remove(Arrays.asList(currentCleanerPosition));
      }
    }

    return new CoordinatesResponse(
        Arrays.asList(currentCleanerPosition),
        cleanedPatches
    );
  }
}
