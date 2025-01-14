Function       | Ideological Cost (relative)\n---------------|---------------------------\nstrlen()         | 1                        # Simple memory access\nstrpos()         | n                        # Loop through string where n is length\narray_push()     | 2                        # Add element to end of array\nis_dir('/path')  | m + k                    # Check path validity and existence; m=path complexity, k=system load\nis_file('/path') | m + k                    # Similar to is_dir but checks for file; cost may vary based on disk speed and other factors