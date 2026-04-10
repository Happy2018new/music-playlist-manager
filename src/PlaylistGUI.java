import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The GUI class extends JFrame and implements ActionListener
// so one single actionPerformed() method can handle all button events.
public class PlaylistGUI extends JFrame implements ActionListener {

    // Reference to the PlaylistManager (business logic)
    private PlaylistManager manager;

    // Input text fields for song details
    private JTextField idField;
    private JTextField titleField;
    private JTextField artistField;
    private JTextField durationField;
    private JTextField genreField;

    // Output area to display results
    private JTextArea outputArea;

    // Buttons declared as instance variables
    // so they can be accessed inside actionPerformed()
    private JButton addButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton listButton;
    private JButton clearButton;

    // Constructor
    public PlaylistGUI(PlaylistManager manager) {
        this.manager = manager;

        setTitle("Playlist Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 450);
        setLocationRelativeTo(null); // Center window

        buildUI(); // Build graphical components
        setVisible(true);
    }

    // Method responsible for building the interface
    private void buildUI() {

        // Panel for song input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 8, 8));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Song Details"));

        // Create text fields
        idField = new JTextField();
        titleField = new JTextField();
        artistField = new JTextField();
        durationField = new JTextField();
        genreField = new JTextField();

        // Add labels and fields to input panel
        inputPanel.add(new JLabel("ID (int):"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Artist:"));
        inputPanel.add(artistField);
        inputPanel.add(new JLabel("Duration (seconds):"));
        inputPanel.add(durationField);
        inputPanel.add(new JLabel("Genre:"));
        inputPanel.add(genreField);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Initialize buttons
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete (by ID)");
        searchButton = new JButton("Search (by Title)");
        listButton = new JButton("View All");
        clearButton = new JButton("Clear Output");

        // Attach this class as the ActionListener
        // All button clicks will be handled in actionPerformed()
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        searchButton.addActionListener(this);
        listButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add buttons to panel
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(listButton);
        buttonPanel.add(clearButton);

        // Create output text area
        outputArea = new JTextArea();
        outputArea.setEditable(false); // Prevent user editing
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Add scrolling capability
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output"));

        // Top panel holds input + buttons
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set main layout
        setLayout(new BorderLayout(10, 10));
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Central event handler method
    // This method is called whenever any registered button is clicked
    @Override
    public void actionPerformed(ActionEvent event) {

        // Determine which button triggered the event
        Object src = event.getSource();

        // Add Song
        if (src == addButton) {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String title = titleField.getText().trim();
                String artist = artistField.getText().trim();
                int duration = Integer.parseInt(durationField.getText().trim());
                String genre = genreField.getText().trim();

                Song song = new Song(id, title, artist, duration, genre);

                // Display result from manager
                outputArea.setText(manager.addSong(song));

            } catch (NumberFormatException ex) {
                // Error if ID or duration is not an integer
                outputArea.setText("Invalid number format. ID and Duration must be integers.");
            }

            // Delete Song
        } else if (src == deleteButton) {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                outputArea.setText(manager.deleteSongById(id));
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid ID. Please enter an integer ID to delete.");
            }

            // Search Song
        } else if (src == searchButton) {
            String title = titleField.getText();
            outputArea.setText(manager.searchSongByTitle(title));

            // List All Songs
        } else if (src == listButton) {
            outputArea.setText(manager.listAllSongs());

            // Clears the text area
        } else if (src == clearButton) {
            outputArea.setText("");
        }
    }
}