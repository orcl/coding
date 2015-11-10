
    Dynamic programming:
        1. transform a big problem into smaller problems.
           from size n-1  to size = n, how to solve big problem with smaller problem solutions.
            
        difference between DP and recursion:
            recursion solve problem from big to small. dont record any intermediate temporary result
                recursive rule
                base case
            
            DP solves problem from small to big, record intermediate result
            from size(<n) subsolutions to size(n) solution
            base case
                
                    
    DP usuall problems:
        one dimensional original data (such as a rope, a word, a piece of wood), want MAX or MIN (cut, merge, etc.)
        1.1 if the weight of each smallest element in the original data is identical/similar
            1.1.1 e.g. identical: 1 meter of rope
            1.1.2 e.g. similar:   a letter, a number
        then this kind of problem is usually simple:
            Linear scan and look back to the previous element(s).

        for example:
            Longest Ascending Subarray (when at i, look back at i-1)
            Longest ascending subsequence ( when at i, look back at 1.... i-1)
            cut rope
            cut palindrome

    1.2 if the weight are not the same
        1.2.1  e.g. DP1 
        1.2.2 e.g. cut the wood
        expand from the center, [index=0,1,2,3,n-1], for each M[i,j], we usually need to try out all possible k that (i<k<j),
        M[i,j] = max(M[i,k]



