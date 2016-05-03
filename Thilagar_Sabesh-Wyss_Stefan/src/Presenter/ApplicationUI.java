package Presenter;
import Model.Result;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/*
$FHNW
 */
/**
 *
 * @author Stefan
 */
public class ApplicationUI
        extends VBox
        implements ApplicationView {

    private final MainPresenter presenter;
    private TableView<Result> tableView;
    private Label label;

    /**
     * creates a new ApplicationUI
     */
    public ApplicationUI() {
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangeListeners();
        addBindings();

        presenter = new MainPresenter(this);
    }

    public void setResults(List<Result> results) {
        ObservableList<Result> observableList
                = FXCollections.observableArrayList();
        observableList.addAll(results);
        tableView.setItems(observableList);

        TableColumn<Result, String> nameColumn = new TableColumn<>("Gemeinde");
        tableView.getColumns().add(nameColumn);
        // TODO: nameColumn.setCellValueFactory(...)
        
        // TODO: define all other columns and their cell value factories
        
        // TODO: set label text (number of communities)
    }

    private void initializeControls() {
        tableView = new TableView<>();
        label = new Label();
    }

    private void layoutControls() {
        getChildren().add(tableView);
        VBox.setVgrow(tableView, Priority.ALWAYS);
        getChildren().add(label);
    }

    private void addEventHandlers() {
    }

    private void addValueChangeListeners() {
    }

    private void addBindings() {
    }
}

