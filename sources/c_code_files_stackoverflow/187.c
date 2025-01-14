#include <unicode/ubrk.h>
#include <php.h>

PHP_FUNCTION(grapheme_substr)
{
    // ... (rest of the function implementation remains the same)

    UBreakIterator* bi;
    // ... (initialize bi)

    // ... (use bi)

    ubrk_close(bi);
    // ... (rest of the function implementation remains the same)
}