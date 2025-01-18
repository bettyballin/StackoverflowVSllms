public class TestClass {

    public String onSubmit(RedirectAttributes attributes) {
        /* ... */
        attributes.addFlashAttribute("errors", "example error"); // Flash attribute here
        return "redirect:/login";
    }
}

interface RedirectAttributes {
    RedirectAttributes addFlashAttribute(String attributeName, Object attributeValue);
}