public class SampleView extends Composite {

    interface MyUiBinder extends UiBinder<Widget, SampleView> {}
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
    @UiField
    SpanElement nameField;

   //... rest of your business logic

    public static void main(String[] args) {
    }
}

class Composite {
    // Empty class
}

interface UiBinder<U, V> {
    // Empty interface
}

class GWT {
    public static <T> T create(Class<T> clazz) {
        return null;
    }
}

@interface UiField {
    // Empty annotation
}

class SpanElement {
    // Empty class
}

class Widget {
    // Empty class
}