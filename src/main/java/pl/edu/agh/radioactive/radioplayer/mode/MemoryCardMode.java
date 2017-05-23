package pl.edu.agh.radioactive.radioplayer.mode;

import pl.edu.agh.radioactive.radioplayer.PlayerMode;
import pl.edu.agh.radioactive.radioplayer.PlayerState;
import pl.edu.agh.radioactive.radioplayer.mode.modetype.ModeType;
import pl.edu.agh.radioactive.radioplayer.state.MemoryCard;

public class MemoryCardMode extends PlayerMode {

    public MemoryCardMode() {
        super(ModeType.MEMORY_CARD);
    }

    private void withStateValidation(PlayerState state, Runnable action) {
        if (!state.isPowerOn()) {
            System.out.println("[ERROR] cannot play - radio player turned off.");
        } else if (!state.getMemoryCard().isPresent()) {
            System.out.println("[ERROR] cannot play - please insert a memory card.");
        } else {
            action.run();
        }
    }

    @Override
    public void play(PlayerState state) {
        withStateValidation(state, () -> playASong(state.getMemoryCard().get()));
    }

    private void playASong(MemoryCard memoryCard) {
        System.out.println("[INFO] playing " + memoryCard.getCurrentSong());
    }

}
