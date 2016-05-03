/*
$FHNW
 */
package Presenter;
import View.*;


/**
 *
 * @author Stefan
 */
public class MainPresenter {

    private final ApplicationView applicationView;
//    private final ApplicationModel applicationModel;

    /**
     * creates a new PresentationModel
     *
     * @param applicationView the ApplicationView
     */
    public MainPresenter(ApplicationView applicationView) {
        this.applicationView = applicationView;

//        applicationModel = new FileBackendModel();
//        this.applicationView.setResults(applicationModel.getData());
    }

    public MainPresenter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
