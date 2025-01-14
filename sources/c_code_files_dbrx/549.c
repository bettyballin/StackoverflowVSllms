#include <libnotify/notify.h>
#include <gdk-pixbuf/gdk-pixbuf.h>

int main() {
    notify_init("Title");
    NotifyNotification* n = notify_notification_new ("Hi", "This is an example notification.", NULL);

    // optional: choose icon
    const char *icon_path = "/absolute/path/to/my_custom_icon.png";
    GdkPixbufFormat *format;
    format = gdk_pixbuf_get_file_info(icon_path, NULL);
    if (format) {
        GdkPixbuf *pixbuf = gdk_pixbuf_new_from_file(icon_path, NULL);
        notify_notification_set_image_from_pixbuf(n, pixbuf);
        g_object_unref(pixbuf);
        g_free(format);
    } else {
        // fallback to Ubuntu logo if custom icon is missing
        GdkPixbuf *pixbuf = gdk_pixbuf_new_from_file("/usr/share/icons/gnome/scalable/status/gnome-logo-icon.svg", NULL);
        notify_notification_set_image_from_pixbuf(n, pixbuf);
        g_object_unref(pixbuf);
    }

    // optional: specify urgency level and timeout value (seconds)
    notify_notification_set_urgency(n, NOTIFY_URGENCY_NORMAL);
    notify_notification_set_timeout(n, 5000); // milliseconds.  -1 will display the notification indefinitely until clicked or user closed it.

    GError *error = NULL;
    notify_notification_show(n, &error); // shows the notification on screen
    if (error) {
        g_printerr("Error showing notification: %s\n", error->message);
        g_error_free(error);
    }

    notify_uninit();
    return 0;
}