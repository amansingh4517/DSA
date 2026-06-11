# Trees — Complete Mental Model

> **The one idea that changes everything:**  
> A tree is not a data structure. It is a **decision that repeats itself.**  
> Every node asks the same question. It talks to its two children, gets answers back,  
> combines them, and passes the result up. That's it. Forever.

---

## Table of Contents

1. [How to Think About a Tree](#1-how-to-think-about-a-tree)
2. [The Three Questions — Ask Before Every Problem](#2-the-three-questions--ask-before-every-problem)
3. [The Universal Template](#3-the-universal-template)
4. [Base Case — The Foundation of Everything](#4-base-case--the-foundation-of-everything)
5. [How Answers Flow](#5-how-answers-flow)
6. [The Three Patterns Every Tree Problem Uses](#6-the-three-patterns-every-tree-problem-uses)
7. [The Combine Step](#7-the-combine-step)
8. [BST — When Structure Gives You Power](#8-bst--when-structure-gives-you-power)
9. [Common Mistakes](#9-common-mistakes)
10. [Practice Roadmap](#10-practice-roadmap)
11. [Quick Reference](#11-quick-reference)

---

## 1. How to Think About a Tree

Most people try to trace the entire tree in their head — following every recursive  
call from top to bottom. This always fails. The tree is too big to hold in memory.

**The correct approach: think about ONE node only.**

```
          [  LEFT CHILD  ]       [  RIGHT CHILD  ]
               gives me X              gives me Y
                      \                /
                       \              /
                        v            v
                      [ THIS NODE ]
                        I combine X and Y
                        I return my answer upward
```

The node does not know — and does not care — how deep the tree goes below it.  
It simply **trusts** that its children return the correct answer.

This trust is not an assumption. It is the definition of recursion.  
If the base case is correct and the combine step is correct,  
the whole tree works automatically.

> **The mental shift to make:**  
> Stop asking *"what happens in the whole tree?"*  
> Start asking *"if my children magically give me the right answer, what do I do with it?"*

---

## 2. The Three Questions — Ask Before Every Problem

Before writing a single line of code, answer these on paper:

```
┌──────────────────────────────────────────────────────────┐
│                                                          │
│   1. What does NULL return?                              │
│      → The simplest possible answer when nothing is here │
│                                                          │
│   2. What do I ask my children to give me?               │
│      → What information do I need from below?            │
│                                                          │
│   3. How do I combine their answers into mine?           │
│      → Given left's answer and right's answer,           │
│        what do I return to MY parent?                    │
│                                                          │
└──────────────────────────────────────────────────────────┘
```

If you can answer all three → write the code. It will be correct.  
If you cannot answer one of them → do not open your IDE yet.

These three questions map directly to three parts of your code:  
Question 1 = base case. Question 2 = recurse. Question 3 = return statement.

---

## 3. The Universal Template

Every tree problem uses this skeleton.  
The skeleton never changes. Only the combine step does.

```java
int solve(TreeNode node) {

    // ── 1. BASE CASE ──────────────────────────────────────────
    // What to return when there is no node.
    // Always the very first line. Never skip this.
    if (node == null) return 0;

    // ── 2. RECURSE ────────────────────────────────────────────
    // Ask children for their answers.
    // You do not need to know what happens inside these calls.
    // Trust them.
    int left  = solve(node.left);
    int right = solve(node.right);

    // ── 3. COMBINE ────────────────────────────────────────────
    // Use left, right, and node.val to compute THIS node's answer.
    // THIS IS THE ONLY LINE THAT CHANGES BETWEEN PROBLEMS.
    return /* your logic here */;
}
```

When the return type is `boolean`:

```java
boolean solve(TreeNode node) {
    if (node == null) return true;   // base case changes per problem

    boolean left  = solve(node.left);
    boolean right = solve(node.right);

    return /* combine with && or || */;
}
```

When you need to pass information downward:

```java
void solve(TreeNode node, int valueFromParent) {
    if (node == null) return;

    // use valueFromParent here

    solve(node.left,  /* updated value */);
    solve(node.right, /* updated value */);
}
```

---

## 4. Base Case — The Foundation of Everything

**Always check `node == null`. Never check for a leaf node.**

### Why checking for a leaf is wrong

```java
// WRONG
if (node.left == null && node.right == null) return 1;
```

This only handles the case where a node has no children.  
What happens when recursion calls `solve(node.left)` and `node.left` is `null`?

```
solve(null)
  → null.left   ← NullPointerException
```

Your function crashes on any tree where a node has only one child.

### Why checking for null is right

```java
// CORRECT
if (node == null) return 0;
```

This handles everything:

```
Null node  → returns immediately, no crash
Leaf node  → calls solve(null) on both sides, gets base value back from both,
             then computes its own answer correctly — automatically
Any node   → always safe
```

Leaves are handled automatically by the null check.  
You never need a separate leaf condition.

### What to return at null — depends on what you are computing

| Function computes | Return at null |
|---|---|
| A count or height | `0` |
| A sum | `0` |
| A boolean — does X exist? | `false` |
| A boolean — is X valid? | `true` |
| A minimum value | `Integer.MAX_VALUE` |
| A maximum value | `Integer.MIN_VALUE` or `0` |
| A node reference | `null` |

> **Rule of thumb:** return the value that has no effect when combined.  
> For `Math.max` → return `0`. For `&&` → return `true`. For `+` → return `0`.

---

## 5. How Answers Flow

### Bottom-up flow (most common)

Answers are built at the leaves and travel upward.  
The root is the last node to compute its answer.

```
Tree:
         A
        / \
       B   C
      / \
     D   E

Execution order:
  D computes first  → returns answer to B
  E computes        → returns answer to B
  B combines D + E  → returns answer to A
  C computes        → returns answer to A
  A combines B + C  → this is the final answer

Order: leaves first → internal nodes → root last
```

This is why recursion works on trees. The deepest nodes finish first  
and the answer assembles itself upward automatically.

### Top-down flow

Sometimes you carry information **down** from parent to child as a parameter.

```java
void solve(TreeNode node, int infoFromParent) {
    if (node == null) return;

    // use infoFromParent to make a decision or update state

    solve(node.left,  /* updated value for left  */);
    solve(node.right, /* updated value for right */);
}
```

**When to use top-down:**  
When each node needs to know something about its ancestors —  
for example: the accumulated sum on this path, or the valid value range for a BST node.

### Mixed flow (most powerful)

Both at once — carry something down as parameters,  
return something up as return values.

```java
int solve(TreeNode node, int infoFromParent) {
    if (node == null) return 0;

    int left  = solve(node.left,  /* updated info */);
    int right = solve(node.right, /* updated info */);

    return /* combine left, right, node.val, infoFromParent */;
}
```

---

## 6. The Three Patterns Every Tree Problem Uses

### Pattern 1 — Return the answer directly

The function's return value IS the answer.  
Works when the answer at the root equals the answer to the whole problem.

```java
int solve(TreeNode node) {
    if (node == null) return BASE_VALUE;
    int left  = solve(node.left);
    int right = solve(node.right);
    return COMBINE(left, right, node.val);
}
```

Use for: height, count, sum, checking a property that must hold everywhere.

---

### Pattern 2 — Global variable (return value and answer are different)

The function returns something upward (like height) to help the parent,  
but the **real answer** is stored in a variable updated at each node as a side effect.

Use this when: the answer could be at any node, not just the root.  
Common signal in problem statement: *"between any two nodes"*, *"any path"*,  
*"maximum/minimum across the whole tree"*.

```java
int[] globalAnswer = {0};   // or Integer.MIN_VALUE depending on problem

int helper(TreeNode node) {
    if (node == null) return 0;

    int left  = helper(node.left);
    int right = helper(node.right);

    // Update the real answer as a side effect at this node
    globalAnswer[0] = Math.max(globalAnswer[0], EXPRESSION(left, right, node.val));

    // Return something that serves the PARENT — often different from the answer
    return DIFFERENT_EXPRESSION(left, right, node.val);
}
```

> **Key insight:** what the function **returns** and what the **answer** is  
> are two different things.  
> The return value serves the parent node above.  
> The global variable tracks the best result seen across all nodes so far.

Use an `int[]` array in Java instead of a static field  
to avoid state leaking between multiple test case calls.

---

### Pattern 3 — Backtracking (build and undo)

Used when you need to collect all paths, all combinations, or explore all possibilities.  
You add to a shared state going **down** the tree, and undo it coming **back up**.

```java
void dfs(TreeNode node, List<Integer> current, List<List<Integer>> result) {
    if (node == null) return;

    current.add(node.val);                          // ADD on the way DOWN

    if (/* reached a goal — e.g. leaf, target sum */) {
        result.add(new ArrayList<>(current));       // save a copy, not a reference
    }

    dfs(node.left,  current, result);
    dfs(node.right, current, result);

    current.remove(current.size() - 1);             // UNDO on the way BACK UP
}
```

> **The invariant to maintain:**  
> `current` always contains exactly the nodes on the path from root to the current node.  
> Add before going down. Remove after coming back up. Never break this.

**Common mistake:** forgetting `new ArrayList<>(current)` when saving.  
If you write `result.add(current)` you save a reference, not a copy.  
By the time you read it, the list will be empty or modified.

---

## 7. The Combine Step

This is the only creative part of any tree problem.  
Everything else — the skeleton, the base case, the recursion — is mechanical.

**How to figure out the combine step:**

Ask: *"Given what my left subtree returned and what my right subtree returned,  
what is the correct answer for the subtree rooted at THIS node?"*

### Common combine expressions

```java
// Depth / height — tallest path downward
return 1 + Math.max(left, right);

// Minimum depth
return 1 + Math.min(left, right);

// Count of all nodes
return 1 + left + right;

// Sum of all values
return node.val + left + right;

// Property must hold everywhere (all nodes)
return left && right && /* condition at this node */;

// Property must hold somewhere (any node)
return left || right || /* condition at this node */;

// Best value seen — update global, return what parent needs
globalBest = Math.max(globalBest, EXPRESSION(left, right, node.val));
return /* what parent needs — often 1 + Math.max(left, right) */;
```

### Combine step by return type

| Return type | Typical combine pattern |
|---|---|
| `int` measuring something | arithmetic on `left`, `right`, `node.val` |
| `boolean` checking something | `&&` or `\|\|` of left, right, local condition |
| `TreeNode` finding a node | return whichever child found it, or `node` itself |
| `void` collecting results | add to shared list, recurse both sides |

---

## 8. BST — When Structure Gives You Power

A Binary Search Tree has one guarantee:  
**every value in the left subtree < node.val < every value in the right subtree.**

This guarantee lets you make a **decision at each node**  
instead of always exploring both sides blindly.

### The BST decision at each node

```java
// Regular binary tree — must explore both sides
solve(node.left);
solve(node.right);

// BST — choose ONE direction based on value
if (target < node.val)
    return solve(node.left);        // answer must be on the left
else if (target > node.val)
    return solve(node.right);       // answer must be on the right
else
    return node;                    // found it
```

This is why BST search is O(log n) on a balanced tree vs O(n) on a plain binary tree.

### Validating BST property — the classic trap

Checking only the immediate parent-child relationship is wrong.

```
       5
      / \
     1   6
        / \
       4   7
```

Node 4 is less than its parent 6 — looks valid locally.  
But 4 is also less than the root 5 — which means it should be in the left subtree.  
A local check passes. The tree is actually invalid.

**Correct approach: carry a valid range downward.**

```java
boolean isValid(TreeNode node, long min, long max) {
    if (node == null) return true;

    if (node.val <= min || node.val >= max) return false;

    return isValid(node.left,  min,       node.val)   // left range narrows upper bound
        && isValid(node.right, node.val,  max);        // right range narrows lower bound
}

// Initial call:
isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
// Use long to avoid overflow when node values are Integer.MIN/MAX_VALUE
```

### In-order traversal of a BST = sorted sequence

In-order (left → node → right) visits BST nodes in ascending order.  
Use this whenever a BST problem needs values in sorted order.

```java
void inOrder(TreeNode node, List<Integer> result) {
    if (node == null) return;
    inOrder(node.left, result);     // left subtree first
    result.add(node.val);           // then this node
    inOrder(node.right, result);    // then right subtree
}
```

---

## 9. Common Mistakes

### Mistake 1 — Leaf check instead of null check

```java
// Crashes when a node has exactly one child
if (node.left == null && node.right == null) return 1;

// Always correct
if (node == null) return 0;
```

### Mistake 2 — Accessing node properties before the null check

```java
// NullPointerException if node is null
if (node.val == target) return node;

// Null check must come first, always
if (node == null) return null;
if (node.val == target) return node;
```

### Mistake 3 — Tracing the whole tree in your head

You do not need to follow what happens inside `solve(node.left)`.  
Assume it returns the correct answer. Use that answer in your combine step.  
Tracing every call leads to confusion and wrong code every time.

### Mistake 4 — Saving a reference instead of a copy

```java
// Saves a reference — the list will be modified or emptied later
result.add(current);

// Save a snapshot of the current state
result.add(new ArrayList<>(current));
```

### Mistake 5 — Integer overflow in BST range validation

```java
// Fails when node values equal Integer.MIN_VALUE or MAX_VALUE
boolean isValid(TreeNode node, int min, int max) { ... }

// Use long to safely bound all possible int values
boolean isValid(TreeNode node, long min, long max) { ... }
isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
```

### Mistake 6 — Global state leaking between test cases

```java
// Static field retains value from the previous test case
static int best = 0;

// Use an array passed as parameter — resets every call
public int solve(TreeNode root) {
    int[] best = { 0 };
    helper(root, best);
    return best[0];
}
```

### Mistake 7 — Forgetting to undo in backtracking

```java
// path keeps growing — results will be wrong
path.add(node.val);
dfs(node.left,  path, result);
dfs(node.right, path, result);
// missing: path.remove(path.size() - 1);

// Correct — always undo before returning
path.add(node.val);
dfs(node.left,  path, result);
dfs(node.right, path, result);
path.remove(path.size() - 1);       // undo
```

### Mistake 8 — Wrong base case return for the combine operation

If your combine uses `Math.max`, returning `Integer.MIN_VALUE` at null is safer than `0`  
(in case all values are negative). Match the neutral element to your operation.

```java
// If combining with Math.max and values can be negative:
if (node == null) return Integer.MIN_VALUE;   // not 0

// If combining with Math.min:
if (node == null) return Integer.MAX_VALUE;   // not 0

// If combining with addition (counting, summing):
if (node == null) return 0;                   // correct neutral for +
```

---

## 10. Practice Roadmap

Work through these in order. Each level adds exactly one new concept.  
Do not skip levels. Do not move to the next level until the current one feels automatic.

### Level 1 — Drill the skeleton

Goal: the three-line template (null check, recurse, combine) becomes muscle memory.

| What to practice | New concept introduced |
|---|---|
| Height / max depth | The pure template. Reference implementation. |
| Count all nodes | Same skeleton. Combine changes. Proves template is universal. |
| Check a symmetric property | Combine returns boolean. Think about two nodes simultaneously. |

**After this level:** you should write the skeleton without thinking.

### Level 2 — Information flows downward

Goal: break out of bottom-up thinking. Learn to carry state downward.

| What to practice | New concept introduced |
|---|---|
| Check if a root-to-leaf path meets a condition | Carry remaining value down as a parameter. |
| Collect all root-to-leaf paths meeting a condition | Backtracking — add going down, remove going up. |

**After this level:** you understand both directions of information flow.

### Level 3 — Global state

Goal: understand that what a function returns and what the answer is can be different.

| What to practice | New concept introduced |
|---|---|
| Longest path between any two nodes | Function returns height. Answer lives in global. The biggest unlock. |
| Best value across any path in the tree | Same pattern. Must decide whether to include negative branches. |

**After this level:** Hard tree problems become approachable.

### Level 4 — BST properties

Goal: use the ordering guarantee to avoid exploring both sides.

| What to practice | New concept introduced |
|---|---|
| Validate a BST | Carry min/max bounds downward. Range narrowing per subtree. |
| Find lowest common ancestor in a BST | Value comparison decides direction — no need to explore both sides. |
| Find k-th smallest element | In-order traversal of BST gives sorted order. |

**After this level:** you treat BST and binary tree as distinct problem types.

### Level 5 — Construction

Goal: build trees instead of just reading them.

| What to practice | New concept introduced |
|---|---|
| Build a tree from two traversal arrays | Top-down construction. Divide and conquer on index ranges. |

---

## 11. Quick Reference

### The skeleton

```java
int solve(TreeNode node) {
    if (node == null) return 0;           // Q1: what does null return?
    int left  = solve(node.left);         // Q2: ask left child
    int right = solve(node.right);        // Q2: ask right child
    return /* combine left, right */;     // Q3: combine
}
```

### Pattern selector

```
Does the answer always live at the root?
  YES → Pattern 1: return the answer directly

Does the answer live at any node (any path, any subtree)?
  YES → Pattern 2: global variable updated as side effect

Do you need to collect all valid paths or states?
  YES → Pattern 3: backtracking (add down, remove up)

Does each node need to know something about its ancestors?
  YES → pass it as a parameter (top-down)
  NO  → build it from return values (bottom-up)

Is the tree a BST?
  YES → use value comparisons to pick ONE direction
  NO  → recurse both sides
```

### Base case selector

```
Counting or measuring?         → return 0
Checking validity with &&?     → return true
Checking existence with ||?    → return false
Finding minimum?               → return Integer.MAX_VALUE
Finding maximum (can be neg)?  → return Integer.MIN_VALUE
Finding a node?                → return null
Void — collecting into list?   → return  (nothing)
```

### Combine cheat sheet

| What you are computing | Combine line |
|---|---|
| Height / max depth | `1 + Math.max(left, right)` |
| Minimum depth | `1 + Math.min(left, right)` |
| Node count | `1 + left + right` |
| Value sum | `node.val + left + right` |
| Property holds everywhere | `left && right && conditionHere` |
| Property holds anywhere | `left \|\| right \|\| conditionHere` |
| Best across all nodes | update `best[0]`; return `1 + Math.max(left, right)` |

---

*DSA Learning Notes — Java — Trees*
