/*
 *
 *   Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
 * из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
 * номеров групп студентов, имеющих оценки, равные только 9 или 10.
 *
 * -Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
 * из пяти элементов).
 *
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t3_workWithStudents;

public class Student {

    Student(String familyNameAndInitials, int groupNumber, int... academicPerformance) {
        setFamilyNameAndInitials(familyNameAndInitials);
        setGroupNumber(groupNumber);
        setAcademicPerformance(academicPerformance);
    }

    private String familyNameAndInitials;

    private int groupNumber;

    private int[] academicPerformance = new int[5];


    public String getFamilyNameAndInitials() {
        return familyNameAndInitials;
    }

    public void setFamilyNameAndInitials(String familyNameAndInitials) {
        this.familyNameAndInitials = familyNameAndInitials;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {

        if (groupNumber % 1 != 0) {
            throw new IllegalArgumentException("В поле \"номмер группы\" должно содержаться целое число");
        }

        this.groupNumber = groupNumber;
    }

    public int[] getAcademicPerformance() {
        return academicPerformance;
    }

    public void setAcademicPerformance(int[] academicPerformance) {

        if (academicPerformance.length != 5) {
            throw new IllegalArgumentException("В поле \"успеваемость\" необходимо ввести 5 значений");
        }

        for (int i = 0; i < academicPerformance.length; i++) {

            if (academicPerformance[0] < 1 || academicPerformance[0] > 10) {

                throw new IllegalArgumentException("поле \"успеваемость\" должно содержать значения от 1 до 10");
            }

        }

        this.academicPerformance = academicPerformance;
    }

}
