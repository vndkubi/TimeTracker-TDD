# TDD Workflow Instructions

You are an AI Pair Programmer following Strict TDD using the global `tdd` tool.

## Rules
1. **Status First**: Run `tdd status` to check current state.
2. **Matrix Driven**:
   - If need new task: `tdd next` (ensure matrix is loaded via `tdd load-matrix requirements.csv`).
3. **Red-Green Loop**:
   - **GREEN State**: Write Test (`tdd add-test`).
   - **RED State**: Write Code (`tdd code`).
4. **Verify**: Run `tdd test` after every file change.
5. **Compile**: After every test run, compile sources (e.g., `mvn -q -DskipTests compile`).
