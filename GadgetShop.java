import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;

// main GUI class
public class GadgetShop extends Application
{
    // input fields
    private TextField modelField = new TextField();
    private TextField priceField = new TextField();
    private TextField weightField = new TextField();
    private TextField sizeField = new TextField();
    private TextField creditField = new TextField();
    private TextField memoryField = new TextField();
    private TextField phoneNumberField = new TextField();
    private TextField durationField = new TextField();
    private TextField downloadField = new TextField();
    private TextField displayNumberField = new TextField();

    // gadget list
    private ArrayList<Gadget> gadgets = new ArrayList<>();

    @Override
    public void start(Stage stage)
    {
        // main layout
        Pane root = new Pane();

        // title
        Label titleLabel = new Label("Gadget Shop");
        titleLabel.setLayoutX(200);
        titleLabel.setLayoutY(20);

        // model field
        Label modelLabel = new Label("Model");
        modelLabel.setLayoutX(20);
        modelLabel.setLayoutY(60);
        modelField.setLayoutX(20);
        modelField.setLayoutY(85);

        // price field
        Label priceLabel = new Label("Price");
        priceLabel.setLayoutX(150);
        priceLabel.setLayoutY(60);
        priceField.setLayoutX(150);
        priceField.setLayoutY(85);

        // weight field
        Label weightLabel = new Label("Weight");
        weightLabel.setLayoutX(290);
        weightLabel.setLayoutY(60);
        weightField.setLayoutX(290);
        weightField.setLayoutY(85);

        // size field
        Label sizeLabel = new Label("Size");
        sizeLabel.setLayoutX(430);
        sizeLabel.setLayoutY(60);
        sizeField.setLayoutX(430);
        sizeField.setLayoutY(85);

        // credit field
        Label creditLabel = new Label("Credit");
        creditLabel.setLayoutX(20);
        creditLabel.setLayoutY(125);
        creditField.setLayoutX(20);
        creditField.setLayoutY(150);

        // memory field
        Label memoryLabel = new Label("Memory");
        memoryLabel.setLayoutX(150);
        memoryLabel.setLayoutY(125);
        memoryField.setLayoutX(150);
        memoryField.setLayoutY(150);

        // add buttons
        Button addMobileButton = new Button("Add Mobile");
        addMobileButton.setLayoutX(300);
        addMobileButton.setLayoutY(150);

        Button addMP3Button = new Button("Add MP3");
        addMP3Button.setLayoutX(430);
        addMP3Button.setLayoutY(150);

        // clear and display buttons
        Button clearButton = new Button("Clear");
        clearButton.setLayoutX(300);
        clearButton.setLayoutY(190);

        Button displayAllButton = new Button("Display All");
        displayAllButton.setLayoutX(430);
        displayAllButton.setLayoutY(190);

        // phone number field
        Label phoneNumberLabel = new Label("Phone No");
        phoneNumberLabel.setLayoutX(20);
        phoneNumberLabel.setLayoutY(205);
        phoneNumberField.setLayoutX(20);
        phoneNumberField.setLayoutY(230);

        // duration field
        Label durationLabel = new Label("Duration");
        durationLabel.setLayoutX(150);
        durationLabel.setLayoutY(205);
        durationField.setLayoutX(150);
        durationField.setLayoutY(230);

        // download field
        Label downloadLabel = new Label("Download");
        downloadLabel.setLayoutX(360);
        downloadLabel.setLayoutY(245);
        downloadField.setLayoutX(360);
        downloadField.setLayoutY(270);

        // display number field
        Label displayNumberLabel = new Label("Display Number");
        displayNumberLabel.setLayoutX(500);
        displayNumberLabel.setLayoutY(245);
        displayNumberField.setLayoutX(500);
        displayNumberField.setLayoutY(270);

        // action buttons
        Button makeCallButton = new Button("Make A Call");
        makeCallButton.setLayoutX(20);
        makeCallButton.setLayoutY(270);

        Button downloadMusicButton = new Button("Download Music");
        downloadMusicButton.setLayoutX(150);
        downloadMusicButton.setLayoutY(270);

        // add mobile
        addMobileButton.setOnAction(e ->
        {
            try
            {
                Mobile mobile = new Mobile(getModel(), getPrice(), getWeight(), getSize(), getCredit());
                gadgets.add(mobile);
                System.out.println("Mobile added.");
            }
            catch(NumberFormatException ex)
            {
                showError("Input Error", "Enter valid mobile values.");
            }
        });

        // add mp3
        addMP3Button.setOnAction(e ->
        {
            try
            {
                MP3 mp3 = new MP3(getModel(), getPrice(), getWeight(), getSize(), getMemory());
                gadgets.add(mp3);
                System.out.println("MP3 added.");
            }
            catch(NumberFormatException ex)
            {
                showError("Input Error", "Enter valid MP3 values.");
            }
        });

        // clear all fields
        clearButton.setOnAction(e ->
        {
            modelField.clear();
            priceField.clear();
            weightField.clear();
            sizeField.clear();
            creditField.clear();
            memoryField.clear();
            phoneNumberField.clear();
            durationField.clear();
            downloadField.clear();
            displayNumberField.clear();
        });

        // display all gadgets
        displayAllButton.setOnAction(e ->
        {
            for(int i = 0; i < gadgets.size(); i++)
            {
                Gadget gadget = gadgets.get(i);
                System.out.println("Display Number: " + i);
                gadget.display();
                System.out.println("____________________");
            }
        });

        // make a call
        makeCallButton.setOnAction(e ->
        {
            int displayNumber = getDisplayNumber();

            if(displayNumber != -1)
            {
                try
                {
                    Gadget gadget = gadgets.get(displayNumber);

                    // check selected gadget type
                    if(gadget instanceof Mobile)
                    {
                        Mobile mobile = (Mobile) gadget;
                        mobile.makeCall(getPhoneNumber(), getDuration());
                    }
                    else
                    {
                        showError("Type Error", "Selected gadget is not a mobile.");
                    }
                }
                catch(NumberFormatException ex)
                {
                    showError("Input Error", "Enter a valid duration.");
                }
            }
        });

        // download music
        downloadMusicButton.setOnAction(e ->
        {
            int displayNumber = getDisplayNumber();

            if(displayNumber != -1)
            {
                try
                {
                    Gadget gadget = gadgets.get(displayNumber);

                    // check selected gadget type
                    if(gadget instanceof MP3)
                    {
                        MP3 mp3 = (MP3) gadget;
                        mp3.downloadMusic(getDownloadSize());
                    }
                    else
                    {
                        showError("Type Error", "Selected gadget is not an MP3.");
                    }
                }
                catch(NumberFormatException ex)
                {
                    showError("Input Error", "Enter a valid download value.");
                }
            }
        });

        // add items to pane
        root.getChildren().add(titleLabel);
        root.getChildren().add(modelLabel);
        root.getChildren().add(modelField);
        root.getChildren().add(priceLabel);
        root.getChildren().add(priceField);
        root.getChildren().add(weightLabel);
        root.getChildren().add(weightField);
        root.getChildren().add(sizeLabel);
        root.getChildren().add(sizeField);
        root.getChildren().add(creditLabel);
        root.getChildren().add(creditField);
        root.getChildren().add(memoryLabel);
        root.getChildren().add(memoryField);
        root.getChildren().add(addMobileButton);
        root.getChildren().add(addMP3Button);
        root.getChildren().add(clearButton);
        root.getChildren().add(displayAllButton);
        root.getChildren().add(phoneNumberLabel);
        root.getChildren().add(phoneNumberField);
        root.getChildren().add(durationLabel);
        root.getChildren().add(durationField);
        root.getChildren().add(downloadLabel);
        root.getChildren().add(downloadField);
        root.getChildren().add(displayNumberLabel);
        root.getChildren().add(displayNumberField);
        root.getChildren().add(makeCallButton);
        root.getChildren().add(downloadMusicButton);

        // show stage
        stage.setScene(new Scene(root, 690, 330));
        stage.setTitle("Gadget Shop");
        stage.show();
    }

