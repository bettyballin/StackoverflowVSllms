class ExternalLibraryResource {
    // Minimal implementation to make the code compile
}

class ResourceWrapper {
    private ExternalLibraryResource libResource;

    public void open() { /* implementation... */ }
    public void close() { /* implementation... */ }

    protected void finalize() throws Throwable {
        try {
            if (libResource != null) { // Still allocated?
                close(); // Try to release it now.
            }
        } finally {
            super.finalize();
        }
    }
}