/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import javax.servlet.http.HttpServletRequest;

public class CustomDecoratorMapper
implements DecoratorMapper {
    @Override
    public String getDecorator(HttpServletRequest httpServletRequest) {
        String string = (String)httpServletRequest.getAttribute("decorator");
        if (string != null) {
            return string;
        }
        return null;
    }

    public static void main(String[] stringArray) {
        CustomDecoratorMapper customDecoratorMapper = new CustomDecoratorMapper();
    }
}
