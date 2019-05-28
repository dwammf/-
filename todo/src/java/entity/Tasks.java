/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "tasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasks.findAll", query = "SELECT t FROM Tasks t")
    , @NamedQuery(name = "Tasks.findByIdtasks", query = "SELECT t FROM Tasks t WHERE t.idtasks = :idtasks")
    , @NamedQuery(name = "Tasks.findByTaskname", query = "SELECT t FROM Tasks t WHERE t.taskname = :taskname")})
public class Tasks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtasks")
    private Integer idtasks;
    @Size(max = 45)
    @Column(name = "taskname")
    private String taskname;
    @JoinColumn(name = "userid", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User userid;

    public Tasks() {
    }

    public Tasks(Integer idtasks) {
        this.idtasks = idtasks;
    }

    public Integer getIdtasks() {
        return idtasks;
    }

    public void setIdtasks(Integer idtasks) {
        this.idtasks = idtasks;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtasks != null ? idtasks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks) object;
        if ((this.idtasks == null && other.idtasks != null) || (this.idtasks != null && !this.idtasks.equals(other.idtasks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tasks[ idtasks=" + idtasks + " ]";
    }
    
}
