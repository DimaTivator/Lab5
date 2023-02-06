package commands;

import collectionManagement.CollectionManager;
import io.fileIO.out.HumanBeingXMLWriter;

public class SaveCollectionToFileCommand extends Command {

    public String filePath = "humanBeing.xml";

    public SaveCollectionToFileCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public SaveCollectionToFileCommand(CollectionManager collectionManager, String filePath) {
        super(collectionManager);
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        HumanBeingXMLWriter humanBeingXMLWriter = new HumanBeingXMLWriter();
        humanBeingXMLWriter.writeData(getCollectionManager().getCollection(), filePath);
    }
}
