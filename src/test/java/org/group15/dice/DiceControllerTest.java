package org.group15.dice;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DiceControllerTest {

    @Test
    void retrieveUserRoll_RollTheDice() {
        // Arrange
        DiceView view = mock(DiceView.class);
        DiceModel model = mock(DiceModel.class);
        // Create array of 10 mocked die
        Die[] dice = IntStream.range(0,10)
                .mapToObj(x -> mock(Die.class))
                .toArray(Die[]::new);

        // Make sure the model returns the array
        when(model.getDice()).thenReturn(dice);

        var sut = new DiceController(model, view);

        // Act
        DiceModel roll = sut.retrieveUserRoll();

        // Assert
        // We verify that roll has been called on all dice exactly once
        for(var die: dice){
            verify(die, times(1)).roll();
        }
    }
}