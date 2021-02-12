package com.mcg.surface;

public abstract class RectangularSurface implements Surface {
    protected int width;
    protected int height;

    public RectangularSurface(int width, int height) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean isPointOnSurface(int x, int y) {
        if (x < 0 || x > this.width) {
            return false;
        }

        if (y < 0 || y > this.height) {
            return false;
        }

        return true;
    }
}
