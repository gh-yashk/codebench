# Testcases

> POST `/api/testcases`

```json
{
  "problemId": 1,
  "index": 0,
  "input": "[2, 7, 11, 15]\n9",
  "output": "[0, 1]"
}
```

```json
{
  "problemId": 1,
  "index": 1,
  "input": "[3, 2, 4]\n6",
  "output": "[1, 2]"
}
```

```json
{
  "problemId": 2,
  "index": 0,
  "input": "123",
  "output": "321"
}
```

```json
{
  "problemId": 2,
  "index": 1,
  "input": "-123",
  "output": "-321"
}
```

```json
{
  "problemId": 3,
  "index": 0,
  "input": "121",
  "output": "true"
}
```

```json
{
  "problemId": 3,
  "index": 1,
  "input": "-121",
  "output": "false"
}
```

```json
{
  "problemId": 4,
  "index": 0,
  "input": "()",
  "output": "true"
}
```

```json
{
  "problemId": 4,
  "index": 1,
  "input": "([)]",
  "output": "false"
}
```

```json
{
  "problemId": 5,
  "index": 0,
  "input": "[1,2,4]\n[1,3,4]",
  "output": "[1,1,2,3,4,4]"
}
```

```json
{
  "problemId": 5,
  "index": 1,
  "input": "[]\n[0]",
  "output": "[0]"
}
```

```json
{
  "problemId": 6,
  "index": 0,
  "input": "abcabcbb",
  "output": "3"
}
```

```json
{
  "problemId": 6,
  "index": 1,
  "input": "bbbbb",
  "output": "1"
}
```

```json
{
  "problemId": 7,
  "index": 0,
  "input": "[\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"]",
  "output": "[[\"eat\",\"tea\",\"ate\"],[\"tan\",\"nat\"],[\"bat\"]]"
}
```

```json
{
  "problemId": 7,
  "index": 1,
  "input": "[\"\"]",
  "output": "[[\"\"]]"
}
```

```json
{
  "problemId": 8,
  "index": 0,
  "input": "[1,3]\n[2]",
  "output": "2.0"
}
```

```json
{
  "problemId": 8,
  "index": 1,
  "input": "[1,2]\n[3,4]",
  "output": "2.5"
}
```

```json
{
  "problemId": 9,
  "index": 0,
  "input": "[0,1,0,2,1,0,1,3,2,1,2,1]",
  "output": "6"
}
```

```json
{
  "problemId": 9,
  "index": 1,
  "input": "[4,2,0,3,2,5]",
  "output": "9"
}
```

```json
{
  "problemId": 10,
  "index": 0,
  "input": "4",
  "output": "[[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]"
}
```

```json
{
  "problemId": 10,
  "index": 1,
  "input": "1",
  "output": "[[\"Q\"]]"
}
```

```json
{
  "problemId": 11,
  "index": 0,
  "input": "[-1,0,1,2,-1,-4]",
  "output": "[[-1,-1,2],[-1,0,1]]"
}
```

```json
{
  "problemId": 11,
  "index": 1,
  "input": "[]",
  "output": "[]"
}
```
