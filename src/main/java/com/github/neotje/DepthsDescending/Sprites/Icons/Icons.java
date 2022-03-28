package com.github.neotje.DepthsDescending.Sprites.Icons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Icons extends DynamicSpriteEntity {
    public Icons(String icon,Coordinate2D location) {
        super(icon,location, new Size(20, 20));
    }
}
