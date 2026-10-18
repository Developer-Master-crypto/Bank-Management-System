# Bank Management System

A desktop ATM-style banking application built in Java Swing. The idea is to let a customer open an account, receive a card and PIN, then perform everyday banking actions the same way they would at a machine: deposit, withdraw, check balance, print a mini statement, and change PIN.

## Ideation

People already understand an ATM. This project uses that familiar flow as a teaching and demonstration model for a complete beginner-to-intermediate Java application: forms, validation, JDBC, and a MySQL backend.

**Problem.** Manual or paper-based account opening and cash handling is slow, error-prone, and hard to audit.

**Idea.** Capture account opening in three short screens, issue a 16-digit card number and 4-digit PIN, then route every later action through a PIN-authenticated ATM menu. Each cash movement is stored as a bank transaction so balance is always derived from history, not a single editable field.

**Who it is for.** Students and developers learning Java GUI + database integration, and anyone who wants a working local prototype of core retail-banking operations.

## What the application does

1. **Sign in** with card number and PIN, or start a new application.
2. **Open an account** in three pages:
   - Personal details (name, DOB, gender, email, address)
   - Additional details (occupation, PAN, Aadhaar, senior citizen, existing customer)
   - Account type and services (ATM card, internet banking, and so on)
3. **Issue credentials.** After submit, the system generates a card number and PIN and opens a first deposit screen.
4. **Operate the ATM.** From the transaction menu the customer can:
   - Deposit cash
   - Withdraw cash (blocked if the balance is too low)
   - Use Fast Cash presets (100, 500, 1000, 2000, 5000, 10000)
   - View a mini statement and current balance
   - Enquire balance
   - Change PIN
   - Exit

## Project flow

```text
Login
  ├─ SIGN IN  → Transaction menu
  └─ SIGN UP  → Signup page 1 → page 2 → page 3
                    └─ card + PIN issued → first Deposit → Transaction menu

Transaction menu
  ├─ Deposit
  ├─ Withdraw
  ├─ Fast Cash
  ├─ Mini Statement
  ├─ Pin Change
  ├─ Balance Enquiry
  └─ Exit
```

## Tech stack

| Layer | Choice |
| --- | --- |
| Language | Java 17+ |
| UI | Java Swing (`JFrame`, buttons, radio groups, date chooser) |
| Build | Maven (`Bank_Management_Syatem`) |
| Database | MySQL (`bankmanagementsystem`) |
| Connectivity | JDBC (`mysql-connector-j`) |
| Extra UI | JCalendar for date of birth |

Main entry points: `org.ganesh.Main` or `org.ganesh.Login`.

## Modules (source)

| Class | Role |
| --- | --- |
| `Main` | Starts the login window on the Swing thread |
| `Login` | Card/PIN authentication and signup entry |
| `SignupOne` / `Signuptwo` / `Signupthree` | Three-step account opening |
| `Transaction` | ATM home menu |
| `Deposit` / `Withdrawl` / `FastCash` | Cash in and cash out |
| `BalanceEnquiry` / `MiniStatement` | Read-only account views |
| `PinChange` | Updates PIN in `bank`, `login`, and `signup3` |
| `connjdbc` | Shared MySQL connection |

## Data idea

Balance is not stored as one master number. The `bank` table holds rows of type `Deposit` or `Withdraw`. Screens add deposits, subtract withdrawals, and show the running total. That matches how a simple ledger works and keeps mini statement and balance in sync.

Typical tables used by the app:

- `signupOne` — personal details
- `signup2` — additional KYC-style details
- `signup3` — account type, card, PIN, facilities
- `login` — card number and PIN for sign-in
- `bank` — pin, date, type, amount

Create the database `bankmanagementsystem` in MySQL and point `connjdbc` at your local user and password before running.

## How to run

1. Install JDK 17 or later and MySQL.
2. Create database `bankmanagementsystem` and the tables above.
3. Set JDBC URL, username, and password in `src/main/java/org/ganesh/connjdbc.java`.
4. Place `logo.jpg` and `atm.jpg` in `src/main/resources/icons/` (login logo and ATM background).
5. Compile and run:

```bash
mvn compile
mvn exec:java -Dexec.mainClass=org.ganesh.Main
```

Or run `org.ganesh.Login` from your IDE.

## Scope and next ideas

This is a **local desktop prototype**, not a production bank. Card numbers and PINs are generated in the app; traffic is not encrypted; SQL is written for a classroom/lab setup.

Possible next steps: prepared statements everywhere, hashed PINs, a proper accounts table with a stored balance, transfer between accounts, and an admin console for staff.

## License

Academic / personal project. Use and extend as needed for learning.
