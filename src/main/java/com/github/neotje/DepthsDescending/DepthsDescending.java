package com.github.neotje.DepthsDescending;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.neotje.DepthsDescending.Scenes.GameScene;
import com.github.neotje.DepthsDescending.Scenes.TitleScene;

public class DepthsDescending extends YaegerGame {

    public static void main(String[] args) {
        launch(args); }

    @Override
    public void setupGame() {
        setGameTitle("Descending Depths");
        setSize(new Size(690, 517));

    }

    @Override
    public void setupScenes() {
    addScene(0, new TitleScene(this));
    addScene(1, new GameScene());

    }


}
