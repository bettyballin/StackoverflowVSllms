package test;

import java.util.ArrayList;
import java.util.List;

public class Bookmarks implements Cloneable {
    private List<Bookmark> bookmarks = new ArrayList<>();

    @Override
    protected Bookmarks clone() throws CloneNotSupportedException {
        Bookmarks cloned = (Bookmarks) super.clone();
        cloned.bookmarks = new ArrayList<>();
        for (Bookmark bookmark : this.bookmarks) {
            cloned.bookmarks.add(bookmark.clone());
        }
        return cloned;
    }

    // Add methods to manipulate the list of bookmarks, etc...

    public static void main(String[] args) {
    }
}

class Bookmark implements Cloneable {
    @Override
    protected Bookmark clone() throws CloneNotSupportedException {
        return (Bookmark) super.clone();
    }
}