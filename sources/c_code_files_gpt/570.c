#include <ft2build.h>
#include FT_FREETYPE_H

int main() {
    FT_Library ft;
    if (FT_Init_FreeType(&ft)) {
        // Handle error
        return 1;
    }

    FT_Face face;
    if (FT_New_Face(ft, "path/to/font.ttf", 0, &face)) {
        // Handle error
        FT_Done_FreeType(ft);
        return 1;
    }

    FT_Set_Pixel_Sizes(face, 0, 48);

    if (FT_Load_Char(face, 'A', FT_LOAD_RENDER)) {
        // Handle error
        FT_Done_Face(face);
        FT_Done_FreeType(ft);
        return 1;
    }

    // Use face->glyph->bitmap to get the bitmap of the character and render it with OpenGL ES

    FT_Done_Face(face);
    FT_Done_FreeType(ft);
    return 0;
}