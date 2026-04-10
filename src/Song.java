public class Song {
    private int id;
    private String title;
    private String artist;
    private int duration; // seconds
    private String genre;

    // To do: Constructor

    // To do: Getters

    // To do: Setters

    // This method converts the seconds into a minute format.
    private String formatDuration(int totalSeconds) {
        if (totalSeconds < 0)
            totalSeconds = 0;
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
    }

    // This method converts the song object into a String.
    @Override
    public String toString() {
        return "ID: " + id
                + " | Title: " + title
                + " | Artist: " + artist
                + " | Duration: " + formatDuration(duration)
                + " | Genre: " + genre;
    }
}
