
import hibernate.persistence.dao.RoleDAO;
import java.util.ArrayList;
import hibernate.persistence.entities.User;
import hibernate.persistence.dao.UserDAO;
import hibernate.persistence.dao.UserRoleDAO;
import hibernate.persistence.entities.Role;
import hibernate.persistence.entities.UserRole;

public class TestarPersistence {

    public static void main(String[] args) {
        try {
            // Remove todas as regras
            removeAllRoles();
            // Remove todos os usuarios
            removeAllUser();
            // Remove todos relacionamentos
            removeAllUserRoles();
            // Cria um novo usuario
            User user = createUsers("User 1");
            // Cria novas regras
            Role role1 = createRoles("Regra 1");
            Role role2 = createRoles("Regra 2");
            // Cria o relaciomanento
            createUsersRoles(role1, user);
            createUsersRoles(role2, user);
            // Lista todos usuarios
            showAllUser();
            // Lista todas as regras
            showAllRole();
            // Lista todos relacionamentos
            showAllUserRole();
            // Busca usuarios que contenham determinada regra
            showUserFindRole(role1);
            // Adiciona uma nova regra ao usuario
            Role role3 = createRoles("Regra 3 - relacionamento");
            addNewRole(user, role3);
            // Remove uma regra do usuario
            removeRole(role1, user);
            // Verifica se usuario possui a regra
            hasRole(user, role1);
            // Busca todas as regras que tenham o usuario
            findRoles(user);
                    
        } catch (Exception ex) {
            System.out.println("A tentativa de criar usuários falhou!/n... " + ex.getMessage());
        }

    }

    private static User createUsers(String name) throws Exception {
        UserDAO dao_user = new UserDAO();

        System.out.println("Cria novos usuarios...");

        User user1 = new User();
        user1.setName(name);
        dao_user.save(user1);

        return user1;
    }

    private static Role createRoles(String name) throws Exception {
        RoleDAO dao_role = new RoleDAO();

        System.out.println("Cria novas regras...");

        Role role1 = new Role();
        role1.setName(name);
        dao_role.save(role1);

        return role1;

    }

    private static void createUsersRoles(Role role1, User user1) throws Exception {
        UserRoleDAO dao_userrole = new UserRoleDAO();

        System.out.println("Criando relacionamento...");
        UserRole userrole1 = new UserRole();
        userrole1.setRoleid(role1.getID());
        userrole1.setUserid(user1.getId());
        dao_userrole.save(userrole1);

    }

    private static void showAllUser() throws Exception {
        System.out.println("Listando usuários...");
        UserDAO dao = new UserDAO();
        ArrayList users = (ArrayList) dao.findAll();
        User o;

        for (int i = 0; i < users.size(); i++) {
            o = (User) users.get(i);
            System.out.println(o);
        }

    }

    private static void showAllRole() throws Exception {
        System.out.println("Listando regras...");
        RoleDAO dao = new RoleDAO();
        ArrayList roles = (ArrayList) dao.findAll();
        Role o;

        for (int i = 0; i < roles.size(); i++) {
            o = (Role) roles.get(i);
            System.out.println(o);
        }

    }

    private static void showAllUserRole() throws Exception {
        System.out.println("Listando usuários e regras ...");
        UserRoleDAO dao = new UserRoleDAO();

        ArrayList userrole = (ArrayList) dao.findAll();
        UserRole o;

        for (int i = 0; i < userrole.size(); i++) {
            o = (UserRole) userrole.get(i);
            System.out.println(o);
        }

    }

    private static void showUserFindRole(Role role) throws Exception {
        System.out.println("Listando usuários que contenham a regra " + role.getName() + "  ...");
        UserRoleDAO dao = new UserRoleDAO();
        ArrayList userrole = (ArrayList) dao.findUser(role);
        UserRole o;

        for (int i = 0; i < userrole.size(); i++) {
            o = (UserRole) userrole.get(i);
            System.out.println(o);
        }

    }

    private static void addNewRole(User user, Role role) throws Exception {
        System.out.println("Adicionando regras a usuários...");
        UserRoleDAO userrole = new UserRoleDAO();
        userrole.addRole(user, role);

    }

    private static void removeRole(Role role, User user) throws Exception {
        System.out.println("Removendo regras...");
        UserRoleDAO userrole = new UserRoleDAO();
        userrole.removeRole(user, role);
    }

    private static void hasRole(User user, Role role) throws Exception {
        System.out.println("Verificando regras...");
        UserRoleDAO userrole = new UserRoleDAO();
        userrole.hasRole(user, role);
    }

    private static void findRoles(User user) throws Exception {
        System.out.println("Listando Regras dos usuários...");

        UserRoleDAO userrole = new UserRoleDAO();
        ArrayList listrole = (ArrayList) userrole.findRole(user);
        Role role;

        for (int i = 0; i < listrole.size(); i++) {
            role = (Role) listrole.get(i);
            System.out.println(role);
        }

    }

    private static void removeAllUser() throws Exception {
        System.out.println("Romovendo todos os usuarios...");
        UserDAO dao = new UserDAO();
        dao.removeAll();
    }

    private static void removeAllRoles() throws Exception {
        System.out.println("Removendo todas as roles...");
        RoleDAO dao = new RoleDAO();
        dao.removeAll();
    }
    
    private static void removeAllUserRoles() throws Exception {
        System.out.println("Removendo todas as userroles...");
        UserRoleDAO dao = new UserRoleDAO();
        dao.removeAll();
    }

}
