package businessLogic;

public class LocalBLFacadeFactory implements BLFacadeFactory {

    public BLFacade createBLFacade() {
        return new BLFacadeImplementation();
    }
}
