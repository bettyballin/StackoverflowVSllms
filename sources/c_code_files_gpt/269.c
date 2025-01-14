#include <libnotify/notify.h>

int main(int argc, char **argv) {
    // Initialize the libnotify library
    notify_init("Sample Application");

    // Create a new notification
    NotifyNotification *notification = notify_notification_new("Hello", "This is a notification.", NULL);

    // Show the notification
    notify_notification_show(notification, NULL);

    // Cleanup and uninitialize the libnotify library
    g_object_unref(G_OBJECT(notification));
    notify_uninit();

    return 0;
}