# Counting It Up

## Authors

Daniel Bohinc, Ben Knox

## Description & Overview

CountingItUpV5 is a java program which uses 64 bit integers to perform combinations. 
The max value for a 64 bit integer being, 9,223,372,036,854,775,807. As you can see by the names of the files,
CountingItUpV5 was our fifth attempt which successfully calculated combinations where the final result would go as 
high as 9,223,372,036,854,775,807. We had multiple other attempts which ran into problems regarding the bit limit  
as well as rounding errors. One attempt could calculate combinations in 5 lines of code however using the data type double meant that
for the extremely large numbers the rounding errors would have caught up and our result was off. 

CountingItUpV4 looked at the greatest common denominator between the current result and the list of numbers of K to 0. The program would divide the result by the gcd and then multiply by the next number in the list n to n - k.
This worked well because in previous implementations we found that our end result would be a fraction and the numerator would exceed the 64 bits that a long holds. How ever this implementation worked well for larger numbers but not so well for lower numbers, which caused this program to not be robust enough to pass AutoJudge. However if we were able to perform the division for this fraction we could have achieved the correct result. After this we focused on completing any potential divisions as early as possible so that the number would not exceed the bit count too early on. 

We finally looked at another solution which was derived from https://en.wikipedia.org/wiki/Binomial_coefficient. This solution was sufficient enough for it to pass AutoJudge.


## Testing

We first started with creating a python script called findMaxNK.py, which printed values for N and K which stayed within the limits of the 64 bit max integer. In hindsight this program was not sufficient enough as it had skipped quite a lot of test cases. The output file was mock.txt, and it only contained about 11 test cases. The additional cases were from requesting clarification on AutoJudge. Though I assumed that only so many values could be within the range of the 64 bit integer cap, and many of the output cases were close to the max number, we though it would be okay. We found that adjusting for the new test cases, we forgot about the lower end cases, which lead us to making a whole new version, going from 4.5 to 5.

## Usage

After downloading the program, you can run it via main from the CountingItUpV5.java file, and input factorials in the terminal.

```Java
javac CountingItUpV5.java
java CountingItUp.java
52 5
```

If you would like you could also use the file scanner to adjust the exampleIn.txt to read the factorials and print them as it scans through the file.

## Installation

Download CountingItUpV5.java from the repo and run through main. 

If you want to run the program with file inputs then also download exampleIn.txt from the repository as well.

----

Option two is to clone the repository, and use the CountingItUpV4.java to run the program.

```bash
cd existing_repo
git remote add origin https://altitude.otago.ac.nz/bohda634/lookwhostalking.git
git branch -M main
git push -uf origin main
```
