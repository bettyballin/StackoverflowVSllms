convert base_image.jpg \\n \( -size 800x600 xc:none \) \               # Create a transparent canvas\n -font TT0590M_.ttf \\n -fill gray30 \\n -draw 'text 72,32 "ABCDEFGHIJKLM"' \        # Draw text for the shadow\n -blur 0x4 \                                  # Blur only this layer\n \( -size 800x600 xc:none \) \               # Create another transparent canvas\n -font TT0590M_.ttf \\n -fill white \\n -draw 'text 72,27 "ABCDEFGHIJKLM"' \        # Draw the main text on top\n -composite \                               # Composite with the blurred shadow\n result.png