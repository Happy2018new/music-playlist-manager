public class PlaylistManager {
    private static final int MAX_SONGS = 10;

    // Must not change: fixed-size array storage
    private Song[] playlist = new Song[MAX_SONGS];
    private int count = 0;

    public String addSong(Song song) {
        // To do: Complete the addSong() method

        return "Song added:\n" + song; // song is the song added to the playlist.
    }

    public String deleteSongById(int id) {
        // To do: Complete the deteSongById() method

        return "Deleted:\n" + removed; // removed is the song deleted.
    }

    public String searchSongByTitle(String title) {
        // To do: Check if the title is null

        // To do: Check if the title is found in the playlist

        // To do: Check if the title is not found in the playlist

        return "No song found with title \"" + target + "\"."; //
    }

    // Sorting feature: alphabetical by title ascending (A -> Z)
    // No built-in sorting allowed
    public String sortSongs() {
        // To do: Complete sorting()

        return "Playlist sorted by title.\n\n" + listAllSongs();
    }

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

    // ---------- Helper methods ----- //
    // You can add any helper methods, if needed.

}