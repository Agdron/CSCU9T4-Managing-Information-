import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;

public class Main {

    public static int TvCount = 0;
    public static int FilmCount = 0;
    public static int MusicCount = 0;
    public static int TheaterCount = 0;
    public static int projectCount = 0;
    public static int count = 0;

    private JFrame frame;
    private JPanel panel;
    private JPanel textArea;
    private JPanel panelText;
    private JPanel newInfo;
    private JButton button;
    private JButton clearButton;
    private JButton getSummary;
    private JButton locationSearch;
    private JButton typeSearch;
    private JButton IDSearch;
    private JTextArea area;

    private JLabel IDSearchLabel;
    private JLabel locationSearchLabel;
    private JLabel typeSearchLabel;

    private JTextField IDSearchInput;
    private JTextField locationSearchInput;
    private JTextField typeSearchInput;

    private JTextField newProjectName;
    private JLabel EnterName;
    private JTextField newDate;
    private JLabel EnterDate;
    private JTextField newLocation;
    private JLabel EnterLocation;
    private JTextField newCost;
    private JLabel EnterCost;
    private JTextField newPricetoCustomer;
    private JLabel EnterPrice;
    private JComboBox newVenueSize;
    private JLabel EnterVenue;
    private JTextField newDuration;
    private JLabel EnterDuration;
    private JTextField newExtra;
    private JLabel EnterExtra;
    private JComboBox newFormat;
    private JLabel EnterFormat;

    private JComboBox DurationUnits;
    private JLabel EnterUnits;

    private JButton createObject;

    static List<Projects> arrTV = new ArrayList<Projects>();
    static List<Projects> arrFilm = new ArrayList<Projects>();
    static List<Projects> arrMusic = new ArrayList<Projects>();
    static List<Projects> arrTheater = new ArrayList<Projects>();

