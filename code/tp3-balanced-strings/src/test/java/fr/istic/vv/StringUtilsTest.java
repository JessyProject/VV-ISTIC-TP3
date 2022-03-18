package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void checkIfIsBalancedReturnTrueWhereStringIsEmpty() {
        assertTrue(stringUtils.isBalanced(""));
    }

    @Test
    void checkIfIsBalancedReturnTrueWhereStringIsBalanced() {
        assertTrue(stringUtils.isBalanced("()[]{}"));
        assertTrue(stringUtils.isBalanced("({[]{}})"));
        assertTrue(stringUtils.isBalanced("({[aa]{bb}d})"));
    }

    @Test
    void checkIfIsBalancedReturnFalseWhereStringIsNotBalanced() {
        assertFalse(stringUtils.isBalanced(")()[]{}"));
        assertFalse(stringUtils.isBalanced("()[]{(})"));
    }
}