    // show error message
    private void showError(String title, String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // get model text
    public String getModel()
    {
        return modelField.getText();
    }

    // get price value
    public double getPrice()
    {
        return Double.parseDouble(priceField.getText().trim());
    }

    // get weight value
    public int getWeight()
    {
        return Integer.parseInt(weightField.getText().trim());
    }

    // get size text
    public String getSize()
    {
        return sizeField.getText();
    }

    // get credit value
    public int getCredit()
    {
        return Integer.parseInt(creditField.getText().trim());
    }

    // get memory value
    public int getMemory()
    {
        return Integer.parseInt(memoryField.getText().trim());
    }

    // get phone number text
    public String getPhoneNumber()
    {
        return phoneNumberField.getText();
    }

    // get duration value
    public int getDuration()
    {
        return Integer.parseInt(durationField.getText().trim());
    }

    // get download value
    public int getDownloadSize()
    {
        return Integer.parseInt(downloadField.getText().trim());
    }

    // get display number 
    public int getDisplayNumber()
    {
        int displayNumber = -1;

        try
        {
            displayNumber = Integer.parseInt(displayNumberField.getText().trim());

            if(displayNumber < 0 || displayNumber >= gadgets.size())
            {
                showError("Display Number Error", "Enter a display number in range.");
                displayNumber = -1;
            }
        }
        catch(NumberFormatException ex)
        {
            showError("Display Number Error", "Display number must be an integer.");
        }

        return displayNumber;
    }

    // main method
    public static void main(String[] args)
    {
        launch(args);
    }
}