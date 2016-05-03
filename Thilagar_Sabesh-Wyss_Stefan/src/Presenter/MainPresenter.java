/*
$FHNW
 */
package Presenter;

import View.*;
import Model.*;

/**
 *
 * @author Stefan
 */
public class MainPresenter {

    private final MainView applicationView;
    private final MainModel applicationModel;

    /**
     * creates a new PresentationModel
     *
     * @param applicationView the MainView
     */
    public MainPresenter(MainView applicationView) {
        this.applicationView = applicationView;

        applicationModel = new FileBackend();
        this.applicationView.setResults(applicationModel.getData());
    }

    public MainPresenter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
