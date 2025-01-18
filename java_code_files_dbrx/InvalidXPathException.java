public class InvalidXPathException {
    // Example: test for invalid queryPath
    String queryPath = "invalid.xpath[]"; // This will likely cause an error

    // To fix the issue above, try something like this (example):
    {
        queryPath = "/root/element[@attribute='value']";
    }

    public static void main(String[] args) {
    }
}