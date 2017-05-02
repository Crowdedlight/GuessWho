package ovh.crow.guesswho;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by Frederik Mazur Andersen on 19-03-2017.
 */

@Entity
public class Attribute {
    @Id
    private Long id;

    @NotNull
    private Long AreaID;
    @NotNull
    private Long ModifierID;

    @ToMany
    @JoinEntity(
            entity = PersonAttribute.class,
            sourceProperty = "AttributeID",
            targetProperty = "PersonID"
    )
    private List<Person> PersonsWithThisAttribute;

    @ToOne(joinProperty = "AreaID")
    private Areas area;

    @ToOne(joinProperty = "ModifierID")
    private Modifiers modifier;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 2114943461)
    private transient AttributeDao myDao;

    @Generated(hash = 35132546)
    public Attribute(Long id, @NotNull Long AreaID, @NotNull Long ModifierID) {
        this.id = id;
        this.AreaID = AreaID;
        this.ModifierID = ModifierID;
    }

    @Generated(hash = 959577406)
    public Attribute() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAreaID() {
        return this.AreaID;
    }

    public void setAreaID(Long AreaID) {
        this.AreaID = AreaID;
    }

    public Long getModifierID() {
        return this.ModifierID;
    }

    public void setModifierID(Long ModifierID) {
        this.ModifierID = ModifierID;
    }

    @Generated(hash = 1062106316)
    private transient Long area__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1595218314)
    public Areas getArea() {
        Long __key = this.AreaID;
        if (area__resolvedKey == null || !area__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AreasDao targetDao = daoSession.getAreasDao();
            Areas areaNew = targetDao.load(__key);
            synchronized (this) {
                area = areaNew;
                area__resolvedKey = __key;
            }
        }
        return area;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1398320894)
    public void setArea(@NotNull Areas area) {
        if (area == null) {
            throw new DaoException(
                    "To-one property 'AreaID' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.area = area;
            AreaID = area.getId();
            area__resolvedKey = AreaID;
        }
    }

    @Generated(hash = 1076801964)
    private transient Long modifier__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 474108502)
    public Modifiers getModifier() {
        Long __key = this.ModifierID;
        if (modifier__resolvedKey == null || !modifier__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ModifiersDao targetDao = daoSession.getModifiersDao();
            Modifiers modifierNew = targetDao.load(__key);
            synchronized (this) {
                modifier = modifierNew;
                modifier__resolvedKey = __key;
            }
        }
        return modifier;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1772257786)
    public void setModifier(@NotNull Modifiers modifier) {
        if (modifier == null) {
            throw new DaoException(
                    "To-one property 'ModifierID' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.modifier = modifier;
            ModifierID = modifier.getId();
            modifier__resolvedKey = ModifierID;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 693592877)
    public List<Person> getPersonsWithThisAttribute() {
        if (PersonsWithThisAttribute == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PersonDao targetDao = daoSession.getPersonDao();
            List<Person> PersonsWithThisAttributeNew = targetDao
                    ._queryAttribute_PersonsWithThisAttribute(id);
            synchronized (this) {
                if (PersonsWithThisAttribute == null) {
                    PersonsWithThisAttribute = PersonsWithThisAttributeNew;
                }
            }
        }
        return PersonsWithThisAttribute;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 286861793)
    public synchronized void resetPersonsWithThisAttribute() {
        PersonsWithThisAttribute = null;
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
    @Generated(hash = 701260076)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAttributeDao() : null;
    }

}