    public Main(){

        //Setting Up the JFrame

        frame = new JFrame();
        frame.setSize(new Dimension(850, 1000));

        // Four Separate JPanels used for design reasons and so the program is easy to use
        panel = new JPanel();
        panelText = new JPanel();
        textArea = new JPanel();
        newInfo = new JPanel();

        // Text area setup

        area = new JTextArea();
        area.setBounds(0, 0, 500, 500);
        area.setEditable(false);

        // Scroll Pane attempted setup, though this for some reason does not work in the final product
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

/////////////////////////////////////////////////////////////////////////////////////

        // Buttons to clear the screen and get the requested summary

        clearButton = new JButton("Clear Screen");
        clearButton.addActionListener(new ButtonListener());

        getSummary = new JButton("Get Summary of Recorded Products");
        getSummary.addActionListener(new ButtonListener());

////////////////////////////////////////////////////////////////////////////////////

        //Buttons and Search Boxes for the three searches

        locationSearch = new JButton("Search for location");
        locationSearch.addActionListener(new ButtonListener());

        typeSearch = new JButton("Search for Project Type");
        typeSearch.addActionListener(new ButtonListener());

        IDSearch = new JButton("Search for ID");
        IDSearch.addActionListener(new ButtonListener());

        locationSearchInput = new JTextField(15);
        locationSearchLabel = new JLabel("Enter a location: ");

        typeSearchInput = new JTextField(15);
        typeSearchLabel = new JLabel("Enter a Project Type: ");

        IDSearchInput = new JTextField(15);
        IDSearchLabel = new JLabel("Enter a Project ID: ");

//////////////////////////////////////////////////////////////////////////////////

        // And Thus Starts the creation of "a new object"
        // To Do this, several string arrays are created with options

        String[] choicesFormat = {"Music", "Film", "Theater", "TV"};
        String[] choicesVenue = {"Small", "Medium", "Large"};
        String[] choicesUnits = {"Hours", "Days"};

        newProjectName = new JTextField(15);
        EnterName = new JLabel("New Project Name: ");

        newDate = new JTextField(15);
        EnterDate = new JLabel("New Date: ");

        newLocation = new JTextField(15);
        EnterLocation = new JLabel("New Location: ");

        newCost = new JTextField(15);
        EnterCost = new JLabel("New Cost: ");

        newPricetoCustomer = new JTextField(15);
        EnterPrice = new JLabel("New Price to Customer: ");

        newVenueSize = new JComboBox<String>(choicesVenue);
        EnterVenue = new JLabel("New Venue Size: ");

        newDuration = new JTextField(15);
        EnterDuration = new JLabel("New Duration: ");

        newExtra = new JTextField(15);
        EnterExtra = new JLabel("New Genre/Format/Playwright/TV: ");

        newFormat = new JComboBox<String>(choicesFormat);
        EnterFormat = new JLabel("Choose a Project Type: ");

        DurationUnits = new JComboBox<String>(choicesUnits);
        EnterUnits = new JLabel("Select the Duration Units: ");

        // Create object button will take above data and pop it into a lovely little java object for us

        createObject = new JButton("Add Entry");
        createObject.addActionListener(new ButtonListener());


/////////////////////////////////////////////////////////////////////////////////

        // setting colours and other random crap to do with my UI such as the preferred size of textArea and newInfo

        textArea.setPreferredSize(new Dimension(650,150));
        newInfo.setPreferredSize(new Dimension(900, 200));
        panel.setBackground(Color.LIGHT_GRAY);
        panelText.setBackground(Color.gray);
        newInfo.setBackground(Color.LIGHT_GRAY);

        // Adding the panels onto the frame

        frame.add(panel, BorderLayout.NORTH);

        frame.add(panelText);
        frame.add(textArea, BorderLayout.LINE_END);
        frame.add(newInfo, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Funny title haha very funny, honestly please give it a chance, with how long this code took me at least
        // let me have a wee bit of fun with it.
        frame.setTitle("Kilted Kangaroo 2: Now The Haggis is Kilted");

        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.setLayout(new FlowLayout(1, 10, 10));



        // Adding all buttons, labels, text areas and input bars to the separate panels
        /*        panel.add(button);*/
        panel.add(clearButton);
        panel.add(getSummary);

        panelText.add(locationSearchLabel);
        panelText.add(locationSearchInput);
        panelText.add(locationSearch);
        panelText.add(typeSearchLabel);
        panelText.add(typeSearchInput);
        panelText.add(typeSearch);
        panelText.add(IDSearchLabel);
        panelText.add(IDSearchInput);
        panelText.add(IDSearch);

        textArea.add(area);
        textArea.add(scrollPane);
        scrollPane.setVisible(true);
        /*
        textArea.add(scrollPane);*/

        newInfo.add(EnterName);
        newInfo.add(newProjectName);
        newInfo.add(EnterFormat);
        newInfo.add(newFormat);
        newInfo.add(EnterDate);
        newInfo.add(newDate);
        newInfo.add(EnterLocation);
        newInfo.add(newLocation);
        newInfo.add(EnterCost);
        newInfo.add(newCost);
        newInfo.add(EnterPrice);
        newInfo.add(newPricetoCustomer);
        newInfo.add(EnterVenue);
        newInfo.add(newVenueSize);
        newInfo.add(EnterDuration);
        newInfo.add(newDuration);
        newInfo.add(EnterUnits);
        newInfo.add(DurationUnits);
        newInfo.add(EnterExtra);
        newInfo.add(newExtra);
        newInfo.add(createObject);

        frame.setVisible(true);
    }
    public static void main(String[] args) throws FileNotFoundException {

        new Main();

        // Scan in the Kilted Random Kangaroo stuff (yes I know it's a haggis) and yes I know this is unprofessional :))
        Scanner scanner = new Scanner(new File("the_kilted_haggis_productions_projects.csv"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); // Sets current line as variable

            String[] info = line.split(","); // Splits line where commas are

            if (info[0].equals("project_id")) { // Skips the first line
                continue;
            }

            else {
                // TV creator
                if (info[2].equals("TV")) {


                    // Loops through all data
                    for (int i = 0; i < info.length; i++) {
                        // Skips blank data
                        if (info[i].isBlank()) {
                            continue;
                        }
                    }
                    // Checks whether project has turned a profit
                    if (Double.parseDouble(info[5]) < Double.parseDouble(info[6])){
                        projectCount +=1;
                        TvCount += 1;
                        //Ups the count if it has, this is used later in the summary.
                    }

                    Projects objects = new TV(Double.parseDouble(info[0]), info[1], info[2], info[3], info[4],
                            Double.parseDouble(info[5]), Double.parseDouble(info[6]), info[7],
                            Double.parseDouble(info[8]),
                            info[9], info[10]);


                    arrTV.add(objects);


                    count++;
                    //count is used later when adding new objects to the arraylists
                    System.out.println(objects);
                }

                // Music creator
                else if (info[2].equals("Music")) {


                    // Loops through all data
                    for (int i = 0; i < info.length; i++) {
                        // Skips blank data
                        if (info[i].isBlank()) {
                            continue;
                        }
                    }
                    // Checks whether project has turned a profit
                    if (Double.parseDouble(info[5]) < Double.parseDouble(info[6])){
                        projectCount +=1;
                        MusicCount += 1;
                    }

                    Projects objects = new Music(Double.parseDouble(info[0]), info[1], info[2], info[3], info[4],
                            Double.parseDouble(info[5]), Double.parseDouble(info[6]), info[7],
                            Double.parseDouble(info[8]),
                            info[9], info[10]);


                    arrMusic.add(objects);

                    count++;
                    System.out.println(objects);
                }

                //Theater creator
                if (info[2].equals("Theater")) {


                    // Loops through all data
                    for (int i = 0; i < info.length; i++) {
                        // Skips blank data
                        if (info[i].isBlank()) {
                            continue;
                        }
                    }
                    // Checks whether project has turned a profit
                    if (Double.parseDouble(info[5]) < Double.parseDouble(info[6])){
                        projectCount +=1;
                        TheaterCount += 1;
                    }

                    Projects objects = new Theater(Double.parseDouble(info[0]), info[1], info[2], info[3], info[4],
                            Double.parseDouble(info[5]), Double.parseDouble(info[6]), info[7],
                            Double.parseDouble(info[8]),
                            info[9], info[10]);


                    arrTheater.add(objects);

                    count++;
                    System.out.println(objects);
                }

                // Film creator
                else if (info[2].equals("Film")) {


                    // Loops through all data
                    for (int i = 0; i < info.length; i++) {
                        // Skips blank data
                        if (info[i].isBlank()) {
                            continue;
                        }
                    }
                    // Checks whether project has turned a profit
                    if (Double.parseDouble(info[5]) < Double.parseDouble(info[6])){
                        projectCount +=1;
                        FilmCount += 1;
                    }

                    Projects objects = new Film(Double.parseDouble(info[0]), info[1], info[2], info[3], info[4],
                            Double.parseDouble(info[5]), Double.parseDouble(info[6]), info[7],
                            Double.parseDouble(info[8]),
                            info[9], info[10]);


                    arrFilm.add(objects);

                    count++;
                    System.out.println(objects);
                }
            }
        }
        System.out.println("Overall Project Count: " + projectCount);
        System.out.println("TV Count: " + TvCount + " Music Count: " + MusicCount + " Theater Count: " + TheaterCount + " Film Count: " + FilmCount);
        System.out.println(count);
    }


    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button){
                for (int i = 0; i < arrFilm.size(); i++) {
                    area.setText("");
                    area.append(arrFilm.get(i).toString());
                }
            }
            else if (e.getSource() == clearButton){
                area.setText(""); // Clear's the text area
            }
            else if (e.getSource() == getSummary){
                area.setText("");
                area.setText("Kilted Haggis has produced a total of " + projectCount + " projects that turned a profit, \n" + FilmCount + " of which were Films, \n" +
                        TvCount + " of which were Television Shows, \n" + TheaterCount + " of which were Theatre Shows, \n" +MusicCount+ " of which were Music Shows.");
                // Produces a summary of the projects turning a profit and prints the information neatly
            }
            else if (e.getSource() == locationSearch) {

                area.setText("");
                //This code will filter through and display projects of a specific location
                String searchTerm = " Location: " + locationSearchInput.getText();
                int finds = 0;

                //Loops through each array and finds the specific location which each project has

                for (int i = 0; i < arrFilm.size(); i++) {
                    String current = arrFilm.get(i).toString();

                    if (current.contains(searchTerm)) {
                        area.append(current);
                        finds++;
                    }
                }

                for (int i = 0; i < arrTV.size(); i++) {
                    String current = arrTV.get(i).toString();

                    if (current.contains(searchTerm)) {
                        area.append(current);
                        finds++;
                    }
                }

                for (int i = 0; i < arrTheater.size(); i++) {
                    String current = arrTheater.get(i).toString();

                    if (current.contains(searchTerm)) {
                        area.append(current);
                        finds++;
                    }
                }

                for (int i = 0; i < arrMusic.size(); i++) {
                    String current = arrMusic.get(i).toString();

                    if (current.contains(searchTerm)) {
                        area.append(current);
                        finds++;
                    }
                }
                if (finds == 0) {
                    area.append("No results found.");
                }
            }
            else if (e.getSource() == typeSearch) {

                //This method searches for projects of a specific type

                area.setText("");

                String searchTerm = " Type: " + typeSearchInput.getText();
                int finds = 0;

                //Once again loops through all of the objects and finds projects where the type equals what was input

                for (int i = 0; i < arrFilm.size(); i++) {
                    String current = arrFilm.get(i).toString();

                    if (current.contains(searchTerm)) {
                        area.append(current);
                        finds++;
                    }
                }

                for (int i = 0; i < arrTV.size(); i++) {
                    String current = arrTV.get(i).toString();

                    if (current.contains(searchTerm)) {
                        area.append(current);
                        finds++;
                    }
                }

                for (int i = 0; i < arrTheater.size(); i++) {
                    String current = arrTheater.get(i).toString();

                    if (current.contains(searchTerm)) {
                        area.append(current);
                        finds++;
                    }
                }

                for (int i = 0; i < arrMusic.size(); i++) {
                    String current = arrMusic.get(i).toString();

                    if (current.contains(searchTerm)) {
                        area.append(current);
                        finds++;
                    }
                }
                if (finds == 0) {
                    area.append("No results found.");
                }
            }


