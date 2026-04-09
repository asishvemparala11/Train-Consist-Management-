# UC15: Safe Cargo Assignment Using try-catch-finally

## Overview
UC15 demonstrates how to safely handle unsafe cargo assignments in a railway system using structured exception handling with `try-catch-finally` blocks.

## Problem Statement (Drawback of UC14)
In UC14, validation happens during object creation using checked exceptions, stopping execution immediately. However:
- Cargo may be assigned dynamically during runtime
- Operators may choose unsafe combinations while the system is running
- Runtime exceptions need to be managed without crashing the application
- Cleanup and logging must always happen, regardless of success or failure

## Solution: try-catch-finally Pattern

### Key Components

#### 1. **CargoSafetyException.java**
Custom runtime exception for unsafe cargo assignments:
```java
public class CargoSafetyException extends RuntimeException {
    // Unchecked exception - doesn't require explicit throws
    // Allows graceful handling during program execution
}
```

#### 2. **GoodsBogie.java**
Implements safe cargo assignment with exception handling:
```java
public void assignCargo(String cargoType) {
    try {
        // Validation logic
        if (cargoType == null || cargoType.trim().isEmpty()) {
            throw new CargoSafetyException("Cargo type cannot be empty");
        }
        
        // Safety Check: Petroleum in Rectangular bogie is UNSAFE
        if (cargoType.equalsIgnoreCase("Petroleum") && 
            this.shape.equalsIgnoreCase("Rectangular")) {
            throw new CargoSafetyException(
                "Cannot assign Petroleum to Rectangular bogie. " +
                "Petroleum is flammable; Rectangular bogies have open tops."
            );
        }
        
        // Safe assignment
        this.assignedCargo = cargoType;
        this.cargoAssigned = true;
        
    } catch (CargoSafetyException e) {
        // Handle exception gracefully
        System.err.println("✗ ERROR: " + e.getMessage());
        this.assignedCargo = null;
        this.cargoAssigned = false;
        
    } finally {
        // ALWAYS executes - logging/cleanup
        System.out.println("[Validation Complete]");
    }
}
```

#### 3. **UC15_SafeCargoAssignment.java**
Main application demonstrating the use case with multiple scenarios.

### Safety Rules
- ✓ **Petroleum + Cylindrical bogie = SAFE**
- ✗ **Petroleum + Rectangular bogie = UNSAFE** (Fire hazard)
- ✓ Other cargo types can be assigned to any bogie

## Flow of Execution

```
User attempts cargo assignment
        ↓
try block: Validate cargo type
        ↓
Safety check: Check shape compatibility
        ↓
        ├─ SAFE: Assign cargo, continue
        │
        └─ UNSAFE: Throw CargoSafetyException
                ↓
        catch block: Handle exception
                ├─ Log error message
                ├─ Clear cargo assignment
                ├─ Set cargoAssigned = false
                ↓
        finally block: ALWAYS execute
                ├─ Log "Validation Complete"
                ↓
Program continues safely to next operation
```

## Test Cases

### Test Case 1: testCargo_SafeAssignment()
**Purpose:** Verify successful safe cargo assignments

**Scenario:**
- Assign Grain to Rectangular bogie ✓
- Assign Petroleum to Cylindrical bogie ✓

**Assertions:**
- `cargoAssigned` flag is true
- `getAssignedCargo()` returns correct cargo type

---

### Test Case 2: testCargo_UnsafeAssignmentHandled()
**Purpose:** Verify exception handling for unsafe combinations

**Scenario:**
- Attempt to assign Petroleum to Rectangular bogie
- Exception should be caught internally
- No uncaught exception should propagate

**Assertions:**
- Method executes without throwing exception
- System displays error message

---

### Test Case 3: testCargo_CargoNotAssignedAfterFailure()
**Purpose:** Verify cargo is NOT assigned when unsafe combination occurs

**Scenario:**
- Attempt unsafe assignment
- Verify bogie remains in safe state

**Assertions:**
- `cargoAssigned` is false
- `getAssignedCargo()` is null

---

### Test Case 4: testCargo_ProgramContinuesAfterException()
**Purpose:** Verify application continues after exception handling

**Scenario:**
1. Assign Grain to bogie1 (success)
2. Attempt Petroleum to bogie2 (fail)
3. Assign Steel to bogie3 (should work)

**Assertions:**
- bogie1 has cargo ✓
- bogie2 has NO cargo ✓
- bogie3 has cargo ✓
- Program continues after failure ✓

---

### Test Case 5: testCargo_FinallyBlockExecution()
**Purpose:** Verify finally block always executes

