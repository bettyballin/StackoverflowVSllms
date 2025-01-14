pp
#include <boost/gil/gil_all.hpp>
#include <boost/gil/extension/io/jpeg.hpp>

int main() {
    const char *filename = "image.jpg";
    boost::gil::jpeg_read_dimensions(filename);
    return 0;
}