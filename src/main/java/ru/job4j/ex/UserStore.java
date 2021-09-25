package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user : users) {
            if (user.getUserName().equals(login)) {
                rsl = user;
            }
        }
        if (rsl != null) {
            return rsl;
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUserName().length() > 3) {
            return true;
        } else {
            throw new UserInvalidException("User not valid or name less than 3 symbols");
        }

    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println("User not valid");
        } catch (UserNotFoundException ex) {
            System.out.println("User not found");
        }
    }
}