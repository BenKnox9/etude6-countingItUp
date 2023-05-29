# Authors

Daniel Bohinc, Ben Knox

# Counting It Up


# Description & Overview

CountingItUpV5 is a java program which uses 64 bit integers to perform combinations. 
The max value for a 64 bit integer being, 9,223,372,036,854,775,807. As you can see by the names of the files,
CountingItUpV5 was our fifth attempt which successfully calculated combinations where the final result would go as 
high as 9,223,372,036,854,775,807. We had multiple other attempts which ran into problems regarding the bit limit  
as well as rounding errors. One attempt could calculate combinations in 5 lines of code however using the data type double meant that
for the extremely large numbers the rounding errors would have caught up and our result was off. 

CountingItUpV4 looked at the greatest common denominator between the current result and the list of numbers of K to 0. The program would divide the result by the gcd and then multiply by the next number in the list n to n - k.
This worked well because in previous implementations we found that our end result would be a fraction and the numerator would exceed the 64 bits that a long holds. How ever this implementation worked well for larger numbers but not so well for lower numbers, which caused this program to not be robust enough to pass AutoJudge.

We finally looked at another solution which NEED MORE STUFF HERE

However if we were able to perform the division for this fraction we could have achieved the correct result. After this we focused on completing any potential divisions as early as possible so that the number would not exceed the bit count too early on. 

## Testing

We used the CountingItUpTesting.java program to output a large data set using our program. This testing program started at n = 1 and repeated 10 calculations for each k = 1 up to k = 15. We then averaged the 10 runs and printing this into the file. E.g., n = 52, k = 5, was tested 10 times and the time was measured then averaged over 10.

We noticed that the program 

## Usage

After downloading the program, you can run it via main from the CountingItUpV4.java file, and input factorials in the terminal. E.g., 52 5 would be a valid input.

If you would like you could also use the file scanner to adjust the exampleIn.txt to read the factorials and print them as it scans through the file.

## Installation

Download CountingItUpV4.java from the repo and run through main. 

If you want to run the program with file inputs then also download exampleIn.txt from the repo as well.

----

Option two is to clone the repository, and use the CountingItUpV4.java to run the program.

```bash
cd existing_repo
git remote add origin https://altitude.otago.ac.nz/bohda634/lookwhostalking.git
git branch -M main
git push -uf origin main
```
