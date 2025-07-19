# Codes

> POST `/api/codes`

```json
{
  "id": {
    "problem": { "id": 1 },
    "language": { "id": 62 }
  },
  "starterCode": "class Solution {\n    public int[] twoSum(int[] nums, int target) {\n        // your code here\n        return new int[]{};\n    }\n}",
  "wrapper": "import java.util.*;\nimport java.util.stream.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        String listLine = scanner.nextLine();\n        int target = Integer.parseInt(scanner.nextLine());\n\n        int[] nums = Arrays.stream(\n            listLine.replaceAll(\"[\\\\[\\\\] ]\", \"\").split(\",\")\n        ).mapToInt(Integer::parseInt).toArray();\n\n        Solution sol = new Solution();\n        int[] result = sol.twoSum(nums, target);\n        System.out.println(Arrays.toString(result));\n    }\n}",
  "mode": "prepend"
}
```

```json
{
  "id": {
    "problem": { "id": 1 },
    "language": { "id": 71 }
  },
  "starterCode": "def two_sum(nums, target):\n    # your code here\n    return []",
  "wrapper": "import sys\nimport json\n\nif __name__ == '__main__':\n    lines = sys.stdin.read().splitlines()\n    nums = json.loads(lines[0])\n    target = int(lines[1])\n    result = two_sum(nums, target)\n    print(result)",
  "mode": "append"
}
```

```json
{
  "id": {
    "problem": { "id": 2 },
    "language": { "id": 62 }
  },
  "starterCode": "class Solution {\n    public int reverse(int x) {\n        // your code here\n        return 0;\n    }\n}",
  "wrapper": "import java.util.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        int x = Integer.parseInt(scanner.nextLine());\n        Solution sol = new Solution();\n        int result = sol.reverse(x);\n        System.out.println(result);\n    }\n}",
  "mode": "prepend"
}
```

```json
{
  "id": {
    "problem": { "id": 2 },
    "language": { "id": 71 }
  },
  "starterCode": "def reverse(x):\n    # your code here\n    return 0",
  "wrapper": "import sys\n\nif __name__ == '__main__':\n    x = int(sys.stdin.read())\n    result = reverse(x)\n    print(result)",
  "mode": "append"
}
```

```json
{
  "id": {
    "problem": { "id": 3 },
    "language": { "id": 62 }
  },
  "starterCode": "class Solution {\n    public boolean isPalindrome(int x) {\n        // your code here\n        return false;\n    }\n}",
  "wrapper": "import java.util.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        int x = Integer.parseInt(scanner.nextLine());\n        Solution sol = new Solution();\n        boolean result = sol.isPalindrome(x);\n        System.out.println(result);\n    }\n}",
  "mode": "prepend"
}
```

```json
{
  "id": {
    "problem": { "id": 3 },
    "language": { "id": 71 }
  },
  "starterCode": "def is_palindrome(x):\n    # your code here\n    return False",
  "wrapper": "import sys\n\nif __name__ == '__main__':\n    x = int(sys.stdin.read())\n    result = is_palindrome(x)\n    print(result)",
  "mode": "append"
}
```

```json
{
  "id": {
    "problem": { "id": 4 },
    "language": { "id": 62 }
  },
  "starterCode": "class Solution {\n    public boolean isValid(String s) {\n        // your code here\n        return false;\n    }\n}",
  "wrapper": "import java.util.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        String s = scanner.nextLine();\n        Solution sol = new Solution();\n        boolean result = sol.isValid(s);\n        System.out.println(result);\n    }\n}",
  "mode": "prepend"
}
```

```json
{
  "id": {
    "problem": { "id": 4 },
    "language": { "id": 71 }
  },
  "starterCode": "def is_valid(s):\n    # your code here\n    return False",
  "wrapper": "import sys\n\nif __name__ == '__main__':\n    s = sys.stdin.read().strip()\n    result = is_valid(s)\n    print(result)",
  "mode": "append"
}
```

```json
{
  "id": {
    "problem": { "id": 5 },
    "language": { "id": 62 }
  },
  "starterCode": "class ListNode {\n    int val;\n    ListNode next;\n    ListNode(int val) { this.val = val; }\n}\n\nclass Solution {\n    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {\n        // your code here\n        return null;\n    }\n}",
  "wrapper": "import java.util.*;\n\npublic class Main {\n    static ListNode buildList(String input) {\n        input = input.replaceAll(\"[\\\\[\\\\] ]\", \"\");\n        if (input.isEmpty()) return null;\n        String[] nums = input.split(\",\");\n        ListNode dummy = new ListNode(0);\n        ListNode curr = dummy;\n        for (String num : nums) {\n            curr.next = new ListNode(Integer.parseInt(num));\n            curr = curr.next;\n        }\n        return dummy.next;\n    }\n\n    static void printList(ListNode head) {\n        List<Integer> list = new ArrayList<>();\n        while (head != null) {\n            list.add(head.val);\n            head = head.next;\n        }\n        System.out.println(list);\n    }\n\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        ListNode list1 = buildList(scanner.nextLine());\n        ListNode list2 = buildList(scanner.nextLine());\n        Solution sol = new Solution();\n        ListNode merged = sol.mergeTwoLists(list1, list2);\n        printList(merged);\n    }\n}",
  "mode": "prepend"
}
```

