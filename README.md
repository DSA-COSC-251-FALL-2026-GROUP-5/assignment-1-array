# Running the program

## Mac or Linux

So if you're on Mac or something, just do:

```
./build
```

then to run

```
./run OrderedArray
```

or

```
./run UnorderedArray
```

## Windows

idk...

# TODO

- [] write a robust `junit` tests for all methods
- [x] create `UnorderedArray` class
- [x] create `OrderedArray` class
- [x] structure everything correctly
- [] fullfill the following project requirements:

## Project requirements

Be sure to consider the time complexity of each method to receive full credit. Review Chapter 2 and
ensure you understand the differences between an unordered array and an ordered array.

Project Requirements:

~~1. Both classes should include an integer array Integer[] arr as a member variable. Elements
may be set to null to indicate unused positions. Additional member variables may be added if
necessary.~~

~~2. Both classes should have a constructor that accepts an integer parameter used to initialize the size
of arr[].~~

3. Both classes should implement an insert(int x) method to insert an integer into arr[]. If the
array is full, the method should automatically resize the array.

~~- unordered array~~
- ordered array

~~4. Both classes should implement a delete(int x) method that removes the first occurrence of an
integer from arr[] if it exists and returns true. If the integer does not exist, the method should
return false. After deletion, remaining elements should shift left so that all non-null elements
remain contiguous.~~

5. Both classes should implement a find(int x) method that searches for an integer in arr[]. If
the integer exists, return its index; otherwise, return -1.

~~- unordered array~~
- ordered array

~~6. Both classes should implement a get(int index) method that returns the integer at the given in-
dex in arr[]. If the index is out of bounds, the method should throw an IndexOutOfBoundsException.
The method may return null if no element exists at that position.~~
~~TODO: test it~~

~~7. Both classes should implement a size() method that returns the total capacity of arr[].~~

~~TODO: test it~~

~~8. Both classes should implement a count() method that returns the number of non-null elements
currently stored in arr[].~~

~~TODO: test it~~

~~9. Both classes should implement a resize(int newSize) method that changes the size of arr[] to
newSize. Existing elements and their order should be preserved as much as possible. Any elements
beyond the new size should be discarded.~~

10. In UnorderedArray, arr[] remains unsorted. In OrderedArray, arr[] must always remain sorted
in ascending order.

11. Each method must include a short comment specifying and explaining its time complexity.
