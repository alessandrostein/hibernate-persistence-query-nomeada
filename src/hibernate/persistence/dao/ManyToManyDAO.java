package hibernate.persistence.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Fabio Tavares Dippold
 *
 */
public abstract class ManyToManyDAO implements IManyToManyDAO {

    protected Session session;

    @Override
    public Object create(Object o) throws Exception {
        try {
            session = obtainSession();
            session.beginTransaction();
            session.save(o);
            session.flush();
            session.getTransaction().commit();
            return o;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    @Override
    public void save(Object o) throws Exception {
        try {
            session = obtainSession();
            session.beginTransaction();
            session.update(o);
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    @Override
    public void delete(Object o) throws Exception {
        try {
            session = obtainSession();
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    @Override
    public Object findById(Integer theRelationshipId) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.getNamedQuery(getNamedQueryToFindById());
            q.setString("id", theRelationshipId.toString());
            Object o = q.uniqueResult();
            return o;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    @Override
    public Object findChildren(Integer theParentId) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.getNamedQuery(getNamedQueryToFindChildren());
            q.setString("id", theParentId.toString());
            Object o = q.uniqueResult();
            return o;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    @Override
    public Object findParents(Integer theSonId) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.getNamedQuery(getNamedQueryToFindParents());
            q.setString("id", theSonId.toString());
            Object o = q.uniqueResult();
            return o;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }    
    
    @Override
    public List findAll() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.getNamedQuery(getNamedQueryToFindAll());
            List lst = q.list();
            session.getTransaction().commit();
            return lst;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    @Override
    public List list(Integer firstResult, Integer maxResults) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.getNamedQuery(getNamedQueryToListByRange());
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List lst = q.list();
            return lst;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }    
    
    @Override
    public List listChildren(Integer theParentId, Integer firstResult, Integer maxResults) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.getNamedQuery(getNamedQueryToListChildrenByRange());
            q.setString("id", theParentId.toString());
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List lst = q.list();
            return lst;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    @Override
    public List listParents(Integer theSonId, Integer firstResult, Integer maxResults) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.getNamedQuery(getNamedQueryToListParentsByRange());
            q.setString("id", theSonId.toString());
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List lst = q.list();
            return lst;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }    
    
    @Override
    public Long countAll() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.getNamedQuery(getNamedQueryToCountAll());
            Long count = (Long) q.uniqueResult();
            session.getTransaction().commit();
            return count;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }    
    
    @Override
    public Long countChildren(Integer theParentId) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.getNamedQuery(getNamedQueryToCountChildren());
            q.setString("id", theParentId.toString());
            Long count = (Long) q.uniqueResult();
            session.getTransaction().commit();
            return count;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    @Override
    public Long countParents(Integer theSonId) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.getNamedQuery(getNamedQueryToCountParents());
            q.setString("id", theSonId.toString());
            Long count = (Long) q.uniqueResult();
            session.getTransaction().commit();
            return count;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }    
    
    @Override
    public void removeAll() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.getNamedQuery(getNamedQueryToRemoveAll());
            q.executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    @Override
    public void removeChildren(Integer theParentId) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.getNamedQuery(getNamedQueryToRemoveChildren());
            q.setString("id", theParentId.toString());
            q.executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }    

    @Override
    public void removeParents(Integer theSonId) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.getNamedQuery(getNamedQueryToRemoveParents());
            q.setString("id", theSonId.toString());
            q.executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }    
    
    protected Session obtainSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    protected void releaseSession(Session session) {
        // Do nothing...
    }

    /*
     * Abstract Members...
     */
    /*
     * FIND BEHAVIOR...
     */
    protected abstract String getNamedQueryToFindAll();
    protected abstract String getNamedQueryToFindById();
    protected abstract String getNamedQueryToFindChildren();
    protected abstract String getNamedQueryToFindParents();
    /*
     *  COUNT BEHAVIOR
     */
    protected abstract String getNamedQueryToCountAll();
    protected abstract String getNamedQueryToCountChildren();    
    protected abstract String getNamedQueryToCountParents();
    /*
     * REMOVE BEHAVIOR
     */
    protected abstract String getNamedQueryToRemoveAll();
    protected abstract String getNamedQueryToRemoveChildren();
    protected abstract String getNamedQueryToRemoveParents();
    /*
     * FIND RANGE
     */
    protected abstract String getNamedQueryToListByRange();
    protected abstract String getNamedQueryToListChildrenByRange();
    protected abstract String getNamedQueryToListParentsByRange();
}
