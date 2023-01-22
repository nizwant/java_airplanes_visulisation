package gui.dynamic;

import constants.Constants;
import gui.App;

public class DynamicPlacement implements Runnable {
    App _appRef;

    public DynamicPlacement(App pApp) {
        _appRef = pApp;
    }

    @Override
    public void run() {
        while (true) {
            _appRef.LoadPlanes();
            _appRef.Refresh();

//            System.out.println("working");
//            var content = _appRef.getContentPane();
//            for (var comp : content.getComponents()) {
//                System.out.println(comp);
//            }

            try {
                Thread.sleep(Constants.REFRESH_DELAY_IN_SECONDS * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}