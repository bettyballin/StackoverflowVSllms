#define stackSize 16777218\nint stack[stackSize];\nint stackPointer = -1;\n\nstatic bool pop(int *x, int *y, int h) { \n    if (stackPointer >= 0) { \n        int p = stack[stackPointer]; \n        *x = p / h; \n        *y = p % h; \n        stackPointer--; \n        return true; \n    } else { \n        return false;\n    } \n}\n\nstatic bool push(int x, int y, int h) { \n    if (stackPointer < stackSize - 1) { \n        stackPointer++; \n        stack[stackPointer] = h * x + y; \n        return true;\n    } else { \n        return false;\n    } \n}\n\nstatic void emptyStack() { \n    stackPointer = -1;\n}\n\nvoid scan_fill_do_action(int x, int y, texture_info *tex, VALUE hash_arg, sync sync_mode, bool primary, action_struct *payload) {\n    action_struct cur;\n    rgba old_color;\n    int y1;\n    bool spanLeft, spanRight;\n\n    if (!bound_by_rect(x, y, 0, 0, tex->width - 1, tex->height - 1)) return;\n\n    draw_prologue(&cur, tex, 0, 0, 1024, 1024, &hash_arg, sync_mode, primary, &payload);\n\n    old_color = get_pixel_color(tex, x, y);\n\n    if (cmp_color(old_color, cur.color)) return;\n\n    emptyStack();\n\n    if (!push(x, y, tex->width)) return;\n\n    while (pop(&x, &y, tex->width)) { \n        y1 = y;\n        while (y1 >= 0 && cmp_color(old_color, get_pixel_color(tex, x, y1))) y1--;\n        y1++;\n        spanLeft = spanRight = false;\n        while (y1 < tex->height && cmp_color(old_color, get_pixel_color(tex, x, y1))) {\n            set_pixel_color_with_style(payload, tex, x, y1);\n\n            if (!spanLeft && x > 0 && cmp_color(old_color, get_pixel_color(tex, x - 1, y1))) { \n                if (!push(x - 1, y1, tex->width)) return;\n                spanLeft = true;\n            } else if (spanLeft && x > 0 && !cmp_color(old_color, get_pixel_color(tex, x - 1, y1))) {\n                spanLeft = false;\n            }\n\n            if (!spanRight && x < tex->width - 1 && cmp_color(old_color, get_pixel_color(tex, x + 1, y1))) { \n                if (!push(x + 1, y1, tex->width)) return;\n                spanRight = true;\n            } else if (spanRight && x < tex->width - 1 && !cmp_color(old_color, get_pixel_color(tex, x + 1, y1))) {\n                spanRight = false;\n            }\n            y1++;\n        }\n    }\n    draw_epilogue(&cur, tex, primary);\n}