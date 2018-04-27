package it.academy.classes.operations.gettingInfo;

import it.academy.classes.menu.Menu;
import it.academy.interfaces.Operation;

public class GetAllInfo implements Operation {
    private Menu menu;

    public GetAllInfo(Menu menu) {
        this.menu = menu;
    }

    public String name() {
        return "Show all information about hospital.";
    }

    @Override
    public void run() {
        BaseWorker worker = new BaseWorker("OfflineBase.json", "https://raw.githubusercontent.com/YanKuhalski/Different/master/OnlinePatientBase.json");
        worker.showAllInfo();
        menu.choice();
    }
}
