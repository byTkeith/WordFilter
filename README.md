# Longest Word Finder

## Author: [Your Name]

This Java program reads a text file containing words and identifies the longest word. It removes punctuation from the words and calculates the length of each word to determine the longest one.

### Usage

1. Compile the `LongestWord.java` file:
   ```bash
   javac LongestWord.java
   ```

2. Run the program:
   ```bash
   java LongestWord
   ```

3. Ensure that the input file (`words.txt`) is in the same directory as the compiled program.

### Input File Format

The input file (`words.txt`) should contain a list of words, one word per line. Punctuation marks within the words will be removed during processing.

### Example Input File (`words.txt`)

```
apple
banana
grapefruit
kiwi
orange
```

### Output

The program identifies the longest word in the input file and prints its position (line number) and length. The result is saved in a new file called `words2.txt`.

Example output in `words2.txt`:

```
The longest word in this text file is [3]
grapefruit with 10 letters.