```json
{
  "id": {
    "problem": { "id": 5 },
    "language": { "id": 71 }
  },
  "starterCode": "class ListNode:\n    def __init__(self, val=0, next=None):\n        self.val = val\n        self.next = next\n\ndef merge_two_lists(list1, list2):\n    # your code here\n    return None",
  "wrapper": "import sys\nimport json\n\nclass ListNode:\n    def __init__(self, val=0, next=None):\n        self.val = val\n        self.next = next\n\ndef build_list(arr):\n    dummy = ListNode(0)\n    current = dummy\n    for num in arr:\n        current.next = ListNode(num)\n        current = current.next\n    return dummy.next\n\ndef print_list(head):\n    out = []\n    while head:\n        out.append(head.val)\n        head = head.next\n    print(out)\n\nif __name__ == '__main__':\n    lines = sys.stdin.read().splitlines()\n    list1 = build_list(json.loads(lines[0]))\n    list2 = build_list(json.loads(lines[1]))\n    merged = merge_two_lists(list1, list2)\n    print_list(merged)",
  "mode": "append"
}
```

```json
{
  "id": {
    "problem": { "id": 6 },
    "language": { "id": 62 }
  },
  "starterCode": "class Solution {\n    public int lengthOfLongestSubstring(String s) {\n        // your code here\n        return 0;\n    }\n}",
  "wrapper": "import java.util.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        String s = scanner.nextLine();\n        Solution sol = new Solution();\n        int result = sol.lengthOfLongestSubstring(s);\n        System.out.println(result);\n    }\n}",
  "mode": "prepend"
}
```

```json
{
  "id": {
    "problem": { "id": 6 },
    "language": { "id": 71 }
  },
  "starterCode": "def length_of_longest_substring(s):\n    # your code here\n    return 0",
  "wrapper": "import sys\n\nif __name__ == '__main__':\n    s = sys.stdin.read().strip()\n    result = length_of_longest_substring(s)\n    print(result)",
  "mode": "append"
}
```

```json
{
  "id": {
    "problem": { "id": 7 },
    "language": { "id": 62 }
  },
  "starterCode": "class Solution {\n    public List<List<String>> groupAnagrams(String[] strs) {\n        Map<String, List<String>> map = new HashMap<>();\n        for (String str : strs) {\n            char[] chars = str.toCharArray();\n            Arrays.sort(chars);\n            String key = new String(chars);\n            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);\n        }\n        return new ArrayList<>(map.values());\n    }\n}",
  "wrapper": "import java.util.*;\nimport java.util.stream.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        String line = scanner.nextLine();\n        String[] strs = line.replaceAll(\"[\\\\[\\\\]\"]\", \"\").split(\",\");\n        Solution sol = new Solution();\n        List<List<String>> result = sol.groupAnagrams(strs);\n        System.out.println(result);\n    }\n}",
  "mode": "prepend"
}
```

```json
{
  "id": {
    "problem": { "id": 7 },
    "language": { "id": 71 }
  },
  "starterCode": "def group_anagrams(strs):\n    # your code here\n    return []",
  "wrapper": "import sys\nimport json\n\nif __name__ == '__main__':\n    strs = json.loads(sys.stdin.read())\n    result = group_anagrams(strs)\n    print(result)",
  "mode": "append"
}
```

```json
{
  "id": {
    "problem": { "id": 8 },
    "language": { "id": 62 }
  },
  "starterCode": "class Solution {\n    public double findMedianSortedArrays(int[] nums1, int[] nums2) {\n        int[] merged = new int[nums1.length + nums2.length];\n        System.arraycopy(nums1, 0, merged, 0, nums1.length);\n        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);\n        Arrays.sort(merged);\n        int n = merged.length;\n        if (n % 2 == 0) {\n            return (merged[n/2 - 1] + merged[n/2]) / 2.0;\n        } else {\n            return merged[n/2];\n        }\n    }\n}",
  "wrapper": "import java.util.*;\nimport java.util.stream.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        int[] nums1 = Arrays.stream(scanner.nextLine().replaceAll(\"[\\\\[\\\\] ]\", \"\").split(\",\"))\n                           .filter(s -> !s.isEmpty())\n                           .mapToInt(Integer::parseInt).toArray();\n        int[] nums2 = Arrays.stream(scanner.nextLine().replaceAll(\"[\\\\[\\\\] ]\", \"\").split(\",\"))\n                           .filter(s -> !s.isEmpty())\n                           .mapToInt(Integer::parseInt).toArray();\n        Solution sol = new Solution();\n        double result = sol.findMedianSortedArrays(nums1, nums2);\n        System.out.println(result);\n    }\n}",
  "mode": "prepend"
}
```

