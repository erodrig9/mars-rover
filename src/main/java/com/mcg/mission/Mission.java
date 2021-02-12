package com.mcg.mission;

import java.util.Objects;

import com.mcg.surface.Surface;

public abstract class Mission {
    protected Surface surface;

    public Mission(Surface surface) {
        this.surface = Objects.requireNonNull(surface, "surface must not be null");
    }
}
