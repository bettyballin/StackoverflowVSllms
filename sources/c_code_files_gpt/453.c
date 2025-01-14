#include <libsecret/secret.h>
#include <glib.h> // Include glib.h for gchar type

const SecretSchema my_schema = {
    "org.example.Password", SECRET_SCHEMA_NONE,
    {
        { "service", SECRET_SCHEMA_ATTRIBUTE_STRING },
        { "account", SECRET_SCHEMA_ATTRIBUTE_STRING },
        { NULL, 0 },
    }
};

void store_password(const gchar *service, const gchar *account, const gchar *password) {
    secret_password_store_sync(&my_schema, NULL, "Example Password", password, NULL,
                               "service", service, "account", account, NULL);
}

gchar* retrieve_password(const gchar *service, const gchar *account) {
    return secret_password_lookup_sync(&my_schema, NULL, "service", service, "account", account, NULL);
}

int main() {
    // Example usage
    store_password("example-service", "example-account", "example-password");
    gchar *password = retrieve_password("example-service", "example-account");
    g_print("Retrieved password: %s\n", password);
    g_free(password);
    return 0;
}