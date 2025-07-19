-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: rce_db
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `codes`
--

DROP TABLE IF EXISTS `codes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `codes` (
  `mode` varchar(255) DEFAULT NULL,
  `starter_code` text NOT NULL,
  `wrapper` text NOT NULL,
  `problem_id` bigint NOT NULL,
  `lang_id` bigint NOT NULL,
  PRIMARY KEY (`lang_id`,`problem_id`),
  KEY `FKlc14we0s63jc17kplljlfouer` (`problem_id`),
  CONSTRAINT `FKhjj2fehncqannttfr5y1sgcpy` FOREIGN KEY (`lang_id`) REFERENCES `languages` (`id`),
  CONSTRAINT `FKlc14we0s63jc17kplljlfouer` FOREIGN KEY (`problem_id`) REFERENCES `problems` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codes`
--

LOCK TABLES `codes` WRITE;
/*!40000 ALTER TABLE `codes` DISABLE KEYS */;
INSERT INTO `codes` VALUES ('prepend','class Solution {\n    public int[] twoSum(int[] nums, int target) {\n        // your code here\n        return new int[]{};\n    }\n}','import java.util.*;\nimport java.util.stream.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        String listLine = scanner.nextLine();\n        int target = Integer.parseInt(scanner.nextLine());\n\n        int[] nums = Arrays.stream(\n            listLine.replaceAll(\"[\\\\[\\\\] ]\", \"\").split(\",\")\n        ).mapToInt(Integer::parseInt).toArray();\n\n        Solution sol = new Solution();\n        int[] result = sol.twoSum(nums, target);\n        System.out.println(Arrays.toString(result));\n    }\n}',1,62),('prepend','class Solution {\n    public int reverse(int x) {\n        // your code here\n        return 0;\n    }\n}','import java.util.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        int x = Integer.parseInt(scanner.nextLine());\n        Solution sol = new Solution();\n        int result = sol.reverse(x);\n        System.out.println(result);\n    }\n}',2,62),('prepend','class Solution {\n    public boolean isPalindrome(int x) {\n        // your code here\n        return false;\n    }\n}','import java.util.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        int x = Integer.parseInt(scanner.nextLine());\n        Solution sol = new Solution();\n        boolean result = sol.isPalindrome(x);\n        System.out.println(result);\n    }\n}',3,62),('prepend','class Solution {\n    public boolean isValid(String s) {\n        // your code here\n        return false;\n    }\n}','import java.util.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        String s = scanner.nextLine();\n        Solution sol = new Solution();\n        boolean result = sol.isValid(s);\n        System.out.println(result);\n    }\n}',4,62),('prepend','class ListNode {\n    int val;\n    ListNode next;\n    ListNode(int val) { this.val = val; }\n}\n\nclass Solution {\n    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {\n        // your code here\n        return null;\n    }\n}','import java.util.*;\n\npublic class Main {\n    static ListNode buildList(String input) {\n        input = input.replaceAll(\"[\\\\[\\\\] ]\", \"\");\n        if (input.isEmpty()) return null;\n        String[] nums = input.split(\",\");\n        ListNode dummy = new ListNode(0);\n        ListNode curr = dummy;\n        for (String num : nums) {\n            curr.next = new ListNode(Integer.parseInt(num));\n            curr = curr.next;\n        }\n        return dummy.next;\n    }\n\n    static void printList(ListNode head) {\n        List<Integer> list = new ArrayList<>();\n        while (head != null) {\n            list.add(head.val);\n            head = head.next;\n        }\n        System.out.println(list);\n    }\n\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        ListNode list1 = buildList(scanner.nextLine());\n        ListNode list2 = buildList(scanner.nextLine());\n        Solution sol = new Solution();\n        ListNode merged = sol.mergeTwoLists(list1, list2);\n        printList(merged);\n    }\n}',5,62),('prepend','class Solution {\n    public int lengthOfLongestSubstring(String s) {\n        // your code here\n        return 0;\n    }\n}','import java.util.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        String s = scanner.nextLine();\n        Solution sol = new Solution();\n        int result = sol.lengthOfLongestSubstring(s);\n        System.out.println(result);\n    }\n}',6,62),('prepend','class Solution {\n    public List<List<String>> groupAnagrams(String[] strs) {\n        Map<String, List<String>> map = new HashMap<>();\n        for (String str : strs) {\n            char[] chars = str.toCharArray();\n            Arrays.sort(chars);\n            String key = new String(chars);\n            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);\n        }\n        return new ArrayList<>(map.values());\n    }\n}','import java.util.*;\nimport java.util.stream.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        String line = scanner.nextLine();\n        String[] strs = line.replaceAll(\"[\\\\[\\\\]\"]\", \"\").split(\",\");\n        Solution sol = new Solution();\n        List<List<String>> result = sol.groupAnagrams(strs);\n        System.out.println(result);\n    }\n}',7,62),('prepend','class Solution {\n    public double findMedianSortedArrays(int[] nums1, int[] nums2) {\n        int[] merged = new int[nums1.length + nums2.length];\n        System.arraycopy(nums1, 0, merged, 0, nums1.length);\n        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);\n        Arrays.sort(merged);\n        int n = merged.length;\n        if (n % 2 == 0) {\n            return (merged[n/2 - 1] + merged[n/2]) / 2.0;\n        } else {\n            return merged[n/2];\n        }\n    }\n}','import java.util.*;\nimport java.util.stream.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        int[] nums1 = Arrays.stream(scanner.nextLine().replaceAll(\"[\\\\[\\\\] ]\", \"\").split(\",\"))\n                           .filter(s -> !s.isEmpty())\n                           .mapToInt(Integer::parseInt).toArray();\n        int[] nums2 = Arrays.stream(scanner.nextLine().replaceAll(\"[\\\\[\\\\] ]\", \"\").split(\",\"))\n                           .filter(s -> !s.isEmpty())\n                           .mapToInt(Integer::parseInt).toArray();\n        Solution sol = new Solution();\n        double result = sol.findMedianSortedArrays(nums1, nums2);\n        System.out.println(result);\n    }\n}',8,62),('prepend','class Solution {\n    public int trap(int[] height) {\n        int left = 0, right = height.length - 1;\n        int leftMax = 0, rightMax = 0, water = 0;\n        while (left < right) {\n            if (height[left] < height[right]) {\n                leftMax = Math.max(leftMax, height[left]);\n                water += leftMax - height[left];\n                left++;\n            } else {\n                rightMax = Math.max(rightMax, height[right]);\n                water += rightMax - height[right];\n                right--;\n            }\n        }\n        return water;\n    }\n}','import java.util.*;\nimport java.util.stream.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        int[] height = Arrays.stream(scanner.nextLine().replaceAll(\"[\\\\[\\\\] ]\", \"\").split(\",\"))\n                            .filter(s -> !s.isEmpty())\n                            .mapToInt(Integer::parseInt).toArray();\n        Solution sol = new Solution();\n        int result = sol.trap(height);\n        System.out.println(result);\n    }\n}',9,62),('prepend','class Solution {\n    public List<List<String>> solveNQueens(int n) {\n        // your code here\n        return new ArrayList<>();\n    }\n}','import java.util.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        int n = Integer.parseInt(scanner.nextLine());\n        Solution sol = new Solution();\n        List<List<String>> result = sol.solveNQueens(n);\n        System.out.println(result);\n    }\n}',10,62),('prepend','class Solution {\n    public List<List<Integer>> threeSum(int[] nums) {\n        // your code here\n        return new ArrayList<>();\n    }\n}','import java.util.*;\nimport java.util.stream.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        int[] nums = Arrays.stream(scanner.nextLine().replaceAll(\"[\\[\\] ]\", \"\").split(\",\"))\n                           .filter(s -> !s.isEmpty())\n                           .mapToInt(Integer::parseInt).toArray();\n        Solution sol = new Solution();\n        List<List<Integer>> result = sol.threeSum(nums);\n        System.out.println(result);\n    }\n}',11,62),('append','def two_sum(nums, target):\n    # your code here\n    return []','import sys\nimport json\n\nif __name__ == \'__main__\':\n    lines = sys.stdin.read().splitlines()\n    nums = json.loads(lines[0])\n    target = int(lines[1])\n    result = two_sum(nums, target)\n    print(result)',1,71),('append','def reverse(x):\n    # your code here\n    return 0','import sys\n\nif __name__ == \'__main__\':\n    x = int(sys.stdin.read())\n    result = reverse(x)\n    print(result)',2,71),('append','def is_palindrome(x):\n    # your code here\n    return False','import sys\n\nif __name__ == \'__main__\':\n    x = int(sys.stdin.read())\n    result = is_palindrome(x)\n    print(result)',3,71),('append','def is_valid(s):\n    # your code here\n    return False','import sys\n\nif __name__ == \'__main__\':\n    s = sys.stdin.read().strip()\n    result = is_valid(s)\n    print(result)',4,71),('append','class ListNode:\n    def __init__(self, val=0, next=None):\n        self.val = val\n        self.next = next\n\ndef merge_two_lists(list1, list2):\n    # your code here\n    return None','import sys\nimport json\n\nclass ListNode:\n    def __init__(self, val=0, next=None):\n        self.val = val\n        self.next = next\n\ndef build_list(arr):\n    dummy = ListNode(0)\n    current = dummy\n    for num in arr:\n        current.next = ListNode(num)\n        current = current.next\n    return dummy.next\n\ndef print_list(head):\n    out = []\n    while head:\n        out.append(head.val)\n        head = head.next\n    print(out)\n\nif __name__ == \'__main__\':\n    lines = sys.stdin.read().splitlines()\n    list1 = build_list(json.loads(lines[0]))\n    list2 = build_list(json.loads(lines[1]))\n    merged = merge_two_lists(list1, list2)\n    print_list(merged)',5,71),('append','def length_of_longest_substring(s):\n    # your code here\n    return 0','import sys\n\nif __name__ == \'__main__\':\n    s = sys.stdin.read().strip()\n    result = length_of_longest_substring(s)\n    print(result)',6,71),('append','def group_anagrams(strs):\n    # your code here\n    return []','import sys\nimport json\n\nif __name__ == \'__main__\':\n    strs = json.loads(sys.stdin.read())\n    result = group_anagrams(strs)\n    print(result)',7,71),('append','def find_median_sorted_arrays(nums1, nums2):\n    # your code here\n    return 0.0','import sys\nimport json\n\nif __name__ == \'__main__\':\n    lines = sys.stdin.read().splitlines()\n    nums1 = json.loads(lines[0])\n    nums2 = json.loads(lines[1])\n    result = find_median_sorted_arrays(nums1, nums2)\n    print(result)',8,71),('append','def trap(height):\n    # your code here\n    return 0','import sys\nimport json\n\nif __name__ == \'__main__\':\n    height = json.loads(sys.stdin.read())\n    result = trap(height)\n    print(result)',9,71),('append','def solve_n_queens(n):\n    # your code here\n    return []','import sys\n\nif __name__ == \'__main__\':\n    n = int(sys.stdin.read())\n    result = solve_n_queens(n)\n    print(result)',10,71),('append','def three_sum(nums):\n    # your code here\n    return []','import sys\nimport json\n\nif __name__ == \'__main__\':\n    nums = json.loads(sys.stdin.read())\n    result = three_sum(nums)\n    print(result)',11,71);
/*!40000 ALTER TABLE `codes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `languages`
--

DROP TABLE IF EXISTS `languages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `languages` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKf6axmaokhmrbmm746866v0uyu` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `languages`
--

LOCK TABLES `languages` WRITE;
/*!40000 ALTER TABLE `languages` DISABLE KEYS */;
INSERT INTO `languages` VALUES (62,'Java'),(71,'Python');
/*!40000 ALTER TABLE `languages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problems`
--

DROP TABLE IF EXISTS `problems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `problems` (
  `id` bigint NOT NULL,
  `description` text,
  `difficulty` varchar(255) DEFAULT NULL,
  `slug` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsyfi1gsxso63v8ad5a54a0si8` (`slug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problems`
--

LOCK TABLES `problems` WRITE;
/*!40000 ALTER TABLE `problems` DISABLE KEYS */;
INSERT INTO `problems` VALUES (1,'# 1. Two Sum\n\n![Easy](https://img.shields.io/badge/difficulty-easy-brightgreen)\n\nGiven an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to `target`*.\n\nYou may assume that each input has *exactly one solution*, and you may not use the *same element twice*.\n\nReturn the answer in *ascending order*.\n\n## Example 1\n- **Input:** `nums = [2, 7, 11, 15], target = 9`\n- **Output:** `[0, 1]`\n- **Explanation:** `nums[0] + nums[1] == 9`, so return `[0, 1]`.\n\n## Example 2\n- **Input:** `nums = [3, 2, 4], target = 6`\n- **Output:** `[1, 2]`\n\n## Example 3\n- **Input:** `nums = [3, 3], target = 6`\n- **Output:** `[0, 1]`\n\n## Constraints\n- `2 ≤ nums.length ≤ 10⁴`\n- `-10⁹ ≤ nums[i] ≤ 10⁹`\n- `-10⁹ ≤ target ≤ 10⁹`\n- Exactly one valid answer exists.','easy','two-sum','Two Sum'),(2,'# 2. Reverse Integer\n\n![Easy](https://img.shields.io/badge/difficulty-easy-brightgreen)\n\nGiven a signed 32-bit integer `x`, return `x` with its digits reversed. If reversing `x` causes the value to go outside the signed 32-bit integer range, return `0`.\n\n## Example 1\n- **Input:** `x = 123`\n- **Output:** `321`\n\n## Example 2\n- **Input:** `x = -123`\n- **Output:** `-321`\n\n## Example 3\n- **Input:** `x = 120`\n- **Output:** `21`\n\n## Constraints\n- `-2³¹ ≤ x ≤ 2³¹ - 1`','easy','reverse-integer','Reverse Integer'),(3,'# 3. Palindrome Number\n\n![Easy](https://img.shields.io/badge/difficulty-easy-brightgreen)\n\nGiven an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.\n\n## Example 1\n- **Input:** `x = 121`\n- **Output:** `true`\n\n## Example 2\n- **Input:** `x = -121`\n- **Output:** `false`\n\n## Example 3\n- **Input:** `x = 10`\n- **Output:** `false`\n\n## Constraints\n- `-2³¹ ≤ x ≤ 2³¹ - 1`','easy','palindrome-number','Palindrome Number'),(4,'# 4. Valid Parentheses\n\n![Easy](https://img.shields.io/badge/difficulty-easy-brightgreen)\n\nGiven a string `s` containing just the characters `\'(\', \')\', \'{\', \'}\', \'[\'` and `\']\'`, determine if the input string is valid.\n\nAn input string is valid if:\n- Open brackets are closed by the same type of brackets.\n- Open brackets are closed in the correct order.\n\n## Example 1\n- **Input:** `s = \"()\"`\n- **Output:** `true`\n\n## Example 2\n- **Input:** `s = \"()[]{}\"`\n- **Output:** `true`\n\n## Example 3\n- **Input:** `s = \"(]\"`\n- **Output:** `false`\n\n## Constraints\n- `1 ≤ s.length ≤ 10⁴`\n- `s` consists of parentheses only: `\'()[]{}\'`','easy','valid-parentheses','Valid Parentheses'),(5,'# 5. Merge Two Sorted Lists\n\n![Easy](https://img.shields.io/badge/difficulty-easy-brightgreen)\n\nYou are given the heads of two sorted linked lists `list1` and `list2`. Merge the two lists into one sorted list and return the head.\n\n## Example 1\n- **Input:** `list1 = [1,2,4], list2 = [1,3,4]`\n- **Output:** `[1,1,2,3,4,4]`\n\n## Example 2\n- **Input:** `list1 = [], list2 = []`\n- **Output:** `[]`\n\n## Example 3\n- **Input:** `list1 = [], list2 = [0]`\n- **Output:** `[0]`\n\n## Constraints\n- The number of nodes in both lists is in the range `[0, 50]`.\n- `-100 ≤ Node.val ≤ 100`','easy','merge-two-sorted-lists','Merge Two Sorted Lists'),(6,'# 6. Longest Substring Without Repeating Characters\n\n![Medium](https://img.shields.io/badge/difficulty-medium-yellow)\n\nGiven a string `s`, find the length of the longest substring without repeating characters.\n\n## Example 1\n- **Input:** `s = \"abcabcbb\"`\n- **Output:** `3`\n\n## Example 2\n- **Input:** `s = \"bbbbb\"`\n- **Output:** `1`\n\n## Example 3\n- **Input:** `s = \"pwwkew\"`\n- **Output:** `3`\n\n## Constraints\n- `0 ≤ s.length ≤ 5 * 10⁴`\n- `s` consists of English letters, digits, symbols and spaces.','medium','longest-substring-without-repeating-characters','Longest Substring Without Repeating Characters'),(7,'# 7. Group Anagrams\n\n![Medium](https://img.shields.io/badge/difficulty-medium-yellow)\n\nGiven an array of strings `strs`, group the anagrams together.\n\nYou can return the answer in any order.\n\n## Example 1\n- **Input:** `strs = [\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"]`\n- **Output:** `[[\"eat\",\"tea\",\"ate\"],[\"tan\",\"nat\"],[\"bat\"]]`\n\n## Constraints\n- `1 ≤ strs.length ≤ 10⁴`\n- `0 ≤ strs[i].length ≤ 100`\n- `strs[i]` consists of lowercase English letters.','medium','group-anagrams','Group Anagrams'),(8,'# 8. Median of Two Sorted Arrays\n\n![Hard](https://img.shields.io/badge/difficulty-hard-red)\n\nGiven two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the median of the two sorted arrays.\n\nThe overall run time complexity should be `O(log (m+n))`.\n\n## Example 1\n- **Input:** `nums1 = [1,3], nums2 = [2]`\n- **Output:** `2.0`\n\n## Example 2\n- **Input:** `nums1 = [1,2], nums2 = [3,4]`\n- **Output:** `2.5`\n\n## Constraints\n- `nums1.length == m`\n- `nums2.length == n`\n- `0 ≤ m, n ≤ 1000`\n- `1 ≤ m + n ≤ 2000`\n- `-10⁶ ≤ nums1[i], nums2[i] ≤ 10⁶`','hard','median-of-two-sorted-arrays','Median of Two Sorted Arrays'),(9,'# 9. Trapping Rain Water\n\n![Hard](https://img.shields.io/badge/difficulty-hard-red)\n\nGiven `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.\n\n## Example 1\n- **Input:** `height = [0,1,0,2,1,0,1,3,2,1,2,1]`\n- **Output:** `6`\n\n## Example 2\n- **Input:** `height = [4,2,0,3,2,5]`\n- **Output:** `9`\n\n## Constraints\n- `n == height.length`\n- `1 ≤ n ≤ 2 * 10⁴`\n- `0 ≤ height[i] ≤ 10⁵`','hard','trapping-rain-water','Trapping Rain Water'),(10,'# 10. N-Queens\n\n![Hard](https://img.shields.io/badge/difficulty-hard-red)\n\nThe n-queens puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.\n\nGiven an integer `n`, return all distinct solutions to the n-queens puzzle.\n\nEach solution contains a distinct board configuration of the n-queens\' placement, where `\'Q\'` and `\'.\'` both indicate a queen and an empty space respectively.\n\n## Example\n- **Input:** `n = 4`\n- **Output:** `[[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]`\n\n## Constraints\n- `1 ≤ n ≤ 9`','hard','n-queens','N-Queens'),(11,'# 11. 3Sum\n\n![Medium](https://img.shields.io/badge/difficulty-medium-yellow)\n\nGiven an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.\n\nNotice that the solution set must not contain duplicate triplets.\n\n## Example 1\n- **Input:** `nums = [-1,0,1,2,-1,-4]`\n- **Output:** `[[-1,-1,2],[-1,0,1]]`\n\n## Example 2\n- **Input:** `nums = []`\n- **Output:** `[]`\n\n## Constraints\n- `3 ≤ nums.length ≤ 3000`\n- `-10⁵ ≤ nums[i] ≤ 10⁵`','medium','3sum','3Sum');
/*!40000 ALTER TABLE `problems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submissions`
--

DROP TABLE IF EXISTS `submissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submissions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_code` text NOT NULL,
  `lang_id` bigint NOT NULL,
  `problem_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `verdict` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeggqthd3amchyryje3k9e4na4` (`lang_id`),
  KEY `FKj5kbdqokftgx992cx24x3s583` (`problem_id`),
  KEY `FK760bgu69957phd7hax608jdms` (`user_id`),
  CONSTRAINT `FK760bgu69957phd7hax608jdms` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKeggqthd3amchyryje3k9e4na4` FOREIGN KEY (`lang_id`) REFERENCES `languages` (`id`),
  CONSTRAINT `FKj5kbdqokftgx992cx24x3s583` FOREIGN KEY (`problem_id`) REFERENCES `problems` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submissions`
--

LOCK TABLES `submissions` WRITE;
/*!40000 ALTER TABLE `submissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `submissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testcases`
--

DROP TABLE IF EXISTS `testcases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testcases` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `input` varchar(255) DEFAULT NULL,
  `output` varchar(255) DEFAULT NULL,
  `problem_id` bigint DEFAULT NULL,
  `testcase_index` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKatr9pejjajssqvxvp1366g00h` (`problem_id`,`testcase_index`),
  CONSTRAINT `FKme0641jfjwft3ryqgkcepbf12` FOREIGN KEY (`problem_id`) REFERENCES `problems` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testcases`
--

LOCK TABLES `testcases` WRITE;
/*!40000 ALTER TABLE `testcases` DISABLE KEYS */;
INSERT INTO `testcases` VALUES (1,'[2, 7, 11, 15]\n9','[0, 1]',1,0),(2,'[3, 2, 4]\n6','[1, 2]',1,1),(3,'123','321',2,0),(4,'-123','-321',2,1),(5,'121','true',3,0),(6,'-121','false',3,1),(7,'()','true',4,0),(8,'([)]','false',4,1),(9,'abcabcbb','3',6,0),(10,'bbbbb','1',6,1),(11,'[\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"]','[[\"eat\",\"tea\",\"ate\"],[\"tan\",\"nat\"],[\"bat\"]]',7,0),(12,'[\"\"]','[[\"\"]]',7,1),(13,'[1,3]\n[2]','2.0',8,0),(14,'[1,2]\n[3,4]','2.5',8,1),(15,'[0,1,0,2,1,0,1,3,2,1,2,1]','6',9,0),(16,'[4,2,0,3,2,5]','9',9,1),(17,'4','[[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]',10,0),(18,'1','[[\"Q\"]]',10,1),(19,'[1,2,4]\n[1,3,4]','[1,1,2,3,4,4]',5,0),(20,'[]\n[0]','[0]',5,1),(21,'[-1,0,1,2,-1,-4]','[[-1,-1,2],[-1,0,1]]',11,0),(22,'[]','[]',11,1);
/*!40000 ALTER TABLE `testcases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-19 20:32:36
