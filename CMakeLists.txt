cmake_minimum_required(VERSION 3.10)

# Set the project name and specify C as the language
project(MyProject C)

# Collect all .c files in the directory
file(GLOB_RECURSE SOURCES
    "*.c"
)

# Add an executable target using the collected sources
add_executable(my_program ${SOURCES})

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wno-error")