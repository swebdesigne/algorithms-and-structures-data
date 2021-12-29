package solid.single_responsibility_principle;

public class Logger {
    public void displayLog(String msg) {
        logger(msg);
    }

    private String logger(String msg) {
        return msg;
    }
}
