
package View;

import Model.Film;
import Presenter.MainPresenter;
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
public class ViewUI extends VBox implements MainView {


    private final MainPresenter presenter;

    private TableView<Film> tableView;
    private Label label;

    /**
     * creates a new ApplicationUI
     */
    public ViewUI() {
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangeListeners();
        addBindings();

        presenter = new MainPresenter(this);
    }

    @Override
    public void setFilm(List<Film> films) {
        ObservableList<Film> observableList
                = FXCollections.observableArrayList();
        observableList.addAll(films);

        tableView.setItems(observableList);


        TableColumn<Film, String> nameColumn = new TableColumn<>("Filme");

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

