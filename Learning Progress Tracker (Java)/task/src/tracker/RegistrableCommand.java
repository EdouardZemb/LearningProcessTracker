package tracker;

public interface RegistrableCommand {
    void register(CommandRegistry commandRegistry);
}
