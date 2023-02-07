package commands;

import collectionManagement.CollectionManager;
import io.fileIO.out.HumanBeingXMLWriter;

/**
 * The SaveCollectionToFileCommand class extends the Command class.
 * This class is used to save the collection managed by CollectionManager to an XML file.
 */
public class SaveCollectionToFileCommand extends Command {

    /**
     * The default file path to save the collection.
     */
    public String filePath = "humanBeing.xml";

    /**
     * Constructs a SaveCollectionToFileCommand object with a CollectionManager object, using the default file path.
     *
     * @param collectionManager The CollectionManager object that the command operates on.
     */
    public SaveCollectionToFileCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    /**
     * Constructs a SaveCollectionToFileCommand object with a CollectionManager object and a file path.
     *
     * @param collectionManager The CollectionManager object that the command operates on
     * @param filePath The file path to save the collection to.
     */
    public SaveCollectionToFileCommand(CollectionManager collectionManager, String filePath) {
        super(collectionManager);
        this.filePath = filePath;
    }

    /**
     * Executes the SaveCollectionToFileCommand. This method uses the HumanBeingXMLWriter class to write the collection to an XML file.
     */
    @Override
    public void execute() {
        HumanBeingXMLWriter humanBeingXMLWriter = new HumanBeingXMLWriter();
        humanBeingXMLWriter.writeData(getCollectionManager().getCollection(), filePath);
    }
}
