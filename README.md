# Impledge_Assignment

 Compounded Word Finder

## Overview

This Java program reads a list of words from a file, identifies the longest and second-longest compounded words, and measures the time taken to process the input.

## Execution
1. **Clone Repository:**
   ```bash
   git clone <repository-url>
2. Navigate to Directory:
   cd <repository-directory>
## Approach
Approach:

    **Input Reading:
        The program starts by reading words from an input file (input_02.txt).
        It uses a Scanner to read lines from the file and stores them in a List<String> named rkwords.

    **Sorting:
        The list of words (rkwords) is then sorted in descending order of length using Comparator.comparingInt(String::length).reversed().

    **Set Initialization:
        A HashSet named rkwordSets is created from the sorted list (rkwords). This set is used to efficiently check word presence.

    **Finding Longest Compounded Word:
        The method findLongestCompoundedWord iterates through the sorted words to find the longest compounded word.
        It uses the method isCompoundedWord to check if a word is compounded.

    **Finding Second Longest Compounded Word:
        The method findSecondLongestCompoundedWord iterates through the sorted words to find the second longest compounded word.
        It uses a counter (count) to keep track and returns the second compounded word when count reaches 2.

    **Checking Compounded Word:
        The method isCompoundedWord recursively checks if a given word is compounded.
        It removes the current word from the set (wordSet) to prevent self-matching.
        It then checks if the word can be split into two compounded parts, using recursion if needed.

    **Output:
        The program prints the longest and second-longest compounded words, along with the time taken for processing.

Design Decisions:

    **Efficiency:
        The use of a HashSet improves efficiency in checking word presence.
        Sorting words by length aids in efficiently identifying compounded words.

    **Readability:
        The code uses clear variable names (rkwords, rkwordSets, etc.) to enhance readability.
        Methods are designed to perform specific tasks, improving code organization.

    **Simplicity:
        The recursive approach for checking compounded words is simple and effective.

    **Timing:
        The program measures the time taken for processing using System.currentTimeMillis().

Potential Improvements:

    **Optimization:
        Depending on the size of the input, further optimizations may be considered.

    **Error Handling:
        Adding error handling for file reading and potential exceptions.

    **Testing:
        Comprehensive testing with various input scenarios.
