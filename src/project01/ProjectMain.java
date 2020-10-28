package project01;


public class ProjectMain {

    private static String fileName;

    public static void main(String[] args) {
        ProjectMain execution = new ProjectMain();
        try {
            execution.start();
            // execution.print();
        } catch (Exception exceptionValue) {
            System.out.println("Something bad happened.");
        }
    }

    private void start() {
        System.out.println("Starting the program...");
        ControlClass control = new ControlClass();

        fileName = control.getFileName();

        control.classManager();

    }

    private void print() {
        System.out.println(fileName);
    }

    public static String get() {
        return fileName;
    }
}
