cmake_minimum_required(VERSION 3.10)

# Set the project name
project(StackoverflowProject)

# Set the C++ standard
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED True)

# Specify the source files directory
set(SOURCE_DIR cpp_code_files_stackoverflow)

# Find all .cpp files in the source directory
file(GLOB SOURCES "${SOURCE_DIR}/*.cpp")

set(VALID_SOURCES)

# Loop through each source file to test compile
foreach(SOURCE_FILE ${SOURCES})
    # Create a temporary target for testing compilation
    try_compile(COMPILE_RESULT "${CMAKE_BINARY_DIR}/temp"
        "${SOURCE_FILE}"
        CMAKE_FLAGS "-DCMAKE_CXX_STANDARD=11"
    )

    # If compile was successful, add to VALID_SOURCES
    if(COMPILE_RESULT)
        list(APPEND VALID_SOURCES "${SOURCE_FILE}")
    else()
        message(WARNING "Skipping uncompilable file: ${SOURCE_FILE}")
    endif()
endforeach()

# Create the executable with valid source files
foreach(VALID_SOURCE ${VALID_SOURCES})
    get_filename_component(FILE_NAME ${VALID_SOURCE} NAME_WE)
    add_executable(${FILE_NAME} ${VALID_SOURCE})
endforeach()