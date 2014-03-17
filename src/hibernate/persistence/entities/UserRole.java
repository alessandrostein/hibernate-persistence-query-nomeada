/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.persistence.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author alessandrostein
 */
@Entity
@Table(name = "userrole",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"userid", "roleid"})}
)
@NamedQueries({
    @NamedQuery(name = "userrole.id.equals", query = "SELECT o FROM UserRole o WHERE o.id=:id"),
    @NamedQuery(name = "userrole.find.all", query = "SELECT o FROM UserRole o"),
    @NamedQuery(name = "userrole.find.user", query = "SELECT o FROM UserRole o WHERE o.userid=:id"),
    @NamedQuery(name = "userrole.find.role", query = "SELECT o FROM UserRole o WHERE o.roleid=:id"),
    @NamedQuery(name = "userrole.has.role", query = "SELECT o FROM UserRole o WHERE o.roleid=:roleid AND o.userid=:userid")
    /*@NamedQuery(name = "userrole.count.all", query = "SELECT COUNT(o.id) FROM UserRole o"),
    @NamedQuery(name = "userrole.count.all.user", query = "SELECT COUNT(o.id) FROM UserRole o WHERE o.userId=:id"),
    @NamedQuery(name = "userrole.count.all.role", query = "SELECT COUNT(o.id) FROM UserRole o WHERE o.roleId=:id"),

    @NamedQuery(name = "userrole.remove.all", query = "DELETE FROM UserRole o"),
    @NamedQuery(name = "userrole.remove.all.user", query = "DELETE FROM UserRole o WHERE o.userId=:id"),
    @NamedQuery(name = "userrole.remove.all.role", query = "DELETE FROM UserRole o WHERE o.roleId=:id"),

    @NamedQuery(name = "userrole.find.range.equals", query = "SELECT o FROM UserRole o WHERE o.userId=:id AND (o.id BETWEEN :minId AND :maxId)")
*/})
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "userid", nullable = false)
    private int userid;
    
    @Column(name = "roleid", nullable = false)
    private int roleid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    @Override
    public String toString() {
        return this.getClass().getName() + "[ id= " + id + " userId=" + userid + " roleId=" + roleid + "]";
    }


}
