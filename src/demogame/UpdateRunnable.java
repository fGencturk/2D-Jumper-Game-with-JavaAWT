package demogame;

public class UpdateRunnable implements Runnable {
    private GameManager gm;

    public UpdateRunnable(GameManager gm) {
        this.gm = gm;
    }

    @Override
    public void run() {
        gm.Update();
    }
}
