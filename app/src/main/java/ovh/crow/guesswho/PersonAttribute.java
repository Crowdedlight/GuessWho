package ovh.crow.guesswho;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;

/**
 * Created by Frederik Mazur Andersen on 19-03-2017.
 */

@Entity
public class PersonAttribute {
    @Id
    private long id;

    @NotNull
    private long PersonID;
    @NotNull
    private long AttributeID;

    @ToOne(joinProperty = "PersonID")
    private Person person;

    @ToOne(joinProperty = "AttributeID")
    private Attribute attribute;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 542276787)
    private transient PersonAttributeDao myDao;

    @Generated(hash = 1154009267)
    private transient Long person__resolvedKey;

    @Generated(hash = 735162862)
    private transient Long attribute__resolvedKey;

    @Generated(hash = 728652474)
    public PersonAttribute(long id, long PersonID, long AttributeID) {
        this.id = id;
        this.PersonID = PersonID;
        this.AttributeID = AttributeID;
    }
    @Generated(hash = 746416815)
    public PersonAttribute() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getPersonID() {
        return this.PersonID;
    }
    public void setPersonID(long PersonID) {
        this.PersonID = PersonID;
    }
    public long getAttributeID() {
        return this.AttributeID;
    }
    public void setAttributeID(long AttributeID) {
        this.AttributeID = AttributeID;
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1043444630)
    public Person getPerson() {
        long __key = this.PersonID;
        if (person__resolvedKey == null || !person__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PersonDao targetDao = daoSession.getPersonDao();
            Person personNew = targetDao.load(__key);
            synchronized (this) {
                person = personNew;
                person__resolvedKey = __key;
            }
        }
        return person;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1043261299)
    public void setPerson(@NotNull Person person) {
        if (person == null) {
            throw new DaoException(
                    "To-one property 'PersonID' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.person = person;
            PersonID = person.getId();
            person__resolvedKey = PersonID;
        }
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 951802101)
    public Attribute getAttribute() {
        long __key = this.AttributeID;
        if (attribute__resolvedKey == null
                || !attribute__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AttributeDao targetDao = daoSession.getAttributeDao();
            Attribute attributeNew = targetDao.load(__key);
            synchronized (this) {
                attribute = attributeNew;
                attribute__resolvedKey = __key;
            }
        }
        return attribute;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1819862204)
    public void setAttribute(@NotNull Attribute attribute) {
        if (attribute == null) {
            throw new DaoException(
                    "To-one property 'AttributeID' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.attribute = attribute;
            AttributeID = attribute.getId();
            attribute__resolvedKey = AttributeID;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 364880310)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPersonAttributeDao() : null;
    }
}
