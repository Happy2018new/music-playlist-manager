public class PlaylistManager {
    private static final int MAX_SONGS = 10;

    // Must not change: fixed-size array storage
    private Song[] playlist = new Song[MAX_SONGS];
    private int count = 0;

    /**
     * addSong adds a new song to the playlist.
     * 
     * If the playerlist is full, or the given song is invalid,
     * or the given song ID already exists, then this method does
     * nothing but output corresponding messages.
     * 
     * Otherwise, everything work as well, the new song successfully
     * added, and the output message will show the details of the added song.
     * 
     * @param song The new song want to add.
     * @return The output message.
     */
    public String addSong(Song song) {
        String validationError;

        if (this.count >= MAX_SONGS) {
            return "addSong: You already put " + MAX_SONGS + " songs and now the playlist is full! Cannot put anymore!";
        }
        if ((validationError = song.validateSong()) != null) {
            return "addSong: " + validationError;
        }
        for (Song element : this.playlist) {
            if (element == null) {
                break;
            }
            if (element.getSongID() == song.getSongID()) {
                return "addSong: A song with ID "
                        + element.getSongID() + " was already existing! "
                        + "Please assign a different ID to the new song.";
            }
        }

        this.playlist[this.count] = song;
        this.count++;
        return "Song added:\n" + song;
    }

    /**
     * deleteSongById removes a song from the playlist by given ID.
     * 
     * If the target song not found, then nothing will be removed.
     * Otherwise, the target song will be removed from the playlist.
     * 
     * @param id The song ID of the song want to remove.
     * @return The output message.
     */
    public String deleteSongById(int id) {
        int indexToRemove = -1;
        Song removed = null;

        for (int i = 0; i < this.count; i++) {
            if (this.playlist[i].getSongID() == id) {
                indexToRemove = i;
                removed = this.playlist[i];
                break;
            }
        }
        if (indexToRemove == -1 || removed == null) {
            return "deleteSongById: Target song with ID " + id + " was not found.";
        }

        for (int i = indexToRemove; i <= this.count - 2; i++) {
            this.playlist[i] = this.playlist[i + 1];
        }
        this.playlist[this.count - 1] = null;
        this.count--;

        return "Song deleted:\n" + removed;
    }

    /**
     * searchSongByTitle searches a song by the given song title.
     * If multiple songs have the same title, only the first song will be returned.
     * 
     * @param title The given song title.
     * @return The output message.
     */
    public String searchSongByTitle(String title) {
        Song target = null;

        if (title == null || title.trim().isEmpty()) {
            return "searchSongByTitle: The title of the song you want to search cannot be a null or empty string.";
        }
        for (Song song : this.playlist) {
            if (song == null) {
                break;
            }
            if (song.getSongTitle().equals(title)) {
                target = song;
                break;
            }
        }
        if (target == null) {
            return "searchSongByTitle: No song found with title \"" + title + "\".";
        }

        return "Target song with title \"" + title + "\" was found, and it is:\n" + target;
    }

    /**
     * sortSongs sorts the songs alphabetical by title ascending (A -> Z).
     * 
     * @return The output message.
     */
    public String sortSongs() {
        for (int i = 0; i < this.count; i++) {
            for (int j = i; j < this.count; j++) {
                Song left = this.playlist[i];
                Song right = this.playlist[j];
                if (left.getSongTitle().compareTo(right.getSongTitle()) > 0) {
                    this.playlist[i] = right;
                    this.playlist[j] = left;
                }
            }
        }
        return "Playlist sorted by title.\n\n" + listAllSongs();
    }

    /**
     * listAllSongs lists all songs and put their info into the returned string.
     * 
     * @return The output message.
     */
    public String listAllSongs() {
        if (count == 0) {
            return "Playlist is empty.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist (").append(count).append(" song").append(count == 1 ? "" : "s").append("):\n\n");
        for (int i = 0; i < count; i++) {
            sb.append(i + 1).append(". ").append(playlist[i]).append("\n");
        }
        return sb.toString();
    }
}
