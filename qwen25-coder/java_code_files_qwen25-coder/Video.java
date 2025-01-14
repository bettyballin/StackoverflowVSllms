import java.lang.String;

public class Audio extends Archive {
    private int durationInSeconds;
    // Other audio-specific fields

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public static void main(String[] args) {
    }
}

class Video extends Archive {
    private String videoFormat;
    // Other video-specific fields

    public String getVideoFormat() {
        return videoFormat;
    }

    public void setVideoFormat(String videoFormat) {
        this.videoFormat = videoFormat;
    }
}

class Book extends Archive {
    private int numberOfPages;
    private String author;

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class Archive {
    // Base class fields and methods
}