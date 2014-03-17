
import hibernate.persistence.dao.RoleDAO;
import java.util.ArrayList;
import hibernate.persistence.entities.User;
import hibernate.persistence.dao.UserDAO;
import hibernate.persistence.dao.UserRoleDAO;
import hibernate.persistence.entities.Role;
import hibernate.persistence.entities.UserRole;
import java.util.HashSet;
import java.util.Set;

public class TestarPersistence {

    public static void main(String[] args) {
        try {
            createUsersRoles();
            showAllUser();
        } catch (Exception ex) {
            System.out.println("A tentativa de criar usuários falhou!/n... " + ex.getMessage());
        }

    }

    private static void createUsersRoles() throws Exception {
        RoleDAO dao_role = new RoleDAO();
        UserDAO dao_user = new UserDAO();
        UserRoleDAO dao_userrole = new UserRoleDAO();
        
        System.out.println("Remove todas as regras...");
        dao_role.removeAll();
        
        System.out.println("Remove todos os usuarios...");
        dao_user.removeAll();
        
        System.out.println("Cria novas regras...");
        Role role1 = new Role();
        role1.setName("Regra 1");
        dao_role.save(role1);
        
        System.out.println("Cria novos usuarios...");
        User user1 = new User();
        user1.setName("Usuario 1");
        dao_user.save(user1);
        
        System.out.println("Criando relacionamento...");
        UserRole userrole1 = new UserRole();
        userrole1.setRoleid(role1.getID());
        userrole1.setUserid(user1.getId());
        dao_userrole.save(userrole1);
        
        System.out.print(" OK!");

    }

    public static void showUserRole(Role role) throws Exception {
        /*System.out.println("Listando regras do usuario...");
        
        RoleDAO dao = new RoleDAO();
        ArrayList roles = (ArrayList) dao.findUser(role);
        User o;

        for (int i = 0; i < roles.size(); i++) {
            o = (User) roles.get(i);
            System.out.println(o);
        }
*/

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

        User admin = (User) dao.getNewInstance();

    }

}
