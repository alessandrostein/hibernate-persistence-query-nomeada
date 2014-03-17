package hibernate.persistence.dao;

import java.util.List;

/**
 *
 * @author Fabio Tavares Dippold
 * 
 */
public interface IManyToManyDAO {

    Long countAll() throws Exception;
    
    Long countChildren(Integer theParentId) throws Exception;

    Long countParents(Integer theSonId) throws Exception;

    Object create(Object o) throws Exception;

    void delete(Object o) throws Exception;

    List findAll() throws Exception;

    Object findById(Integer theRelationshipId) throws Exception;

    Object findChildren(Integer theParentId) throws Exception;

    Object findParents(Integer theSonId) throws Exception;

    Object getNewInstance();

    List list(Integer firstResult, Integer maxResults) throws Exception;
    
    List listChildren(Integer theParentId, Integer firstResult, Integer maxResults) throws Exception;
    
    List listParents(Integer theSonId, Integer firstResult, Integer maxResults) throws Exception;

    void removeAll() throws Exception;

    void removeChildren(Integer theParentId) throws Exception;
    
    void removeParents(Integer theSonId) throws Exception;

    void save(Object o) throws Exception;
    
}
