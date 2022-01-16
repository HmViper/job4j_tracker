package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    /**
     * Хранение пары клиент - счета клиента в HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление нового клиента в HashMap
     * Производится проверка существования клиента. Для нового клиента добавляется
     * пустой List с его счетами
     *
     * @param user новый добавляемый пользователь
     */
    public void addUser(User user) {
        if (user != null) {
            users.putIfAbsent(user, new ArrayList<>());
        }
    }

    /**
     * Добавление нового счета для клиента. Производится поиск
     * клиента по паспорту. Если клиент существует то выбираем все счета.
     * Если нового счета среди них нет то создаем новый счет
     *
     * @param passport паспорт клиента для его поиска
     * @param account  новый добавляемый счет клиента
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Поиск клиента по паспорту. Перебираем всех клиентов
     * Сравниваем входной параметр с паспортами перебираемых клиентов
     *
     * @param passport паспорт клиента для его поиска
     * @return найденный клиент по паспорту
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * поиск счета по реквизитам. Перебираем всех клиентов.
     * Находим искомого клиента по паспорту. У найденного клиента перебираем все его счета
     * В перебираемых счетах сравниваем реквизиты. Находим искомый счет
     *
     * @param passport  паспорт для поиска клиента
     * @param requisite реквизиты искомого счета
     * @return найденный счет
     */

    public Account findByRequisite(String passport, String requisite) {
        if (requisite != null) {
            User user = findByPassport(passport);
            if (user != null) {
                return users.get(user)
                        .stream()
                        .filter(u -> u.getRequisite().equals(requisite))
                        .findFirst().orElse(null);
            }
        }
        return null;
    }

    /**
     * Перенос денежный средств со счета на счет. Производим поиск счета отправителя и получателя
     * получаем баланс счета отправителя. Списываем сумму со счета отправителя на счет получателя
     *
     * @param srcPassport   паспорт отправителя для поиска счета
     * @param srcRequisite  реквизиты счета отправителя для поиска счета
     * @param destPassport  паспорт получателя для поиска счета
     * @param destRequisite реквизиты получателя для поиска счета
     * @param amount        сумма списания
     * @return возвращает true если все удачно, false если списание не удалось.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSource = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSource != null && accountDest != null && accountSource.getBalance() >= amount) {
            accountSource.setBalance(accountSource.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}