            else if (e.getSource() == IDSearch) {
            // Yeah, ID search, I think it's pretty self explanatory by now
                area.setText("");

                String searchTerm = "Project ID: " + IDSearchInput.getText();
                int finds = 0;


                //Yep, loopy doopy, searching for a specific ID

                for (int i = 0; i < arrFilm.size(); i++) {
                    String current = arrFilm.get(i).toString();

                    if (current.contains(searchTerm)) {
                        area.append(current);
                        finds++;
                    }
                }

                for (int i = 0; i < arrTV.size(); i++) {
                    String current = arrTV.get(i).toString();

                    if (current.contains(searchTerm)) {
                        area.append(current);
                        finds++;
                    }
                }

                for (int i = 0; i < arrTheater.size(); i++) {
                    String current = arrTheater.get(i).toString();

                    if (current.contains(searchTerm)) {
                        area.append(current);
                        finds++;
                    }
                }

                for (int i = 0; i < arrMusic.size(); i++) {
                    String current = arrMusic.get(i).toString();

                    if (current.contains(searchTerm)) {
                        area.append(current);
                        finds++;
                    }
                }
                if (finds == 0) {
                    area.append("No results found.");
                }
            }

            // Now here is how we add a new entry
            // Below code will check the index of the format option selected, and add entered data to an object based on which was chosen


