#include <string>
#include <glibmm/ustring.h>

// Function to replace all occurrences of 'search' with 'replace' in 'subject'
template <typename T>
T replace_all(T const& search, T const& replace, T const& subject) {
    T result = subject;
    size_t pos = 0;
    while ((pos = result.find(search)) != T::npos) {
        result.replace(pos, search.length(), replace);
        pos += replace.length();
    }
    return result;
}

// Explicit instantiation for std::string
template std::string replace_all<std::string>(std::string const& search,
                                              std::string const& replace,
                                              std::string const& subject);

// Explicit instantiation for Glib::ustring
template Glib::ustring replace_all<Glib::ustring>(Glib::ustring const& search,
                                                  Glib::ustring const& replace,
                                                  Glib::ustring const& subject);