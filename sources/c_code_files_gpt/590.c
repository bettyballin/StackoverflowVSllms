#include <libssh/libssh.h>
#include <libssh/sftp.h>
#include <stdio.h>

int main() {
    ssh_session session;
    ssh_channel channel;
    sftp_session sftp;

    // Initialize the SSH session
    ssh_init();

    // Create a new SSH session
    session = ssh_new();

    // Set the host and port for the SSH connection
    ssh_options_set(session, SSH_OPTIONS_HOST, "example.com");
    ssh_options_set(session, SSH_OPTIONS_PORT, "22");

    // Connect to the SSH server
    if (ssh_connect(session)) {
        fprintf(stderr, "Connection failed : %s\n", ssh_get_error(session));
        return -1;
    }

    // Authenticate with the SSH server
    if (ssh_userauth_password(session, NULL, "password")) {
        fprintf(stderr, "Authentication failed : %s\n", ssh_get_error(session));
        return -1;
    }

    // Create a new SFTP session
    sftp = sftp_new(session);

    // Initialize the SFTP session
    if (sftp_init(sftp)) {
        fprintf(stderr, "SFTP initialization failed : %s\n", ssh_get_error(session));
        return -1;
    }

    // Use the SFTP session here...

    // Close the SFTP session
    sftp_free(sftp);

    // Close the SSH session
    ssh_disconnect(session, SSH_DISCONNECT_BY_APPLICATION);
    ssh_free(session);

    // Shutdown the SSH library
    ssh_finalize();

    return 0;
}