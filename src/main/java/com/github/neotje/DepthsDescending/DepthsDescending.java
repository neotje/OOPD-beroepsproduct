package com.github.neotje.DepthsDescending;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.neotje.DepthsDescending.Rooms.Room;
import com.github.neotje.DepthsDescending.Scenes.EndScene;
import com.github.neotje.DepthsDescending.Scenes.GameScene;
import com.github.neotje.DepthsDescending.Scenes.TitleScene;
import com.github.neotje.DepthsDescending.Entities.Player;

public class DepthsDescending extends YaegerGame {
    public Player player1 = new Player(10,10, 5, new Coordinate2D(316, 349), this);
    public CustomFont ringbearerTitle = new CustomFont("fonts/FONT.TTF", 60);
    public CustomFont ringbearerParagraph = new CustomFont("fonts/FONT.TTF", 20);
    public CustomFont ringbearerStats = new CustomFont("fonts/FONT.TTF", 15);

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
        addScene(1, new Room("background/room.png", this));
        addScene(2, new Room("background/room.png", this));
        addScene(3, new Room("background/room.png", this));
        addScene(4, new Room("background/room.png", this));
        addScene(5, new Room("background/room.png", this));
        addScene(6, new Room("background/room.png", this));
        addScene(7, new Room("background/room.png", this));
        addScene(8, new Room("background/room.png", this));
        addScene(9, new Room("background/room9.png", this));
        addScene(10, new Room("background/room10.png", this));
        addScene(11, new EndScene(this));
    }
}