cmake_minimum_required(VERSION 3.10)

# Set the project name and specify C as the language
project(MyProject C)

# Collect all .c files in the sources/dbrx directory
file(GLOB_RECURSE DBRX_SOURCES "sources/c_code_files_dbrx/*.c")

# Create executables for each source file that contains a main function
foreach(SOURCE ${DBRX_SOURCES})
    get_filename_component(FILENAME ${SOURCE} NAME)
    get_filename_component(NAME ${SOURCE} NAME_WE)

    # Read the content of the source file
    file(READ ${SOURCE} CONTENT)

    # Check if the file contains a main function
    if(CONTENT MATCHES "int\\s+main\\s*\\(")
        message(STATUS "Adding executable for: ${FILENAME}")
        add_executable(${NAME} ${SOURCE})
    else()
        message(STATUS "Skipping non-executable file: ${FILENAME}")
    endif()
endforeach()

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wno-error")