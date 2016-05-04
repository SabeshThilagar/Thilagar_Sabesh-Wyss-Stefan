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

    private final MainView mView;
    private final MainModel mModel;

    public MainPresenter(ViewUI viewUI) {
        this.mView = viewUI;
        mModel =  new FileBackend();
        this.mView.setFilm(mModel.getData());
    }

}
