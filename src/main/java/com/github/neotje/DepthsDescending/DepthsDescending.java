package com.github.neotje.DepthsDescending;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.neotje.DepthsDescending.Scenes.EndScene;
import com.github.neotje.DepthsDescending.Scenes.RoomScene;
import com.github.neotje.DepthsDescending.Scenes.TitleScene;
import com.github.neotje.DepthsDescending.Entities.Player;

public class DepthsDescending extends YaegerGame {
    public Player player1 = new Player(10,10, 5, new Coordinate2D(316, 349), this);
    public CustomFont ringbearerTitle = new CustomFont("fonts/FONT.TTF", 60);
    public CustomFont ringbearerParagraph = new CustomFont("fonts/FONT.TTF", 20);
    public CustomFont ringbearerStats = new CustomFont("fonts/FONT.TTF", 15);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Descending Depths");
        setSize(new Size(690, 517));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new RoomScene("background/room.png", this, 0));
        addScene(2, new RoomScene("background/room.png", this, 1));
        addScene(3, new RoomScene("background/room.png", this, 2));
        addScene(4, new RoomScene("background/room.png", this, 3));
        addScene(5, new RoomScene("background/room.png", this, 4));
        addScene(6, new RoomScene("background/room.png", this, 5));
        addScene(7, new RoomScene("background/room.png", this, 6));
        addScene(8, new RoomScene("background/room.png", this, 7));
        addScene(9, new RoomScene("background/room9.png", this, 8));
        addScene(10, new RoomScene("background/room10.png", this, 9));
        addScene(11, new EndScene(this));
    }
}