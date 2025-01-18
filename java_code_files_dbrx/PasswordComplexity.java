public class PasswordComplexity {

    private int getPasswordComplexity(String password) {
        if (password == null || password.length() <= 4){
            return 1; // Very weak
        }

        int complexity = 0;
        boolean hasCapitalLetters = false, hasLowercaseLetters = false, hasDigits = false, hasSpecialCharacters = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapitalLetters = true;
            else if (Character.isLowerCase(c)) hasLowercaseLetters = true;
            else if (Character.isDigit(c)) hasDigits = true;
            else if (!Character.isAlphabetic(c) && !Character.isDigit(c) ) hasSpecialCharacters = true; // assumes spaces and control characters are not allowed.
        }
        // This will award 1 point for each kind of character, plus additional points up to a maximum based on the length
        complexity += (hasCapitalLetters ? 1 : 0); // check if capital letters exist in password. If they do add one point else zero
        complexity += (hasLowercaseLetters ? 1 : 0);
        complexity += (hasDigits ? 1 : 0);
        complexity += (hasSpecialCharacters ? 1 : 0);
        // Now, additional points up to a max of extraComplexityBonus for every character above the base length (4) to encourage longer passwords.
        final int baseLength = 4; // any password shorter than this will only score on different types of characters
        final int extraComplexityBonus = Math.min(password.length() - baseLength, 6); // max complexity gain from length is capped at 6 points here and added to the initial bonus for having different character sets.
        complexity += extraComplexityBonus;

        return Math.min(5, complexity); // limit maximum possible score to 5
    }

    public static void main(String[] args) {
        PasswordComplexity pc = new PasswordComplexity();
        
        // Test the method with some example passwords
        String[] testPasswords = { "abc", "Abc123!", "password", "P@ssw0rd1234", "A1b2C3d4!" };
        for (String pwd : testPasswords) {
            int complexity = pc.getPasswordComplexity(pwd);
            System.out.println("Password: " + pwd + " | Complexity: " + complexity);
        }
    }
}