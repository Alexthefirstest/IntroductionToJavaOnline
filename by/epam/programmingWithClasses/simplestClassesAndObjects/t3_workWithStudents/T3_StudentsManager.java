/*
 *
 *    Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
 * из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
 * номеров групп студентов, имеющих оценки, равные только 9 или 10.
 *
 * класс содержит методы, необходимые для вывода фамилий и номеров групп студентов,
 * имеющих оценки, равные только 9 или 10 и метод для создания нового объекта student.
 *
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t3_workWithStudents;

import java.util.ArrayList;

public class T3_StudentsManager {

    public static void main(String[] args) {

        Student[] students = new Student[10];

        students[0] = addStudent("Студент1 А.А.", 1, 8, 7, 1, 8, 9);
        students[1] = addStudent("Студент2 А.А.", 1, 8, 6, 1, 8, 9);
        students[2] = addStudent("Студент3 А.А.", 2, 8, 8, 9, 8, 9);
        students[3] = addStudent("Студент4 А.А.", 1, 10, 10, 10, 10, 10);
        students[4] = addStudent("Студент5 А.А.", 2, 10, 9, 10, 9, 10);
        students[5] = addStudent("Студент6 А.А.", 1, 8, 7, 6, 8, 9);
        students[6] = addStudent("Студент7 А.А.", 1, 8, 7, 9, 8, 6);
        students[7] = addStudent("Студент8 А.А.", 1, 10, 9, 10, 9, 10);
        students[8] = addStudent("Студент9 А.А.", 1, 8, 7, 1, 8, 9);
        students[9] = addStudent("Студент10 А.А.", 1, 8, 7, 1, 8, 8);

        printNamesAndGroupNumber(excellentStudentsFinder(students));
    }


    static public Student addStudent(String familyNameAndInitials, int groupNumber, int... academicPerformance) {

        Student student = new Student(familyNameAndInitials, groupNumber, academicPerformance);
        return student;
    }


    static public void printNamesAndGroupNumber(Student[] students) {

        for (int i = 0; i < students.length; i++) {
            System.out.println("Студент " + students[i].getFamilyNameAndInitials() + ", группа №" + students[i].getGroupNumber());
        }

    }


    static public Student[] excellentStudentsFinder(Student[] students) {

        ArrayList<Student> excellentStudents = new ArrayList<Student>();

        for (int i = 0; i < students.length; i++) {

            int[] marks = students[i].getAcademicPerformance();
            int j = 0;
            boolean isExcellent = true;

            while (j < marks.length && isExcellent == true) {
                isExcellent = marks[j] >= 9 ? true : false;
                j++;
            }

            if (isExcellent == true) {
                excellentStudents.add(students[i]);
            }

        }//for

        Student[] excellentStudentsarr = new Student[excellentStudents.size()];
        excellentStudentsarr = excellentStudents.toArray(excellentStudentsarr);
        return excellentStudentsarr;
    }

}//class