```json
{
  "id": {
    "problem": { "id": 8 },
    "language": { "id": 71 }
  },
  "starterCode": "def find_median_sorted_arrays(nums1, nums2):\n    # your code here\n    return 0.0",
  "wrapper": "import sys\nimport json\n\nif __name__ == '__main__':\n    lines = sys.stdin.read().splitlines()\n    nums1 = json.loads(lines[0])\n    nums2 = json.loads(lines[1])\n    result = find_median_sorted_arrays(nums1, nums2)\n    print(result)",
  "mode": "append"
}
```

```json
{
  "id": {
    "problem": { "id": 9 },
    "language": { "id": 62 }
  },
  "starterCode": "class Solution {\n    public int trap(int[] height) {\n        int left = 0, right = height.length - 1;\n        int leftMax = 0, rightMax = 0, water = 0;\n        while (left < right) {\n            if (height[left] < height[right]) {\n                leftMax = Math.max(leftMax, height[left]);\n                water += leftMax - height[left];\n                left++;\n            } else {\n                rightMax = Math.max(rightMax, height[right]);\n                water += rightMax - height[right];\n                right--;\n            }\n        }\n        return water;\n    }\n}",
  "wrapper": "import java.util.*;\nimport java.util.stream.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        int[] height = Arrays.stream(scanner.nextLine().replaceAll(\"[\\\\[\\\\] ]\", \"\").split(\",\"))\n                            .filter(s -> !s.isEmpty())\n                            .mapToInt(Integer::parseInt).toArray();\n        Solution sol = new Solution();\n        int result = sol.trap(height);\n        System.out.println(result);\n    }\n}",
  "mode": "prepend"
}
```

```json
{
  "id": {
    "problem": { "id": 9 },
    "language": { "id": 71 }
  },
  "starterCode": "def trap(height):\n    # your code here\n    return 0",
  "wrapper": "import sys\nimport json\n\nif __name__ == '__main__':\n    height = json.loads(sys.stdin.read())\n    result = trap(height)\n    print(result)",
  "mode": "append"
}
```

```json
{
  "id": {
    "problem": { "id": 10 },
    "language": { "id": 62 }
  },
  "starterCode": "class Solution {\n    public List<List<String>> solveNQueens(int n) {\n        // your code here\n        return new ArrayList<>();\n    }\n}",
  "wrapper": "import java.util.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        int n = Integer.parseInt(scanner.nextLine());\n        Solution sol = new Solution();\n        List<List<String>> result = sol.solveNQueens(n);\n        System.out.println(result);\n    }\n}",
  "mode": "prepend"
}
```

```json
{
  "id": {
    "problem": { "id": 10 },
    "language": { "id": 71 }
  },
  "starterCode": "def solve_n_queens(n):\n    # your code here\n    return []",
  "wrapper": "import sys\n\nif __name__ == '__main__':\n    n = int(sys.stdin.read())\n    result = solve_n_queens(n)\n    print(result)",
  "mode": "append"
}
```

```json
{
  "id": {
    "problem": { "id": 11 },
    "language": { "id": 62 }
  },
  "starterCode": "class Solution {\n    public List<List<Integer>> threeSum(int[] nums) {\n        // your code here\n        return new ArrayList<>();\n    }\n}",
  "wrapper": "import java.util.*;\nimport java.util.stream.*;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        int[] nums = Arrays.stream(scanner.nextLine().replaceAll(\"[\\[\\] ]\", \"\").split(\",\"))\n                           .filter(s -> !s.isEmpty())\n                           .mapToInt(Integer::parseInt).toArray();\n        Solution sol = new Solution();\n        List<List<Integer>> result = sol.threeSum(nums);\n        System.out.println(result);\n    }\n}",
  "mode": "prepend"
}
```

```json
{
  "id": {
    "problem": { "id": 11 },
    "language": { "id": 71 }
  },
  "starterCode": "def three_sum(nums):\n    # your code here\n    return []",
  "wrapper": "import sys\nimport json\n\nif __name__ == '__main__':\n    nums = json.loads(sys.stdin.read())\n    result = three_sum(nums)\n    print(result)",
  "mode": "append"
}
```
