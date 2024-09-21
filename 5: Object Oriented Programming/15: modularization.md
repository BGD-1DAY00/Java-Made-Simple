# Modularization: Breaking Down a Large Function

## Before: Large, Monolithic Function

```c
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_STUDENTS 100
#define MAX_NAME_LENGTH 50

int main() {
    char names[MAX_STUDENTS][MAX_NAME_LENGTH];
    int grades[MAX_STUDENTS];
    int attendance[MAX_STUDENTS];
    int studentCount = 0;
    char input[10];

    while (1) {
        printf("\nSchool Management System\n");
        printf("1. Add Student\n");
        printf("2. Display All Students\n");
        printf("3. Update Grade\n");
        printf("4. Update Attendance\n");
        printf("5. Calculate Average Grade\n");
        printf("6. Exit\n");
        printf("Enter your choice: ");
        scanf("%s", input);

        if (strcmp(input, "1") == 0) {
            if (studentCount < MAX_STUDENTS) {
                printf("Enter student name: ");
                scanf("%s", names[studentCount]);
                printf("Enter grade: ");
                scanf("%d", &grades[studentCount]);
                printf("Enter attendance (days present): ");
                scanf("%d", &attendance[studentCount]);
                studentCount++;
                printf("Student added successfully.\n");
            } else {
                printf("Maximum student limit reached.\n");
            }
        } else if (strcmp(input, "2") == 0) {
            printf("\nStudent List:\n");
            for (int i = 0; i < studentCount; i++) {
                printf("%d. Name: %s, Grade: %d, Attendance: %d days\n", 
                       i+1, names[i], grades[i], attendance[i]);
            }
        } else if (strcmp(input, "3") == 0) {
            int index, newGrade;
            printf("Enter student index: ");
            scanf("%d", &index);
            if (index > 0 && index <= studentCount) {
                printf("Enter new grade: ");
                scanf("%d", &newGrade);
                grades[index-1] = newGrade;
                printf("Grade updated successfully.\n");
            } else {
                printf("Invalid student index.\n");
            }
        } else if (strcmp(input, "4") == 0) {
            int index, newAttendance;
            printf("Enter student index: ");
            scanf("%d", &index);
            if (index > 0 && index <= studentCount) {
                printf("Enter new attendance: ");
                scanf("%d", &newAttendance);
                attendance[index-1] = newAttendance;
                printf("Attendance updated successfully.\n");
            } else {
                printf("Invalid student index.\n");
            }
        } else if (strcmp(input, "5") == 0) {
            if (studentCount > 0) {
                int sum = 0;
                for (int i = 0; i < studentCount; i++) {
                    sum += grades[i];
                }
                float average = (float)sum / studentCount;
                printf("Average grade: %.2f\n", average);
            } else {
                printf("No students to calculate average.\n");
            }
        } else if (strcmp(input, "6") == 0) {
            printf("Exiting program.\n");
            break;
        } else {
            printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}
```

## After: Modularized Version

```c
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_STUDENTS 100
#define MAX_NAME_LENGTH 50

char names[MAX_STUDENTS][MAX_NAME_LENGTH];
int grades[MAX_STUDENTS];
int attendance[MAX_STUDENTS];
int studentCount = 0;

void addStudent() {
    if (studentCount < MAX_STUDENTS) {
        printf("Enter student name: ");
        scanf("%s", names[studentCount]);
        printf("Enter grade: ");
        scanf("%d", &grades[studentCount]);
        printf("Enter attendance (days present): ");
        scanf("%d", &attendance[studentCount]);
        studentCount++;
        printf("Student added successfully.\n");
    } else {
        printf("Maximum student limit reached.\n");
    }
}

void displayStudents() {
    printf("\nStudent List:\n");
    for (int i = 0; i < studentCount; i++) {
        printf("%d. Name: %s, Grade: %d, Attendance: %d days\n", 
               i+1, names[i], grades[i], attendance[i]);
    }
}

void updateGrade() {
    int index, newGrade;
    printf("Enter student index: ");
    scanf("%d", &index);
    if (index > 0 && index <= studentCount) {
        printf("Enter new grade: ");
        scanf("%d", &newGrade);
        grades[index-1] = newGrade;
        printf("Grade updated successfully.\n");
    } else {
        printf("Invalid student index.\n");
    }
}

void updateAttendance() {
    int index, newAttendance;
    printf("Enter student index: ");
    scanf("%d", &index);
    if (index > 0 && index <= studentCount) {
        printf("Enter new attendance: ");
        scanf("%d", &newAttendance);
        attendance[index-1] = newAttendance;
        printf("Attendance updated successfully.\n");
    } else {
        printf("Invalid student index.\n");
    }
}

void calculateAverageGrade() {
    if (studentCount > 0) {
        int sum = 0;
        for (int i = 0; i < studentCount; i++) {
            sum += grades[i];
        }
        float average = (float)sum / studentCount;
        printf("Average grade: %.2f\n", average);
    } else {
        printf("No students to calculate average.\n");
    }
}

void displayMenu() {
    printf("\nSchool Management System\n");
    printf("1. Add Student\n");
    printf("2. Display All Students\n");
    printf("3. Update Grade\n");
    printf("4. Update Attendance\n");
    printf("5. Calculate Average Grade\n");
    printf("6. Exit\n");
    printf("Enter your choice: ");
}

int main() {
    char input[10];

    while (1) {
        displayMenu();
        scanf("%s", input);

        if (strcmp(input, "1") == 0) {
            addStudent();
        } else if (strcmp(input, "2") == 0) {
            displayStudents();
        } else if (strcmp(input, "3") == 0) {
            updateGrade();
        } else if (strcmp(input, "4") == 0) {
            updateAttendance();
        } else if (strcmp(input, "5") == 0) {
            calculateAverageGrade();
        } else if (strcmp(input, "6") == 0) {
            printf("Exiting program.\n");
            break;
        } else {
            printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}
```