# Bit Manipulation

## 1. Fundamental Rule
Bit manipulation can safely replace normal arithmetic operations only when the operation aligns with the binary (base-2) structure of numbers. This usually happens with powers of two.

## 2. Basic Building Blocks

### Bitwise Operators

| Operator | Symbol | Description | Example (A=5 [0101], B=3 [0011]) |
| :--- | :---: | :--- | :--- |
| **AND** | `&` | Returns 1 if both bits are 1. | `5 & 3` $\to$ `0101 & 0011` = `0001` (1) |
| **OR** | `\|` | Returns 1 if at least one bit is 1. | `5 \| 3` $\to$ `0101 \| 0011` = `0111` (7) |
| **XOR** | `^` | Returns 1 if bits are different. | `5 ^ 3` $\to$ `0101 ^ 0011` = `0110` (6) |
| **NOT** | `~` | Inverts all bits (0 $\to$ 1, 1 $\to$ 0). | `~5` $\to$ `~0000...0101` = `1111...1010` (-6) |
| **Left Shift** | `<<` | Shifts bits to the left, filling with 0. Equivalent to multiplying by $2^k$. | `5 << 1` $\to$ `0101 << 1` = `1010` (10) |
| **Right Shift** | `>>` | Shifts bits to the right. Equivalent to dividing by $2^k$. | `5 >> 1` $\to$ `0101 >> 1` = `0010` (2) |

---

## 3. Operations That CAN Be Replaced

### 3.1 Even / Odd Check
The least significant bit (LSB) determines parity. If LSB is 1, the number is odd.
**Normal:** `n % 2 == 0`
**Bit manipulation:** `(n & 1) == 0`

Example: `n = 6 (110)` $\to$ `6 & 1 = 0` $\to$ even

### 3.2 Power of 2 Check
A number is a power of 2 if it has exactly one set bit.
**Formula:** `n > 0 && (n & (n - 1)) == 0`

Example: `n = 16 (10000)` $\to$ true, `n = 12 (1100)` $\to$ false

### 3.3 Modulo by Powers of 2
For non-negative numbers, modulo by $2^k$ is equivalent to masking the lower $k$ bits.
**Formula:** `n % 2^k` $\Leftrightarrow$ `n & (2^k - 1)`

Examples:
*   `n % 4` $\Leftrightarrow$ `n & 3`
*   `n % 8` $\Leftrightarrow$ `n & 7`

Example: `12 % 4 = 0` $\Leftrightarrow$ `12 & 3 = 0`

### 3.4 Multiply / Divide by Powers of 2
**Multiply:** `n * 2^k` $\Leftrightarrow$ `n << k`
**Divide (non-negative n):** `n / 2^k` $\Leftrightarrow$ `n >> k`

Example: `10 << 1 = 20`, `20 >> 2 = 5`

### 3.5 Power of 4 Check
A power of 4 is a power of 2 whose single set bit lies at an even index (0, 2, 4...).
**Formula:** `n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0`

Example: `16` $\to$ true, `8` $\to$ false

### 3.6 Bit Operations (Legitimate Use)
These are the fundamental operations used to manipulate specific bits at a given position `i` (0-indexed from right).

#### Get Bit
Check if the bit at the $i$-th position is 0 or 1.
```java
// Logic: Mask with 1 shifted i times
int getBit(int n, int i) {
    int bitMask = 1 << i;
    if ((n & bitMask) == 0) return 0;
    else return 1;
}
```

#### Set Bit
Set the bit at the $i$-th position to 1.
```java
// Logic: OR with 1 shifted i times
int setBit(int n, int i) {
    int bitMask = 1 << i;
    return n | bitMask;
}
```

#### Clear Bit
Set the bit at the $i$-th position to 0.
```java
// Logic: AND with NOT of (1 shifted i times)
int clearBit(int n, int i) {
    int bitMask = ~(1 << i);
    return n & bitMask;
}
```

#### Toggle Bit
Flip the bit at the $i$-th position.
```java
// Logic: XOR with 1 shifted i times
int toggleBit(int n, int i) {
    int bitMask = 1 << i;
    return n ^ bitMask;
}
```

#### Check Bit
Alternative verification (boolean style).
` (n & (1 << i)) != 0 `

---

## 4. Common Patterns & Tricks

### Swap Two Numbers (Without Temp Variable)
Logic: XOR property $a \oplus a = 0$ and $a \oplus 0 = a$.
```java
a = a ^ b;
b = a ^ b;
a = a ^ b;
```

### Clear Last Set Bit
This is important for many algorithms (like counting set bits).
**Formula:** `n & (n - 1)`
Example: `40 (101000) & 39 (100111) -> 32 (100000)`

### Count Set Bits (Brian Kernighan’s Algorithm)
Repeatedly turn off the least significant set bit until the number becomes 0.
```java
int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
        n = n & (n - 1);
        count++;
    }
    return count;
}
```

---

## 5. Operations That SHOULD NOT Be Replaced
The following operations should generally use normal arithmetic operators:
*   General addition and subtraction (`a + b`, `a - b`)
*   Modulo by non-powers of 2 (`n % 3`, `n % 5`, ...)
*   Multiplication or division by arbitrary numbers
*   Power checks for non-2 numbers (power of 3, 5, 7, ...)

## 6. Engineering Judgment
Clarity is more important than cleverness. Modern compilers already optimize arithmetic operations. Use bit manipulation only when it clearly models the math or when the problem explicitly requires it.

## 7. One-Line Summary
Bit manipulation cleanly replaces arithmetic only for powers of two and bit-level logic — nowhere else.
