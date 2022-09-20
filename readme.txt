This project is a word wrapper written in java. The purpose of this program is to delete extra white spaces in a paragraph, keep blank lines and stop when it reads the word "stop". 

1. the algorithm reads a paragraph line by line
2. if the line is blank it prints a blank line
3. if the input is "Stop.", it gets out of the loop
4. then it reads the integer which is the max length typed by user
5. then it gets rid of extra white spaces
6. it then enters a loop to wrap text and checks if the text doesn't exceed the limit yet, it adds it to the line 
and updates its value
7. then it checks for large words by checking the index of the last white space, if it's -1, it prints that new word on a separate 
line and updates its value
8. all values are stored in a buffer and at the end, the buffer is printed