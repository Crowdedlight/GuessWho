package ovh.crow.guesswho;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by Frederik Mazur Andersen on 19-03-2017.
 */

@Entity
public class Modifiers {
    @Id
    private long id;

    @NotNull
    private String name;

    @ToMany(referencedJoinProperty = "ModifierID")
    private List<Attribute> attributes;
}
