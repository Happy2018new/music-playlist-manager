public class Song {
    private int id;
    private String title;
    private String artist;
    private int duration; // seconds
    private String genre;

    // Constructor
    public Song(int id, String title, String artist, int duration, String genre) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
    }

    public String validateSong() {
        if (this.id <= 0) {
            return "validateSong: The song ID must be a positive integer.";
        }
        if (this.title == null || this.title.trim().isEmpty()) {
            return "validateSong: The song title cannot be a null or empty string.";
        }
        if (this.artist == null) {
            return "validateSong: The song artist cannot be a null string.";
        }
        if (this.duration <= 0) {
            return "validateSong: The song duration must be a positive number.";
        }
        if (this.genre == null) {
            return "validateSong: The song genre cannot be a null string.";
        }
        return null;
    }

    public int getSongID() {
        return this.id;
    }

    public String getSongTitle() {
        return this.title;
    }

    public String getSongArtist() {
        return this.artist;
    }

    public int getSongDuration() {
        return this.duration;
    }

    public String getSongGenre() {
        return this.genre;
    }

    public void setSongID(int id) throws Exception {
        throw new Exception("setSongID: The song ID can not be changed once set.");
    }

    public void setSongTitle(String title) {
        this.title = title;
    }

    public void setSongArtist(String artist) {
        this.artist = artist;
    }

    public void setSongDuration(int duration) {
        this.duration = duration;
    }

    public void setSongGenre(String genre) {
        this.genre = genre;
    }

    // This method converts the seconds into a minute format.
    private String formatDuration(int totalSeconds) {
        if (totalSeconds < 0) {
            totalSeconds = 0;
        }
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
    }

    // This method converts the song object into a String.
    @Override
    public String toString() {
        return "ID: " + id
                + " | Title: " + title
                + " | Artist: " + (artist.isEmpty() ? "Unknown Artist" : artist)
                + " | Duration: " + formatDuration(duration)
                + " | Genre: " + (genre.isEmpty() ? "Unknown Genre" : genre);
    }
}
