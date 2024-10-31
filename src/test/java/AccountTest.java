import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import org.group15.player.Account;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class AccountTest {
    private Account account;
    private final int minValue = 0;
    private final int maxValue = 3000;


    @DisplayName("Ensure getAmount returns the amount, and that the amount is bounded")
    @ParameterizedTest
    @ValueSource(ints={-1000, 0, 1000, 2000, 3000, 4000})
    void getAmount_ShouldReturn_TheSetAmount(int initPoints) {
        // Arrange
        account = new Account(initPoints);
        int expectedAmount = Math.clamp(initPoints, minValue, maxValue);

        // Act
        int amount = account.getAmount();

        // Assert
        assertEquals(expectedAmount, amount);
    }

    @DisplayName("Ensure the points are bounded and addAmount returns true when valid")
    @ParameterizedTest
    @CsvSource({"1000,0","3000,0", "2000,100", "2850,150", "2999,200"})
    void addAmount_ShouldReturnTrue_WhenSuccess(int initPoints, int points) {
        // Arrange
        account = new Account(initPoints);
        int expectedPoints = Math.clamp(initPoints+points, minValue, maxValue);

        // Act
        boolean result = account.addAmount(points);
        int amount = account.getAmount();

        // Assert
        assertTrue(result);
        assertEquals(expectedPoints, amount);
    }

    @DisplayName("Ensure addAmount fails if the amount is at maximum, and points is above zero")
    @ParameterizedTest
    @CsvSource({"3000,1", "3000,10", "3000,100"})
    void addAmount_ShouldReturnFalse_WhenAmountIsAtMaximum(int initPoints, int points) {
        // Arrange
        account = new Account(initPoints);

        // Act
        boolean result = account.addAmount(points);
        int amount = account.getAmount();

        // Assert
        assertFalse(result, "The result should be false, if addAmount is used incorrectly");
        assertEquals(initPoints, amount);
    }

    @DisplayName("Ensure addAmount fails if the points are negative")
    @ParameterizedTest
    @CsvSource({"0,-10","1000,-1","3000,-1"})
    void addAmount_ShouldReturnFalse_WhenPointsIsNegative(int initPoints, int points) {
        // Arrange
        account = new Account(initPoints);
        int expectedAmount = Math.clamp(initPoints, minValue, maxValue);

        // Act
        boolean result = account.addAmount(points);
        int amount = account.getAmount();

        // Assert
        assertFalse(result, "The result should be false, if addAmount is used incorrectly");
        assertEquals(expectedAmount, amount);
    }

    @DisplayName("Ensure the points are bounded and removeAmount returns true when valid")
    @ParameterizedTest
    @CsvSource({"0,0", "1000,0", "1000,1500", "2000,100", "2850,150", "3000,0", "3000,200"})
    void removeAmount_ShouldReturnTrue_WhenSuccess(int initPoints, int value) {
        // Arrange
        account = new Account(initPoints);
        int expectedPoints = Math.clamp(initPoints-value, minValue, maxValue);

        // Act
        boolean result = account.removeAmount(value);
        int amount = account.getAmount();

        // Assert
        assertTrue(result);
        assertEquals(expectedPoints, amount);
    }

    @DisplayName("Ensure removeAmount fails if the amount is zero, and the points is above zero")
    @ParameterizedTest
    @ValueSource(ints={1, 10, 100, 1000, 10000})
    void removeAmount_ShouldReturnFalse_WhenAmountIsZero(int value) {
        // Arrange
        account = new Account(0);
        int expectedAmount = 0;

        // Act
        boolean result = account.removeAmount(value);
        int amount = account.getAmount();

        // Assert
        assertFalse(result);
        assertEquals(expectedAmount, amount);
    }

    @DisplayName("Ensure removeAmount fails if the points are negative")
    @ParameterizedTest
    @CsvSource({"0,-1","1000,-1", "1000,-10"})
    void removeAmount_ShouldReturnFalse_WhenPointsIsNegative(int initPoints, int value) {
        // Arrange
        account = new Account(initPoints);
        int expectedAmount = Math.clamp(initPoints, minValue, maxValue);

        // Act
        boolean result = account.removeAmount(value);
        int amount = account.getAmount();

        // Assert
        assertFalse(result);
        assertEquals(expectedAmount, amount);
    }
}