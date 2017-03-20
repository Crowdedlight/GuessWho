package ovh.crow.guesswho;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;

/**
 * Created by Frederik Mazur Andersen on 19-03-2017.
 */

@Entity
public class Attribute {
    @Id
    private long id;

    @NotNull
    private long AreaID;
    @NotNull
    private long ModifierID;

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

}
