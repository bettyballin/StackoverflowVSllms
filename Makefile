CC = gcc
CFLAGS =-Wall 
SOURCES = $(wildcard sources/*/*.c)
OBJECTS = $(SOURCES:.c=.o)
TARGET = my_program

all: $(TARGET)

$(TARGET): $(OBJECTS)
	$(CC) $(CFLAGS) -o $(TARGET) $(OBJECTS)

%.o: %.c
	-$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(TARGET) $(OBJECTS)