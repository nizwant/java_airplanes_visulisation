package gui.dynamic;

import constants.Constants;

public class tmpName implements Runnable {
    @Override
    public void run() {
        this.DoSth();

        try {
            Thread.sleep(Constants.REFRESH_DELAY_IN_SECONDS * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void DoSth() {

    }
}