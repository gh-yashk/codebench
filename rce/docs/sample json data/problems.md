# Problems

> POST `/api/problems`

```json
{
  "id": 1,
  "title": "Two Sum",
  "slug": "two-sum",
  "description": "# 1. Two Sum\n\n![Easy](https://img.shields.io/badge/difficulty-easy-brightgreen)\n\nGiven an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to `target`*.\n\nYou may assume that each input has *exactly one solution*, and you may not use the *same element twice*.\n\nReturn the answer in *ascending order*.\n\n## Example 1\n- **Input:** `nums = [2, 7, 11, 15], target = 9`\n- **Output:** `[0, 1]`\n- **Explanation:** `nums[0] + nums[1] == 9`, so return `[0, 1]`.\n\n## Example 2\n- **Input:** `nums = [3, 2, 4], target = 6`\n- **Output:** `[1, 2]`\n\n## Example 3\n- **Input:** `nums = [3, 3], target = 6`\n- **Output:** `[0, 1]`\n\n## Constraints\n- `2 ≤ nums.length ≤ 10⁴`\n- `-10⁹ ≤ nums[i] ≤ 10⁹`\n- `-10⁹ ≤ target ≤ 10⁹`\n- Exactly one valid answer exists.",
  "difficulty": "easy"
}
```

```json
{
  "id": 2,
  "title": "Reverse Integer",
  "slug": "reverse-integer",
  "description": "# 2. Reverse Integer\n\n![Easy](https://img.shields.io/badge/difficulty-easy-brightgreen)\n\nGiven a signed 32-bit integer `x`, return `x` with its digits reversed. If reversing `x` causes the value to go outside the signed 32-bit integer range, return `0`.\n\n## Example 1\n- **Input:** `x = 123`\n- **Output:** `321`\n\n## Example 2\n- **Input:** `x = -123`\n- **Output:** `-321`\n\n## Example 3\n- **Input:** `x = 120`\n- **Output:** `21`\n\n## Constraints\n- `-2³¹ ≤ x ≤ 2³¹ - 1`",
  "difficulty": "easy"
}
```

```json
{
  "id": 3,
  "title": "Palindrome Number",
  "slug": "palindrome-number",
  "description": "# 3. Palindrome Number\n\n![Easy](https://img.shields.io/badge/difficulty-easy-brightgreen)\n\nGiven an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.\n\n## Example 1\n- **Input:** `x = 121`\n- **Output:** `true`\n\n## Example 2\n- **Input:** `x = -121`\n- **Output:** `false`\n\n## Example 3\n- **Input:** `x = 10`\n- **Output:** `false`\n\n## Constraints\n- `-2³¹ ≤ x ≤ 2³¹ - 1`",
  "difficulty": "easy"
}
```

