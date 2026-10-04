# Assignment 3: Bridge Pattern

- **Student Name:** Rayazov Mustafa
- **Group:** SE-2529
- **Topic:** Option D — Remote Controls
- **Repository URL:** https://github.com/mrreikol/SDP-Assignment-3
- **Base Commit Hash:** 38b55de8b0cbe9c940b24a8ccfa17a9a5ca129a0

---

## 1. Role Map

| Pattern Role | Class / Interface | Source File Path |
| :--- | :--- | :--- |
| **Client** | `Main` | `src/Main.java` |
| **Abstraction** | `Remote` | `src/remote/Remote.java` |
| **Refined Abstraction (A1)** | `BasicRemote` | `src/remote/BasicRemote.java` |
| **Refined Abstraction (A2)** | `QuietRemote` | `src/remote/QuietRemote.java` |
| **Implementor** | `Device` | `src/remote/Device.java` |
| **Concrete Implementor (I1)** | `TvDevice` | `src/remote/TvDevice.java` |
| **Concrete Implementor (I2)** | `RadioDevice` | `src/remote/RadioDevice.java` |
| **Extension Implementor (I3)** | `ProjectorDevice` | `src/remote/ProjectorDevice.java` |

---

## 2. Key Code References

- **Bridge Interface Field:** Stored as `private Device device` in `src/remote/Remote.java` (line 6).
- **Execution Operation:** `public abstract String execute()` defined in `src/remote/Remote.java` (line 37) and implemented in `BasicRemote` and `QuietRemote`.
- **Runtime Replacement Method:** `public void setImplementation(Device device)` in `src/remote/Remote.java` (line 29).
- **Runtime Switch Check (T5):** Executed in `src/Main.java` (lines 46–60).

---

## 3. Build and Run Commands

Compile the project from the root folder without IDE dependencies:
```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"

java -cp out Main --demo