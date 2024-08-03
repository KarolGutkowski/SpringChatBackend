# Spring Chat Application

## Short description
This a backend for chat application based on websockets.
For the project i've used so far
- Spring boot
- Websockets
- Docker (docker compose)

## How to run

### With docker and Gradle
This is more future-proof and will also guarantee database container spin-up in the future.

> [!IMPORTANT]
> You'll need docker daemon to be on and gradle to be installed

```sh
# run the script in the main directory of the project
./run_gradle.sh
```

### With most IDEs
Your idea (f.e. Intellij) should recognize Gradle build files and set up the compilation properly.
Bare in mind this might require some database setup in the future

