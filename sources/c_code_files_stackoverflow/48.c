#include <stdio.h>
#include <stdlib.h>

void setAlpha(unsigned char *rgba, int width, int height, int alpha)
{
  int x, y;

  for(y = 0; y < height; y++)
  {
    for(x = 0; x < width; x++, rgba += 4)
    {
      rgba[3] = (unsigned char) alpha;
    }
  }
}

int main()
{
  int width = 2;
  int height = 2;
  int alpha = 128; // Example alpha value
  unsigned char *rgbaBuffer = malloc(width * height * 4); // 4 bytes per pixel (RGBA)

  if (rgbaBuffer == NULL)
  {
    printf("Memory allocation failed\n");
    return 1;
  }

  // Example: Initialize buffer with some values (all zeros for simplicity)
  for (int i = 0; i < width * height * 4; ++i)
  {
    rgbaBuffer[i] = 0;
  }

  // Call the setAlpha function
  setAlpha(rgbaBuffer, width, height, alpha);

  // Print the alpha channel values after modification
  for (int y = 0; y < height; y++)
  {
    for (int x = 0; x < width; x++)
    {
      printf("Alpha value at (%d, %d): %d\n", x, y, rgbaBuffer[(y * width * 4) + (x * 4) + 3]);
    }
  }

  free(rgbaBuffer); // Don't forget to free the allocated memory
  return 0;
}