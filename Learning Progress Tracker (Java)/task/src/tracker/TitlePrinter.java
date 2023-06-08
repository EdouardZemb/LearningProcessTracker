package tracker;

public class TitlePrinter {
    private final OutputProvider outputProvider;

    public TitlePrinter(OutputProvider outputProvider) {
        this.outputProvider = outputProvider;
    }

    public void printTitle() {
        outputProvider.print("Learning Progress Tracker");
    }
}