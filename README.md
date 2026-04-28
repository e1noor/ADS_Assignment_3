I chose three algorithms for this assignment.

Basic sorting: Bubble Sort  
Advanced sorting: Heap Sort  
Searching: Binary Search

I tested them on random and sorted arrays of sizes 10, 100, and 1000. I measured execution time using System.nanoTime().

Here is my output:

![output](output.png)



What I learned:

Heap Sort is faster than Bubble Sort, especially when the array is large. This matches O(n log n) vs O(n²). Bubble Sort works better on sorted data, but still slow. Heap Sort performs well on both random and sorted arrays.

Binary Search is very fast (O(log n)). It works only on sorted arrays because it needs to divide the search space in half.

Overall, the results match the expected Big-O complexity.

![main](<img width="1920" height="1080" alt="main" src="https://github.com/user-attachments/assets/09a82640-6220-4a73-9435-b5ca210456ee" />)

![sorter_1](<img width="1920" height="1080" alt="sorter_2" src="https://github.com/user-attachments/assets/df69c6a0-49c6-4ea8-8fcd-4f8f109c45be" />)

![sorter_2](<img width="1920" height="1080" alt="sorter_1" src="https://github.com/user-attachments/assets/f03abcac-28ca-474c-9cb6-b48ca667da3a" />)

![searcher](<img width="1920" height="1080" alt="experiment_1" src="https://github.com/user-attachments/assets/24ec615e-74ad-4748-8587-92a12a58e946" />)

![experiment_1](<img width="1920" height="1080" alt="searcher" src="https://github.com/user-attachments/assets/0a7eee6c-cdf3-4464-b38a-3a1d31b71673" />)

![experiment_2](<img width="1920" height="1080" alt="experiment_2" src="https://github.com/user-attachments/assets/cc8df8cf-8630-460e-b101-49610fe35640" />)
