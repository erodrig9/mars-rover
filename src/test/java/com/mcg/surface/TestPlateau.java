package com.mcg.surface;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestPlateau {
    @Test
    public void testSize() {
        final int expectedWidth = 5;
        final int expectedHeight = 5;

        RectangularSurface surface = new Plateau(5, 5);

        assertEquals(expectedWidth, surface.width);
        assertEquals(expectedHeight, surface.height);
    }

    @Test
    public void testPointOnSurface() {
        RectangularSurface surface = new Plateau(5, 5);
        assertTrue(surface.isPointOnSurface(1, 2));
    }

    @Test
    public void testPointNotOnSurface() {
        RectangularSurface surface = new Plateau(5, 5);
        assertFalse(surface.isPointOnSurface(6, 6));
    }
}
