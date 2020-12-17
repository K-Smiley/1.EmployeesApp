package app;

import controllers.Controller;

/**
 *
 * @author mga
 */
public class CustomersApp {

    private static void run() {
        final Controller controller = new Controller();
        controller.run();
    }

    /**
     *
     * @param args
     */
    public static void main(final String[] args) {
        CustomersApp.run();
    }
}
