public class Song {
    private int id;
    private String title;
    private String artist;
    private int duration; // seconds
    private String genre;

    /**
     * Initializes a new Song object with the following parameters.
     * 
     * Note that this constructor will not check the given args are correct or not,
     * and this is your repsonsibility to calling {@link #validateSong} to check
     * the returned Song object is valid or not.
     * 
     * @param id       The id of the song, must be a positive integer.
     * @param title    The title of the song, cannot be empty.
     * @param artist   The artist of the song, cannot be empty.
     * @param duration The duration of the song in seconds, must be a positive
     *                 integer.
     * @param genre    The genre of the song, cannot be empty.
     */
    public Song(int id, String title, String artist, int duration, String genre) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
    }

    /**
     * validateSong checks current song object is valid or not.
     * 
     * Note that it is your responsibility to call this method after you
     * init or update a Song object, to check the song is valid or not.
     * 
     * If check failed, then validateSong returns a non-null String,
     * which this string represents the reason why the song is invalid.
     * 
     * If all things work as well, meaning the song is valid,
     * then ensure validateSong returns a null String value.
     * 
     * @return A non-null String if the song is invalid, otherwise null.
     */
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

    /**
     * getSongID returns the ID of the song.
     * 
     * If {@link #validateSong} is called and returns null,
     * then make sure {@link #getSongID} returns a positive integer.
     * 
     * @return The ID of the song.
     */
    public int getSongID() {
        return this.id;
    }

    /**
     * getSongTitle returns the title of the song.
     * 
     * If {@link #validateSong} is called and returns null,
     * then make sure {@link #getSongTitle} returns a non-empty string.
     * 
     * @return The title of the song.
     */
    public String getSongTitle() {
        return this.title;
    }

    /**
     * getSongArtist returns the artist of the song.
     * 
     * If {@link #validateSong} is called and returns null,
     * then make sure {@link #getSongArtist} returns a non-null string.
     * 
     * A non-null string still can be an empty string,
     * but it will never be a null string.
     * 
     * @return The artist of the song.
     */
    public String getSongArtist() {
        return this.artist;
    }

    /**
     * getSongDuration returns the duration of the song in seconds.
     *
     * If {@link #validateSong} is called and returns null,
     * then make sure {@link #getSongDuration} returns a positive integer.
     * 
     * @return The duration of the song in seconds.
     */
    public int getSongDuration() {
        return this.duration;
    }

    /**
     * getSongGenre returns the genre of the song.
     *
     * If {@link #validateSong} is called and returns null,
     * then make sure {@link #getSongGenre} returns a non-null string.
     * 
     * A non-null string still can be an empty string,
     * but it will never be a null string.
     * 
     * @return The genre of the song.
     */
    public String getSongGenre() {
        return this.genre;
    }

    /**
     * setSongID sets the ID of the song.
     * 
     * Make sure the each calling to this method will result as an exception,
     * because the song ID cannot be changed after the Song object is created.
     * 
     * @param id The new ID of the song.
     * @throws Exception The song ID cannot be changed once set, so here will always
     *                   throw an exception.
     */
    public void setSongID(int id) throws Exception {
        throw new Exception("setSongID: The song ID can not be changed once set.");
    }

    /**
     * setSongTitle sets the title of the song.
     * Please make sure the title is a non-empty string.
     * 
     * @param title The new title of the song.
     */
    public void setSongTitle(String title) {
        this.title = title;
    }

    /**
     * setSongArtist sets the artist of the song.
     * Please make sure the artist is a non-null string,
     * but the string can still be empty.
     * 
     * @param artist The new artist of the song.
     */
    public void setSongArtist(String artist) {
        this.artist = artist;
    }

    /**
     * setSongDuration sets the duration of the song in seconds.
     * Please make sure the duration is a positive integer.
     * 
     * @param duration The new duration of the song in seconds.
     */
    public void setSongDuration(int duration) {
        this.duration = duration;
    }

    /**
     * setSongGenre sets the genre of the song.
     * Please make sure the genre is a non-null string,
     * but the string can still be empty.
     * 
     * @param genre The new genre of the song.
     */
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
