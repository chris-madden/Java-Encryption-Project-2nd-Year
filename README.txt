Java Encryption Project

This program only encrypts, it doesn't decrypt.

Encryption only works if codeword has no duplicates, all letters must be different.

Program has 2 classes, TestRunner and Encoding.

User enters name of file they want to encrypt.

User is asked for a codeword which is used to encrypt file.

File is read in line by line and each line is encoded and encrypted singly. 

Encoding is done using a HashMap.

To make up for the extra characters contained in the war and peace file, 2 new letters were added to the polybius, Z and J.

Each line is made into a 2D array and correct letter is found and written to a txt file called Encryption.

Encryption speed relies on length of codeword.

Speeds range from 1 second (2 letter codeword) to 3 seconds (26 letter codeword)

