----------------------
Description
----------------------
The algo performs plagiarism detection using a N-tuple comparison algorithm allowing for synonyms in the text.

The program takes in 3 required arguments, and one optional.  In other cases such as no arguments, the program prints out usage instructions.
<br>
1) file name for a list of synonyms<br>
2) input file 1<br>
3) input file 2<br>
4) (optional) the number N, the tuple size.  If not supplied, the default should be N=3.<br>

The synonym file has lines each containing one group of synonyms.  For example a line saying "run sprint jog" means these words should be treated as equal.

The input file1 should be declared plagiarized based on the number of N-tuples in file1 that appear in file2 (in other words we are looking for tuples in file1 that matches a source (file2) against which we are checking the percentage of plagarism in file1), where the tuples are compared by accounting for synonyms as described above.  For example, the text "go for a run" (file1) has two 3-tuples, ["go for a", "for a run"] both of which appear in the text "go for a jog" (file2).

The output of the program should be the percent of tuples in file1 which appear in file2.  So for the above example, the output would be one line saying "100%".  In another example, for texts "go for a run" and "went for a jog" and N=3 we would output "50%" because only one tuple in the first text appears in the second one.

----------------
Design Decisions
-----------------
1. Singleton Detector class responsible for detecting the plagiarism based on N-tuple comparison
2. Each Tuple match is counted as matching or not matching and percentage is calculated total number of comparisons that are being made
3. FileHandler class to deal with file I/O specific, is source of input is not file a new Handler can easily be imported and used.
4. TupleMap has value to count for frequency of occurrences that could be used to check against one - one tuple matching (not
really used in this algorithm)

----------
Algorithm
----------
The Algorithm is broken into following main steps<br>
1. Synonym list is broken into HashMap such that all synonyms except the first one point to the first one as (key-value) pair.<br>
2. All synonyms in both the input Strings are replaced using synonym map<br>
3. Second string file is parsed and all tuples are constructed and added to tupleMap.<br>
4. First string file is parsed and all the tuples are checked against tubpleMay Key for matching<br>

-----------
Assumptions
-----------
1. If tuple size is more than number of words in any file than 0% is returned and any incorrect tuble size will result in defaulttuple size
2. Tuple is considered as matching tuple if and only if all the words are same (or synonym) in the exact order
Example "for a run" and "run for a” is not considered as matching tuple
3. Synonym list file is in the correct format.

-----------
Limitations
-----------
1. Only Alpha-Numeric words are considered as a word, everything else is pretty much a word delimiter. In the Detector Class,
there is a constant for regex pattern matching that can be modified to include/exclude to delimiter list.
For example auto-reload is considered as two words instead of one.
2. Multiple language not supported and special characters such as (ê,â etc.) are still considered as word delimiter.
3. Active vs passive sentence structure can still trick the detector
4. Sentence restructuring and copy paste of text are not 100% tracked because some new set of tuples will be created and algorithm 
respect the order of the words in the tuple.

-------------
Alternatives
-------------
1. A seperate class "Tuple" to handle all tuple related operations such as toString(), comparater<>(tuple1, tuple2) and its own
set of operations could have made the design even more flexible and may be better.
