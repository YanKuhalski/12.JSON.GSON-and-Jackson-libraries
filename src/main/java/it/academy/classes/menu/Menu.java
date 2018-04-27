package it.academy.classes.menu;

import it.academy.classes.operations.EndOfWork;
import it.academy.classes.operations.gettingInfo.GetAllInfo;
import it.academy.classes.operations.registration.Registration;
import it.academy.interfaces.Operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<Integer, Operation> operations = new HashMap<Integer, Operation>();

    {
        operations.put(1, new Registration(this));
        operations.put(2, new GetAllInfo(this));
        operations.put(3, new EndOfWork());
    }

    public void choice() {
        for (Map.Entry<Integer, Operation> entry : operations.entrySet()) {
            System.out.println("" + entry.getKey() + " to " + entry.getValue().name());
        }
        Scanner scanner = new Scanner(System.in);
        operations.get(scanner.nextInt()).run();
        scanner.nextLine();
    }
}
