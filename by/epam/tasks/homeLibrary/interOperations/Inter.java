/*
 *
 * класс класс реализует методы для входа в аккаунт полльзователя и администратора,
 * а так же регистрации
 *и вспомогательные методы
 *
 */

package by.epam.tasks.homeLibrary.interOperations;

import by.epam.tasks.homeLibrary.booksManagers.BookManagerForAdministrator;
import by.epam.tasks.homeLibrary.interOperations.logIn.LogIn;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Inter {

    public Inter() {

        loadUsers();
    }

    HashMap<String, String[]> usersData = new HashMap<>();

    public boolean usersLogIn() {

        String login;
        String password;
        int choice = 1;

        login = LogIn.enterLogin();
        password = LogIn.enterPasswordAndEncrypt();

        String[] user = usersData.get(login);

        while (user == null || !password.equals(user[0])) {

            System.out.println("неверно введено имя пользователя или пароль");

            System.out.print("1 - продолжить, 2 - назад: ");
            choice = BookManagerForAdministrator.doChoiceBetween1and2();

            if (choice == 2) {
                return false;
            }


            login = LogIn.enterLogin();
            password = LogIn.enterPasswordAndEncrypt();
            user = usersData.get(login);
        }

        return true;

    }

    public boolean adminLogIn() {

        String login;
        String password;

        login = LogIn.enterLogin();
        password = LogIn.enterPasswordAndEncrypt();

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(".\\src\\by\\epam\\tasks\\homeLibrary\\usersInfo\\adm.txt"));

            String line = reader.readLine();
            String[] adminInformation = line.split("/");
            reader.close();

            if (login.equals(adminInformation[0]) && password.equals(adminInformation[1])) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean userSignIn() {

        String login;
        String password;
        String email;
        Scanner in = new Scanner(System.in);

        login = LogIn.enterLogin();

        while (usersData.containsKey(login)) {
            System.out.print("этот логин уже занят, используйте другой: ");
            login = LogIn.enterLogin();
        }

        password = LogIn.enterPasswordAndEncrypt();
        System.out.print("Введите email: ");
        email = in.nextLine();

        addUser(login, password, email);

        return true;
    }

    private void addUser(String login, String password, String email) {

        /*
         *добавлени юзера в список внутри программы и сохранения файл,
         *таким образом отдельно целиком обновлять данные в файле не нужно
         */
        usersData.put(login, new String[]{password, email});
        saveUser(login, password, email);

    }

    private void saveUser(String login, String password, String email) {

        try {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(".\\src\\by\\epam\\tasks\\homeLibrary\\usersInfo\\users.txt", true));

            writer.write(login + "/" + password + "/" + email + "\n");
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    private void loadUsers() {

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(".\\src\\by\\epam\\tasks\\homeLibrary\\usersInfo\\users.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] userInformation = line.split("/");

                usersData.put(userInformation[0], new String[]{userInformation[1], userInformation[2]});
            }
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
