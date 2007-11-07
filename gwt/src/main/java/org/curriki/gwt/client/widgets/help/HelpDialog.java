package org.curriki.gwt.client.widgets.help;

import asquare.gwt.tk.client.ui.ModalDialog;
import asquare.gwt.tk.client.ui.BasicPanel;
import asquare.gwt.tk.client.util.DomUtil;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.Window;
import org.curriki.gwt.client.widgets.modaldialogbox.ChoiceDialog;
import org.curriki.gwt.client.widgets.modaldialogbox.SizeDialogController;
import org.curriki.gwt.client.Main;

public class HelpDialog extends ModalDialog {
    String titleText;
    String url;
    String cssDialogName;
    Frame frame;

    public HelpDialog(String titleText, String url, String cssDialogName) {
        this();
        this.titleText = titleText;
        this.url = url;
        this.cssDialogName = cssDialogName;
        init();
    }

    public HelpDialog()
    {
        addController(new SizeDialogController(frame));
    }

    public String getCSSName(String name) {
        if ((name==null)||name.equals(""))
            return "dialog-" + cssDialogName;
        else
            return "dialog-" + cssDialogName + "-" + name;
    }

    public void resizeWindow() {
    }

    public void init(){
        addStyleName(getCSSName(null));
        FlowPanel caption = new FlowPanel();
        caption.setWidth("100%");
        caption.setStyleName(getCSSName("caption"));
        HTML captionText = new HTML(titleText);
        caption.add(captionText);
        captionText.setStyleName(getCSSName("caption-text"));

        final HelpDialog dialog = this;
        ClickListener closeDialog = new ClickListener(){
            public void onClick(Widget sender){
                if ((dialog != null) && dialog.isVisible()){
                    dialog.hide();
                }
            }
        };
        Button closeButton = new Button(Main.getTranslation("close"));
        closeButton.addStyleName(getCSSName("caption-button"));
        closeButton.addClickListener(closeDialog);
        caption.add(closeButton);

        ClickListener openDialog = new ClickListener(){
            public void onClick(Widget sender){
                String url = frame.getUrl();
                Window.open(url, "currikihelp", "");
                  if ((dialog != null) && dialog.isVisible()){
                    dialog.hide();
                }
            }
        };
        Button openButton = new Button(Main.getTranslation("openinnewwindow"));
        openButton.addStyleName(getCSSName("caption-button"));
        openButton.addClickListener(openDialog);
        caption.add(openButton);
        setCaption(caption);

        int absoluteTop = getAbsoluteTop();
        int width = Window.getClientWidth() * 90 / 100;
        int height = (Window.getClientHeight() - absoluteTop) * 85 / 100;
        // resize to be 80%
        setWidth((width) + "px");
        setHeight((height) + "px");

        BasicPanel main = new BasicPanel();
        main.setWidth((width) + "px");
        main.setHeight((height - 20) + "px");
        main.addStyleName(getCSSName("content"));

        frame = new Frame(url);
        frame.setStyleName(getCSSName("frame"));
        frame.setWidth((width - 10) + "px");
        frame.setHeight((height - 20) + "px");
        main.add(frame);
        add(main);
        show();
    }
}