            else if (e.getSource() == createObject){
                area.setText("");

                if(newProjectName.getText().isEmpty()){
                    area.setText("Error, Fields not filled in!"); //Checks whether the field is empty
                }

                else if (newDate.getText().isEmpty()){
                    area.setText("Error, Fields not filled in!");
                }

                else if (newLocation.getText().isEmpty()){
                    area.setText("Error, Fields not filled in!");
                }

                else if (newCost.getText().isEmpty()){
                    area.setText("Error, Fields not filled in!");
                }

                else if (newPricetoCustomer.getText().isEmpty()){
                    area.setText("Error, Fields not filled in!");
                }

                else if (newDuration.getText().isEmpty()){
                    area.setText("Error, Fields not filled in!");
                }

                else if (newExtra.getText().isEmpty()){
                    area.setText("Error, Fields not filled in!");
                }

                else {

                    area.setText("ENTRIES ADDED: \n");

                    if (newFormat.getSelectedIndex() == 0) {  // ID 0 == Music
                        count++; // Ups the ID number to be one more than the last project added
                        if (Double.parseDouble(newCost.getText()) < Double.parseDouble(newPricetoCustomer.getText())) {
                            projectCount += 1;
                            MusicCount += 1;
                            // Code to check if the new project turns a profit and ups the counts for the summary if so
                        }
                        Projects objects = new Music(count, newProjectName.getText(), newFormat.getSelectedItem().toString(), newDate.getText(), newLocation.getText(),
                                Double.parseDouble(newCost.getText()), Double.parseDouble(newPricetoCustomer.getText()), newVenueSize.getSelectedItem().toString(),
                                Double.parseDouble(newDuration.getText()),
                                DurationUnits.getSelectedItem().toString(), newExtra.getText());

                        arrMusic.add(objects);
                        System.out.println("New Object: \n" + objects);
                        area.append(objects.toString());


                    } else if (newFormat.getSelectedIndex() == 1) { // ID 1 == Film
                        count++;
                        if (Double.parseDouble(newCost.getText()) < Double.parseDouble(newPricetoCustomer.getText())) {
                            projectCount += 1;
                            FilmCount += 1;
                        }
                        Projects objects = new Film(count, newProjectName.getText(), newFormat.getSelectedItem().toString(), newDate.getText(), newLocation.getText(),
                                Double.parseDouble(newCost.getText()), Double.parseDouble(newPricetoCustomer.getText()), newVenueSize.getSelectedItem().toString(),
                                Double.parseDouble(newDuration.getText()),
                                DurationUnits.getSelectedItem().toString(), newExtra.getText());
                        arrFilm.add(objects);
                        System.out.println("New Object: \n" + objects);
                        area.append(objects.toString());


                    } else if (newFormat.getSelectedIndex() == 2) { // ID 2 == Theater
                        count++;
                        if (Double.parseDouble(newCost.getText()) < Double.parseDouble(newPricetoCustomer.getText())) {
                            projectCount += 1;
                            TheaterCount += 1;
                        }
                        Projects objects = new Theater(count, newProjectName.getText(), newFormat.getSelectedItem().toString(), newDate.getText(), newLocation.getText(),
                                Double.parseDouble(newCost.getText()), Double.parseDouble(newPricetoCustomer.getText()), newVenueSize.getSelectedItem().toString(),
                                Double.parseDouble(newDuration.getText()),
                                DurationUnits.getSelectedItem().toString(), newExtra.getText());
                        arrTheater.add(objects);
                        System.out.println("New Object: \n" + objects);
                        area.append(objects.toString());


                    } else if (newFormat.getSelectedIndex() == 3) { // ID 3 == TV
                        count++;
                        if (Double.parseDouble(newCost.getText()) < Double.parseDouble(newPricetoCustomer.getText())) {
                            projectCount += 1;
                            TvCount += 1;
                        }
                        Projects objects = new TV(count, newProjectName.getText(), newFormat.getSelectedItem().toString(), newDate.getText(), newLocation.getText(),
                                Double.parseDouble(newCost.getText()), Double.parseDouble(newPricetoCustomer.getText()), newVenueSize.getSelectedItem().toString(),
                                Double.parseDouble(newDuration.getText()),
                                DurationUnits.getSelectedItem().toString(), newExtra.getText());
                        arrTV.add(objects);
                        System.out.println("New Object: \n" + objects);
                        area.append(objects.toString());
                    }
                }
            }
        }
    }
}
// There was a game breaking bug here which I discovered approx 2 hours before I submitted. Had to make a quick fix.
// Please don't break my beautiful program