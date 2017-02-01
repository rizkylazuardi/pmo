package com.anabatic.pmo.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.anabatic.pmo.core.annotation.AuthorizationField;




/**
 * Base class for Model objects. Child objects should implement toString(),
 * equals() and hashCode().
 *
 * @author <a href="mailto:ab.annas@gmail.com">Andi Baso Annas</a>
 */
@MappedSuperclass
public abstract class BaseGenericObject implements Serializable {
	private static final long serialVersionUID = -8623055094444553886L;
	private Date createdTime;

    @Column(name = "created_time", nullable = true, insertable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @AuthorizationField(shown = false)
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    private String createdBy;

    @Column(name = "created_by", nullable = true, insertable = true, updatable = false, length = 25, precision = 0)
    @AuthorizationField(shown = false)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date updatedTime;

    @Column(name = "updated_time", nullable = true, insertable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @AuthorizationField(shown = false)
    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    private String updatedBy;

    @Column(name = "updated_by", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    @AuthorizationField(shown = false)
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    private String authoriser;

    @Column(name = "authoriser", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    @AuthorizationField(shown = false)
    public String getAuthoriser() {
        return authoriser;
    }
    
	public void setAuthoriser(String authoriser) {
        this.authoriser = authoriser;
    }
	
    private Date authorizeTime;

    @Column(name = "authorize_time", nullable = true, insertable = true, updatable = true)
    @AuthorizationField(shown = false)
    public Date getAuthorizeTime() {
		return authorizeTime;
	}

	public void setAuthorizeTime(Date authorizeTime) {
		this.authorizeTime = authorizeTime;
	}

    private String status;
    @Column(name = "status", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Integer version;

    @Column(name = "version")
    @AuthorizationField(shown = false)
    public Integer getVersion() {
        return version;
    }
    
    private BaseGenericObject newValue;

//    @Column(name="new_value", length=8000)
    @Transient
    public BaseGenericObject getNewValue() {
		return newValue;
	}

	public void setNewValue(BaseGenericObject newValue) {
		this.newValue = newValue;
	}

	public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Returns a multi-line String with key=value pairs.
     *
     * @return a String representation of this class.
     */
    public abstract String toString();

    /**
     * Compares object equality. When using Hibernate, the primary key should
     * not be a part of this comparison.
     *
     * @param o object to compare to
     * @return true/false based on equality tests
     */
    public abstract boolean equals(Object o);

    /**
     * When you override equals, you should override hashCode. See "Why are
     * equals() and hashCode() importation" for more information:
     * http://www.hibernate.org/109.html
     *
     * @return hashCode
     */
    public abstract int hashCode();
    
}
