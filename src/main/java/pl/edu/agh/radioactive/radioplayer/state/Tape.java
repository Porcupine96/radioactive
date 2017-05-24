package pl.edu.agh.radioactive.radioplayer.state;

import pl.edu.agh.radioactive.radioplayer.state.entity.TapeSide;

public class Tape {

    private String title;
    private TapeSide side;

    public Tape(String title, TapeSide side) {
        this.title = title;
        this.side = side;
    }

    public TapeSide getSide() {
        return side;
    }

    public String getTitle() {
        return title;
    }

    public void changeSide() {
        if (this.side == TapeSide.RIGHT) {
            this.side = TapeSide.LEFT;
        } else {
            this.side = TapeSide.RIGHT;
        }
    }

}