```json
{
  "id": 4,
  "title": "Valid Parentheses",
  "slug": "valid-parentheses",
  "description": "# 4. Valid Parentheses\n\n![Easy](https://img.shields.io/badge/difficulty-easy-brightgreen)\n\nGiven a string `s` containing just the characters `'(', ')', '{', '}', '['` and `']'`, determine if the input string is valid.\n\nAn input string is valid if:\n- Open brackets are closed by the same type of brackets.\n- Open brackets are closed in the correct order.\n\n## Example 1\n- **Input:** `s = \"()\"`\n- **Output:** `true`\n\n## Example 2\n- **Input:** `s = \"()[]{}\"`\n- **Output:** `true`\n\n## Example 3\n- **Input:** `s = \"(]\"`\n- **Output:** `false`\n\n## Constraints\n- `1 ≤ s.length ≤ 10⁴`\n- `s` consists of parentheses only: `'()[]{}'`",
  "difficulty": "easy"
}
```

```json
{
  "id": 5,
  "title": "Merge Two Sorted Lists",
  "slug": "merge-two-sorted-lists",
  "description": "# 5. Merge Two Sorted Lists\n\n![Easy](https://img.shields.io/badge/difficulty-easy-brightgreen)\n\nYou are given the heads of two sorted linked lists `list1` and `list2`. Merge the two lists into one sorted list and return the head.\n\n## Example 1\n- **Input:** `list1 = [1,2,4], list2 = [1,3,4]`\n- **Output:** `[1,1,2,3,4,4]`\n\n## Example 2\n- **Input:** `list1 = [], list2 = []`\n- **Output:** `[]`\n\n## Example 3\n- **Input:** `list1 = [], list2 = [0]`\n- **Output:** `[0]`\n\n## Constraints\n- The number of nodes in both lists is in the range `[0, 50]`.\n- `-100 ≤ Node.val ≤ 100`",
  "difficulty": "easy"
}
```

```json
{
  "id": 6,
  "title": "Longest Substring Without Repeating Characters",
  "slug": "longest-substring-without-repeating-characters",
  "description": "# 6. Longest Substring Without Repeating Characters\n\n![Medium](https://img.shields.io/badge/difficulty-medium-yellow)\n\nGiven a string `s`, find the length of the longest substring without repeating characters.\n\n## Example 1\n- **Input:** `s = \"abcabcbb\"`\n- **Output:** `3`\n\n## Example 2\n- **Input:** `s = \"bbbbb\"`\n- **Output:** `1`\n\n## Example 3\n- **Input:** `s = \"pwwkew\"`\n- **Output:** `3`\n\n## Constraints\n- `0 ≤ s.length ≤ 5 * 10⁴`\n- `s` consists of English letters, digits, symbols and spaces.",
  "difficulty": "medium"
}
```

```json
{
  "id": 7,
  "title": "Group Anagrams",
  "slug": "group-anagrams",
  "description": "# 7. Group Anagrams\n\n![Medium](https://img.shields.io/badge/difficulty-medium-yellow)\n\nGiven an array of strings `strs`, group the anagrams together.\n\nYou can return the answer in any order.\n\n## Example 1\n- **Input:** `strs = [\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"]`\n- **Output:** `[[\"eat\",\"tea\",\"ate\"],[\"tan\",\"nat\"],[\"bat\"]]`\n\n## Constraints\n- `1 ≤ strs.length ≤ 10⁴`\n- `0 ≤ strs[i].length ≤ 100`\n- `strs[i]` consists of lowercase English letters.",
  "difficulty": "medium"
}
```

```json
{
  "id": 8,
  "title": "Median of Two Sorted Arrays",
  "slug": "median-of-two-sorted-arrays",
  "description": "# 8. Median of Two Sorted Arrays\n\n![Hard](https://img.shields.io/badge/difficulty-hard-red)\n\nGiven two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the median of the two sorted arrays.\n\nThe overall run time complexity should be `O(log (m+n))`.\n\n## Example 1\n- **Input:** `nums1 = [1,3], nums2 = [2]`\n- **Output:** `2.0`\n\n## Example 2\n- **Input:** `nums1 = [1,2], nums2 = [3,4]`\n- **Output:** `2.5`\n\n## Constraints\n- `nums1.length == m`\n- `nums2.length == n`\n- `0 ≤ m, n ≤ 1000`\n- `1 ≤ m + n ≤ 2000`\n- `-10⁶ ≤ nums1[i], nums2[i] ≤ 10⁶`",
  "difficulty": "hard"
}
```

```json
{
  "id": 9,
  "title": "Trapping Rain Water",
  "slug": "trapping-rain-water",
  "description": "# 9. Trapping Rain Water\n\n![Hard](https://img.shields.io/badge/difficulty-hard-red)\n\nGiven `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.\n\n## Example 1\n- **Input:** `height = [0,1,0,2,1,0,1,3,2,1,2,1]`\n- **Output:** `6`\n\n## Example 2\n- **Input:** `height = [4,2,0,3,2,5]`\n- **Output:** `9`\n\n## Constraints\n- `n == height.length`\n- `1 ≤ n ≤ 2 * 10⁴`\n- `0 ≤ height[i] ≤ 10⁵`",
  "difficulty": "hard"
}
```

```json
{
  "id": 10,
  "title": "N-Queens",
  "slug": "n-queens",
  "description": "# 10. N-Queens\n\n![Hard](https://img.shields.io/badge/difficulty-hard-red)\n\nThe n-queens puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.\n\nGiven an integer `n`, return all distinct solutions to the n-queens puzzle.\n\nEach solution contains a distinct board configuration of the n-queens' placement, where `'Q'` and `'.'` both indicate a queen and an empty space respectively.\n\n## Example\n- **Input:** `n = 4`\n- **Output:** `[[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]`\n\n## Constraints\n- `1 ≤ n ≤ 9`",
  "difficulty": "hard"
}
```

```json
{
  "id": 11,
  "title": "3Sum",
  "slug": "3sum",
  "description": "# 11. 3Sum\n\n![Medium](https://img.shields.io/badge/difficulty-medium-yellow)\n\nGiven an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.\n\nNotice that the solution set must not contain duplicate triplets.\n\n## Example 1\n- **Input:** `nums = [-1,0,1,2,-1,-4]`\n- **Output:** `[[-1,-1,2],[-1,0,1]]`\n\n## Example 2\n- **Input:** `nums = []`\n- **Output:** `[]`\n\n## Constraints\n- `3 ≤ nums.length ≤ 3000`\n- `-10⁵ ≤ nums[i] ≤ 10⁵`",
  "difficulty": "medium"
}
```
