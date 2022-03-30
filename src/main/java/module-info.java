module OOPD.beroepsproduct {
    requires hanyaeger;

    exports com.github.neotje.DepthsDescending;
    exports com.github.neotje.DepthsDescending.Scenes;

    opens background;
    opens fonts;
    opens textures;
    opens textures.dragon;
    opens sound;
}