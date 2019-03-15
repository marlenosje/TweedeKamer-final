/**
 * @author Paul Tonk
 * @version 1.0 mrt 2019
 */
package audio;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.util.ArrayList;

/**
 * Provide basic playing of MP3 files via the javazoom library.
 * See http://www.javazoom.net/
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicPlayer {
    // The current player. It might be null.
    private AdvancedPlayer player;
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files = new ArrayList<>();

    /**
     * Constructor for objects of class MusicFilePlayer
     */
    public MusicPlayer() {
        player = null;
        addFileMededelingen();
    }

    /**
     * Voeg mededelingen toe
     * .
     */
    public void addFileMededelingen() {
        files.add("../tweedekamer final/audio/Teksten/Opname01.mp3");
        files.add("../tweedekamer final/audio/Teksten/Opname02.mp3");
        files.add("../tweedekamer final/audio/Teksten/Opname03.mp3");
        files.add("../tweedekamer final/audio/Teksten/Opname04.mp3");
        files.add("../tweedekamer final/audio/Teksten/Opname05.mp3");
        files.add("../tweedekamer final/audio/Teksten/Opname06.mp3");
        files.add("../tweedekamer final/audio/Teksten/DingDong.mp3");
    }


    /**
     * Play a part of the given file.
     * The method returns once it has finished playing.
     *
     * @param filename The file to be played.
     */
    public void playSample(String filename) {
        try {
            setupPlayer(filename);
            player.play(500);
        } catch (JavaLayerException e) {
            reportProblem(filename);
        } finally {
            killPlayer();
        }
    }

    /**
     * Start playing the given audio file belonging to the index.
     * The method returns once the playing has been started.
     *
     * @param index The fileindex to be played.
     */
    public void startPlaying(int index) {
        String filename = files.get(index);
        startPlaying(filename);
    }

    /**
     * Return the number of files in the collection.
     *
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles() {
        return files.size();
    }

    /**
     * Start playing the given audio file.
     * The method returns once the playing has been started.
     *
     * @param filename The file to be played.
     */
    public void startPlaying(final String filename) {
        try {
            setupPlayer(filename);
            Thread playerThread = new Thread() {
                public void run() {
                    try {
                        player.play(5000);
                    } catch (JavaLayerException e) {
                        reportProblem(filename);
                    } finally {
                        killPlayer();
                    }
                }
            };
            playerThread.start();
        } catch (Exception ex) {
            reportProblem(filename);
        }
    }

    public void stop() {
        killPlayer();
    }

    /**
     * Set up the player ready to play the given file.
     *
     * @param filename The name of the file to play.
     */
    private void setupPlayer(String filename) {
        try {
            InputStream is = getInputStream(filename);
            player = new AdvancedPlayer(is, createAudioDevice());
        } catch (IOException e) {
            reportProblem(filename);
            killPlayer();
        } catch (JavaLayerException e) {
            reportProblem(filename);
            killPlayer();
        }
    }

    /**
     * Return an InputStream for the given file.
     *
     * @param filename The file to be opened.
     * @return An input stream for the file.
     * @throws IOException If the file cannot be opened.
     */
    private InputStream getInputStream(String filename)
            throws IOException {
        return new BufferedInputStream(
                new FileInputStream(filename));
    }

    /**
     * Create an audio device.
     *
     * @return An audio device.
     * @throws JavaLayerException if the device cannot be created.
     */
    private AudioDevice createAudioDevice()
            throws JavaLayerException {
        return FactoryRegistry.systemRegistry().createAudioDevice();
    }

    /**
     * Terminate the player, if there is one.
     */
    private void killPlayer() {
        synchronized (this) {
            if (player != null) {
                player.stop();
                player = null;
            }
        }
    }

    /**
     * Report a problem playing the given file.
     *
     * @param filename The file being played.
     */
    private void reportProblem(String filename) {
        System.out.println("There was a problem playing: " + filename);
    }

}
