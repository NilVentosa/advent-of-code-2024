#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <DayNumber>"
    exit 1
fi

DAY_NUMBER=$1

DEST_DIR="src/main/java/xyz/ventosa/day$DAY_NUMBER"
DEST_DIR_TEST="src/test/java/xyz/ventosa/day$DAY_NUMBER"
RESOURCES_DIR="src/main/resources/Day$DAY_NUMBER"

if [ -d "$DEST_DIR" ]; then
    echo "Directory $DEST_DIR already exists."
    exit 1
fi

TEST_FILE="dayGenerator/templates/DayTest.java"
SOLUTION_FILE="dayGenerator/templates/Day.java"

if [ ! -f "$TEST_FILE" ] || [ ! -f "$SOLUTION_FILE" ]; then
    echo "One or both files do not exist."
    exit 1
fi

mkdir -p "$DEST_DIR"
mkdir -p "$DEST_DIR_TEST"
mkdir -p "$RESOURCES_DIR"

sed "s/\${DayNumber}/$DAY_NUMBER/g" "$TEST_FILE" > "$DEST_DIR_TEST/Day${DAY_NUMBER}Test.java"
sed "s/\${DayNumber}/$DAY_NUMBER/g" "$SOLUTION_FILE" > "$DEST_DIR/Day${DAY_NUMBER}.java"
touch "$RESOURCES_DIR/input"
touch "$RESOURCES_DIR/test"
