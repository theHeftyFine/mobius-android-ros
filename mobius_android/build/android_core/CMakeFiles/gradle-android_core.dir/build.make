# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 2.8

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list

# Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/student/Mobius_DLC/mobius-android-ros/mobius_android/src

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/student/Mobius_DLC/mobius-android-ros/mobius_android/build

# Utility rule file for gradle-android_core.

# Include the progress variables for this target.
include android_core/CMakeFiles/gradle-android_core.dir/progress.make

android_core/CMakeFiles/gradle-android_core:
	cd /home/student/Mobius_DLC/mobius-android-ros/mobius_android/src/android_core && ROS_MAVEN_REPOSITORY=https://github.com/rosjava/rosjava_mvn_repo/raw/master /home/student/Mobius_DLC/mobius-android-ros/mobius_android/build/catkin_generated/env_cached.sh /home/student/Mobius_DLC/mobius-android-ros/mobius_android/src/android_core/gradlew assembleRelease uploadArchives

gradle-android_core: android_core/CMakeFiles/gradle-android_core
gradle-android_core: android_core/CMakeFiles/gradle-android_core.dir/build.make
.PHONY : gradle-android_core

# Rule to build all files generated by this target.
android_core/CMakeFiles/gradle-android_core.dir/build: gradle-android_core
.PHONY : android_core/CMakeFiles/gradle-android_core.dir/build

android_core/CMakeFiles/gradle-android_core.dir/clean:
	cd /home/student/Mobius_DLC/mobius-android-ros/mobius_android/build/android_core && $(CMAKE_COMMAND) -P CMakeFiles/gradle-android_core.dir/cmake_clean.cmake
.PHONY : android_core/CMakeFiles/gradle-android_core.dir/clean

android_core/CMakeFiles/gradle-android_core.dir/depend:
	cd /home/student/Mobius_DLC/mobius-android-ros/mobius_android/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/student/Mobius_DLC/mobius-android-ros/mobius_android/src /home/student/Mobius_DLC/mobius-android-ros/mobius_android/src/android_core /home/student/Mobius_DLC/mobius-android-ros/mobius_android/build /home/student/Mobius_DLC/mobius-android-ros/mobius_android/build/android_core /home/student/Mobius_DLC/mobius-android-ros/mobius_android/build/android_core/CMakeFiles/gradle-android_core.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : android_core/CMakeFiles/gradle-android_core.dir/depend

