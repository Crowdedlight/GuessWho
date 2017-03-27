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
    private Long id;

    @NotNull
    private Long PersonID;
    @NotNull
    private Long AttributeID;

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

    @Generated(hash = 109839529)
    public PersonAttribute(Long id, @NotNull Long PersonID,
            @NotNull Long AttributeID) {
        this.id = id;
        this.PersonID = PersonID;
        this.AttributeID = AttributeID;
    }

    @Generated(hash = 746416815)
    public PersonAttribute() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonID() {
        return this.PersonID;
    }

    public void setPersonID(Long PersonID) {
        this.PersonID = PersonID;
    }

    public Long getAttributeID() {
        return this.AttributeID;
    }

    public void setAttributeID(Long AttributeID) {
        this.AttributeID = AttributeID;
    }

    @Generated(hash = 1154009267)
    private transient Long person__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 377943963)
    public Person getPerson() {
        Long __key = this.PersonID;
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

    @Generated(hash = 735162862)
    private transient Long attribute__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1191217157)
    public Attribute getAttribute() {
        Long __key = this.AttributeID;
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
