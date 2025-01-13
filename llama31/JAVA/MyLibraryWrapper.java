import com.google.gwt.core.client.JavaScriptObject;

public class MyLibraryWrapper {
  // Create a JavaScriptObject to hold the library instance
  private native JavaScriptObject createLibraryInstance() /*-{
    return $wnd.MyLibrary();
  }-*/;

  // Wrap library methods using JSNI
  public native void myLibraryMethod(String param) /*-{
    var lib = this.@com.example.MyLibraryWrapper::createLibraryInstance()();
    lib.myLibraryMethod(param);
  }-*/;

  public static void main(String[] args) {
  }
}