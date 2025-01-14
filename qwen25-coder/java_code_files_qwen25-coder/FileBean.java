// File: FileBean.java

import java.lang.String;
import org.icefaces.ace.model.fileentry.FileEntryEvent;
import org.icefaces.ace.model.fileentry.FileEntryResults;

public class FileBean {
    private String fileName;

    public void handleFileUpload(FileEntryEvent event) {
        FileEntryResults results = event.getResults();
        if (results.isValid()) {
            fileName = results.getFileInfo().get(0).getFileName();
        }
    }

    // getters and setters
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        // Create an instance of FileBean and simulate a file upload
        FileBean fileBean = new FileBean();
        fileBean.handleFileUpload(new FileEntryEvent());
        System.out.println("Uploaded file name: " + fileBean.getFileName());
    }
}

// File: org/icefaces/ace/model/fileentry/FileEntryEvent.java

package org.icefaces.ace.model.fileentry;

public class FileEntryEvent {
    public FileEntryResults getResults() {
        return new FileEntryResults();
    }
}

// File: org/icefaces/ace/model/fileentry/FileEntryResults.java

package org.icefaces.ace.model.fileentry;

import java.util.ArrayList;
import java.util.List;

public class FileEntryResults {
    public boolean isValid() {
        return true; // Return true for testing purposes
    }

    public List<FileInfo> getFileInfo() {
        List<FileInfo> list = new ArrayList<>();
        list.add(new FileInfo());
        return list;
    }
}

// File: org/icefaces/ace/model/fileentry/FileInfo.java

package org.icefaces.ace.model.fileentry;

public class FileInfo {
    public String getFileName() {
        return "dummyFileName.txt"; // Return a dummy file name
    }
}