**Scenario:**
- Test finally with safe assignment
- Test finally with unsafe assignment

**Assertions:**
- Completion logging appears in both cases
- Finally block executes regardless of try/catch outcome

---

### Additional Tests:

**testCargo_EmptyCargoType():**
- Verify empty cargo types are rejected

**testCargo_MultipleAssignments():**
- Verify multiple sequential assignments work correctly

## Key Concepts Used

### 1. **try Block**
- Contains code that might throw an exception
- Cargo validation logic
- Assignment operations

### 2. **catch Block**
- Catches specific exceptions (CargoSafetyException)
- Handles errors gracefully
- Logs error messages
- Reverts state (clears cargo assignment)

### 3. **finally Block**
- ALWAYS executes, regardless of try/catch outcome
- Used for cleanup/logging
- Ensures consistency
- Represents "validation complete" message

### 4. **Custom Runtime Exception**
- `CargoSafetyException extends RuntimeException`
- Unchecked exception (compiler doesn't require throws)
- Thrown during program execution
- Represents domain-specific safety violations

### 5. **Graceful Failure Handling**
- Exception caught and handled
- No application crash
- User gets error feedback
- System continues operating safely

## Example Output

```
===== UC15: Safe Cargo Assignment Using try-catch-finally =====

--- Phase 1: Initialize Goods Bogies ---
Created two goods bogies: 1 Rectangular, 1 Cylindrical

--- Phase 2: Test Case 1 - Safe Cargo Assignment ---
Attempting: Assign Grain to Rectangular bogie

✓ Cargo assignment successful: Grain assigned to bogie BG-RECT-101 (Rectangular)
  [Validation Complete] Bogie BG-RECT-101 - Cargo Assignment Status: SUCCESS

--- Phase 3: Test Case 2 - Unsafe Cargo Detection ---
Attempting: Assign Petroleum to Rectangular bogie (UNSAFE)

✗ ERROR - Cargo assignment failed for bogie BG-RECT-103
  Reason: SAFETY VIOLATION: Cannot assign Petroleum to Rectangular bogie...
  [Validation Complete] Bogie BG-RECT-103 - Cargo Assignment Status: FAILED

Verification: Check if cargo was assigned after failure
Cargo assigned? false

--- Phase 4: Test Case 3 - Safe Petroleum Assignment ---
Attempting: Assign Petroleum to Cylindrical bogie (SAFE)

✓ Cargo assignment successful: Petroleum assigned to bogie BG-CYL-102 (Cylindrical)
  [Validation Complete] Bogie BG-CYL-102 - Cargo Assignment Status: SUCCESS
```

## Benefits

| Benefit | Impact |
|---------|--------|
| **Runtime Safety** | Prevents unsafe cargo combinations during execution |
| **Exception Management** | Catches and handles runtime errors gracefully |
| **Program Resilience** | Continues operating after failures |
| **Consistent Logging** | Finally block ensures cleanup always happens |
| **Error Feedback** | Users get clear, actionable error messages |
| **State Protection** | Reverts state on failure, maintaining consistency |

## Comparison: UC14 vs UC15

| Aspect | UC14 (Checked Exceptions) | UC15 (try-catch-finally) |
|--------|--------------------------|-------------------------|
| **When checked** | Compile time | Runtime |
| **Handling** | Forces throws/try-catch | Optional with try-catch |
| **Control** | Caller must handle | Callee can handle internally |
| **Scenario** | Object creation | Dynamic operations |
| **Application flow** | Stops at error | Continues after handling |
| **Cleanup** | No guarantee | Always happens (finally) |

## How to Run

### Compile
```bash
javac src/main/java/*.java
javac -cp src/main/java src/test/java/UC15_SafeCargoAssignmentTest.java
```

### Run Main Application
```bash
java -cp src/main/java UC15_SafeCargoAssignment
```

### Run Tests
```bash
java -cp src/test/java:src/main/java org.junit.runner.JUnitCore UC15_SafeCargoAssignmentTest
```

## Files Created

1. **CargoSafetyException.java** - Custom unchecked exception
2. **GoodsBogie.java** - Bogie with safe cargo assignment logic
3. **UC15_SafeCargoAssignment.java** - Main application demonstration
4. **UC15_SafeCargoAssignmentTest.java** - Comprehensive test suite

## Conclusion

UC15 demonstrates that beyond throwing exceptions (UC14), professional software systems must also **catch, manage, and recover from errors gracefully** using structured exception handling. The `try-catch-finally` pattern ensures:
- ✓ Safety constraints are enforced
- ✓ Errors are handled without crashing
- ✓ Cleanup/logging always happens
- ✓ Application remains stable and resilient
