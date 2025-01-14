import org.jparsec.Parser;
import org.jparsec.Parsers;
import org.jparsec.Scanners;
import org.jparsec.Token;
import org.jparsec.Terminals;
import org.jparsec.error.ParserException;

import java.util.Arrays;

public class DSLParser {
    private static final String[] KEYWORDS = {
            "Create", "user", "with", "email", "and", "password",
            "Log", "in"
    };

    private static final Terminals TERMS = Terminals.operators().words(Scanners.IDENTIFIER).keywords(Arrays.asList(KEYWORDS)).build();

    private static final Parser<Void> IGNORED = Parsers.or(Scanners.WHITESPACES).skipMany();

    private final Parser<CreateUser> createUser = Parsers.sequence(
            TERMS.token("Create"),
            TERMS.token("user"),
            TERMS.token(Parsers.NOT(Parsers.or(TERMS.token("with"), TERMS.token("and")))),
            TERMS.token("with"),
            TERMS.token("email"),
            TERMS.token(Parsers.ANY_TOKEN),
            TERMS.token("and"),
            TERMS.token("password"),
            TERMS.token(Parsers.ANY_TOKEN),
            (create, user, usernameToken, with, email, emailToken, and, password, passwordToken) -> {
                String username = usernameToken.toString();
                String emailStr = emailToken.toString();
                String passwordStr = passwordToken.toString();
                CreateUser cu = new CreateUser(username);
                cu.withEmail(emailStr);
                cu.andPassword(passwordStr);
                return cu;
            }
    ).from(TERMS.tokenizer(), IGNORED);

    private final Parser<LoginUser> login = Parsers.sequence(
            TERMS.token("Log"),
            TERMS.token(Parsers.NOT(TERMS.token("in"))),
            TERMS.token("in"),
            (log, usernameToken, in) -> {
                String username = usernameToken.toString();
                return new LoginUser(username);
            }
    ).from(TERMS.tokenizer(), IGNORED);

    public static void main(String[] args) {
        DSLParser parser = new DSLParser();

        String input = "Create user user1 with email test@example.com and password test";
        try {
            CreateUser result = parser.createUser.parse(input);
            System.out.println(result);
        } catch (ParserException e) {
            e.printStackTrace();
        }

        input = "Log user1 in";
        try {
            LoginUser result = parser.login.parse(input);
            System.out.println("Logged in successfully: " + result);
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
}

class CreateUser {
    private final String user;
    private String email;
    private String password;

    public CreateUser(String user) {
        this.user = user;
    }

    public CreateUser withEmail(String email) {
        this.email = email;
        return this;
    }

    public void andPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CreateUser{" +
                "user='" + user + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

class LoginUser {
    private final String user;

    public LoginUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "user='" + user + '\'' +
                '}';
    }
}