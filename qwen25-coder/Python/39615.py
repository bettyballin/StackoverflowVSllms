import svgpathtools\n\ndef svg_to_html_map(svg_file, html_id="ceemap"):\n    paths, attributes, svg_canvas = svgpathtools.svg2paths(\n        svg_file,\n        return_svg_attributes=True)\n    \n    print(f'<map id="{html_id}" name="{html_id}">')\n    for i, path in enumerate(paths):\n        coords = ' '.join([f"{int(p.real)},{int(p.imag)}" for p in path.vertices()])\n        # Replace with actual link and alt text\n        href = f"country_{i}.html"\n        alt = f"Country {i}"\n        print(f'<area shape="poly" coords="{coords}" href="{href}" target="_blank" alt="{alt}" />')\n    print('</map>')\n\n# Example usage:\nsvg_to_html_map('CEEmap.svg')