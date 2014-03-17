/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.persistence.dao;

import hibernate.persistence.entities.Role;
import hibernate.persistence.entities.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author alessandrostein
 */
public class UserRoleDAO extends AbstractDAO implements IRoleDAO, IUserDAO {

   // private Session session;

    @Override
    public List findUser(Role o) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.getNamedQuery(getNamedQueryToFindUser());
            q.setInteger("id", o.getID());
            List lst = q.list();
            session.getTransaction().commit();
            return (ArrayList) lst;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        }
    }

    @Override
    public Object getNewInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRole(User user, Role role) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeRole(User user, Role role) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasRole(User user, Role role) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList findRole(User o) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.getNamedQuery(getNamedQueryToFindRole());
            q.setInteger("id", o.getId());
            List lst = q.list();
            session.getTransaction().commit();
            return (ArrayList) lst;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        }
    }

    protected String getNamedQueryToFindRole() {
        return "userrole.find.role";
    }

    protected String getNamedQueryToFindUser() {
        return "userrole.find.user";
    }

    @Override
    protected String getNamedQueryToFindAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getNamedQueryToFindById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getNamedQueryToFindByName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getNamedQueryToCountAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getNamedQueryToRemoveAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getNamedQueryToFindByRange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
