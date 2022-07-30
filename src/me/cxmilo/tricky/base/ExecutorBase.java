package me.cxmilo.tricky.base;

public class ExecutorBase {

    /**
     * Initialize all the game components.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Base base = new TrickyBase();
        Runtime.getRuntime().addShutdownHook(new Thread(base::shutdown));
        base.init();
    }
}
