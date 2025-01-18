import java.lang.String;

public class SamplePart implements IExecutableExtension {
  private IConfigurationElement element;

  @Override
  public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
    if (config != null && propertyName != null) {
      this.element = config;
    }
  }

  public static void main(String[] args) {
  }
}

interface IExecutableExtension {
  void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException;
}

interface IConfigurationElement {
}

class CoreException extends Exception {
}