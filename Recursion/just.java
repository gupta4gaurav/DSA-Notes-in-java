                                countSubstrs("abcab", 0, 4, 5)
                             /                    \
 countSubstrs("abcab", 1, 4, 4)                   countSubstrs("abcab", 0, 3, 4)
             /            \                      /                   \
countSubstrs("bcab", 2, 4, 3) countSubstrs("abc", 1, 3, 3) countSubstrs("bca", 0, 3, 3) countSubstrs("abc", 1, 2, 3)
          /           \        /          \         /           \        /           \
countSubstrs("cab", 3, 4, 2) countSubstrs("b", 2, 2, 2) countSubstrs("ca", 1, 3, 2) countSubstrs("b", 2, 2, 2) countSubstrs("c", 2, 2, 2) countSubstrs("ab", 1, 1, 2) countSubstrs("bc", 0, 2, 2) countSubstrs("ab", 1, 1, 2)
         /              \          /            \          /              \        /             \           /            \
countSubstrs("a", 4, 4, 1) countSubstrs("", 3, 3, 1) countSubstrs("c", 2, 3, 1) countSubstrs("", 3, 3, 1) countSubstrs("c", 2, 2, 1) countSubstrs("a", 1, 2, 1) countSubstrs("b", 0, 1, 1) countSubstrs("b", 0, 0, 1) countSubstrs("a", 1, 1, 1)
        /                 \         /                \          /               \       /                \         /             \
       1                   1       1                  1        1                 1     1                  1       1               1
