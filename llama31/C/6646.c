#include <gtk/gtk.h>\n#include <gdk-pixbuf/gdk-pixbuf.h>\n\n// ...\n\nGdkPixbuf *pixbuf = gdk_pixbuf_new_from_file("image.png", NULL);\ngdk_pixbuf_saturate_and_pixelate(pixbuf, 0.5, FALSE);\ngdk_pixbuf_scale(pixbuf, 128, 128, GDK_INTERP_BILINEAR, 0, 0, 128, 128);\n\n// ...