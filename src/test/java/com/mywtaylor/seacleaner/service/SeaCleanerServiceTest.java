package com.mywtaylor.seacleaner.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.mywtaylor.seacleaner.model.CoordinatesResponse;
import com.mywtaylor.seacleaner.model.Instructions;
import com.mywtaylor.seacleaner.SeaCleanerException.BadRequestError;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeaCleanerServiceTest {

  private SeaCleanerService underTest;

  @BeforeEach
  void setUp() {
    underTest = new SeaCleanerService();
  }

  @Test
  void unrecognisedDirectionThrowsException() {
    Instructions instructions = new Instructions(
        List.of(5, 5),
        List.of(1, 1),
        List.of(
            List.of(2, 2)
        ),
        "D"
    );

    assertThatThrownBy(() -> underTest.processCleaning(instructions))
        .withFailMessage("unrecognised direction, must be N, E, S, W")
        .isInstanceOf(BadRequestError.class);
  }

  @Test
  void outOfBoundsInstructionsThrowsException() {
    Instructions instructions = new Instructions(
        List.of(5, 1),
        List.of(0, 0),
        List.of(
            List.of(2, 0)
        ),
        "EEEEEEE"
    );

    assertThatThrownBy(() -> underTest.processCleaning(instructions))
        .withFailMessage("instructions lead cleaner out of bounds")
        .isInstanceOf(BadRequestError.class);
  }

  @Test
  void seaCleanerRepeatedJourneyHappyCase() {
    Instructions instructions = new Instructions(
        List.of(11, 11),
        List.of(4, 0),
        List.of(
            List.of(5, 0),
            List.of(6, 0),
            List.of(7, 0),
            List.of(8, 0),
            List.of(9, 0),
            List.of(9, 1),
            List.of(9, 2),
            List.of(9, 3),
            List.of(9, 4),
            List.of(9, 5),
            List.of(9, 6)

        ),
        "EEEEENNNNNNWWWWWSSSSSSEEEEENNNNNNWWWWWSSSSSSEEEEENNNNNNWWWWWSSSSSS"
    );

    assertThat(underTest.processCleaning(instructions))
        .usingRecursiveComparison()
        .isEqualTo(
            new CoordinatesResponse(
                List.of(4, 0),
                11
            )
        );
  }
}